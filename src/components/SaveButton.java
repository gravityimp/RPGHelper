package components;

import mediators.Mediator;

// Mediator - Piotr Wróbel
public class SaveButton implements Component {
    private Mediator mediator;

    public SaveButton() {}

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /*
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.saveChanges();
    } */

    @Override
    public String getName() {
        return "SaveButton";
    }
}
// Mediator end - week 5