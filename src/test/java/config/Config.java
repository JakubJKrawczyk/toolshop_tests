package config;

public final class Config{

    public static final String TESTING_ENVIRONMENT_URL_APP =
            System.getenv().getOrDefault(
                    "TESTING_ENVIRONMENT_URL_APP",
                    "http://172.16.10.138:4200"
            );

    public static final String TESTING_ENIRONMENT_URL_API =
            System.getenv().getOrDefault(
                    "TESTING_ENVIRONMENT_URL_API",
                    "http://172.16.10.138:8091"
            );

}