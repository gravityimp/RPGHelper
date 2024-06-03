import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import pollub.rpghelper.quests.Quest;
import pollub.rpghelper.quests.rewards.BasicReward;
import pollub.rpghelper.quests.rewards.Reward;
import pollub.rpghelper.states.quests.CompletedState;
import pollub.rpghelper.states.quests.InProgressState;
import pollub.rpghelper.states.quests.NotTakenState;

public class QuestTest {

    private Quest quest;

    @Before
    public void setUp() {
        quest = new Quest.QuestBuilder()
                .name("Test Quest")
                .description("This is a test quest to test the quest")
                .difficulty("Easy")
                .reward(new BasicReward(100, 50)) // Setting a BasicReward with 100 experience and 50 gold
                .build();
    }

    @Test
    public void testQuestCreation() {
        assertNotNull(quest.getName());
        assertNotNull(quest.getDescription());
        assertEquals("Easy", quest.getDifficulty());
        assertNotNull(quest.getReward());
        assertEquals(NotTakenState.class, quest.getState().getClass());
    }

    @Test
    public void testAbandonQuestStateTransition() {
        quest.start();
        assertEquals(InProgressState.class, quest.getState().getClass());

        quest.abandon();
        assertEquals(NotTakenState.class, quest.getState().getClass());

        quest.start();
        assertEquals(InProgressState.class, quest.getState().getClass());
    }

    @Test
    public void testCompleteQuestStateTransition() {
        quest.start();
        assertEquals(InProgressState.class, quest.getState().getClass());

        quest.complete();
        assertEquals(CompletedState.class, quest.getState().getClass());
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidQuestStateTransition() {
        quest.complete();
        quest.start();
    }

    @Test
    public void testRewardStructure() {
        Reward reward = quest.getReward();
        assertTrue(reward instanceof BasicReward);

        BasicReward basicReward = (BasicReward) reward;
        assertEquals(100, basicReward.getExperience());
        assertEquals(50, basicReward.getGold());
        assertFalse(basicReward.isItemReward());
        assertTrue(basicReward.getItems().isEmpty());
    }
}
