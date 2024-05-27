import board.*;
import character.CharacterClass;
import character.CharacterFactory;
import character.base.Character;
import command.AttackCommand;
import command.CharacterCommand;
import command.HealCommand;
import functions.CharacterStatsModifier;
import functions.RandomItemGenerator;
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
import quests.Quest;
import quests.rewards.BasicReward;
import templates.LevelingSystem;
import templates.SimpleLevelingSystem;

import java.util.*;

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
        RollExpression roll2D6 = new AndExpression(rollD6_1, rollD6_2);

        System.out.println("2d6: " + interpreter.interpret(roll2D6));
        RollExpression rollD20_1 = new DiceRollExpression(20);
        RollExpression rollD20_2 = new DiceRollExpression(20);
        RollExpression rollMaxD6 = new MaxExpression(rollD20_1, rollD20_2);

        System.out.println("Max of d20 rolls: " + interpreter.interpret(rollMaxD6));
        // Interpreter implementation - end

        // Observer Pattern implementation - begin
        Enemy e1 = new HumanEnemy(10, 2);
        AttackCommand ac = new AttackCommand(e1);

        ac.execute(myCharacter);
        // Observer Pattern implementation - end

        // State Pattern implementation - begin
        Quest q = new Quest.QuestBuilder().name("Quest 1").description("This is a sample quest!").difficulty("Hard").reward(new BasicReward(100, 10)).build();
        q.start();
        q.abandon();
        // State Pattern implementation - end

        // Template Method Pattern implementation - begin
        Character character = new Character(CharacterClass.WARRIOR, 12, 4, 9, new CharacterMemento());
        LevelingSystem levelingSystem = new SimpleLevelingSystem();

        for (int i = 0; i < 5; i++) {
            levelingSystem.levelUp(character, new Random().nextInt(50 + 1 - 15) + 15);
        }
        // Template Method Pattern implementation - end

        // Visitor implementation - begin
        CharacterSprite charSprite = new CharacterSprite(0, 0, 0, "images/char1.png", myCharacter);
        charSprite.move(1, 2);

        EnemySprite enemySprite = new EnemySprite(1, 10, 10, "images/guard.png", myEnemy);
        enemySprite.move(-2, -1);

        ItemData i = (new ItemData.ItemDataBuilder()).name("test").armor(2).health(3).damage(7).build();
        ArmorSprite armorSprite = new ArmorSprite(2, 1, 2, "images/chestplate.png", new Armor(i));
        WeaponSprite weaponSprite = new WeaponSprite(3, 1, 2, "images/sword.png", new Weapon(i));

        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(charSprite, enemySprite, armorSprite, weaponSprite));
        // Visitor implementation - end

        RandomItemGenerator<Armor> armorGenerator = () -> {
            Random RANDOM = new Random();
            ItemData itemData = (new ItemData.ItemDataBuilder())
                    .name("Armor " + RANDOM.nextInt(100))
                    .armor(RANDOM.nextDouble() * 30)
                    .build();
            return new Armor(itemData);
        };

        RandomItemGenerator<Weapon> weaponGenerator = () -> {
            Random RANDOM = new Random();
            ItemData itemData = (new ItemData.ItemDataBuilder())
                    .name("Weapon " + RANDOM.nextInt(100))
                    .damage(RANDOM.nextDouble() * 50)
                    .build();
            return new Weapon(itemData);
        };

        Map<String, Armor> armorMap = new HashMap<>();
        List<Weapon> weaponList = new ArrayList<>();

        for (int it = 0; it < 10; it++) {
            armorMap.put(it + ". armor in inventory", armorGenerator.generateItem());
            weaponList.add(weaponGenerator.generateItem());
        }

        armorMap.forEach((key, armor) -> {
            System.out.println(key + ":");
            armor.display();
            System.out.println("============");
        });

        weaponList
                .stream()
                .filter(weapon -> weapon.getDamage() > 30)
                .forEach(weapon -> {
                    weapon.display();
                    System.out.println("============");
                });

        Character modifiedCharacter = new Character(CharacterClass.WARRIOR, 12, 4, 9, new CharacterMemento());
        CharacterStatsModifier<Weapon> equipWeapon = (target, item) -> {
            double newDamage = target.getDamage() + item.getDamage();
            target.setDamage(newDamage);
        };

        Weapon modifyingWeapon = new Weapon(
                (new ItemData.ItemDataBuilder()).name("test").armor(2).health(3).damage(7).build()
        );
        equipWeapon.updateCharacter(modifiedCharacter, modifyingWeapon);

        System.out.println("============");
        System.out.println("Modified character:");
        modifiedCharacter.display();
    }
}
