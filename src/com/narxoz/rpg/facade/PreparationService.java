package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        // TODO: Validate inputs and return a useful preparation summary.
        // You may also decide to initialize temporary state here.
        if (hero == null || boss == null || action == null) {
            throw new IllegalArgumentException("boss or hero or action must not be null");
        }
        return String.format(
                "Preparation complete — %s (HP: %d) enters the dungeon to face %s (HP: %d) wielding \\\"%s\\\" (dmg: %d).",
                hero.getName(), hero.getHealth(),
                boss.getName(),
                boss.getHealth(),
                action.getActionName(),
                action.getDamage());
    }
}
