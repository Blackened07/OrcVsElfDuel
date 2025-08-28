package Weapons;

public class Dagger extends Weapons{
    protected int health;
    protected int evasion;

    public Dagger(int attack, int attackSpeed) {
        super(attack, attackSpeed);
    }
    public Dagger(int attack, int attackSpeed, int health) {
        super(attack, attackSpeed);
        this.health = health;
    }
    public Dagger(int attack, int attackSpeed, int health, int evasion) {
        super(attack, attackSpeed);
        this.health = health;
        this.evasion = evasion;
    }

    public int getHealth() {
        return health;
    }

    public int getEvasion() {
        return evasion;
    }
}
