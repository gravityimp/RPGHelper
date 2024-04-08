package command;

import character.base.Character;
import enemies.Enemy;

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
    }

    @Override
    public void undo(Character character) {
        target.setHealth(previousTargetHealth);
    }

    @Override
    public void backup(Character character) {
        previousTargetHealth = target.getHealth();
    }
}
