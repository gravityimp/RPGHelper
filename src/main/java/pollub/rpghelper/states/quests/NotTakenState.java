package pollub.rpghelper.states.quests;

import pollub.rpghelper.quests.Quest;
import pollub.rpghelper.states.QuestState;

public class NotTakenState extends QuestState {

    public NotTakenState(Quest quest) {
        super(quest);
    }

    @Override
    public String onStart() {
        System.out.println("Quest '" + getQuest().getName() + "' has been started.");
        getQuest().setState(new InProgressState(getQuest()));
        return "";
    }

    @Override
    public String onComplete() {
        throw new IllegalStateException("Quest '" + getQuest().getName() + "' cannot be completed because it has not been started.");
    }

    @Override
    public String onAbandon() {
        throw new IllegalStateException("Quest '" + getQuest().getName() + "' cannot be abandoned because it has not been started.");
    }
}
