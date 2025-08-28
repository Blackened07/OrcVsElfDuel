package Weapons;

public class Axe extends Weapons{
    protected int health;
    protected int evasion;

    public Axe(int attack, int attackSpeed) {
        super(attack, attackSpeed);
    }
    public Axe(int attack, int attackSpeed, int health) {
        super(attack, attackSpeed);
        this.health = health;
    }
    public Axe(int attack, int attackSpeed, int health, int evasion) {
        super(attack, attackSpeed);
        this.health = health;
        this.evasion = evasion;
    }

    public int getHealth() {
        return health;
    }
}
