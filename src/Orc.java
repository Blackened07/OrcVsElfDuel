public class Orc  {
    private int health;
    private int rage;
    private int armor;
    private int evasion;
    private int attackPower;
    private int attackSpeed;


    public Orc(int health, int rage, int armor, int evasion, int attackPower, int attackSpeed) {
        this.health = health;
        this.rage = rage;
        this.armor = armor;
        this.evasion = evasion;
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public int getRage() {
        return rage;
    }

    public int getArmor() {
        return armor;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int attackWithWeapon(Elf elf) {
        return getAttackPower() - (elf.getEvasion()/getAttackSpeed()) - ((elf.getArmor()*elf.getEvasion()/100)*3) + (getAttackSpeed()/100)*10;
    }

    public int castBerserk() {
        return 15;
    }
}
