package hexlet.code.service;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    public List<UserDTO> getAll() {
        var users = userRepository.findAll();
        return users.stream()
                .map(p -> userMapper.map(p))
                .toList();
    }
    public UserDTO create(UserCreateDTO userData) {
        var user = userMapper.map(userData);
        userRepository.save(user);
        return userMapper.map(user);
    }

    public UserDTO show(Long id) {
        var user =  userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        return userMapper.map(user);
    }

    public UserDTO update(UserUpdateDTO data, Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        userMapper.update(data, user);
        userRepository.save(user);
        return userMapper.map(user);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
