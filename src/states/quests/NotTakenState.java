package states.quests;

import quests.Quest;
import states.QuestState;

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
        System.out.println("Quest '" + getQuest().getName() + "' cannot be completed because it has not been started.");
        return "";
    }

    @Override
    public String onAbandon() {
        System.out.println("Quest '" + getQuest().getName() + "' cannot be abandoned because it has not been started.");
        return "";
    }
}
