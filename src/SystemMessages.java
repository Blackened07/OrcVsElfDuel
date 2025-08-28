public class SystemMessages {

    static class StartGameMessages {
        public static void elfInfoPlayer1 (Character player1, Elf elf) {
            System.out.println(player1.getName() + " is starting with " + player1.getHealth() + " health, " + elf.getMana() + " mana, " + player1.getAttackPower() + " attack power, " +
                    player1.getArmor() + " armor, " + player1.getEvasion() + " Evasion, " + player1.getAttackSpeed() + " attack speed");
        }
        public static void orcInfoPlayer2 (Character player2, Orc orc) {
            System.out.println(player2.getName() + " is starting " + player2.getHealth() + " health, " + orc.getRage() + " rage, " + player2.getAttackPower() + " attack power, " +
                    player2.getArmor() + " armor, " + player2.getEvasion() + " Evasion, " + player2.getAttackSpeed() + " attack speed");
        }
        public static void elfInfoPlayer2 (Character player2, Elf elf) {
            System.out.println(player2.getName() + " is starting " + player2.getHealth() + " health, " + elf.getMana() + " mana, " + player2.getAttackPower() + " attack power, " +
                    player2.getArmor() + " armor, " + player2.getEvasion() + " Evasion, " + player2.getAttackSpeed() + " attack speed");
        }
        public static void orcInfoPlayer1 (Character player1, Orc orc) {
            System.out.println(player1.getName() + " is starting with " + player1.getHealth() + " health, " + orc.getRage() + " rage, " + player1.getAttackPower() + " attack power, " +
                    player1.getArmor() + " armor, " + player1.getEvasion() + " Evasion, " + player1.getAttackSpeed() + " attack speed");
        }

        static String info = "Воспользуйтесь следующими командами: attackW - атака оружием, castFB - атака огненным шаром, castBers - увеличение атаки";
    }


    static class BattleMessages {
        static String orcFailCast = "Берсерк на перезарядке! Вы потратили время и нанесли минимальный урон!";
        static String elfFailCast = "Огненный шар на перезарядке! Вы потратили время и нанесли минимальный урон!";
        static String orcCastFb = "Орки предпочитают топор! Вы потратили время и нанесли минимальный урон!";
        static String elfCastBers = "Эльфы не впадают в иступление! Вы потратили время и нанесли минимальный урон!";

        public static String player1Dmged (Character player1, Orc orc, Elf elf) {
            if (player1.equals(orc)) return "У орка осталось " + orc.getHealth() + " здоровья и " + orc.getRage() + " ярости.";
            else return "У эльфа осталось " + elf.getHealth() + " здоровья и " + elf.getMana() + " маны";
        }
        public static String player2Dmged (Character player2, Orc orc, Elf elf) {
            if (player2.equals(orc)) return "У орка осталось " + orc.getHealth() + " здоровья и " + orc.getRage() + " ярости.";
            else return "У эльфа осталось " + elf.getHealth() + " здоровья и " + elf.getMana() + " маны";
        }

        public static String orcCastBers (Elf elf) {
            return  " урона. У эльфа осталось " + elf.getHealth() + " здоровья и " + elf.getMana() + " маны";
        }
        public static String elfCastFB (Orc orc) {
            return " урона. " + "У орка осталось " + orc.getHealth() + " здоровья и " + orc.getRage() + " ярости.";
        }
    }
}
