import Weapons.Sword;
import Weapons.Weapons;

public abstract class Character {
    protected int health;
    protected int armor;
    protected int evasion;
    protected int attackPower;
    protected int attackSpeed;
    protected String name;


    public Character(int health, int armor, int evasion, int attackPower, int attackSpeed, String name) {
        this.health = health;
        this.armor = armor;
        this.evasion = evasion;
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

   // public void setArmor(int armor) {
   //     this.armor = armor;
   // }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    public abstract int attackWithWeapon(Character enemy);

    public void setWeapon(Weapons weapon) {

    }

}
