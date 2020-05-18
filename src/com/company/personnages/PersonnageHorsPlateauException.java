package com.company.personnages;

/**
 * classe exception : ecrit 'sortie de plateau'
 */
public class PersonnageHorsPlateauException extends Exception {
    public PersonnageHorsPlateauException() {
        System.out.println("Ton perso est sorti du plateau.");
    }
}
