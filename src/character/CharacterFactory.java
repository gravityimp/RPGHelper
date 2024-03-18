package character;

import character.base.Character;

// Simple Factory - (Piotr Wróbel)
class CharacterFactory {

    private CharacterFactory() {}

    // Method to create different types of items based on input
    public static Character createCharacter(CharacterClass characterClass) {
        return switch (characterClass) {
            case CharacterClass.WARRIOR -> new Character(CharacterClass.WARRIOR, 10, 3, 9);
            case CharacterClass.ARCHER -> new Character(CharacterClass.ARCHER, 6, 7, 5);
            case CharacterClass.MAGE -> new Character(CharacterClass.MAGE, 5, 8, 8);
            case CharacterClass.ASSASSIN -> new Character(CharacterClass.ASSASSIN, 8, 5, 3);
            default -> throw new IllegalArgumentException("Invalid character class: " + characterClass);
        };
    }
}
// Simple Factory end - week 2
