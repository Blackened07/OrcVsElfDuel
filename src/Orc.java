import Weapons.Sword;
import Weapons.Axe;
import Weapons.Mace;
import Weapons.Weapons;

import java.util.Random;

public class Orc  extends Character{
    private int rage;
    Weapons weapon;

    public Orc(int health, int armor, int evasion, int attackPower, int attackSpeed, String name, int rage) {
        super(health, armor, evasion, attackPower, attackSpeed, name);
        this.rage = rage;
    }
    public int getRage() {
        return rage;
    }
    public void setRage(int rage) {this.rage = rage;
    }

    Random rand = new Random();
    @Override
    public void attackWithWeapon(Character enemy) {
        int dmg = getAttackPower() - (enemy.getEvasion()/getAttackSpeed()) -
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + getAttackSpeed()/5 + rand.nextInt(10); ;
        enemy.damage(dmg);
        System.out.println(enemy.getName() + " получил " + dmg + " урона. ");
    }

    @Override
    public void damage(int dmg) {
        health -= dmg;
    }

    public int castBerserk() {
        return 28;
    }


    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
        setAttackPower(getAttackPower() + weapon.getAttack());
        setAttackSpeed(getAttackSpeed() + weapon.getAttackSpeed());
        setHealth(getHealth() + weapon.getHealth());
        setEvasion(getEvasion() + weapon.getEvasion());
    }
}

