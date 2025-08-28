package Weapons;

public class Mace extends Weapons{
    protected int health;
    protected int evasion;

    public Mace(int attack, int attackSpeed) {
        super(attack, attackSpeed);
    }
    public Mace(int attack, int attackSpeed, int health) {
        super(attack, attackSpeed);
        this.health = health;
    }
    public Mace(int attack, int attackSpeed, int health, int evasion) {
        super(attack, attackSpeed);
        this.health = health;
        this.evasion = evasion;
    }

    public int getHealth() {
        return health;
    }
}
