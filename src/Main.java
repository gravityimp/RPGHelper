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
    }
}
