package strategies;

import items.base.Armor;

public class ArmorUsageStrategy implements  ItemUsageStrategy{
    private Armor armor;

    public ArmorUsageStrategy(Armor armor) {
        this.armor = armor;
    }

    @Override
    public void use() {
        System.out.println("Equipping " + armor.getName() + " for defense!");
    }
}
