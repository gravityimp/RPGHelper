package mementos;

import command.CharacterCommand;
import character.base.Character;

import java.util.Stack;

// Memento - Yurii Tyshchenko
public class CharacterMemento {
    private Stack<CharacterCommand> commandHistory = new Stack<>();
    private Stack<CharacterCommand> undoneCommands = new Stack<>();

    public void executeCommand(CharacterCommand command, Character character) {
        command.execute(character);
        commandHistory.push(command);
        undoneCommands.clear(); // Clear undone commands stack when a new command is executed
    }

    public void undoLastCommand(Character character) {
        if (!commandHistory.isEmpty()) {
            CharacterCommand lastCommand = commandHistory.pop();
            lastCommand.undo(character);
            undoneCommands.push(lastCommand); // Move the undone command to the undone stack
        }
    }

    public void redoLastCommand(Character character) {
        if (!undoneCommands.isEmpty()) {
            CharacterCommand lastUndoneCommand = undoneCommands.pop();
            lastUndoneCommand.execute(character);
            commandHistory.push(lastUndoneCommand); // Move the redone command back to the command history
        }
    }

    public void backup(CharacterCommand command, Character character) {
        // Implement backup logic if needed
    }
}
// Memento end - week 5