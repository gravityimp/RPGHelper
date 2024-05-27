package pollub.rpghelper.states.quests;

import pollub.rpghelper.quests.Quest;
import pollub.rpghelper.states.QuestState;

public class CompletedState extends QuestState {

    public CompletedState(Quest quest) {
        super(quest);
    }

    @Override
    public String onStart() {
        System.out.println("Quest '" + getQuest().getName() + "' has already been completed.");
        return "";
    }

    @Override
    public String onComplete() {
        System.out.println("Quest '" + getQuest().getName() + "' has already been completed.");
        return "";
    }

    @Override
    public String onAbandon() {
        System.out.println("Quest '" + getQuest().getName() + "' has already been completed and cannot be abandoned.");
        return "";
    }
}