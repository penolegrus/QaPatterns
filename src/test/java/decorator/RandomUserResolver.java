package decorator;

import models.UserModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.reflect.Parameter;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomUserResolver  implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.isAnnotated(RandomUser.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return generateUser(parameterContext.getParameter());
    }

    private Object generateUser(Parameter parameter) {
        Class<?> type = parameter.getType();
        Random random = new Random();
        if (UserModel.class.equals(type)) {
            return UserModel.builder()
                    .age(random.nextInt(35))
                    .salary(Math.abs(random.nextDouble()))
                    .isMarried(random.nextBoolean())
                    .username("user_" + randomString(5))
                    .password("pass_" + randomString(8))
                    .build();
        }
        throw new ParameterResolutionException("No random user is generated for " + type);
    }

    private String randomString(int length){
        return new Random().ints(length, 0, 26)
                .mapToObj(i -> String.valueOf((char) (i + 'a')))
                .collect(Collectors.joining());
    }
}
