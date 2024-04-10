package character;

import character.base.Character;
import mementos.CharacterMemento;

// Simple Factory - (Piotr Wróbel)
public class CharacterFactory {

    private CharacterFactory() {}

    // Method to create different types of items based on input
    public static Character createCharacter(CharacterClass characterClass) {
        // Memento - Yurii Tyshchenko
        CharacterMemento memento = new CharacterMemento();

        return switch (characterClass) {
            case CharacterClass.WARRIOR -> new Character(CharacterClass.WARRIOR, 10, 3, 9, memento);
            case CharacterClass.ARCHER -> new Character(CharacterClass.ARCHER, 6, 7, 5, memento);
            case CharacterClass.MAGE -> new Character(CharacterClass.MAGE, 5, 8, 8, memento);
            case CharacterClass.ASSASSIN -> new Character(CharacterClass.ASSASSIN, 8, 5, 3, memento);
            default -> throw new IllegalArgumentException("Invalid character class: " + characterClass);
        };
        // Memento end - week 5
    }
}
// Simple Factory end - week 2
