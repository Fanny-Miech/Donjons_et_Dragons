package com.company.bonus.attack;

import com.company.bonus.Bonus;

public abstract class Attack extends Bonus {

    //*****************  ATTRIBUTS  **************

    protected String name;
    protected int force;

    //*****************  CONSTRUCTEURS  *************

    public Attack(String name, int force) {
        this.name = name;
        this.force = force;
    }

    //***************** METHODS  ********************

    @Override
    public String toString() {
        return "Arme : " + this.name + " // Force d'attaque : " + this.force;
    }

    //*****************  GETTER  ***********************

    public String getName() {
        return name;
    }

    public int getForce() {
        return force;
    }


    //***************** SETTER  *************************

    public void setName(String name) {
        this.name = name;
    }

    public void setForce(int force) {
        this.force = force;
    }
}
