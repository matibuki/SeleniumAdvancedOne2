package configuration.factory;

import configuration.models.Browser;
import configuration.reader.YamlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PropertyStore {

    static Logger logger = LoggerFactory.getLogger(PropertyStore.class);
    YamlReader yamlReader = new YamlReader();
    private Browser browser;
    private List<EnvironmentFactory> listOfEnvironments;

    private PropertyStore() {
        setBrowser();
        setEnv();
    }

    public static PropertyStore getInstance() {
        return PropertyStore.PropertyStoreSingleton.INSTANCE;
    }

    public static class PropertyStoreSingleton {
        private static final PropertyStore INSTANCE = new PropertyStore();
    }

    private void setEnv() {
        listOfEnvironments = yamlReader.getConfig().getEnvironment().getEnvironments();
        for (EnvironmentFactory environmentSpec : listOfEnvironments) {
            if (environmentSpec.isActive()) {
                Map<String, Object> envProperties = environmentSpec.getProperties();
                for (Map.Entry entry : envProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Environment properties loaded");
                }
                logger.info("Environment = " + System.getProperty("envName"));
                break;
            }
        }
    }

    private void setBrowser() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Browser loaded");
        }
    }


}
