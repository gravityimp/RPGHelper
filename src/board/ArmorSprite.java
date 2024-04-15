package board;

import items.base.Armor;

// Visitor - Piotr Wróbel
public class ArmorSprite implements Sprite {
    private int id;
    private int x;
    private int y;
    private String filepath;
    private Armor armor;

    public ArmorSprite(int id, int x, int y, String filepath, Armor armor) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.filepath = filepath;
        this.armor = armor;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitArmor(this);
    }

    @Override
    public void move(int x, int y) {
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

    public Armor getArmor() {
        return armor;
    }
}
// Visitor end - week 6
