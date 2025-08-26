public class SystemMessages {

    static String orcFailCast = "Берсерк на перезарядке! Вы потратили время и нанесли минимальный урон!";
    static String elfFailCast = "Огненный шар на перезарядке! Вы потратили время и нанесли минимальный урон!";
    static String orcCastFb = "Орки предпочитают топор! Вы потратили время и нанесли минимальный урон!";
    static String elfCastBers = "Эльфы не впадают в иступление! Вы потратили время и нанесли минимальный урон!";

    public static String orcDmged (Orc orc) {
        return "У орка осталось " + orc.getHealth() + " здоровья и " + orc.getRage() + " ярости.";
    }
    public static String elfDmged (Elf elf) {
        return "У эльфа осталось " +
                elf.getHealth() + " здоровья b " + elf.getMana() + " маны";
    }
    public static String orcCastBers (Elf elf) {
        return  " урона. У эльфа осталось " + elf.getHealth() + " здоровья b " + elf.getMana() + " маны";
    }
    public static String elfCastFB (Orc orc) {
        return " урона. " + "У орка осталось " + orc.getHealth() + " здоровья и " + orc.getRage() + " ярости.";
    }
}
