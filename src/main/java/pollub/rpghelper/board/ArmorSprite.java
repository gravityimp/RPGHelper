package pollub.rpghelper.board;

import pollub.rpghelper.items.base.Armor;

import static pollub.rpghelper.board.BoardConstants.*;

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
    public boolean move(int x, int y) {
        if (this.x + x < BOARD_MIN_WIDTH || this.x + x > BOARD_MAX_WIDTH)
            return false;
        if (this.y + y < BOARD_MIN_HEIGHT || this.y + y > BOARD_MAX_HEIGHT)
            return false;

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

    public Armor getArmor() {
        return armor;
    }
}
// Visitor end - week 6
