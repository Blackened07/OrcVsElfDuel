import Weapons.Sword;
import Weapons.Axe;
import Weapons.Mace;
import Weapons.Dagger;
import Weapons.Staff;


import java.util.Random;
import java.util.Scanner;

public class Battle {
    static class StartGameProcess {
        static Random rand = new Random();

        public static Character chooseTheHero (Scanner sc, Orc orc, Elf elf) {
            System.out.println("Choose your Hero: Orc Grobul, Elf Elurion");
            String hero = sc.nextLine();
            hero = switch (hero) {
                case "Grobul" -> "Grobul";
                case "Elurion" -> "Elurion";
                default -> hero;
            };
            if (hero.equals("Grobul")) return orc;
            else  if (hero.equals("Elurion")) return elf;
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
                                               Sword longsword, Sword shortBlade, Axe evil, Axe gut, Mace demolition,
                                               Mace cranium, Dagger snake, Dagger stinger, Staff prisoner) {
            int count = 0;
            while(count< 2) {
            if (nowPlayer.equals(player1)) {
                StartGameProcess.systemSetWeapon(sc, nowPlayer, orc, elf, longsword, shortBlade,
                        evil, gut, demolition, cranium, snake, stinger, prisoner);
            }
            if (nowPlayer.equals(player2)) {
                StartGameProcess.systemSetWeapon(sc, nowPlayer, orc, elf, longsword, shortBlade,
                        evil, gut, demolition, cranium, snake, stinger, prisoner);
            }
            count++;
            nowPlayer = nowPlayer.equals(player1) ? player2 : player1;
        }
    }

        public static void systemSetWeapon(Scanner scanner, Character nowPlayer, Orc orc, Elf elf,
                                           Sword longsword, Sword shortblade, Axe evil, Axe gut, Mace demolition,
                                           Mace cranium, Dagger snake, Dagger stinger, Staff prisoner) {
            System.out.println(nowPlayer.getName() + ", choose your weapon: \nSWORDS (Orc, Elf)\nLongSword\nShortBlade\nAXES (Orc)\nEvilInvader\nGutShredder" +
                    "\nMACES (Orc)\nDemolitionHammer\nCraniumBasher\nDAGGERS (Elf)\nSnakeBite\nStinger\nSTAVES (Elf)\nVoidPrisoner");
            String weapon = scanner.nextLine();
            if (nowPlayer.equals(elf)) {
                switch (weapon) {
                    case "LongSword" -> elf.setSword(longsword);
                    case "ShortBlade" -> elf.setSword(shortblade, shortblade.getHealth());
                    case "SnakeBite" -> elf.setDagger(snake,snake.getHealth() );
                    case "Stinger" -> elf.setDagger(stinger, stinger.getHealth(), stinger.getEvasion());
                    case "VoidPrisoner" -> elf.setStaff(prisoner, prisoner.getHealth(), prisoner.getMana());
                }
            }
            if (nowPlayer.equals(orc)) {
                switch (weapon) {
                    case "LongSword" -> orc.setSword(longsword);
                    case "ShortBlade" -> orc.setSword(shortblade, shortblade.getHealth());
                    case "EvilInvader" -> orc.setAxe(evil, evil.getHealth());
                    case "GutShredder" -> orc.setAxe(gut, gut.getHealth());
                    case "DemolitionHammer" -> orc.setMace(demolition);
                    case "CraniumBasher" -> orc.setMace(cranium, cranium.getHealth());
                }

            }
        }
    }

    static class Counters {
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
}

