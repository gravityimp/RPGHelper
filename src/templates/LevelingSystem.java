package templates;

import character.base.Character;

public abstract class LevelingSystem {
    public void levelUp(Character character) {
        gainExperiencePoints(character);

        if (canLevelUp(character)) {
            levelUpCharacter(character);
        }
    }

    protected abstract void gainExperiencePoints(Character character);

    protected abstract boolean canLevelUp(Character character);

    protected abstract void levelUpCharacter(Character character);
}
