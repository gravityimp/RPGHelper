package pollub.rpghelper.board;

import pollub.rpghelper.character.base.Character;
import static pollub.rpghelper.board.BoardConstants.*;

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

    public Character getCharacter() {
        return character;
    }
}
// Visitor end - week 6
