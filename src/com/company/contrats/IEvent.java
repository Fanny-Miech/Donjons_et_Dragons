package com.company.contrats;

import com.company.personnages.Heros;

/**
 * interface avec contrat -- interact(Heros)
 */
public interface IEvent {

   /**
    *interaction avec le Heros
    * @param h Heros
    */
   void interact(Heros h);

}
