package pollub.rpghelper.items.base;

import pollub.rpghelper.strategies.ItemUsageStrategy;

// Prototype Pattern Declaration (cloning) - (Yurii Tyshchenko)
public interface Item {
    void use();
    void setUsageStrategy(ItemUsageStrategy usageStrategy);
    void display();
    Item clone(); // Prototype Pattern Declaration end - week 2
    
}
