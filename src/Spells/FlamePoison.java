package Spells;
import Character.Elf;
import Character.Character;

import java.util.Random;

public class FlamePoison extends Spell{
    private final static int INSTANT_DMG = 56;
    private final static int OVERTIME_DMG = 10;
    private final static int MANA_COST = 45;
    private final static int COOLDOWN = 8;
    private final static int DMG_SPREAD = 5;

    private final Elf caster;

    public FlamePoison(Elf caster) {
        super("FlamePoison", COOLDOWN);
        this.caster = caster;
    }

    @Override
    public void cast(Character enemy) {
        super.apply(enemy);
        int dmg = INSTANT_DMG + new Random().nextInt(DMG_SPREAD);
        caster.spendMana(MANA_COST);
        System.out.println("Elf surrounded you with tongues of flame!");
        System.out.println(caster.getName() + " dealt " + dmg + " damage with the " + getSpellName() + " spell");
        enemy.damage(dmg);
    }

    @Override
    public void dmgCounter(Character enemy) {
        if (coolDawnRemaining > 4) {
            int dmg = OVERTIME_DMG + new Random().nextInt(DMG_SPREAD);
            enemy.damage(dmg);
            System.out.println("Flame burned for " + dmg + " damage");
        }
    }

    @Override
    public void unapply() {
        super.unapply();
    }

    @Override
    public void spellCounter() {
        super.spellCounter();
    }
}
