package pollub.rpghelper.board;

import pollub.rpghelper.items.base.Weapon;
import static pollub.rpghelper.board.BoardConstants.*;

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
    public boolean move(int x, int y) {
        this.x += x;
        this.y += y;

        return true;
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
