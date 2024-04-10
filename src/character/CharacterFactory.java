package character;

import character.base.Character;
import mediators.CharacterCommandMediator;

// Simple Factory - (Piotr Wróbel)
public class CharacterFactory {

    private CharacterFactory() {}

    // Method to create different types of items based on input
    public static Character createCharacter(CharacterClass characterClass) {
        // Mediator - Yurii Tyshchenko
        CharacterCommandMediator mediator = new CharacterCommandMediator();

        return switch (characterClass) {
            case CharacterClass.WARRIOR -> new Character(CharacterClass.WARRIOR, 10, 3, 9, mediator);
            case CharacterClass.ARCHER -> new Character(CharacterClass.ARCHER, 6, 7, 5, mediator);
            case CharacterClass.MAGE -> new Character(CharacterClass.MAGE, 5, 8, 8, mediator);
            case CharacterClass.ASSASSIN -> new Character(CharacterClass.ASSASSIN, 8, 5, 3, mediator);
            default -> throw new IllegalArgumentException("Invalid character class: " + characterClass);
        };
        // Mediator end - week 5
    }
}
// Simple Factory end - week 2
