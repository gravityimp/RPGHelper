package command;

import character.base.Character;
import enemies.Enemy;

// Command - Yurii Tyshchenko
public class AttackCommand implements CharacterCommand {
    private Enemy target;
    private double previousTargetHealth;

    public AttackCommand(Enemy target) {
        this.target = target;
    }

    @Override
    public void execute(Character character) {
        previousTargetHealth = target.getHealth();
        character.attack(target);
        System.out.println("Executed attack command!");
    }

    @Override
    public void undo(Character character) {
        target.setHealth(previousTargetHealth);
        System.out.println("Undo attack command!");
    }

    @Override
    public void backup(Character character) {
        previousTargetHealth = target.getHealth();
        System.out.println("Backup attack command!");
    }
}
// Command end - week 5