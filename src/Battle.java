import java.util.Random;

public class Battle {
    static Random rand = new Random();

    public static String startGame (Orc orc, Elf elf) {
        int start = rand.nextInt(10);
        if (start % 2 == 0) {
            System.out.println("Elf is starting with " + elf.getHealth() + " health, " + elf.getMana() + " mana, " + elf.getAttackPower() + " attack power, " +
                    elf.getArmor() + " armor, " + elf.getEvasion() + " Evasion, " + elf.getAttackSpeed() + " attack speed");

            System.out.println("Orc is starting " + orc.getHealth() + " health, " + orc.getRage() + " rage, " + orc.getAttackPower() + " attack power, " +
                    orc.getArmor() + " armor, " + orc.getEvasion() + " Evasion, " + orc.getAttackSpeed() + " attack speed");
            System.out.println("Эльф атакует");
            return "Elurion";
        } else {
            System.out.println("Orc is starting " + orc.getHealth() + " health, " + orc.getRage() + " rage, " + orc.getAttackPower() + " attack power, " +
                    orc.getArmor() + " armor, " + orc.getEvasion() + " Evasion, " + orc.getAttackSpeed() + " attack speed");
            System.out.println("Elf is starting with " + elf.getHealth() + " health, " + elf.getMana() + " mana, " + elf.getAttackPower() + " attack power, " +
                    elf.getArmor() + " armor, " + elf.getEvasion() + " Evasion, " + elf.getAttackSpeed() + " attack speed");
            System.out.println("Орк атакует");
            return "Grobul";
        }
    }
    static int countFB = 0;
    static int countBers = 0;

    public static boolean counterFB (boolean checkFB) {
        if (!checkFB) {
            countFB++;
            return countFB == 6;
        } else return true;
    }
    public static boolean counterBers (Orc orc, boolean checkBers) {
        if (!checkBers) {
            countBers++;
            if (countBers == 4) orc.setAttackPower(orc.getAttackPower() - orc.castBerserk());
            return countBers == 8;
        } else return true;
    }
}

