package Character;

import Weapons.Weapons;

public class Orc extends Character{
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
    public void spendRage (int rage) {
        setRage(getRage() - rage);
    }

    public int castBerserk() {
        return 28;
    }

    @Override
    public void getStatusMessage() {
        System.out.println(getName() + " is " + getHealth() + " health, " + getRage() + " rage, " + getAttackPower() + " attack power, " +
                getArmor() + " armor, " + getEvasion() + " Evasion, " + getAttackSpeed() + " attack speed");
    }

    @Override
    public void getStartMessage() {
        System.out.println(getName() + " is starting with " + getHealth() + " health, " + getRage() + " rage, " + getAttackPower() + " attack power, " +
                getArmor() + " armor, " + getEvasion() + " Evasion, " + getAttackSpeed() + " attack speed");
    }
}

