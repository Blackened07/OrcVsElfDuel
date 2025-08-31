package Spells;
import Character.Character;
import Character.Elf;

import java.util.Random;

public class Fireball extends Spell{
    private final static int DMG = 80;
    private final static int MANA_COST = 28;
    private final static int COOLDOWN = 6;
    private final static int DMG_SPREAD = 10;

    private final Elf caster;

    public Fireball(Elf caster) {
        super("FireBall", COOLDOWN);
        this.caster = caster;
    }

    @Override
    public void cast(Character enemy) {
        super.cast(enemy);
        int dmg = DMG + new Random().nextInt(DMG_SPREAD);
        caster.spendMana(MANA_COST);
        System.out.println("Elf summoned the spirits of fire!");
        System.out.println(caster.getName() + " dealt " + dmg + " damage with the " + getSpellName() + " spell");
        enemy.damage(dmg);
    }
}
