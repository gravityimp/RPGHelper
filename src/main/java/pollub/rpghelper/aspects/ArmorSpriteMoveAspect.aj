package pollub.rpghelper.aspects;

import pollub.rpghelper.board.ArmorSprite;

import static pollub.rpghelper.board.BoardConstants.*;

public aspect ArmorSpriteMoveAspect {
    pointcut callMove(int x, int y, ArmorSprite sprite) :
                call(* ArmorSprite.move(int, int)) && args(x, y) && target(sprite);

        before(int x, int y, ArmorSprite sprite) : callMove(x, y, sprite) {
        }

        boolean around(int x, int y, ArmorSprite sprite) :
                callMove(x, y, sprite) {
            if (sprite.getX() + x < BOARD_MIN_WIDTH || sprite.getX() + x > BOARD_MAX_WIDTH)
                return false;
            if (sprite.getY() + y < BOARD_MIN_HEIGHT || sprite.getY() + y > BOARD_MAX_HEIGHT)
                return false;
            return proceed(x, y, sprite);
        }

        after(int x, int y, ArmorSprite sprite) : callMove(x, y, sprite) {
        }
    }
