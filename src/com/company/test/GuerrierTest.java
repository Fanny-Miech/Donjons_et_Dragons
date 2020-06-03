package com.company.test;

import com.company.personnages.Guerrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    private Guerrier guerrier;

    @BeforeEach
    void setUp() {
        this.guerrier = new Guerrier("bob");
    }

    @Test
    void setNom() {
        String newNom, res;

        newNom = "newNom";
        guerrier.setNom(newNom);
        res = guerrier.getNom();
        assertEquals(newNom, res, "newNom = String");
        //        if (newNom.equals(res)) System.out.println("Test setNom() réussi")
        //        else fail("Test setNom() raté.");

        newNom = "";
        guerrier.setNom(newNom);
        res = "Ninja";
        assertEquals(res, guerrier.getNom(), "newNom = String vide");


    }

    @Test
    void setVie() {
        int newVie, res;

        newVie = 0;
        guerrier.setVie(newVie);
        res = 5;
        assertEquals(guerrier.getVie(), res, "vie < 5");

        newVie = 7;
        guerrier.setVie(newVie);
        res = 7;
        assertEquals(guerrier.getVie(), res, "5 < vie < 10");

        newVie = 5;
        guerrier.setVie(newVie);
        res = 5;
        assertEquals(guerrier.getVie(), res, "vie = 5");

        newVie = 10;
        guerrier.setVie(newVie);
        res = 10;
        assertEquals(guerrier.getVie(), res, "vie = 10");

        newVie = 12;
        guerrier.setVie(newVie);
        res = 10;
        assertEquals(guerrier.getVie(), res, "vie > 10");

        newVie = -1;
        guerrier.setVie(newVie);
        res = 5;
        assertEquals(guerrier.getVie(), res, "vie < 0");
    }

    @Test
    void setForce() {
        int newForce, res;

        newForce = 0;
        guerrier.setForce(newForce);
        res = 5;
        assertEquals(guerrier.getForce(), res, "force < 5");

        newForce = 7;
        guerrier.setForce(newForce);
        res = 7;
        assertEquals(guerrier.getForce(), res, " 5 < force < 10");

        newForce = 5;
        guerrier.setForce(newForce);
        res = 5;
        assertEquals(guerrier.getForce(), res, "force = 5");

        newForce = 10;
        guerrier.setForce(newForce);
        res = 10;
        assertEquals(guerrier.getForce(), res, "force = 10");

        newForce = 12;
        guerrier.setForce(newForce);
        res = 10;
        assertEquals(guerrier.getForce(), res, "force > 10");

        newForce = -1;
        guerrier.setForce(newForce);
        res = 5;
        assertEquals(guerrier.getForce(), res, "force < 0");

    }
}