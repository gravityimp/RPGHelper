package character;

// Flyweight - Piotr Wróbel
public class CharacterType {
    private String name;
    private CharacterClass profession;
    private String backstory;

    public CharacterType(String name, CharacterClass profession, String backstory) {
        this.name = name;
        this.profession = profession;
        this.backstory = backstory;
    }

    public String getName() {
        return name;
    }

    public CharacterClass getProfession() {
        return profession;
    }

    public String getBackstory() {
        return backstory;
    }
}
// Flyweight end - week 4