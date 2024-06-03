package pollub.rpghelper.templates;

import pollub.rpghelper.character.base.Character;

public class SimpleLevelingSystem extends LevelingSystem {
   private int levelUpBonus = 10;

    @Override
    protected void gainExperiencePoints(Character character, int experiencePoints) {
        character.addExperiencePoints(experiencePoints);
        System.out.println(character.getCharacterClass() + " gains " + experiencePoints + " experience points.");
    }

    @Override
    public boolean canLevelUp(Character character) {
        return character.getExperiencePoints() >= getRequiredExperience(character);
    }

    @Override
    protected void levelUpCharacter(Character character) {
        character.setLevel(character.getLevel() + 1);
        character.setExperiencePoints(character.getExperiencePoints() - getRequiredExperience(character));
        character.setHealth(character.getHealth() + levelUpBonus);
        System.out.println(character.getCharacterClass() + " levels up to level " + character.getLevel() + "!");
    }

    @Override
    public int getRequiredExperience(Character character) {
        return 20 + (character.getLevel() * 24);
    }

    public void setLevelUpBonus(int levelUpBonus) {
        this.levelUpBonus = levelUpBonus;
    }
}
