package pollub.rpghelper.templates;

import pollub.rpghelper.character.base.Character;

public abstract class LevelingSystem {
    public void levelUp(Character character, int experiencePoints) {
        gainExperiencePoints(character, experiencePoints);

        if (canLevelUp(character)) {
            levelUpCharacter(character);
        }
    }

    protected abstract void gainExperiencePoints(Character character, int experiencePoints);

    protected abstract boolean canLevelUp(Character character);

    protected abstract void levelUpCharacter(Character character);

    protected abstract int getRequiredExperience(Character character);
}
