/**
 * Class to store application, specific configuration;
 */
package fr.houseofcode.dap;

/**
 * @author djer
 */
public class Config {
    /** Default application name. */
    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";

    /** Default folder to Store DataAccesProject user Google credentials. */
    private static final String CREDENTIALS_FOLDER = System.getProperty("user.home")
            + System.getProperty("file.separator") + "app_data" + System.getProperty("file.separator")
            + "googleCredentials";

    /** Default application credential file. */
    private static final String CLIENT_SECRET_FILE = System.getProperty("user.home")
            + System.getProperty("file.separator") + "app_data" + System.getProperty("file.separator")
            + "credentials.json";

    /** Application name. */
    private String applicationName;
    /** Folder to Store user (Google) credentials. */
    private String credentialFolder;
    /** Application credential file. */
    private String clientSecretFile;

    /**
     * Load the default configuration.
     */
    public Config() {
        super();
        applicationName = APPLICATION_NAME;
        credentialFolder = CREDENTIALS_FOLDER;
        clientSecretFile = CLIENT_SECRET_FILE;
    }

    /**
     * Load the configuration.
     * @param directoryDataStore folder to store configurations
     */
    public Config(final String directoryDataStore) {
        this();
        this.credentialFolder = directoryDataStore + System.getProperty("file.separator") + "googleCredentials";
        this.clientSecretFile = directoryDataStore + System.getProperty("file.separator") + "credentials.json";
    }

    /**
     * Load the configuration.
     * @param directoryDataStore folder to store configurations
     * @param appName            the specific application name
     */
    public Config(final String directoryDataStore, final String appName) {
        this(directoryDataStore);
        this.applicationName = appName;
    }

    /**
     * @return the applicationName
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * @return the credentialFolder
     */
    public String getCredentialFolder() {
        return credentialFolder;
    }

    /**
     * @return the clientSecretFile
     */
    public String getClientSecretFile() {
        return clientSecretFile;
    }

}