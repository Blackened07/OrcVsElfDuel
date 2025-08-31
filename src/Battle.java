import Weapons.*;
import Character.Character;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    static class StartGameProcess {
        static Random rand = new Random();

        public static void chooseTheHero(Scanner sc, Character[] chars, Character[] choosenHeroes) {
            int count = 0;
            int i = 0;
            int p = 1;
            while (count < 2) {
                System.out.println(" Player " + p + ", choose your Hero: ");
                for (Character j : chars) {
                    System.out.println(" - " + j.getName());
                }
                String hero = sc.nextLine();
                for (Character h : chars) {
                    if (hero.equals(h.getName()))
                        choosenHeroes[i] = h;
                }
                count++;
                i++;
                p++;
            }
        }

        public static void startGame(Character[] chars, Character[] rChars) {
            int start = rand.nextInt(10);
                if (start % 2 == 0) {
                    rChars[0] = chars[0];
                    rChars[1] = chars[1];
                } else {
                    rChars[1] = chars[1];
                    rChars[0] = chars[0];
                }
        }

        public static void SetWeapon(Scanner scanner, Character[] rChar,
                                           Weapons[] weapon) {
            int count = 0;
            int i = 0;
            while (count < 2) {
                System.out.println(rChar[i].getName() + ", choose your weapon: ");
                for (Weapons weapons : weapon) {
                    System.out.println(" - " + weapons.getName());
                }
                String weaponName = scanner.nextLine();

                for (Weapons weapons : weapon) {
                    if (weaponName.equals(weapons.getName())) {
                        rChar[i].setWeapon(weapons);
                    }
                }
                count++;
                i++;
            }
            System.out.println(rChar[0].getName() + " chose the " + rChar[0].getWeaponName() + "\n" + rChar[1].getName() + " chose the " + rChar[1].getWeaponName() );
        }
        public static Character setEnemy(Character[] chars, int i) {
            if (i==0) return chars[1];
            else return chars[0];
        }
    }



}


