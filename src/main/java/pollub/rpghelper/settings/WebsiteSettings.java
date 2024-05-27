package pollub.rpghelper.settings;

// Singleton class - (Piotr Wróbel)
public class WebsiteSettings {
    private static WebsiteSettings instance;

    private String theme;
    private Boolean allowNotifications;
    private String language;

    // Private constructor to prevent instantiation from outside
    private WebsiteSettings() {
        this.theme = "Light";
        this.allowNotifications = false;
        this.language = "en";
    }

    // Method to get the singleton instance
    public static WebsiteSettings getInstance() {
        if (instance == null) {
            instance = new WebsiteSettings();
        }
        return instance;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Boolean getAllowNotifications() {
        return allowNotifications;
    }

    public void setAllowNotifications(Boolean allowNotifications) {
        this.allowNotifications = allowNotifications;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
// Singleton Class end - week 2