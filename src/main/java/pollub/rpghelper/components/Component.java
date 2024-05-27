package pollub.rpghelper.components;

import pollub.rpghelper.mediators.Mediator;

// Mediator - Piotr Wróbel
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
// Mediator end - week 5