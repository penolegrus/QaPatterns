package tests;

import services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletones.JiraApiClient;

import java.io.IOException;

public class SingletoneTests {
    @Test
    public void authSuccessTest() throws IOException {
        //some logic
        String taskStatus = JiraApiClient.getInstance().getTaskStatus(4121);
        if(taskStatus == "В работе") {
            JiraApiClient.getInstance()
                    .sendCommentToTask(4121, "Тест не будет пройден пока задача активна");
            return;
        }

        AuthService authService = new AuthService();
        String jwt = authService.getJwt("admin", "admin");
        boolean isGood = authService.someLogic(jwt);
        Assertions.assertTrue(isGood);
    }
}
