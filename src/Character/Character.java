package Character;

import Weapons.Weapons;

import java.util.Random;

public abstract class Character {
    protected int health;
    protected int armor;
    protected int evasion;
    protected int attackPower;
    protected int attackSpeed;
    protected String name;
    Weapons weapon;
    protected String weaponName;
    protected int indexWeapon;


    public Character(int health, int armor, int evasion, int attackPower, int attackSpeed, String name) {
        this.health = health;
        this.armor = armor;
        this.evasion = evasion;
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getIndexWeapon(Weapons[] weapon) {
        int index = -1;
        for (int i = 0; i < weapon.length; i++) {
            if (weapon[i].getName().equals(getWeaponName())) {
                index = i;

            }
        } return index;

    }

    public void attackWithWeapon(Character enemy) {
        int dmg = getAttackPower() - (enemy.getEvasion()/getAttackSpeed()) -
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + getAttackSpeed()/5 + new Random().nextInt(10);
        enemy.damage(dmg);
        System.out.println(getName() + " dealt " + dmg + " damage with the " + getWeaponName() + " weapon");
    }


    public void damage(int dmg) {
        health -= dmg;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
        this.weaponName = weapon.getName();
        setAttackPower(getAttackPower() + weapon.getAttack());
        setAttackSpeed(getAttackSpeed() + weapon.getAttackSpeed());
        setHealth(getHealth() + weapon.getHealth());
        setEvasion(getEvasion() + weapon.getEvasion());
    }


    public abstract void getStartMessage ();
    public abstract void getStatusMessage ();

}
