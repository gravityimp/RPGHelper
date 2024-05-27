package pollub.rpghelper.interpreters;

import java.util.Random;

// Interpreter - Piotr Wróbel
public class DiceRollExpression extends RollExpression {
    private final int sides;

    public DiceRollExpression(int sides) {
        this.sides = sides;
    }
    @Override
    public int interpret() {
        return rollDice(sides);
    }

    private int rollDice(int sides) {
        Random random = new Random();
        return random.nextInt(sides) + 1;
    }
}
// Interpreter end - week 5