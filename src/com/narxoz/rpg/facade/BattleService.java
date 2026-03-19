package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        // TODO: Implement the battle flow.
        // Questions to answer:
        // - Who attacks first?
        // - How many rounds are allowed?
        // - How is damage resolved?
        // - How will randomness affect the result, if at all?
        AdventureResult result = new AdventureResult();
        int maxRounds = 20;
        int round = 0;

        while (hero.isAlive() && boss.isAlive() && round < maxRounds) {
            round++;
            // hero attacks First
            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);
            result.addLine(String.format(" Round %2d | %s attacks %s for %d dmg → boss HP: %d",
                    round,
                    hero.getName(),
                    boss.getName(),
                    heroDamage,
                    boss.getHealth()));

            if (!boss.isAlive()) break;

            // boss counter attacks Herp
            int bossDamage = boss.getAttackPower();
            int variance = (int) (bossDamage * 0.2);
            // Keep the field in use so students can decide whether to rely on it.
            bossDamage += random.nextInt(variance * 2 + 1) - variance;
                // TODO: Replace placeholder branch with real deterministic or random logic.
            hero.takeDamage(bossDamage);
            result.addLine(String.format("| %s counter-attacks %s for %d dmg → hero HP: %d",
                    boss.getName(),
                    hero.getName(),
                    bossDamage,
                    hero.getHealth()));
        }
        result.setRounds(round);

        if (boss.isAlive() && !hero.isAlive()) {
            result.setWinner(boss.getName());
        } else if (hero.isAlive()) {
            result.setWinner(hero.getName());
        } else {
            result.setWinner("Draw");
        }

        return result;
    }
}
