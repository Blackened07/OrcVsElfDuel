package Weapons;

public class Staff extends Weapons{
    protected int health;
    protected int evasion;
    protected int mana;

    public Staff(int attack, int attackSpeed) {
        super(attack, attackSpeed);
    }
    public Staff(int attack, int attackSpeed, int health) {
        super(attack, attackSpeed);
        this.health = health;
    }
    public Staff(int attack, int attackSpeed, int health, int mana) {
        super(attack, attackSpeed);
        this.health = health;
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }
}
