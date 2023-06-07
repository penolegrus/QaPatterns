package singletones;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static volatile ConfigReader instance;
    private final MyProperties config;
    private ConfigReader() throws IOException {
        // Создаем объект ObjectMapper для преобразования JSON в POJO
        ObjectMapper mapper = new ObjectMapper();

        // Загружаем свойства из файла
        Properties props = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))) {
            props.load(input);
        }

        // Преобразуем свойства в JSON
        String json = mapper.writeValueAsString(props);

        // Преобразуем JSON в POJO класс
        config = mapper.readValue(json, MyProperties.class);
    }

    public static ConfigReader getInstance() throws IOException {
        // Проверяем, был ли уже создан объект
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ConfigReader();
                }
            }
        }
        return instance;
    }

    public MyProperties getConfig() {
        return config;
    }
}
