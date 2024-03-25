package party;

import character.CharacterClass;
import character.CharacterType;

import java.util.HashMap;
import java.util.Map;

// Flyweight - Piotr Wróbel
public class PartyFactory {
    static Map<String, CharacterType> characterTypes = new HashMap<>();

    public static CharacterType getCharacterType(String name, CharacterClass profession, String backstory) {
        CharacterType result = characterTypes.get(name);
        if (result == null) {
            result = new CharacterType(name, profession, backstory);
            characterTypes.put(name, result);
        }
        return result;
    }
}
// Flyweight end - week 4