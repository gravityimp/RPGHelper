package pollub.rpghelper.states;

import pollub.rpghelper.quests.Quest;

public abstract class QuestState {
    private Quest quest;

    public QuestState(Quest quest) {
        this.quest = quest;
    }

    public abstract String onStart();
    public abstract String onAbandon();
    public abstract String onComplete();

    public Quest getQuest() {
        return quest;
    }
}