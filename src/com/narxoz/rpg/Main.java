package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        // TODO: Create a hero and a boss with your own meaningful stats.
        HeroProfile hero = new HeroProfile("Jeffrey", 100);
        BossEnemy boss = new BossEnemy("PDiddy", 120, 15);

        // TODO: Start with a base action and then create several decorated versions.
        AttackAction basic = new BasicAttack("Sword Strike", 10);
        AttackAction withCrit= new CriticalFocusDecorator(basic);
        AttackAction withPoison = new PoisonCoatingDecorator(basic);
        AttackAction withFire = new FireRuneDecorator(basic);
        AttackAction critAndFire = new FireRuneDecorator(new CriticalFocusDecorator(basic));
        AttackAction enhanced = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)
                )
        );

        System.out.println("--- Decorator Preview ---");
        System.out.println("Base action: " + basic);
        System.out.println("+Critical Focus: " + withCrit);
        System.out.println("+Poison Coating: " + withPoison);
        System.out.println("+Fire Rune: " +withFire);
        System.out.println("+ Critical Focus + Fire Rune: " + critAndFire);
        System.out.println("All three: " + enhanced);

        // TODO: Replace the placeholder preview above with richer proof of runtime composition.

        System.out.println("\n--- Facade Preview ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, enhanced);

        System.out.println("-- Round-by-round log--");
        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println("-- Adventure Summary --");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());

        // TODO: Expand this demo so it clearly proves:
        // 1) multiple decorator combinations
        // 2) one full dungeon run through the facade
        // 3) readable final summary

        System.out.println("\n=== Demo Complete ===");
    }
}
