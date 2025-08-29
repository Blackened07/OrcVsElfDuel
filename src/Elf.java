
import Weapons.Weapons;

import java.util.Random;


public class Elf extends Character {
    private int mana;
    Weapons weapon;

    public Elf(int health, int armor, int evasion, int attackPower, int attackSpeed, String name, int mana) {
        super(health, armor, evasion, attackPower, attackSpeed, name);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int castFireball() {
        return 80;
    }
    Random rand = new Random();
    @Override
    public void attackWithWeapon(Character enemy) {
        int dmg = getAttackPower() - (enemy.getEvasion()/getAttackSpeed()) -
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + getAttackSpeed()/5 + rand.nextInt(10) ;
        enemy.damage(dmg);
        System.out.println(enemy.getName() + " получил " + dmg + " урона. ");
    }

    @Override
    public void damage(int dmg) {
        super.health -= dmg;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
        setAttackPower(getAttackPower() + weapon.getAttack());
        setAttackSpeed(getAttackSpeed() + weapon.getAttackSpeed());
        setHealth(getHealth() + weapon.getHealth());
        setEvasion(getEvasion() + weapon.getEvasion());
        setMana(getMana() + weapon.getMana());
    }
}
