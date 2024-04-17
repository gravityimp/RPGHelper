package quests;

import quests.rewards.Reward;
import states.QuestState;
import states.quests.NotTakenState;

// Builder Pattern - Piotr Wróbel
public class Quest {

    private String name;
    private String description;
    private String difficulty;
    private Reward reward;

    private QuestState state;

    private Quest() {}

    private Quest(QuestBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.difficulty = builder.difficulty;
        this.reward = builder.reward;

        this.state = new NotTakenState(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Reward getReward() {
        return reward;
    }

    public QuestState getState() {
        return state;
    }

    public void setState(QuestState state) {
        this.state = state;
    }

    public void start() {
        state.onStart();
    }

    public void complete() {
        state.onComplete();
    }

    public void abandon() {
        state.onAbandon();
    }

    public static class QuestBuilder {
        private String name;
        private String description;
        private String difficulty;
        private Reward reward;

        // Setters for quest attributes
        public QuestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public QuestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public QuestBuilder difficulty(String difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public QuestBuilder reward(Reward reward) {
            this.reward = reward;
            return this;
        }

        // Method to build a Quest instance
        public Quest build() {
            if (name == null || description == null) {
                throw new IllegalStateException("Quest name and description must be set");
            }
            return new Quest(this);
        }
    }
}
// Builder Pattern end - week 2
