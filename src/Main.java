import character.CharacterClass;
import character.CharacterFactory;
import character.base.Character;
import command.AttackCommand;
import command.CharacterCommand;
import command.HealCommand;
import enemies.Enemy;
import enemies.HumanEnemy;

import java.util.ArrayList;

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
    }
}
