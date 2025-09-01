package Spells;
import Character.Character;
import Character.Orc;
import Weapons.Weapons;

public class Disarm extends Spell{
    private final static int RAGE_COST = 20;
    private final static int COOLDOWN = 6;

    private final Orc orc;

    public Disarm(Orc orc) {
        super("Disarm", COOLDOWN);
        this.orc = orc;
    }

    @Override
    public String getSpellName() {
        return super.getSpellName();
    }


    @Override
    public void apply(Character enemy, Weapons[] weapon) {
        super.apply(enemy);
        orc.spendRage(RAGE_COST);
        System.out.println("Get your " + enemy.getWeaponName());
        System.out.println("The " + enemy.getName() +  " attack power is decreased");
        int getIndex = enemy.getIndexWeapon(weapon);
        for (int i = 0; i < weapon.length; i++) {
            if (getIndex == i){
                enemy.setAttackPower(enemy.getAttackPower() - weapon[i].getAttack());
                enemy.setAttackSpeed(enemy.getAttackSpeed() - weapon[i].getAttackSpeed());
                break;
            }
        }
    }

    @Override
    public void debuffCounter(Character enemy, Weapons[] weapon) {
        if (coolDawnRemaining == 4) {
            int getIndex = enemy.getIndexWeapon(weapon);
            for (int i = 0; i < weapon.length; i++) {
                if (getIndex == i) {
                    enemy.setAttackPower(enemy.getAttackPower() + weapon[i].getAttack());
                    enemy.setAttackSpeed(enemy.getAttackSpeed() + weapon[i].getAttackSpeed());
                    break;
                }
            }

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
