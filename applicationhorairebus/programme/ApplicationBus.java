/*
 * ApplicationBus.java                                         01 avril 2021
 * IUT Rodez info1 2020-2021, pas de droits
 */
package applicationhorairebus.programme;

import  applicationhorairebus.programme.OutilFichier;
import applicationhorairebus.test.TestGestionGrilleHoraire;
import applicationhorairebus.programme.GestionGrilleHoraire;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Cette classe contiendra la fonction main permettant de lancer l’application 
 * ainsi que plusieurs méthodes. Chacune des méthodes correspondra à une 
 * fonctionnalité de l’application : celles du mode voyageur et celles 
 * du mode administrateur. 
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 */
public class ApplicationBus {

    /**
     * Excécution des différents composants de l'applicationHoraireBus
     * avec appelle aux autres classes : voyageur et administrateur
     * Récupération et enregistrement des dessertes et horaires dans
     * des fichiers textes externes.
     * @param args non utilisé
     */
    public static void main (String[] args) {


        String[][] desserte = OutilFichier.restaurerDesserte();
        int[][] horaire = OutilFichier.restaurerHoraireBus();

        switch (GestionInterface.saisirOptionMenuPrincipal()) {
            case 'v' -> { GestionInterface.afficherMenuVoyageur(); }

            case 'a' -> { GestionInterface.afficherAideAdministrateur();}
                

            case '?' -> GestionInterface.afficherAidePrincipal();
                

            case 'q' -> System.exit(0);
                
        }


    }
}
