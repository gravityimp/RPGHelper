import board.*;
import character.CharacterClass;
import character.CharacterFactory;
import character.base.Character;
import command.AttackCommand;
import command.CharacterCommand;
import command.HealCommand;
import enemies.Enemy;
import enemies.HumanEnemy;
import enemies.MonsterEnemy;
import interpreters.DiceRollExpression;
import interpreters.MaxExpression;
import interpreters.AndExpression;
import interpreters.RollExpression;
import interpreters.RollInterpreter;
import items.ItemData;
import items.base.Armor;
import items.base.Weapon;
import iterators.HumanEnemyIterator;
import iterators.MonsterEnemyIterator;
import mementos.CharacterMemento;
import templates.LevelingSystem;
import templates.SimpleLevelingSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Character myCharacter = CharacterFactory.createCharacter(CharacterClass.ARCHER);
        Enemy myEnemy = new HumanEnemy(10, 2);

        ArrayList<CharacterCommand> characterCommands = new ArrayList<CharacterCommand>();
        characterCommands.add(new HealCommand(3));
        characterCommands.add(new AttackCommand(myEnemy));
        characterCommands.add(new HealCommand(5));
        characterCommands.add(new AttackCommand(myEnemy));

        for(CharacterCommand command : characterCommands) {
           command.execute(myCharacter);
        }

        for(CharacterCommand command : characterCommands) {
            command.undo(myCharacter);
        }

        System.out.println("\n=======================\n");

        // Iterator implementation - begin
        HumanEnemyIterator humanEnemyIterator = new HumanEnemyIterator(new ArrayList<HumanEnemy>() {{
            add(new HumanEnemy(10, 2));
            add(new HumanEnemy(8, 3));
            add(new HumanEnemy(4, 10));
        }});

        MonsterEnemyIterator monsterEnemyIterator = new MonsterEnemyIterator(new ArrayList<MonsterEnemy>() {{
            add(new MonsterEnemy(9, 4));
            add(new MonsterEnemy(7, 5));
            add(new MonsterEnemy(3, 12));
        }});

        while(monsterEnemyIterator.hasNext()) {
            MonsterEnemy monsterEnemy = (MonsterEnemy) monsterEnemyIterator.getNext();
            System.out.println("Monster Enemy with [" + monsterEnemy.getHealth() + " HP] and [" + monsterEnemy.getDamage() + " DMG]!");
        }
        // Iterator implementation - end

        // Interpreter implementation - begin
        RollInterpreter interpreter = new RollInterpreter();

        RollExpression rollD6_1 = new DiceRollExpression(6);
        RollExpression rollD6_2 = new DiceRollExpression(6);
        AndExpression roll2D6 = new AndExpression(rollD6_1, rollD6_2);

        System.out.println("2d6: " + interpreter.interpret(roll2D6));
        RollExpression rollD20_1 = new DiceRollExpression(20);
        RollExpression rollD20_2 = new DiceRollExpression(20);
        MaxExpression rollMaxD6 = new MaxExpression(rollD20_1, rollD20_2);

        System.out.println("Max of d20 rolls: " + interpreter.interpret(rollMaxD6));
        // Interpreter implementation - end

        // Template Method Pattern implementation - begin
        Character character = new Character(CharacterClass.WARRIOR, 12, 4, 9, new CharacterMemento());
        LevelingSystem levelingSystem = new SimpleLevelingSystem();

        for (int i = 0; i < 5; i++) {
            levelingSystem.levelUp(character);
        }
        // Template Method Pattern implementation - end


        // Visitor implementation - begin
        CharacterSprite charSprite = new CharacterSprite(0, 0, 0, "images/char1.png", myCharacter);
        charSprite.move(1, 2);

        EnemySprite enemySprite = new EnemySprite(1, 10, 10, "images/guard.png", myEnemy);
        enemySprite.move(-2, -1);

        ItemData.ItemDataBuilder itemBuilder = new ItemData.ItemDataBuilder();
        itemBuilder = itemBuilder.name("test").armor(2).health(3).damage(7);
        ItemData i = itemBuilder.build();
        ArmorSprite armorSprite = new ArmorSprite(2, 1, 2, "images/chestplate.png", new Armor(i));
        WeaponSprite weaponSprite = new WeaponSprite(3, 1, 2, "images/sword.png", new Weapon(i));

        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(charSprite, enemySprite, armorSprite, weaponSprite));
        // Visitor implementation - end
    }
}
