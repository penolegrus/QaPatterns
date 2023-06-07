package singletones;

public class JiraApiClient {
    private static JiraApiClient instance;

    private JiraApiClient() {}

    public static synchronized JiraApiClient getInstance() {
        if (instance == null) {
            instance = new JiraApiClient();
        }
        return instance;
    }

    public void sendCommentToTask(int taskId, String message){
        //какая то логика отправки комментария в задачу джиры
        //JiraBody jiraBody = new JiraBody(taskId, message);
        //given().body(jiraBody).post("http://someJiraUrl.ru/api/v2/comments").then().log().all();
    }

    public String getTaskStatus(int taskId){
        //логика для получения текущего статуса в задаче джиры
        //return given().get("http://someJiraUrl.ru/api/v2/task" + taskId).then().log().all().....
        return null;
    }

}
