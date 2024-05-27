package pollub.rpghelper.decorators;

import pollub.rpghelper.items.base.Item;
import pollub.rpghelper.strategies.ItemUsageStrategy;

// Decorator Pattern - Yurii Tyshchenko
public class EnchantedItemDecorator implements Item {
    private Item item;
    private String enchantment;

    private ItemUsageStrategy strategy;

    public EnchantedItemDecorator(Item item, String enchantment) {
        this.item = item;
        this.enchantment = enchantment;
    }

    @Override
    public void use() {
        item.use();
        System.out.println("Applying enchantment: " + enchantment);
    }

    @Override
    public void setUsageStrategy(ItemUsageStrategy usageStrategy) {
        item.setUsageStrategy(usageStrategy);
    }

    @Override
    public void display() {
        item.display();
        System.out.println("Enchantment: " + enchantment);
    }

    @Override
    public Item clone() {
        Item clonedItem = item.clone();
        return new EnchantedItemDecorator(clonedItem, enchantment);
    }
}
// Decorator Pattern end - week 3
