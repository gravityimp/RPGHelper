package pollub.rpghelper.aspects;

import pollub.rpghelper.character.base.Character;
import pollub.rpghelper.templates.LevelingSystem;

public aspect LevelUpAspect {
    pointcut callLevelUp(Character character, int experiencePoints, LevelingSystem system) :
            call(* LevelingSystem.levelUp(..)) && args(character, experiencePoints) && target(system);

        before(Character character, int experiencePoints, LevelingSystem system) : callLevelUp(character, experiencePoints, system) {
        }

        void around(Character character, int experiencePoints, LevelingSystem system) : callLevelUp(character, experiencePoints, system) {
            if (system.canLevelUp(character)) {
                return;
            }

            proceed(character, experiencePoints, system);
        }

        after(Character character, int experiencePoints, LevelingSystem system) : callLevelUp(character, experiencePoints, system) {
        }
    }