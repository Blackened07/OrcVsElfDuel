import Weapons.*;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Вводим команды attackW, castFB, castBers
        //добавить в игру спеллы - доты, станы
        Orc Grobul = new Orc(300, 10, 2, 16, 3, "Grobul", 50);
        Elf Elurion = new Elf(275, 4, 8, 11, 7, "Elurion", 100);
        Character[] chars = {Grobul, Elurion};

        Weapons[] weapon = {new Sword("LongSword", 35, 10, 0, 0, 0),
                new Sword("ShortBlade", 27, 35, 5, 15, 0),
                new Axe("EvilInvader", 25, 12, 40, 0, 0),
                new Axe("GutShredder", 30, 9, 5, 0, 0),
                new Mace("DemolitionHammer", 45, 2, 0, 0, 0),
                new Mace("CraniumBasher", 33, 8, 20, 0, 0),
                new Dagger("SnakeBite", 15, 55, 0, 33, 0),
                new Dagger("Stinger", 18, 40, 36, 55, 0),
                new Staff("VoidPrisoner", 15, 10, 50, 50, 100)};

        Scanner sc = new Scanner(System.in);
        //Choose Hero
        Character player1 = Battle.StartGameProcess.chooseTheHero(sc, Grobul, Elurion);
        Character player2 = Battle.StartGameProcess.chooseTheHero(sc, Grobul, Elurion);

        assert player1 != null;
        assert player2 != null;
        Character nowPlayer = Battle.StartGameProcess.startGame(player1, player2, Grobul, Elurion);

        Battle.StartGameProcess.chooseWeaponProcess(sc, nowPlayer, player1, player2, Grobul, Elurion, weapon);

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
            switch (s) {
                case "attackW" -> {
                    if (nowPlayer.equals(player1)) {
                        player1.attackWithWeapon(player2);
                        System.out.println(SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                        System.out.println(player2.getName() + " атакует");
                    } else if (nowPlayer.equals(player2)) {
                        player2.attackWithWeapon(player1);
                        System.out.println(SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                        System.out.println(player1.getName() + " атакует");
                    }
                }
                case "castFB" -> {
                    if (nowPlayer.equals(player1)) {
                        if (nowPlayer.equals(Grobul)){
                            System.out.println(SystemMessages.BattleMessages.orcCastFb);
                            player1.attackWithWeapon(player2);
                            System.out.println(SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                            System.out.println(player2.getName() + " атакует");
                        } else if (checkFB && nowPlayer.equals(Elurion)) {
                            a = Elurion.castFireball() + rand.nextInt(10);
                            player2.setHealth(player2.getHealth() - a);
                            Elurion.setMana(Elurion.getMana() - 28);
                            System.out.println(player1.getName() + " призвал духов огя! " + player2.getName() + " получил " + a + SystemMessages.BattleMessages.elfCastFB(player2));
                            System.out.println(player2.getName() + " атакует");
                            checkFB = false;
                        } else {
                            System.out.println(SystemMessages.BattleMessages.elfFailCast);
                            player1.attackWithWeapon(player2);
                            System.out.println(SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                            System.out.println(player2.getName() + " атакует");
                        }

                    } else if (nowPlayer.equals(player2)) {
                        if (player2.equals(Grobul)) {
                            System.out.println(SystemMessages.BattleMessages.orcCastFb);
                            player2.attackWithWeapon(player1);
                            System.out.println(SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                            System.out.println(player1.getName() + " атакует");
                        } else if (checkFB && nowPlayer.equals(Elurion)) {
                            a = Elurion.castFireball() + rand.nextInt(10);
                            player1.setHealth(player1.getHealth() - a);
                            Elurion.setMana(Elurion.getMana() - 28);
                            System.out.println(player2.getName() + " призвал духов огя! " + player1.getName() + " получил " + a + SystemMessages.BattleMessages.elfCastFB(player1));
                            System.out.println(player1.getName() + " атакует");
                            checkFB = false;
                        } else  {
                            System.out.println(SystemMessages.BattleMessages.elfFailCast);
                            Elurion.attackWithWeapon(Grobul);
                            System.out.println(SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                            System.out.println(player1.getName() + " атакует");
                        }
                    }
                }
                case "castBers" -> {
                    if (nowPlayer.equals(player1)) {
                        if (nowPlayer.equals(Elurion)) {
                        System.out.println(SystemMessages.BattleMessages.elfCastBers);
                        player1.attackWithWeapon(player2);
                        System.out.println(SystemMessages.BattleMessages.player2Dmged(player2, Grobul, Elurion));
                        System.out.println(player2.getName() + " атакует");
                    } else if ( checkBers && player1.equals(Grobul)) {
                            player1.setAttackPower(Grobul.castBerserk() + Grobul.getAttackPower());
                            Grobul.attackWithWeapon(player2);
                            Grobul.setRage(Grobul.getRage() - 15);
                            System.out.println(player1.getName() + " впал в бешенство!" + player2.getName() + " получил 3gg3"  + SystemMessages.BattleMessages.orcCastBers(Elurion));
                            System.out.println(player2.getName() + " атакует");
                            checkBers = false;
                        } else {
                            System.out.println(SystemMessages.BattleMessages.orcFailCast);
                            Grobul.attackWithWeapon(player2);
                            System.out.println(SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                            System.out.println(player2.getName() + " атакует");
                        }
                    }
                    if (nowPlayer.equals(player2)) {
                        if (nowPlayer.equals(Elurion)) {
                            System.out.println(SystemMessages.BattleMessages.elfCastBers);
                            Elurion.attackWithWeapon(player1);
                            System.out.println(SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                            System.out.println(player1.getName() + " атакует");
                        } else if (player2.equals(Grobul) && checkBers) {
                            Grobul.setAttackPower(Grobul.castBerserk() + Grobul.getAttackPower());
                            Grobul.attackWithWeapon(player1);
                            Grobul.setRage(Grobul.getRage() - 15);
                            System.out.println(player2.getName() + " впал в бешенство! " + player1.getName() + " получил wfwff "  + SystemMessages.BattleMessages.orcCastBers(Elurion));
                            System.out.println(player1.getName() + " атакует");
                            checkBers = false;
                        } else  {
                            System.out.println(SystemMessages.BattleMessages.orcFailCast);
                            Grobul.attackWithWeapon(player1);
                            System.out.println(SystemMessages.BattleMessages.player1Dmged(player1, Grobul, Elurion));
                            System.out.println(player1.getName() + " атакует");
                        }
                    }
                }
            }

            //if (s.isEmpty() || !s.equals("attackW") || !s.equals("castFB") || !s.equals("castBers")) {
            //   System.out.println("Неверная команда");
            //}
            nowPlayer = nowPlayer.equals(player1) ? player2 : player1;
        }

    }
}
