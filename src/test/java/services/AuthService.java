package services;


import singletones.ConfigReader;

import java.io.IOException;

public class AuthService {
    //some methods

    public String getJwt(String login, String pass) throws IOException {
        //some login with REST
        String url = ConfigReader.getInstance().getConfig().getUrl();
        return login.toUpperCase()+pass.toUpperCase();
    }

    public boolean someLogic(String jwt){
        return true;
    }
}
