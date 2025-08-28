import Weapons.Sword;
import Weapons.Dagger;
import Weapons.Staff;
import Weapons.Weapons;


public class Elf extends Character{
    private int mana;


    public Elf(int health, int armor, int evasion, int attackPower, int attackSpeed, String name, int mana) {
        super(health, armor, evasion, attackPower, attackSpeed, name);
        this.mana = mana;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int castFireball() {return 80;}

    @Override
    public int attackWithWeapon(Character enemy) {
        return getAttackPower() - (enemy.getEvasion()/getAttackSpeed()) -
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + getAttackSpeed()/5 ;
    }

    public void setWeapon(Weapons weapon) {

            setAttackPower(getAttackPower() + weapon.getAttack());
            setAttackSpeed(getAttackSpeed() + weapon.getAttackSpeed());
            setHealth(getHealth() + weapon.getHealth());
            setEvasion(getEvasion() + weapon.getEvasion());
            setMana(getMana() + weapon.getMana());
    }
}
