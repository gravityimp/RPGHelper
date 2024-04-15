package board;

import character.base.Character;

// Visitor - Piotr Wróbel
public class CharacterSprite implements Sprite {
    private int id;
    private int x;
    private int y;
    private String filepath;
    private Character character;

    public CharacterSprite(int id, int x, int y, String filepath, Character character) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.filepath = filepath;
        this.character = character;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitCharacter(this);
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

    public Character getCharacter() {
        return character;
    }
}
// Visitor end - week 6
