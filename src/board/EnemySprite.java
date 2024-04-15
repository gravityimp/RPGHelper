package board;

import enemies.Enemy;

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

    public Enemy getEnemy() {
        return enemy;
    }
}
// Visitor end - week 6
