package homework;

import java.util.ArrayList;
import java.util.Arrays;

import static homework.HealthState.*;

public class Solution {

    public static void main(String[] args) {

        Gnome gnomeOne = new Gnome(100);
        Gnome gnomeTwo = new Gnome(100);
        Gnome gnomeThree = new Gnome(100);

        ElfArcher elfArcherOne = new ElfArcher(100);
        ElfArcher elfArcherTwo = new ElfArcher(100);
        ElfArcher elfArcherThree = new ElfArcher(100);

        ArrayList<Warrior> armyGnome =  new ArrayList<>(Arrays.asList(gnomeOne,gnomeTwo));
        armyGnome.add(gnomeThree);
        ArrayList<Warrior> armyElf =  new ArrayList<>(Arrays.asList(elfArcherOne,elfArcherTwo));
        armyElf.add(elfArcherThree);

        Solution solution = new Solution();

        solution.initArmy(new ArrayList<>(Arrays.asList(gnomeOne, gnomeTwo, elfArcherOne, elfArcherTwo)));

        solution.battle(armyGnome, armyElf);

        solution.print(new ArrayList<>(Arrays.asList(gnomeOne, gnomeTwo, elfArcherOne, elfArcherTwo)));


    }

    private void print(ArrayList<Warrior> warriors) {
        for(Warrior warrior : warriors) {
            System.out.println(warrior);
        }
    }

    private void battle(ArrayList<Warrior> gnomes, ArrayList<Warrior> elves) {
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < gnomes.size(); i++) {
                Warrior warriorOne = gnomes.get(i);
                Warrior warriorTwo = elves.get(i);
                fight(warriorOne, warriorTwo);
                fight(warriorTwo, warriorOne);
            }
        }
    }

    private void fight(Warrior warriorOne, Warrior warriorTwo) {
        int attackLevel = 0;

        if(warriorOne.getHealthState() != DEAD && warriorOne instanceof Attackable) {
            Attackable one = (Attackable) warriorOne;
            attackLevel = one.attack();
        }
        if (warriorTwo.getHealthState() != DEAD && warriorTwo instanceof Defenceable) {
            Defenceable two = (Defenceable) warriorTwo;
            two.defence(attackLevel);
        }

    }

    private void initArmy(ArrayList<Warrior> warriors) {
        for (Warrior warrior: warriors           ) {
            warrior.intDefenceLevel();
            warrior.initForceLevel();
        }
    }
}
