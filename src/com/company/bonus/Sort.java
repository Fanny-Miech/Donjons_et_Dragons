package com.company.bonus;

import com.company.contrats.Bonus;
import com.company.personnages.*;

public class Sort extends Bonus {

    @Override
    public void interact (Heros h) {
        if (h instanceof Magicien){
            System.out.println("ok interaction avec Magicien");
        } else if (h instanceof Guerrier) {
            System.out.println("pas d'interaction avec un Guerrier");
        }
    }
}
