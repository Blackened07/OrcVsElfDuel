package Character;

import Weapons.Weapons;


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

    public void spendMana (int mana) {
        setMana(getMana() - mana);
    }

    @Override
    public void setWeapon(Weapons weapon) {
        super.setWeapon(weapon);
        setMana(getMana() + weapon.getMana());
    }

    @Override
    public void getStatusMessage() {
        System.out.println(getName() + " is " + getHealth() + " health, " + getMana() + " mana, " + getAttackPower() + " attack power, " +
                getArmor() + " armor, " + getEvasion() + " Evasion, " + getAttackSpeed() + " attack speed");
    }

    @Override
    public void getStartMessage() {
        System.out.println(getName() + " is starting " + getHealth() + " health, " + getMana() + " mana, " + getAttackPower() + " attack power, " +
                getArmor() + " armor, " + getEvasion() + " Evasion, " + getAttackSpeed() + " attack speed");
    }
}
