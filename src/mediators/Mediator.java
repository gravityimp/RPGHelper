package mediators;

// Mediator - Piotr Wróbel
public interface Mediator {
    void addMember(Character character);
    void deleteMember();
    void getMemberInfo(Character character);
    void saveChanges();
    void reset();
}
// Mediator end - week 5