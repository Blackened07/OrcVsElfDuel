package Weapons;

public class Mace extends Weapons{

    public Mace(String name, int attack, int attackSpeed, int health, int evasion, int mana) {
        super(name, attack, attackSpeed, health, evasion, mana);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAttack() {
        return super.getAttack();
    }

    @Override
    public void setAttack(int attack) {
        super.setAttack(attack);
    }

    @Override
    public void setAttackSpeed(int attackSpeed) {
        super.setAttackSpeed(attackSpeed);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getEvasion() {
        return super.getEvasion();
    }

    @Override
    public void setEvasion(int evasion) {
        super.setEvasion(evasion);
    }

    @Override
    public int getMana() {
        return super.getMana();
    }

    @Override
    public void setMana(int mana) {
        super.setMana(mana);
    }

    @Override
    public int getAttackSpeed() {
        return super.getAttackSpeed();
    }

    public int getHealth() {
        return health;
    }
}
