package character.base;

import adapters.Entity;
import character.CharacterClass;
import character.CharacterType;
import items.ItemInventory;

public class Character implements Entity {

    private CharacterClass characterClass;
    private double health;
    private double damage;

    private CharacterType type;

    private ItemInventory inventory;

    public Character(CharacterClass profession, double health, double damage, int inventorySize) {
        this.type = new CharacterType("", profession, "");
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
    }

    // Flyweight - Piotr Wróbel
    public Character(CharacterType type, double health, double damage, int inventorySize) {
        this.type = type;
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
    }
    // Flyweight end - week 4

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public CharacterClass getCharacterClass() {
        return type.getProfession();
    }
}
