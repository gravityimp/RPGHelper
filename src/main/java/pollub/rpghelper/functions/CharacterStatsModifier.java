package pollub.rpghelper.functions;

import pollub.rpghelper.character.base.Character;

@FunctionalInterface
public interface CharacterStatsModifier<T> {
    void updateCharacter(Character character, T item);
}
