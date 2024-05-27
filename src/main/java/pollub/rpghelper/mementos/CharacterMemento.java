package pollub.rpghelper.mementos;

import pollub.rpghelper.command.CharacterCommand;
import pollub.rpghelper.character.base.Character;

import java.util.Stack;

// Memento - Yurii Tyshchenko
public class CharacterMemento {
    private Stack<CharacterCommand> commandHistory = new Stack<>();
    private Stack<CharacterCommand> undoneCommands = new Stack<>();

    public void executeCommand(CharacterCommand command, Character character) {
        command.execute(character);
        commandHistory.push(command);
        undoneCommands.clear();
    }

    public void undoLastCommand(Character character) {
        if (!commandHistory.isEmpty()) {
            CharacterCommand lastCommand = commandHistory.pop();
            lastCommand.undo(character);
            undoneCommands.push(lastCommand);
        }
    }

    public void redoLastCommand(Character character) {
        if (!undoneCommands.isEmpty()) {
            CharacterCommand lastUndoneCommand = undoneCommands.pop();
            lastUndoneCommand.execute(character);
            commandHistory.push(lastUndoneCommand);
        }
    }

    public void backup(CharacterCommand command, Character character) {
        // Backup logic
    }
}
// Memento end - week 5