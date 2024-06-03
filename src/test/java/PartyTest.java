import org.junit.Before;
import org.junit.Test;
import pollub.rpghelper.character.base.Character;
import pollub.rpghelper.character.CharacterClass;
import pollub.rpghelper.party.Party;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PartyTest {

    private Party party;

    @Before
    public void setUp() throws Exception {
        this.party = new Party();
    }

    @Test
    public void testAddMember() {
        party.addMember(100.0, 10.0, 5, "Warrior", CharacterClass.WARRIOR, "A brave warrior");
        List<Character> members = party.getMembers();
        assertEquals(1, members.size());
    }

    @Test
    public void testGetHealthWithSingleMember() {
        party.addMember(100.0, 10.0, 5, "Warrior", CharacterClass.WARRIOR, "A brave warrior");
        assertEquals(100.0, party.getHealth());
    }

    @Test
    public void testGetDamageWithSingleMember() {
        party.addMember(100.0, 10.0, 5, "Warrior", CharacterClass.WARRIOR, "A brave warrior");
        assertEquals(10.0, party.getDamage());
    }

    @Test
    public void testGetHealthWithMultipleMembers() {
        party.addMember(100.0, 10.0, 5, "Warrior", CharacterClass.WARRIOR, "A brave warrior");
        party.addMember(200.0, 20.0, 10, "Mage", CharacterClass.MAGE, "A wise mage");
        assertEquals(300.0, party.getHealth());
    }

    @Test
    public void testGetDamageWithMultipleMembers() {
        party.addMember(100.0, 10.0, 5, "Warrior", CharacterClass.WARRIOR, "A brave warrior");
        party.addMember(200.0, 20.0, 10, "Mage", CharacterClass.MAGE, "A wise mage");
        assertEquals(30.0, party.getDamage());
    }
}
