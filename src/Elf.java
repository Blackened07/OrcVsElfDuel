import Weapons.Sword;
import Weapons.Dagger;
import Weapons.Staff;
import Weapons.Weapons;


public class Elf extends Character{
    private int mana;
    Weapons sword;
    Weapons dagger;
    Weapons staff;

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

    //public void setAttackPowerByWeapon(int attackPower) {
    //    setAttackPower(getAttackPower() + attackPower);
    //}
    //public void setAttackSpeedByWeapon(int attackSpeed) {
   //     setAttackSpeed(getAttackSpeed() + attackSpeed);
    //}

    @Override
    public int attackWithWeapon(Character enemy) {
        return getAttackPower() - (enemy.getEvasion()/getAttackSpeed()) -
                ((enemy.getArmor()*enemy.getEvasion()/100)*3) + (getAttackSpeed()/100)*10 ;
    }

    public int castFireball(Orc orc) {
        return 80;
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
    public void setDagger(Dagger dagger, int health) {
        this.dagger = dagger;
        setAttackPower(getAttackPower() + dagger.getAttack());
        setAttackSpeed(getAttackSpeed() + dagger.getAttackSpeed());
        setHealth(getHealth() + health);
    }
    public void setDagger(Dagger dagger, int health, int evasion) {
        this.dagger = dagger;
        setAttackPower(getAttackPower() + dagger.getAttack());
        setAttackSpeed(getAttackSpeed() + dagger.getAttackSpeed());
        setHealth(getHealth() + health);
        setEvasion(getEvasion() + evasion);
    }
    public void setStaff(Staff staff, int health, int mana) {
        this.staff = staff;
        setAttackPower(getAttackPower() + staff.getAttack());
        setAttackSpeed(getAttackSpeed() + staff.getAttackSpeed());
        setHealth(getHealth() + health);
        setEvasion(getMana() + mana);
    }

}
