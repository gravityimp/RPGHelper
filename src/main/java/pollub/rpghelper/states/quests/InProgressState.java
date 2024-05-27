package pollub.rpghelper.states.quests;

import pollub.rpghelper.quests.Quest;
import pollub.rpghelper.states.QuestState;

public class InProgressState extends QuestState {

    public InProgressState(Quest quest) {
        super(quest);
    }

    @Override
    public String onStart() {
        System.out.println("Quest '" + getQuest().getName()  + "' is already in progress.");
        return "";
    }

    @Override
    public String onComplete() {
        System.out.println("Quest '" + getQuest().getName()  + "' cannot be completed while in progress.");
        return "";
    }

    @Override
    public String onAbandon() {
        System.out.println("Quest '" + getQuest().getName() + "' has been abandoned.");
        getQuest().setState(new NotTakenState(getQuest()));
        return "";
    }
}
