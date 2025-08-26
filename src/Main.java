import Weapons.Sword;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Вводим команды attackW, castFB, castBers
        Orc Grobul = new Orc(300, 50, 10, 20, 16, 20);
        Elf Elurion = new Elf(275, 100, 4, 80, 11, 70);
        Sword LongSword = new Sword(35, 10);
        Sword ShortBlade = new Sword(27, 35);
        Scanner sc = new Scanner(System.in);
        String nowPlayer = Battle.startGame(Grobul, Elurion);
        System.out.println(nowPlayer);
        int count = 0;
        while (count < 2) {

            if (nowPlayer.equals("Elurion")) {
                Battle.chooseWeapon(sc, nowPlayer, Grobul, Elurion, LongSword, ShortBlade);
            }
            if (nowPlayer.equals("Grobul")) {
                Battle.chooseWeapon(sc, nowPlayer, Grobul, Elurion, LongSword, ShortBlade);
            }
            count++;
            nowPlayer = nowPlayer.equals("Elurion") ? "Grobul" : "Elurion";
        }
        Battle.startGame(Grobul, Elurion);
        System.out.println(SystemMessages.info);
        System.out.println(nowPlayer + " attack first");
        Random rand = new Random();

        boolean checkFB = true;
        boolean checkBers = true;

        while (Grobul.getHealth() > 0 && Elurion.getHealth() > 0) {
            int a;
            String s = sc.nextLine();
            checkFB = Battle.counterFB(checkFB);
            checkBers = Battle.counterBers(Grobul, checkBers);
            if (s.equals("attackW")) {
                if (nowPlayer.equals("Elurion")) {
                    a = Elurion.attackWithWeapon(Grobul) + rand.nextInt(10);
                    ;
                    Grobul.setHealth(Grobul.getHealth() - a);
                    System.out.println("Орк получил " + a + " урона. " + SystemMessages.orcDmged(Grobul));
                    System.out.println("Орк атакует");
                } else if (nowPlayer.equals("Grobul")) {
                    a = Grobul.attackWithWeapon(Elurion) + rand.nextInt(10);
                    ;
                    Elurion.setHealth(Elurion.getHealth() - a);
                    System.out.println("Эльф получил " + a + " урона. " + SystemMessages.elfDmged(Elurion));
                    System.out.println("Эльф атакует");
                }
            } else if (s.equals("castFB")) {
                if (nowPlayer.equals("Elurion") && checkFB) {
                    a = Elurion.castFireball(Grobul) + rand.nextInt(10);
                    ;
                    Grobul.setHealth(Grobul.getHealth() - a);
                    Elurion.setMana(Elurion.getMana() - 28);
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
            } else if (s.equals("castBers")) {
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