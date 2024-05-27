package functions;

import character.base.Character;

@FunctionalInterface
public interface CharacterStatsModifier<T> {
    void updateCharacter(Character character, T item);
}
