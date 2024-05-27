package pollub.rpghelper.board;

// Visitor - Piotr Wróbel
public interface Visitor {
    String visitCharacter(CharacterSprite c);
    String visitEnemy(EnemySprite e);
    String visitArmor(ArmorSprite a);
    String visitWeapon(WeaponSprite w);
}
// Visitor end - week 6