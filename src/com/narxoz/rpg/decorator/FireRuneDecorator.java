package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    private static final int FIRE_BONUS = 10;

    @Override
    public String getActionName() {
        // TODO: Decide how this decorator changes the visible action name.
        return super.getActionName() + "Fire Bonus";
    }

    @Override
    public int getDamage() {
        // TODO: Add fire-related behavior on top of wrapped damage.
        return super.getDamage() + FIRE_BONUS;
    }

    @Override
    public String getEffectSummary() {
        // TODO: Append or compose the fire effect description.
        return super.getEffectSummary() + "fire attack : "+ FIRE_BONUS +" dmg";
    }
}
