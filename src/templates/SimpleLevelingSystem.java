package templates;

import character.base.Character;

public class SimpleLevelingSystem extends LevelingSystem {
    private static final double EXPERIENCE_THRESHOLD = 100.0;
    private static final int LEVEL_UP_BONUS = 10;

    @Override
    protected void gainExperiencePoints(Character character) {
        int points = 30;
        character.addExperiencePoints(points);
        System.out.println(character.getCharacterClass() + " gains " + points + " experience points.");
    }

    @Override
    protected boolean canLevelUp(Character character) {
        return character.getExperiencePoints() >= EXPERIENCE_THRESHOLD;
    }

    @Override
    protected void levelUpCharacter(Character character) {
        character.setLevel(character.getLevel() + 1);
        character.setExperiencePoints(character.getExperiencePoints() - EXPERIENCE_THRESHOLD);
        character.setHealth(character.getHealth() + LEVEL_UP_BONUS);
        System.out.println(character.getCharacterClass() + " levels up to level " + character.getLevel() + "!");
    }
}
