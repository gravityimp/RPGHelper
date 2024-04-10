package interpreters;

// Interpreter - Piotr Wróbel
public class MaxExpression extends RollExpression {
    private RollExpression expression1;
    private RollExpression expression2;

    public MaxExpression(RollExpression expression1, RollExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public int interpret() {
        int result1 = expression1.interpret();
        int result2 = expression2.interpret();
        return Math.max(result1, result2);
    }
}
// Interpreter end - week 5