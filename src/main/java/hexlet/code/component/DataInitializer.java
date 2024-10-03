package hexlet.code.component;

import hexlet.code.dto.TaskStatusCreatedDTO;
import hexlet.code.model.Label;
import hexlet.code.model.User;
import hexlet.code.repository.LabelRepository;
import hexlet.code.repository.UserRepository;
import hexlet.code.service.CustomUserDetailsService;
import hexlet.code.service.TaskStatusService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private UserRepository userRepository;
    private final CustomUserDetailsService userService;
    private final TaskStatusService taskStatusService;
    private final LabelRepository labelRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByEmail("hexlet@example.com").isEmpty()) {
            var email = "hexlet@example.com";
            var userData = new User();
            userData.setEmail(email);
            userData.setPassword("qwerty");
            userService.createUser(userData);
        }
        TaskStatusCreatedDTO statusDraft = new TaskStatusCreatedDTO();
        statusDraft.setName("draft");
        statusDraft.setSlug("draft");
        taskStatusService.create(statusDraft);

        TaskStatusCreatedDTO statusToReview = new TaskStatusCreatedDTO();
        statusToReview.setName("to review");
        statusToReview.setSlug("to_review");
        taskStatusService.create(statusToReview);

        TaskStatusCreatedDTO statusToReviewToBeFixed = new TaskStatusCreatedDTO();
        statusToReviewToBeFixed .setName("to be fixed");
        statusToReviewToBeFixed .setSlug("to_be_fixed");
        taskStatusService.create(statusToReviewToBeFixed);

        TaskStatusCreatedDTO statusToPublish = new TaskStatusCreatedDTO();
        statusToPublish.setName("to publish");
        statusToPublish.setSlug("to_publish");
        taskStatusService.create(statusToPublish);

        TaskStatusCreatedDTO statusPublished = new TaskStatusCreatedDTO();
        statusPublished.setName("published");
        statusPublished.setSlug("published");
        taskStatusService.create(statusPublished);

        Label labelFeature = new Label();
        labelFeature.setName("feature");
        labelRepository.save(labelFeature);

        Label labelBug = new Label();
        labelBug.setName("bug");
        labelRepository.save(labelBug);
    }
}
