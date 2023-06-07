package decorator;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import io.qameta.allure.Attachment;

public class LogginExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("Запустился тест: " + context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("Завершился тест: " + context.getDisplayName());

//пример прикрепления скриншота в аллюр отчет к упавшему UI тесту, если проверка была не через should
//        boolean testFailed = context.getExecutionException().isPresent();
//        if (testFailed) {
//            saveScreenshot(Selenide.screenshot(OutputType.BYTES));
//        }
    }

//    /**
//     * Метод добавления скриншота в аллюра отчета через аннотацию
//     *
//     * @param screenShot байты скриншотов
//     * @return
//     */
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public static byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }
}

