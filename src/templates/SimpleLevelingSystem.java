package templates;

import character.base.Character;

public class SimpleLevelingSystem extends LevelingSystem {
    private static final double EXPERIENCE_THRESHOLD = 100.0;
    private static final int LEVEL_UP_BONUS = 10;

    @Override
    protected void gainExperiencePoints(Character character) {
        character.addExperiencePoints(10);
        System.out.println(character.getCharacterClass() + " gains 10 experience points.");
    }

    @Override
    protected boolean canLevelUp(Character character) {
        return character.getExperiencePoints() >= EXPERIENCE_THRESHOLD;
    }

    @Override
    protected void levelUpCharacter(Character character) {
        character.setLevel(character.getLevel() + 1);
        character.setExperiencePoints(0);
        character.setHealth(character.getHealth() + LEVEL_UP_BONUS);
        System.out.println(character.getCharacterClass() + " levels up to level " + character.getLevel() + "!");
    }
}
