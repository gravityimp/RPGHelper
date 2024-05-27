package pollub.rpghelper.functions;

@FunctionalInterface
public interface RandomItemGenerator<T> {
    T generateItem();
}
