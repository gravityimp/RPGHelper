package board;

import items.base.Weapon;

// Visitor - Piotr Wróbel
public class WeaponSprite implements Sprite {
    private int id;
    private int x;
    private int y;
    private String filepath;
    private Weapon weapon;

    public WeaponSprite(int id, int x, int y, String filepath, Weapon weapon) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.filepath = filepath;
        this.weapon = weapon;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitWeapon(this);
    }

    @Override
    public void move(int x, int y) {
        if (this.x + x >= 0 && this.x + x <= 100)
            this.x += x;
        if (this.y + y >= 0 && this.y + y <= 100)
            this.y += y;
    }

    @Override
    public void draw() {
        System.out.println(filepath);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getFilepath() {
        return filepath;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
// Visitor end - week 6
