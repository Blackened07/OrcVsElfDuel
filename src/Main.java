import Weapons.*;
import Character.Character;
import Character.Orc;
import Character.Elf;
import Spells.Berserk;
import Spells.Fireball;
import Spells.Spell;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Вводим команды attackW, castFB, castBers
        //добавить в игру спеллы - доты, станы
        Character[] chars = {new Orc(300, 10, 2, 16, 3, "Grobul", 50),
                new Elf(275, 4, 8, 11, 7, "Elurion", 100)};
        Elf Elurion = (Elf) chars[1];
        Orc Grobul = (Orc) chars[0];
        Character[] choosenHeroes = new Character[2];
        Character[] rChars = new Character[2];
        Weapons[] weapon = {new Sword("LongSword", 35, 10, 0, 0, 0),
                new Sword("ShortBlade", 27, 35, 5, 15, 0),
                new Axe("EvilInvader", 25, 12, 40, 0, 0),
                new Axe("GutShredder", 30, 9, 5, 0, 0),
                new Mace("DemolitionHammer", 45, 2, 0, 0, 0),
                new Mace("CraniumBasher", 33, 8, 20, 0, 0),
                new Dagger("SnakeBite", 15, 55, 0, 33, 0),
                new Dagger("Stinger", 18, 40, 36, 55, 0),
                new Staff("VoidPrisoner", 15, 10, 50, 50, 100)};
        Fireball fireball = new Fireball(Elurion);
        Berserk berserk = new Berserk(Grobul);
        Scanner sc = new Scanner(System.in);
        //Choose Hero

        Battle.StartGameProcess.chooseTheHero(sc, chars, choosenHeroes);
        //definition of random
        Battle.StartGameProcess.startGame(choosenHeroes, rChars);
        //SetWeapon to char [0] & [1]
        Battle.StartGameProcess.SetWeapon(sc, rChars, weapon);
        rChars[0].getStartMessage();
        rChars[1].getStartMessage();
        System.out.println(SystemMessages.StartGameMessages.info);

        int i = 0;
        while (rChars[0].getHealth() > 0 && rChars[1].getHealth() > 0) {
            System.out.println(rChars[i].getName() + " attack now");
            String s = sc.nextLine();
            Character enemy = Battle.StartGameProcess.setEnemy(rChars, i);
            fireball.spellCounter();
            berserk.spellCounter();
            berserk.unapply();
            switch (s) {
                case "attackW" -> {
                    rChars[i].attackWithWeapon(enemy);
                    enemy.getStatusMessage();
                }
                case "castFB" -> {
                    if (rChars[i].equals(Elurion)) {
                        fireball.cast(enemy);
                        enemy.getStatusMessage();
                    } else {
                        rChars[i].attackWithWeapon(enemy);
                       System.out.println(SystemMessages.BattleMessages.orcCastFb);
                        enemy.getStatusMessage();
                    }
                }
                case "castBers" -> {
                    if (rChars[i].equals(Grobul)) {
                        berserk.apply(Grobul);
                        rChars[i].attackWithWeapon(enemy);
                        enemy.getStatusMessage();
                    } else {
                        rChars[i].attackWithWeapon(enemy);
                        System.out.println(SystemMessages.BattleMessages.elfCastBers);
                        enemy.getStatusMessage();
                    }
                }
                default -> System.out.println("You entered bullshit and you are missing your turn");
            }
            i++;
            if (i == 2) {
                i = 0;
            }
        }

    }
}
