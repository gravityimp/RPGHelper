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
        System.out.println(character.getCharacterClass()+" was healed by: "+amount);
    }

    @Override
    public void undo(Character character) {
        character.setHealth(previousHealth);
        System.out.println("Undo healing for "+amount);
    }

    @Override
    public void backup(Character character) {
        previousHealth = character.getHealth();
        System.out.println("Healing backup created! [" + previousHealth + " HP]");
    }
}
