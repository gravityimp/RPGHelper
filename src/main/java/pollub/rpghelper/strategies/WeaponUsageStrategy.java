package pollub.rpghelper.strategies;

import pollub.rpghelper.items.base.Weapon;

public class WeaponUsageStrategy implements ItemUsageStrategy {
    private Weapon weapon;

    public WeaponUsageStrategy(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void use() {
        System.out.println("Swinging " + weapon.getName() + " to attack!");
    }
}

