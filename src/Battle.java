import Weapons.*;


import java.util.Random;
import java.util.Scanner;

public class Battle {
    static class StartGameProcess {
        static Random rand = new Random();

        public static Character chooseTheHero(Scanner sc, Orc orc, Elf elf) {
            System.out.println("Choose your Hero: Orc Grobul, Elf Elurion");
            String hero = sc.nextLine();
            hero = switch (hero) {
                case "Grobul" -> "Grobul";
                case "Elurion" -> "Elurion";
                default -> hero;
            };
            if (hero.equals("Grobul")) return orc;
            else if (hero.equals("Elurion")) return elf;
            else return null;

        }

        public static Character startGame(Character player1, Character player2, Orc orc, Elf elf) {
            Character nowPlayer = null;
            if (player1.equals(elf)) {
                int start = rand.nextInt(10);
                if (start % 2 == 0) {
                    SystemMessages.StartGameMessages.elfInfoPlayer1(player1, elf);
                    SystemMessages.StartGameMessages.orcInfoPlayer2(player2, orc);
                    nowPlayer = elf;
                } else {
                    SystemMessages.StartGameMessages.orcInfoPlayer2(player2, orc);
                    SystemMessages.StartGameMessages.elfInfoPlayer1(player1, elf);
                    nowPlayer = orc;
                }
            } else if (player1.equals(orc)) {
                int start = rand.nextInt(10);
                if (start % 2 == 0) {
                    SystemMessages.StartGameMessages.elfInfoPlayer2(player2, elf);
                    SystemMessages.StartGameMessages.orcInfoPlayer1(player1, orc);
                    nowPlayer = elf;
                } else {
                    SystemMessages.StartGameMessages.orcInfoPlayer1(player1, orc);
                    SystemMessages.StartGameMessages.elfInfoPlayer2(player2, elf);
                    nowPlayer = orc;
                }
            }
            return nowPlayer;
        }

        public static void chooseWeaponProcess(Scanner sc, Character nowPlayer, Character player1, Character player2, Orc orc, Elf elf,
                                               Weapons[] weapon) {
            int count = 0;
            while (count < 2) {
                if (nowPlayer.equals(player1)) {
                    StartGameProcess.systemSetWeapon(sc, nowPlayer, orc, elf, weapon);
                }
                if (nowPlayer.equals(player2)) {
                    StartGameProcess.systemSetWeapon(sc, nowPlayer, orc, elf, weapon);
                }
                count++;
                nowPlayer = nowPlayer.equals(player1) ? player2 : player1;
            }
        }

        public static void systemSetWeapon(Scanner scanner, Character nowPlayer, Orc orc, Elf elf,
                                           Weapons[] weapon) {
            System.out.println(nowPlayer.getName() + ", choose your weapon: ");
            for (Weapons weapons : weapon) {
                System.out.println(" - " + weapons.getName());
            }
            String weaponName = scanner.nextLine();
            String choosenWeapon = "";

                for (Weapons weapons : weapon) {
                    if (weaponName.equals(weapons.getName())) {
                        if (nowPlayer.equals(orc)) {
                            orc.setWeapon(weapons);
                            choosenWeapon = weapons.getName();
                            break;
                        } else if (nowPlayer.equals(elf)) {
                            elf.setWeapon(weapons);
                            choosenWeapon = weapons.getName();
                            break;
                        }
                    }
                }

                System.out.println(nowPlayer.getName() + "You choose the " + choosenWeapon);

        }
    }

    static class Counters {
        static int countFB = 0;
        static int countBers = 0;

        public static boolean counterFB(boolean checkFB) {
            if (!checkFB) {
                countFB++;
                return countFB == 6;
            } else return true;
        }

        public static boolean counterBers(Orc orc, boolean checkBers) {
            if (!checkBers) {
                countBers++;
                if (countBers == 4) orc.setAttackPower(orc.getAttackPower() - orc.castBerserk());
                return countBers == 8;
            } else return true;
        }
    }
}


