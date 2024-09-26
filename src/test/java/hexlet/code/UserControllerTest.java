//package hexlet.code;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import hexlet.code.model.User;
//import hexlet.code.repository.UserRepository;
//import hexlet.code.service.UserService;
//import net.datafaker.Faker;
//import org.instancio.Instancio;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private Faker faker;
//
//    @Autowired
//    private ObjectMapper om;
//
//    private SecurityMockMvcRequestPostProcessors.JwtRequestPostProcessor token;
//
//    private User testUser;
//    @BeforeEach
//    public void setup() {
//        token = jwt().jwt(builder -> builder.subject("hexlet@example.com"));
//
//        testUser = Instancio.of(modelGenerator.getUserModel()).create();
//        userRepository.save(testUser);
//    }
//
//}
