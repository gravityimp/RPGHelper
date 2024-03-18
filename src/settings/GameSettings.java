package settings;

// Singleton Pattern - (Yurii Tyshchenko)
public class GameSettings {
    private static GameSettings instance;

    // Private constructor to prevent instantiation from outside
    private GameSettings() {}

    // Method to get the singleton instance
    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
}
// Singleton Pattern end - week 2
