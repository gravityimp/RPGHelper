package interpreters;

// Interpreter - Piotr Wróbel
public class AndExpression extends RollExpression {
    private RollExpression expression1;
    private RollExpression expression2;

    public AndExpression(RollExpression expression1, RollExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public int interpret() {
        return expression1.interpret() + expression2.interpret();
    }
}
// Interpreter end - week 5