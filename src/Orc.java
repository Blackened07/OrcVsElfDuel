import Weapons.Sword;
import Weapons.Axe;
import Weapons.Mace;
import Weapons.Weapons;

public class Orc  extends Character{
    private int rage;


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
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + getAttackSpeed()/5 ;
    }

    public int castBerserk() {
        return 28;
    }


    public void setWeapon(Weapons weapon) {
        setAttackPower(getAttackPower() + weapon.getAttack());
        setAttackSpeed(getAttackSpeed() + weapon.getAttackSpeed());
        setHealth(getHealth() + weapon.getHealth());
        setEvasion(getEvasion() + weapon.getEvasion());
    }
}

