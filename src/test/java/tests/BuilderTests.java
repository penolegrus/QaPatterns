package tests;

import io.restassured.http.ContentType;
import models.UserModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BuilderTests {
    @Test
    public void builderTest(){
        UserModel user1 = UserModel.builder()
                .age(20)
                .salary(30.000)
                .isMarried(false)
                .password("my_cool_password")
                .username("cool_person").build();

        UserModel user2 = UserModel.builder()
                .password("temp_password")
                .username("temp_user").build();

        System.out.println(user1);
        System.out.println(user2);



        given().auth().oauth2("some jwt token")
                .contentType(ContentType.JSON)
                .body(user2)
                .get("http://threadqa.ru");
    }
}
