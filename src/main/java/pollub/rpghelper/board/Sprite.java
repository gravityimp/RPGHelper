package pollub.rpghelper.board;

// Visitor - Piotr Wróbel
public interface Sprite {
    boolean move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
// Visitor end - week 6