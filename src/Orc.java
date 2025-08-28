import Weapons.Sword;
import Weapons.Axe;
import Weapons.Mace;
import Weapons.Weapons;

public class Orc  extends Character{
    private int rage;
    Weapons sword;
    Weapons axe;
    Weapons mace;

    public Orc(int health, int armor, int evasion, int attackPower, int attackSpeed, String name, int rage) {
        super(health, armor, evasion, attackPower, attackSpeed, name);
        this.rage = rage;
    }
    public int getRage() {
        return rage;
    }
    public void setRage(int rage) {this.rage = rage;
    }


    @Override
    public int attackWithWeapon(Character enemy) {
        return getAttackPower() - (enemy.getEvasion()/getAttackSpeed()) -
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + (getAttackSpeed()/100)*10 ;
    }

    public int castBerserk() {
        return 28;
    }


    public void setSword(Sword sword) {
        this.sword = sword;
        setAttackPower(getAttackPower() + sword.getAttack());
        setAttackSpeed(getAttackSpeed() + sword.getAttackSpeed());
    }
    public void setSword(Sword sword, int health) {
        this.sword = sword;
        setAttackPower(getAttackPower() + sword.getAttack());
        setAttackSpeed(getAttackSpeed() + sword.getAttackSpeed());
        setHealth(getHealth() + health);
    }
    public void setSword(Sword sword, int health, int evasion) {
        this.sword = sword;
        setAttackPower(getAttackPower() + sword.getAttack());
        setAttackSpeed(getAttackSpeed() + sword.getAttackSpeed());
        setHealth(getHealth() + health);
        setEvasion(getEvasion() + evasion);
    }

    public void setAxe(Axe axe) {
       this.axe = axe;
        setAttackPower(getAttackPower() + axe.getAttack());
        setAttackSpeed(getAttackSpeed() + axe.getAttackSpeed());
    }
    public void setAxe(Axe axe, int health) {
        this.axe = axe;
        setAttackPower(getAttackPower() + axe.getAttack());
        setAttackSpeed(getAttackSpeed() + axe.getAttackSpeed());
        setHealth(getHealth() + health);
    }

    public void setMace(Mace mace) {
        this.mace = mace;
        setAttackPower(getAttackPower() + mace.getAttack());
        setAttackSpeed(getAttackSpeed() + mace.getAttackSpeed());
    }
    public void setMace(Mace mace, int health) {
        this.mace = mace;
        setAttackPower(getAttackPower() + mace.getAttack());
        setAttackSpeed(getAttackSpeed() + mace.getAttackSpeed());
        setHealth(getHealth() + health);
    }



}

