import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import pollub.rpghelper.character.base.Character;
import pollub.rpghelper.character.CharacterClass;
import pollub.rpghelper.enemies.HumanEnemy;
import pollub.rpghelper.mementos.CharacterMemento;
import pollub.rpghelper.enemies.Enemy;

public class CharacterTest {

    private Character character;
    private Enemy dummyEnemy;

    @Before
    public void setUp() {
        character = new Character(CharacterClass.WARRIOR, 100.0, 10.0, 10, new CharacterMemento());
        dummyEnemy = new HumanEnemy(20.0, 5.0);
    }

    @Test
    public void testConstructorWithProfession() {
        assertEquals(CharacterClass.WARRIOR, character.getCharacterClass());
    }

    @Test
    public void testGetAndSetHealth() {
        character.setHealth(50.0);
        assertEquals(50.0, character.getHealth(), 0.001);
    }

    @Test
    public void testHealMethod() {
        character.heal(20.0);
        assertEquals(120.0, character.getHealth(), 0.001);
    }

    @Test
    public void testAttackMethod() {
        double maxHealth = character.getHealth();
        character.attack(dummyEnemy);
        assertTrue(dummyEnemy.getHealth() < maxHealth);
    }

    @Test
    public void testAddExperiencePoints() {
        character.addExperiencePoints(500.0);
        assertEquals(500.0, character.getExperiencePoints(), 0.001);
    }
}
