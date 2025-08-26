import Weapons.Weapons;

import java.util.ArrayList;
import java.util.Objects;

public class Elf {
    private int health;
    private int mana;
    private int armor;
    private int evasion;
    private int attackPower;
    private int attackSpeed;
    Weapons sword;

    public Elf(int health, int mana, int armor, int evasion, int attackPower, int attackSpeed) {
        this.health = health;
        this.mana = mana;
        this.armor = armor;
        this.evasion = evasion;
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getArmor() {
        return armor;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower += attackPower;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed += attackSpeed;
    }

    public void setWeapon(Weapons weapon) {
        this.sword = weapon;
        setAttackSpeed(sword.getAttackSpeed());
        setAttackPower(sword.getAttack());
    }

    public int attackWithWeapon(Orc orc) {
        return getAttackPower() - (orc.getEvasion()/getAttackSpeed()) -
                ((orc.getArmor()*orc.getEvasion()/100)*3) + (getAttackSpeed()/100)*10;
    }

    public int castFireball(Orc orc) {
        return 80;
    }


}
