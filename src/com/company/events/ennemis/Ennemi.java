package com.company.events.ennemis;

import com.company.Menu;
import com.company.contrats.IEvent;
import com.company.personnages.Heros;

import java.util.Scanner;

/**
 * classe abstraite implement de Event - doit avoir une methode interact()
 */
public abstract class Ennemi implements IEvent {

    //**************  ATRIBUTS  ********************

    /**
     * points de vie de l'ennemi
     */
    protected int vie;
    /**
     * force d'attaque
     */
    protected int attaque;


    //************  CONSTRUCTEURS  ************************

    /**
     * constructeur vide : ennemi avec vie et attaque = 0
     */
    public Ennemi() {
        this(0, 0);
    }

    /**
     * @param pvie     int
     * @param pattaque int
     */
    public Ennemi(int pvie, int pattaque) {
        this.vie = pvie;
        this.attaque = pattaque;
    }

    //*****************  METHODS  *****************************

    /**
     * La méthode interact() fait partie du contrat entre interface et implements.
     * elle ecrit le nom de l'ennemi et sa force
     *
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {
        System.out.println("// Ennemi --> " + this.getClass().getSimpleName() + " | Vie : " + this.getVie() + " | Attaque : " + this.getAttaque());

    }

    /**
     * Cette methode engage le combat entre le heros et son ennemi un coup donné par le Heros puis un coup donné par son ennemi
     *
     * @param h Heros
     */
    public void fight(Heros h) {
        System.out.println("C'est toi qui attaques en premier " + h.getNom() + " | Force de frappe : " + h.getForce());
        this.setVie(this.getVie() - h.getForce());
        System.out.println("Nouvelle vie de ton ennemi : " + this.getVie());
        if (this.getVie() == 0) {
            System.out.println(this.getClass().getSimpleName() + " est mort. Tu peux continuer ton chemin " + h.getNom());
        } else {
            System.out.println("Maintenant c'est lui qui t'attaque !!!!");
            int newVie = h.getVie() - this.getAttaque();
            h.setVie(newVie);
            System.out.println("Maintenant ta vie est à : " + h.getVie());
            if (h.getVie() == 0) {
                System.out.println("Tu es mort " + h.getNom());
                Menu.replay(h);
            }
        }
    }

    public int goAway(Heros h) {
        int random = 1 + (int) (Math.random() * 6);
        int newPosition = h.getPosition() - random;
        if (newPosition < 0) newPosition = 0;
        System.out.println("Go away -> retour à la case : " + newPosition);

        return newPosition;
    }

    //*************** GETTER  ***********************


    /**
     * @return vie
     */
    public int getVie() {
        return vie;
    }

    /**
     * @return attaque
     */
    public int getAttaque() {
        return attaque;
    }

    //******************  SETTER  ************************


    /**
     * @param vie int
     */
    public void setVie(int vie) {
        if (vie < 0) {
            this.vie = 0;
        } else {
            this.vie = vie;
        }

    }

    /**
     * @param attaque int
     */
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

}
