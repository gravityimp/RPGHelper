package functions;

@FunctionalInterface
public interface RandomItemGenerator<T> {
    T generateItem();
}
