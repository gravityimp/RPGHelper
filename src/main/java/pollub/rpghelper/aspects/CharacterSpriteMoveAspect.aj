package pollub.rpghelper.aspects;

import pollub.rpghelper.board.CharacterSprite;

import static pollub.rpghelper.board.BoardConstants.*;

public aspect CharacterSpriteMoveAspect {
    pointcut callMove(int x, int y, CharacterSprite sprite) :
                call(* CharacterSprite.move(int, int)) && args(x, y) && target(sprite);

        before(int x, int y, CharacterSprite sprite) : callMove(x, y, sprite) {
        }

        boolean around(int x, int y, CharacterSprite sprite) :
                callMove(x, y, sprite) {
            if (sprite.getX() + x < BOARD_MIN_WIDTH || sprite.getX() + x > BOARD_MAX_WIDTH)
                return false;
            if (sprite.getY() + y < BOARD_MIN_HEIGHT || sprite.getY() + y > BOARD_MAX_HEIGHT)
                return false;

            return proceed();
        }

        after(int x, int y, CharacterSprite sprite) : callMove(x, y, sprite) {
        }
    }
