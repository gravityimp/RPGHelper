package quests;

import quests.rewards.Reward;

// Builder Pattern - Piotr Wróbel
public class Quest {

    private String name;
    private String description;
    private String difficulty;
    private Reward reward;

    private Quest() {}

    private Quest(QuestBuilder builder) {
        Quest quest = builder.build();
        this.name = quest.name;
        this.description = quest.description;
        this.difficulty = quest.difficulty;
        this.reward = quest.reward;
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
            // Validate required fields
            if (name == null || description == null) {
                throw new IllegalStateException("Quest name and description must be set");
            }
            return new Quest(this);
        }
    }
}
// Builder Pattern end - week 2
