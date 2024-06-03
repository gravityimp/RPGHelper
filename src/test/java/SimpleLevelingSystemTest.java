import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import pollub.rpghelper.character.CharacterClass;
import pollub.rpghelper.character.base.Character;
import pollub.rpghelper.mementos.CharacterMemento;
import pollub.rpghelper.templates.LevelingSystem;
import pollub.rpghelper.templates.SimpleLevelingSystem;

public class SimpleLevelingSystemTest {

    private LevelingSystem levelingSystem;
    private Character character;

    @Before
    public void setUp() throws Exception {
        levelingSystem = new SimpleLevelingSystem();
        character = new Character(CharacterClass.WARRIOR, 12, 4, 9, new CharacterMemento());
    }

    @Test
    public void testCanLevelUp() {
        Assert.assertFalse(levelingSystem.canLevelUp(character));
    }

    @Test
    public void testDidLevelIncrease() {
        int levelBefore = character.getLevel();
        levelingSystem.levelUp(character, 200);
        int levelAfter = character.getLevel();
        Assert.assertNotEquals(levelAfter, levelBefore);
    }

    @Test
    public void testLevelUpBonus() {
        double health = character.getHealth();
        levelingSystem.levelUp(character, 200);
        double healthAfter = character.getHealth();
        Assert.assertNotEquals(healthAfter, health);
    }

    @Test
    public void testGetRequiredExperience() {
        Assert.assertEquals(20, levelingSystem.getRequiredExperience(character));
        levelingSystem.levelUp(character, 200);
        Assert.assertEquals(44, levelingSystem.getRequiredExperience(character));
    }

    @Test
    public void testSetLevelUpBonus() {
        double health = character.getHealth();
        double difference = 0.0;
        levelingSystem.levelUp(character, 200);
        difference = character.getHealth() - health;

        levelingSystem.setLevelUpBonus(20);
        health = character.getHealth();
        levelingSystem.levelUp(character, 200);
        Assert.assertNotEquals(difference, character.getHealth() - health);
        System.out.println("Before change: " + difference);
        System.out.println("After change: " + (character.getHealth() - health));
    }
}
