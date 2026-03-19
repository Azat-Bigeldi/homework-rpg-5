package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    private static final int POISON_BONUS = 5;

    @Override
    public String getActionName() {
        // TODO: Decide how this decorator changes the visible action name.
        return super.getActionName() + "Poison coating";
    }

    @Override
    public int getDamage() {
        // TODO: Add poison-related behavior on top of wrapped damage.
        return super.getDamage()  + POISON_BONUS;
    }

    @Override
    public String getEffectSummary() {
        // TODO: Append or compose the poison effect description.
        return super.getEffectSummary() + "poison coating : " + POISON_BONUS + " dmg";
    }
}
