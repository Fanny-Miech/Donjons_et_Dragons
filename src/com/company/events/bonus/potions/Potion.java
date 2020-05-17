package com.company.events.bonus.potions;

import com.company.events.bonus.Bonus;
import com.company.personnages.Heros;

public abstract class Potion extends Bonus {

    //**************  ATRIBUTS  ******************
    protected int vie;
    protected String name;

     //****************  CONSTRUCTEUR  ************

    public Potion(String name, int vie) {
        this.name = name;
        this.vie = vie;
    }

    //***************** METHODS  *****************

    @Override
    public void interact(Heros h) {

        int vie = h.getVie();
        h.setVie(h.getVie() + this.vie);

        super.interact(h);
        System.out.println("Potion");
        System.out.println("Bonne surprise : voilà une " + this.name + " qui te fait gagner " + this.vie + " points de vie ! ");
        System.out.println("Niveau de vie actuel : " + vie +  " | Nouveau niveau de vie : " + h.getVie());
    }

    @Override
    public String toString() {
        return this.name + "// + " + this.vie + " points de vie.";
    }

    //******************  GETTER  ****************
    public int getVie() {
        return vie;
    }

    public String getName() {
        return name;
    }

    //****************  SETTER  ******************

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setName(String name) {
        this.name = name;
    }

}
