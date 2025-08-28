import Weapons.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Вводим команды attackW, castFB, castBers
        //добавить в игру спеллы - доты, станы
        Orc Grobul = new Orc(300, 10, 2, 16, 3, "Grobul", 50);
        Elf Elurion = new Elf(275, 4, 8, 11, 7, "Elurion", 100);

        Sword LongSword = new Sword(35, 10);
        Sword ShortBlade = new Sword(27, 35, 5);
        Axe EvilInvader = new Axe(25, 5, 40);
        Axe GutShredder = new Axe(30, 3, 5);
        Mace DemolitionHammer = new Mace(45, 2);
        Mace CraniumBasher = new Mace(33, 8, 20);
        Dagger SnakeBite = new Dagger(15, 55, 33);
        Dagger Stinger = new Dagger(18, 47, 24, 55);
        Staff VoidPrisoner = new Staff(15, 10, 50, 50);
        Scanner sc = new Scanner(System.in);
        //Choose Hero
        Character player1 = Battle.StartGameProcess.chooseTheHero(sc, Grobul, Elurion);
        Character player2 = Battle.StartGameProcess.chooseTheHero(sc, Grobul, Elurion);

        assert player1 != null;
        assert player2 != null;
        Character nowPlayer = Battle.StartGameProcess.startGame(player1, player2, Grobul, Elurion);

        Battle.StartGameProcess.chooseWeaponProcess(sc, nowPlayer, player1, player2, Grobul, Elurion, LongSword, ShortBlade, EvilInvader, GutShredder, DemolitionHammer, CraniumBasher,
                SnakeBite, Stinger, VoidPrisoner);

        Battle.StartGameProcess.startGame(player1, player2, Grobul, Elurion);
        System.out.println(SystemMessages.StartGameMessages.info);
        System.out.println(nowPlayer.getName() + " attack first");
        Random rand = new Random();

        boolean checkFB = true;
        boolean checkBers = true;
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            int a;
            String s = sc.nextLine();
            checkFB = Battle.Counters.counterFB(checkFB);
            checkBers = Battle.Counters.counterBers(Grobul, checkBers);
            if (s.equals("attackW")) {
                if (nowPlayer.equals(player1)) {
                    a = player1.attackWithWeapon(player2) + rand.nextInt(10);
                    player2.setHealth(player2.getHealth() - a);
                    System.out.println(player2.getName() + " получил " + a + " урона. " + SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                    System.out.println(player2.getName() + " атакует");
                } else if (nowPlayer.equals(player2)) {
                    a = player2.attackWithWeapon(player1) + rand.nextInt(10);
                    player1.setHealth(player1.getHealth() - a);
                    System.out.println(player1.getName() + " получил " + a + " урона. " + SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                    System.out.println(player1.getName() + " атакует");
                }
            } else if (s.equals("castFB")) {
                if (nowPlayer.equals(player1) && player1.equals(Elurion)) {
                    if (checkFB) {
                        a = Elurion.castFireball() + rand.nextInt(10);
                        Grobul.setHealth(Grobul.getHealth() - a);
                        Elurion.setMana(Elurion.getMana() - 28);
                        System.out.println(Elurion.getName() + " призвал духов огя! " + Grobul.getName() + " получил " + a + SystemMessages.BattleMessages.elfCastFB(Grobul));
                        System.out.println(player2.getName() + " атакует");
                        checkFB = false;
                    } else {
                        System.out.println(SystemMessages.BattleMessages.elfFailCast);
                        a = Elurion.attackWithWeapon(Grobul);
                        Grobul.setHealth(Grobul.getHealth() - a);
                        System.out.println(player2.getName() + " получил " + a + " урона. " + SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                        System.out.println(player2.getName() + " атакует");
                    }
                } else if (nowPlayer.equals(player1) && player1.equals(Grobul)) {
                    System.out.println(SystemMessages.BattleMessages.orcCastFb);
                    a = Grobul.attackWithWeapon(Elurion);
                    Elurion.setHealth(Elurion.getHealth() - a);
                    System.out.println("Эльф получил " + a + " урона. " + SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                    System.out.println(player2.getName() + " атакует");
                } else if (nowPlayer.equals(player2) && player2.equals(Elurion)) {
                    if (checkFB) {
                        a = Elurion.castFireball() + rand.nextInt(10);
                        Grobul.setHealth(Grobul.getHealth() - a);
                        Elurion.setMana(Elurion.getMana() - 28);
                        System.out.println(Elurion.getName() + " призвал духов огя! " + Grobul.getName() + " получил " + a + SystemMessages.BattleMessages.elfCastFB(Grobul));
                        System.out.println(player1.getName() + " атакует");
                        checkFB = false;
                    } else if (!checkFB) {
                        System.out.println(SystemMessages.BattleMessages.elfFailCast);
                        a = Elurion.attackWithWeapon(Grobul);
                        Grobul.setHealth(Grobul.getHealth() - a);
                        System.out.println("Орк получил " + a + " урона. " + SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                        System.out.println(player1.getName() + " атакует");
                    } else if (nowPlayer.equals(player2) && player1.equals(Grobul)) {
                        System.out.println(SystemMessages.BattleMessages.orcCastFb);
                        a = Grobul.attackWithWeapon(Elurion);
                        Elurion.setHealth(Elurion.getHealth() - a);
                        System.out.println("Эльф получил " + a + " урона. " + SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                        System.out.println(player1.getName() + " атакует");
                    }
                }
            } else if (s.equals("castBers")) {
                if (nowPlayer.equals(player1) && nowPlayer.equals(Elurion)) {
                    System.out.println(SystemMessages.BattleMessages.elfCastBers);
                    a = Elurion.attackWithWeapon(Grobul);
                    Grobul.setHealth(Grobul.getHealth() - a);
                    System.out.println("Орк получил " + a + " урона. " + SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                    System.out.println(player2.getName() + " атакует");
                } else if (nowPlayer.equals(player1) && player1.equals(Grobul)) {
                    if (checkBers) {
                        Grobul.setAttackPower(Grobul.castBerserk() + Grobul.getAttackPower());
                        a = Grobul.attackWithWeapon(Elurion) + rand.nextInt(10);
                        Elurion.setHealth(Elurion.getHealth() - a);
                        Grobul.setRage(Grobul.getRage() - 15);
                        System.out.println("Орк впал в бешенство! Эльф получил " + a + SystemMessages.BattleMessages.orcCastBers(Elurion));
                        System.out.println(player2.getName() + " атакует");
                        checkBers = false;
                    } else {
                        System.out.println(SystemMessages.BattleMessages.orcFailCast);
                        a = Grobul.attackWithWeapon(Elurion);
                        Elurion.setHealth(Elurion.getHealth() - a);
                        System.out.println("Эльф получил " + a + " урона. " + SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                        System.out.println(player2.getName() + " атакует");
                    }
                } else if (nowPlayer.equals(player2) && nowPlayer.equals(Elurion)) {
                    System.out.println(SystemMessages.BattleMessages.elfCastBers);
                    a = Elurion.attackWithWeapon(Grobul);
                    Grobul.setHealth(Grobul.getHealth() - a);
                    System.out.println("Орк получил " + a + " урона. " + SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                    System.out.println(player1.getName() + " атакует");
                } else if (nowPlayer.equals(player2) && player2.equals(Grobul) && checkBers) {
                    Grobul.setAttackPower(Grobul.castBerserk() + Grobul.getAttackPower());
                    a = Grobul.attackWithWeapon(Elurion) + rand.nextInt(10);
                    Elurion.setHealth(Elurion.getHealth() - a);
                    Grobul.setRage(Grobul.getRage() - 15);
                    System.out.println("Орк впал в бешенство! Эльф получил " + a + SystemMessages.BattleMessages.orcCastBers(Elurion));
                    System.out.println(player1.getName() + " атакует");
                    checkBers = false;
                } else if (nowPlayer.equals(player1) && player1.equals(Grobul) && !checkBers) {
                    System.out.println(SystemMessages.BattleMessages.orcFailCast);
                    a = Grobul.attackWithWeapon(Elurion);
                    Elurion.setHealth(Elurion.getHealth() - a);
                    System.out.println("Эльф получил " + a + " урона. " + SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                    System.out.println(player1.getName() + " атакует");
                }
            }

            //if (s.isEmpty() || !s.equals("attackW") || !s.equals("castFB") || !s.equals("castBers")) {
            //   System.out.println("Неверная команда");
            //}
            nowPlayer = nowPlayer.equals(player1) ? player2 : player1;
        }
    }
}
