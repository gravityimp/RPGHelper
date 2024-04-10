package mediators;

import command.CharacterCommand;
import character.base.Character;

import java.util.Stack;

public class CharacterCommandMediator {
    private Stack<CharacterCommand> commandHistory = new Stack<>();

    public void executeCommand(CharacterCommand command, Character character) {
        command.execute(character);
        commandHistory.push(command);
    }

    public void undoLastCommand(Character character) {
        if (!commandHistory.isEmpty()) {
            CharacterCommand lastCommand = commandHistory.pop();
            lastCommand.undo(character);
        }
    }

    public void backup(CharacterCommand command, Character character) {
        // Implement backup logic if needed
    }
}