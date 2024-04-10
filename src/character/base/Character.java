package character.base;

import adapters.Entity;
import character.CharacterClass;
import character.CharacterType;
import command.CharacterCommand;
import enemies.Enemy;
import items.ItemInventory;
import mediators.CharacterCommandMediator;

public class Character implements Entity {

    private CharacterClass characterClass;
    private double health;
    private double damage;

    private CharacterType type;

    private ItemInventory inventory;
    private CharacterCommandMediator mediator;

    public Character(CharacterClass profession, double health, double damage, int inventorySize, CharacterCommandMediator mediator) {
        this.type = new CharacterType("", profession, "");
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
        this.mediator = mediator;
    }

    // Flyweight - Piotr Wróbel
    public Character(CharacterType type, double health, double damage, int inventorySize, CharacterCommandMediator mediator) {
        this.type = type;
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
        this.mediator = mediator;
    }
    // Flyweight end - week 4

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void heal(double amount) {
        this.health += amount;
    }

    public double getDamage() {
        return damage;
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(this.damage);
    }

    public void takeDamage(double damage) {
        this.health -= damage;
    }

    public CharacterClass getCharacterClass() {
        return type.getProfession();
    }

    public void executeCommand(CharacterCommand command) {
        mediator.executeCommand(command, this);
    }

    public void undoLastCommand() {
        mediator.undoLastCommand(this);
    }
}
