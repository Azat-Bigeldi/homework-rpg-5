package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        // TODO: Decide reward rules based on battle outcome.
        if (battleResult == null) {
            return "No reward";
        }
        int rounds = battleResult.getRounds();
        String winner = battleResult.getWinner();
        if ("Draw".equals(winner)) {
            return "Consolation prize: 10 gold coins.";
        }if (rounds <= 5) {
            return "Legendary chest: 200 gold + Rare Weapon!";
        } else if (rounds <= 10) {
            return "Gold chest: 100 gold + Magic Armor.";
        } else {
            return "Bronze chest: 25 gold.";
        }
    }
}
