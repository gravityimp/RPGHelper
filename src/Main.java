import character.CharacterClass;
import character.CharacterFactory;
import character.base.Character;
import command.AttackCommand;
import command.CharacterCommand;
import command.HealCommand;
import enemies.Enemy;
import enemies.HumanEnemy;
import enemies.MonsterEnemy;
import iterators.HumanEnemyIterator;
import iterators.MonsterEnemyIterator;

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

        HumanEnemyIterator humanEnemyIterator = new HumanEnemyIterator(new ArrayList<HumanEnemy>() {{
            add(new HumanEnemy(10, 2));
            add(new HumanEnemy(8, 3));
            add(new HumanEnemy(4, 10));
        }});

        // Iterator implementation - begin
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
    }
}
