/*
 * ApplicationBus.java                                         01 avril 2021
 * IUT Rodez info1 2020-2021, pas de droits
 */
package applicationhorairebus.programme;

import applicationhorairebus.test.TestGestionDesserte;
import applicationhorairebus.programme.GestionDesserte;

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

        boolean nonRepeter = false;

        //OutilFichier.enregistrerDesserte(TestGestionDesserte.EXEMPLE_DESSERTE);

        String[][] desserte_initiale = OutilFichier.restaurerDesserte();
        int[][] horaire = OutilFichier.restaurerHoraireBus();

        String[] desserte;

        do {
            switch (GestionInterface.saisirOptionMenuPrincipal()) {
                case 'v' -> { switch (GestionInterface.saisirOptionMenuVoyageur()) {
                                case 'c' -> GestionDesserte.afficherDesserte(desserte_initiale);

                                case 'a' -> {}

                                case 'm' -> {}

                                case 'i' -> {}

                                case '?' -> {GestionInterface.afficherAideVoyageur();
                                            /* quitte l'appli */
                                            nonRepeter = true;
                                            }

                                case 'r' -> {}
                                        
                                } 
                            }

                case 'a' -> { switch (GestionInterface.saisirOptionMenuAdministrateur()) {
                                case 'm' -> {System.out.println("Fonction non disponible dans la version 1.0");} 
                                            // TODO modifier le mdp


                                case '+' -> {desserte = GestionDesserte.saisirDesserte(); 
                                             GestionDesserte.ajouterDesserte(desserte_initiale, 
                                                                            desserte[0], 
                                                                            desserte[1]);
                                             GestionDesserte.afficherDesserte(desserte_initiale);
                                             OutilFichier.enregistrerDesserte(desserte_initiale);              
                                            }
                                    
                                case 's' -> {desserte = GestionDesserte.saisirDesserte(); 
                                             GestionDesserte.supprimerDesserte(desserte_initiale, 
                                                                    desserte[0], 
                                                                    desserte[1]);
                                             GestionDesserte.afficherDesserte(desserte_initiale);
                                             OutilFichier.enregistrerDesserte(desserte_initiale);
                                            }

                                case 'a' -> {System.out.println("Fonction non disponible dans la version 1.0");} 
                                            // TODO associer horaire à une desserte

                                case 'r' -> {}
                                }
                            }
                    
                case '?' -> GestionInterface.afficherAidePrincipal();
                    
                case 'q' -> System.exit(0);
                    
            }
        } while (nonRepeter == false);

    }
}
