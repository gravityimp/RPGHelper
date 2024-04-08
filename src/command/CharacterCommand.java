package command;


import character.base.Character;

public interface CharacterCommand {
    void backup(Character character);
    void undo(Character character);
    void execute(Character character);
}