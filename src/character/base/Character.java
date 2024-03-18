package character.base;

import adapters.Entity;
import character.CharacterClass;
import items.ItemInventory;

public class Character implements Entity {

    private CharacterClass characterClass;
    private double health;
    private double damage;

    private ItemInventory inventory;

    public Character(CharacterClass characterClass, double health, double damage, int inventorySize) {
        this.characterClass = characterClass;
        this.health = health;
        this.damage = damage;

        this.inventory = new ItemInventory(inventorySize);
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }
}
