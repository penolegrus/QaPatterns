package tests;

import com.google.common.collect.Lists;
import models.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DataDrivenTests {
    @ParameterizedTest
    @CsvSource({"admin,password1", "user,password2", "demo,password3"})
    public void paramsTest(String login, String password){
        System.out.println(login);
        System.out.println(password);
        Assertions.assertTrue(password.startsWith("pass"));
    }

    @ParameterizedTest
    @MethodSource(value = "testUsers")
    public void objectParamsTest(UserModel userModel){
        System.out.println(userModel);
        Assertions.assertTrue(userModel.getPassword().startsWith("pass"));

    }

    private static Stream<UserModel> testUsers(){
        UserModel admin = UserModel.builder().username("admin").password("password1").build();
        UserModel user = UserModel.builder().username("user").password("password2").build();
        UserModel demo = UserModel.builder().username("demo").password("password3").build();
        return Stream.of(admin,user,demo);
    }
}
