package com.company.events.bonus.potions;

import com.company.events.bonus.Bonus;
import com.company.personnages.Heros;

/**
 * class abstraite fille de Bonus et mere Standard et Big
 */
public abstract class Potion extends Bonus {

    //**************  ATRIBUTS  ******************

    /**
     * point de vie que donne cette Potion au joueur
     */
    protected int vie;
    /**
     * nom de cette Potion
     */
    protected String name;

    //****************  CONSTRUCTEUR  ************

    /**
     * Constructeur avec parametres
     *
     * @param name String
     * @param vie  int
     */
    public Potion(String name, int vie) {
        this.name = name;
        this.vie = vie;
    }

    //***************** METHODS  *****************

    /**
     * Interaction entre cet evenement et le heros
     * cette methode augmente le niveau de vie du Heros de this.vie (dans la limite de la vie possible pour le Heros)
     *
     * @param h Heros
     */
    @Override
    public void interact(Heros h) {

        int vie = h.getVie();
        h.setVie(h.getVie() + this.vie);

        super.interact(h);
        //System.out.println(this.getClass().getSuperclass().getSimpleName());
        System.out.println("\nBonne surprise : voilà une " + this.name + " qui te fait gagner " + this.vie + " points de vie ! ");
        System.out.println("Niveau de vie actuel : " + vie + " | Nouveau niveau de vie : " + h.getVie());
    }

    /**
     * @return nom et points de vie bonus qu'offre la potion
     */
    @Override
    public String toString() {
        return this.name + "// + " + this.vie + " points de vie.";
    }

    //******************  GETTER  ****************

    /**
     * @return point de vie bonus
     */
    public int getVie() {
        return vie;
    }

    /**
     * @return nom de la potion
     */
    public String getName() {
        return name;
    }

    //****************  SETTER  ******************

    /**
     * Permet de modifier les points de vie bonus de cette potion
     *
     * @param vie int
     */
    public void setVie(int vie) {
        this.vie = vie;
    }

    /**
     * Permet de modifier le nom de cette potion
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

}
