package mediators.entities;

import mediators.CharacterCommandMediator;

public class Character {
    // existing fields and methods

    private CharacterCommandMediator mediator;

    public Character(CharacterCommandMediator mediator) {
        this.mediator = mediator;
    }

    public void executeCommand(CharacterCommandMediator command) {
        mediator.executeCommand(command, this);
    }

    public void undoLastCommand() {
        mediator.undoLastCommand();
    }

    public void backup(CharacterCommandMediator command) {
        mediator.backup(command, this);
    }
}