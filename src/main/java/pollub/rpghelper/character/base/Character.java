package pollub.rpghelper.character.base;

import pollub.rpghelper.adapters.Entity;
import pollub.rpghelper.character.CharacterClass;
import pollub.rpghelper.character.CharacterType;
import pollub.rpghelper.command.CharacterCommand;
import pollub.rpghelper.enemies.Enemy;
import pollub.rpghelper.items.ItemInventory;
import pollub.rpghelper.mementos.CharacterMemento;

public class Character implements Entity {
    private CharacterClass characterClass;
    private double health;
    private double damage;
    private int level;
    private double experiencePoints;

    private CharacterType type;

    private ItemInventory inventory;
    private CharacterMemento memento;

    public Character(CharacterClass profession, double health, double damage, int inventorySize, CharacterMemento memento) {
        this.type = new CharacterType("", profession, "");
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
        this.memento = memento;
    }

    // Flyweight - Piotr Wróbel
    public Character(CharacterType type, double health, double damage, int inventorySize, CharacterMemento memento) {
        this.type = type;
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
        this.memento = memento;
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
    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void display() {
        System.out.println("Damage: " + this.damage);
        System.out.println("Health: " + this.health);
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
        memento.executeCommand(command, this);
    }

    public void undoLastCommand() {
        memento.undoLastCommand(this);
    }


    public double getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(double experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void addExperiencePoints(double experiencePoints) {
        this.experiencePoints += experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
