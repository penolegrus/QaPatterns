package singletones;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyProperties {
    private String url;
    @JsonProperty("is_secure")
    private Boolean isSecured;
    private Integer threads;

    public MyProperties(String url, Boolean isSecured, Integer threads) {
        this.url = url;
        this.isSecured = isSecured;
        this.threads = threads;
    }

    public MyProperties() {
    }

    public String getUrl() {
        return url;
    }

    public Boolean getSecured() {
        return isSecured;
    }

    public Integer getThreads() {
        return threads;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "url='" + url + '\'' +
                ", isSecured=" + isSecured +
                ", threads=" + threads +
                '}';
    }
}
