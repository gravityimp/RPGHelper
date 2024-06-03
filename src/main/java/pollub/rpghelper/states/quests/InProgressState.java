package pollub.rpghelper.states.quests;

import pollub.rpghelper.quests.Quest;
import pollub.rpghelper.states.QuestState;

public class InProgressState extends QuestState {

    public InProgressState(Quest quest) {
        super(quest);
    }

    @Override
    public String onStart() {
        throw new IllegalStateException("Quest '" + getQuest().getName()  + "' is already in progress.");
    }

    @Override
    public String onComplete() {
        System.out.println("Quest '" + getQuest().getName()  + "' has been completed.");
        getQuest().setState(new CompletedState(getQuest()));
        return "";
    }

    @Override
    public String onAbandon() {
        System.out.println("Quest '" + getQuest().getName() + "' has been abandoned.");
        getQuest().setState(new NotTakenState(getQuest()));
        return "";
    }
}
