package board;

import character.base.Character;
import enemies.Enemy;
import items.base.Armor;
import items.base.Weapon;

// Visitor - Piotr Wróbel
public class XMLExportVisitor implements Visitor {
    public String export(Sprite... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for (Sprite s : args) {
            sb.append(s.accept(this)).append("\n");
        }
        return sb.toString();
    }

    public String visitCharacter(CharacterSprite c) {
        Character character = c.getCharacter();
        return "<character>" + "\n" +
                "    <id>" + c.getId() + "</id>" + "\n" +
                "    <x>" + c.getX() + "</x>" + "\n" +
                "    <y>" + c.getY() + "</y>" + "\n" +
                "    <img>" + c.getFilepath() + "</img>" + "\n" +
                "    <class>" + character.getCharacterClass() + "</class>" + "\n" +
                "    <health>" + character.getHealth() + "</health>" + "\n" +
                "    <damage>" + character.getDamage() + "</damage>" + "\n" +
                "</character>";
    }

    public String visitEnemy(EnemySprite e) {
        Enemy enemy = e.getEnemy();
        return "<enemy>" + "\n" +
                "    <id>" + e.getId() + "</id>" + "\n" +
                "    <x>" + e.getX() + "</x>" + "\n" +
                "    <y>" + e.getY() + "</y>" + "\n" +
                "    <img>" + e.getFilepath() + "</img>" + "\n" +
                "    <health>" + enemy.getHealth() + "</health>" + "\n" +
                "    <damage>" + enemy.getDamage() + "</damage>" + "\n" +
                "</enemy>";
    }

    public String visitArmor(ArmorSprite a) {
        Armor armor = a.getArmor();
        return "<armor>" + "\n" +
                "    <id>" + a.getId() + "</id>" + "\n" +
                "    <x>" + a.getX() + "</x>" + "\n" +
                "    <y>" + a.getY() + "</y>" + "\n" +
                "    <img>" + a.getFilepath() + "</img>" + "\n" +
                "    <name>" + armor.getName() + "</name>" + "\n" +
                "    <health>" + armor.getHealth() + "</health>" + "\n" +
                "    <armor>" + armor.getArmor() + "</armor>" + "\n" +
                "</armor>";
    }

    public String visitWeapon(WeaponSprite w) {
        Weapon weapon = w.getWeapon();
        return "<armor>" + "\n" +
                "    <id>" + w.getId() + "</id>" + "\n" +
                "    <x>" + w.getX() + "</x>" + "\n" +
                "    <y>" + w.getY() + "</y>" + "\n" +
                "    <img>" + w.getFilepath() + "</img>" + "\n" +
                "    <name>" + weapon.getName() + "</name>" + "\n" +
                "    <damage>" + weapon.getDamage() + "</damage>" + "\n" +
                "</armor>";
    }
}
// Visitor end - week 6