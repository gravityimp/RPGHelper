package pollub.rpghelper.command;


import pollub.rpghelper.character.base.Character;

// Command - Yurii Tyshchenko
public interface CharacterCommand {
    void backup(Character character);
    void undo(Character character);
    void execute(Character character);
}
// Command end - week 5