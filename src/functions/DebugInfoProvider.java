package functions;

@FunctionalInterface
public interface DebugInfoProvider<T> {
    void displayInfo(T item);
}