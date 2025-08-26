import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Вводим команды attackW, castFB, castBers
        Orc Grobul = new Orc(300, 50, 10, 20, 36, 20);
        Elf Elurion = new Elf(275, 100, 4, 80, 27, 70);

        String nowPlayer = Battle.startGame(Grobul, Elurion);

        Random rand = new Random();

        boolean checkFB = true;
        boolean checkBers = true;

        System.out.println("Воспользуйтесь следующими командами: attackW - атака оружием, castFB - атака огненным шаром, castBers - увеличение атаки");
        Scanner sc = new Scanner(System.in);

        while (Grobul.getHealth() > 0 && Elurion.getHealth() > 0) {
            int a;
            String s = sc.nextLine();
            checkFB = Battle.counterFB(checkFB);
            checkBers = Battle.counterBers(Grobul, checkBers);
            if (s.equals("attackW")) {
                if (nowPlayer.equals("Elurion")) {
                    a = Elurion.attackWithWeapon(Grobul) + rand.nextInt(10);;
                    Grobul.setHealth(Grobul.getHealth() - a);
                    System.out.println("Орк получил " + a + " урона. " + SystemMessages.orcDmged(Grobul));
                    System.out.println("Орк атакует");
                } else if (nowPlayer.equals("Grobul")) {
                    a = Grobul.attackWithWeapon(Elurion) + rand.nextInt(10);;
                    Elurion.setHealth(Elurion.getHealth() - a);
                    System.out.println("Эльф получил " + a + " урона. " + SystemMessages.elfDmged(Elurion));
                    System.out.println("Эльф атакует");
                }
            } else if (s.equals("castFB")) {
                if(nowPlayer.equals("Elurion") && checkFB) {
                    a = Elurion.castFireball(Grobul) + rand.nextInt(10);;
                    Grobul.setHealth(Grobul.getHealth() - a);
                    Elurion.setMana(Elurion.getMana() - 23);
                    System.out.println("Эльф призвал духов огя! Орк получил " + a + SystemMessages.elfCastFB(Grobul));
                    System.out.println("Орк атакует");
                    checkFB = false;
                } else if (nowPlayer.equals("Grobul")) {
                    System.out.println(SystemMessages.orcCastFb);
                    a = Grobul.attackWithWeapon(Elurion);
                    Elurion.setHealth(Elurion.getHealth() - a);
                    System.out.println("Эльф получил " + a + " урона. " + SystemMessages.elfDmged(Elurion));
                    System.out.println("Эльф атакует");
                } else if (nowPlayer.equals("Elurion") && !checkFB) {
                    System.out.println(SystemMessages.elfFailCast);
                    a = Elurion.attackWithWeapon(Grobul);
                    Grobul.setHealth(Grobul.getHealth() - a);
                    System.out.println("Орк получил " + a + " урона. " + SystemMessages.orcDmged(Grobul));
                    System.out.println("Орк атакует");
                }
            } else if (s.equals("castBers") ) {
                if (nowPlayer.equals("Elurion")) {
                    System.out.println(SystemMessages.elfCastBers);
                    a = Elurion.attackWithWeapon(Grobul);
                    Grobul.setHealth(Grobul.getHealth() - a);
                    System.out.println("Орк получил " + a + " урона. " + SystemMessages.orcDmged(Grobul));
                    System.out.println("Орк атакует");
                } else if (nowPlayer.equals("Grobul") && checkBers) {
                    Grobul.setAttackPower(Grobul.castBerserk() + Grobul.getAttackPower());
                    a = Grobul.attackWithWeapon(Elurion) + rand.nextInt(10);
                    Elurion.setHealth(Elurion.getHealth() - a);
                    Grobul.setRage(Grobul.getRage() - 15);
                    System.out.println("Орк впал в бешенство! Эльф получил " + a + SystemMessages.orcCastBers(Elurion));
                    System.out.println("Эльф атакует");
                    checkBers = false;
                } else if (nowPlayer.equals("Grobul") && !checkBers) {
                    System.out.println(SystemMessages.orcFailCast);
                    a = Grobul.attackWithWeapon(Elurion);
                    Elurion.setHealth(Elurion.getHealth() - a);
                    System.out.println("Эльф получил " + a + " урона. " + SystemMessages.elfDmged(Elurion));
                    System.out.println("Эльф атакует");
                }
            }

            //if (s.isEmpty() || !s.equals("attackW") || !s.equals("castFB") || !s.equals("castBers")) {
             //   System.out.println("Неверная команда");
            //}
            nowPlayer = nowPlayer.equals("Elurion") ? "Grobul" : "Elurion";
        }
    }
}