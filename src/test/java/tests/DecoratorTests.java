package tests;

import decorator.LogginExtension;
import decorator.RandomUser;
import decorator.RandomUserResolver;
import models.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;



@ExtendWith({LogginExtension.class, RandomUserResolver.class})
//наблюдатель декорадр
public class DecoratorTests {

    @Test
    public void coolLoogingTest(){
        System.out.println("Основная логика сравнения значения");
        Assertions.assertTrue(2<5);
    }

    @Test
    public void deskTopTest(@RandomUser UserModel user){
        System.out.println(user);
        System.out.println("ok");
    }
}
