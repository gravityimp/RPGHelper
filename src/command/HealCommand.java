package command;

import character.base.Character;

public class HealCommand implements CharacterCommand {
    private double amount;
    private double previousHealth;

    public HealCommand(double amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Character character) {
        previousHealth = character.getHealth();
        character.heal(amount);
    }

    @Override
    public void undo(Character character) {
        character.setHealth(previousHealth);
    }

    @Override
    public void backup(Character character) {
        previousHealth = character.getHealth();
    }
}
