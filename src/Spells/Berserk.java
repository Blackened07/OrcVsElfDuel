package Spells;
import Character.Character;
import Character.Orc;

public class Berserk extends Spell{
    private final static int RAGE_COST = 15;
    private final static int COOLDOWN = 8;
    private final static int DMG = 28;

    private final Orc orc;

    public Berserk(Orc orc) {
        super("Berserk", COOLDOWN);
        this.orc = orc;
    }

    @Override
    public void apply(Character self) {
        super.apply(self);
        int dmg = DMG + orc.getAttackPower();
        orc.setAttackPower(dmg);
        orc.spendRage(RAGE_COST);
        System.out.println("The orc went berserk");
        System.out.println("The orc's force is increased by " + DMG);
    }

    @Override
    public void unapply() {
        if (coolDawnRemaining == 4) {
            orc.setAttackPower(orc.getAttackPower() - DMG);
            System.out.println("Insane is over");
        }
    }
}
