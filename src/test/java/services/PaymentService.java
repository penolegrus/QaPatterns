package services;

import singletones.ConfigReader;
import singletones.JiraApiClient;

import java.io.IOException;

public class PaymentService {
    //some methods
    private boolean isMethodSecured(String someParam) throws IOException {
        //some login with REST
        boolean isSecured = ConfigReader.getInstance().getConfig().getSecured();

        if (isSecured){
            String status = JiraApiClient.getInstance().getTaskStatus(3123);
            return status == "Bug";
        }
        return false;
    }
}
