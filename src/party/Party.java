package party;

import character.CharacterClass;
import character.CharacterType;
import character.base.Character;
import mementos.CharacterMemento;

import java.util.ArrayList;
import java.util.List;

// Flyweight - Piotr Wróbel
public class Party {
    private List<Character> members = new ArrayList<>();

    public void addMember(double health, double damage, int inventorySize, String name, CharacterClass profession, String backstory) {
        CharacterType type = PartyFactory.getCharacterType(name, profession, backstory);
        Character member = new Character(type, health, damage, inventorySize, new CharacterMemento());
        members.add(member);
    }

    public double getHealth() {
        double health = 0.0;
        for(Character c: members) health += c.getHealth();
        return health;
    }

    public double getDamage() {
        double damage = 0.0;
        for(Character c: members) damage += c.getDamage();
        return damage;
    }
}
// Flyweight end - week 4