package providers;

public class UrlProvider {
    public static String baseUrl = System.getProperty("url");
    public static String login = baseUrl + "?controller=authentication&back=my-account";
    public static String registration = baseUrl + "?controller=authentication&create_account=1";

}
