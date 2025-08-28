package Weapons;

public abstract class Weapons {
    protected String name;
    protected int attack;
    protected int attackSpeed;
    protected int health;
    protected int evasion;
    protected int mana;

    public Weapons(String name, int attack, int attackSpeed, int health, int evasion, int mana) {
        this.name = name;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
        this.health = health;
        this.evasion = evasion;
        this.mana = mana;
    }


    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }


}
