package character;

import character.base.Character;
import mementos.CharacterMemento;
import static character.CharacterConstants.*;

// Simple Factory - (Piotr Wróbel)
public class CharacterFactory {

    private CharacterFactory() {}

    // Method to create different types of items based on input
    public static Character createCharacter(CharacterClass characterClass) {
        // Memento - Yurii Tyshchenko
        CharacterMemento memento = new CharacterMemento();

        return switch (characterClass) {
            case CharacterClass.WARRIOR -> new Character(CharacterClass.WARRIOR, WARRIOR_DAMAGE, WARRIOR_DAMAGE, WARRIOR_INVENTORY, memento);
            case CharacterClass.ARCHER -> new Character(CharacterClass.ARCHER, ARCHER_HEALTH, ARCHER_DAMAGE, ARCHER_INVENTORY, memento);
            case CharacterClass.MAGE -> new Character(CharacterClass.MAGE, MAGE_HEALTH, MAGE_DAMAGE, MAGE_INVENTORY, memento);
            case CharacterClass.ASSASSIN -> new Character(CharacterClass.ASSASSIN, ASSASSIN_HEALTH, ASSASSIN_DAMAGE, ASSASSIN_INVENTORY, memento);
            default -> throw new IllegalArgumentException("Invalid character class: " + characterClass);
        };
        // Memento end - week 5
    }
}
// Simple Factory end - week 2
