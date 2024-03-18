package adapters;

// Adapter - (Piotr Wróbel)
public class EntityAdapter implements Entity {
    private Entity entity;

    public EntityAdapter(Entity entity) {
        this.entity = entity;
    }

    @Override
    public double getHealth() {
        return entity.getHealth();
    }

    @Override
    public double getDamage() {
        return entity.getDamage();
    }
}

// Adapter end - week 3
