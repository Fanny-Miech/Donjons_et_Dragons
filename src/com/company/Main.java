package com.company;

import com.company.personnages.Guerrier;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //test Guerrier
        Guerrier jeanpaul = new Guerrier("jean_paul", 5, 5);
        String test = jeanpaul.toString();
        int testVie = jeanpaul.getVie();
        System.out.println(test);
        System.out.println("Points de vie : " + testVie);

        //test Menu
        Menu part1 = new Menu();
        part1.welcome();
        part1.chooseYourPerso();
    }
}
