package pollub.rpghelper.board;

import pollub.rpghelper.enemies.Enemy;
import static pollub.rpghelper.board.BoardConstants.*;

// Visitor - Piotr Wróbel
public class EnemySprite implements Sprite {
    private int id;
    private int x;
    private int y;
    private String filepath;
    private Enemy enemy;

    public EnemySprite(int id, int x, int y, String filepath, Enemy enemy) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.filepath = filepath;
        this.enemy = enemy;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitEnemy(this);
    }

    @Override
    public void move(int x, int y) {
        if (this.x + x >= BOARD_MIN_WIDTH && this.x + x <= BOARD_MAX_WIDTH)
            this.x += x;
        if (this.y + y >= BOARD_MIN_HEIGHT && this.y + y <= BOARD_MAX_HEIGHT)
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

    public Enemy getEnemy() {
        return enemy;
    }
}
// Visitor end - week 6
