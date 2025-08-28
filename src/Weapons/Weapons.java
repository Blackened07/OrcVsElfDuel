package Weapons;

public abstract class Weapons {
    protected int attack;
    protected int attackSpeed;

    public Weapons(int attack, int attackSpeed) {
        this.attack = attack;
        this.attackSpeed = attackSpeed;
    }

    public int getAttack() {
        return attack;
    }
    public int getAttackSpeed() {
        return attackSpeed;
    }


}
