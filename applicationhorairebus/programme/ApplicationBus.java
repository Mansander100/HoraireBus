/*
 * ApplicationBus.java                                         01 avril 2021
 * IUT Rodez info1 2020-2021, pas de droits
 */
package applicationhorairebus.programme;

import java.util.Scanner;

import applicationhorairebus.test.TestGestionGrilleHoraire;

import applicationhorairebus.test.TestGestionDesserte;


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

        /* Objet Scanner pour effectuer les saisies au clavier */
        Scanner entree = new Scanner(System.in);

        boolean quitter = false;

        OutilFichier.enregistrerDesserte(TestGestionDesserte.EXEMPLE_DESSERTE);
        OutilFichier.enregistrerHoraireBus(TestGestionGrilleHoraire.preparerGrilleExemple());

        String[][] desserte_initiale = OutilFichier.restaurerDesserte();
        int[][] horaire = OutilFichier.restaurerHoraireBus();

        String[] desserteSaisie;

        do {
            switch (GestionInterface.saisirOptionMenuPrincipal()) {
                case 'v' -> { switch (GestionInterface.saisirOptionMenuVoyageur()) {
                                case 'c' -> {GestionDesserte.afficherDesserte(desserte_initiale);
                                             GestionGrilleHoraire.afficherGrille(horaire);
                                            }

                                case 'a' -> {int colonne = OutilHoraire.saisirEntierIntervalle(0, 9, 
                                                            "Entrez la colonne dans laquelle rechercher de 0 à 9 : ");
                                             int horaireSaisie = OutilHoraire.saisirHoraire();
                                             System.out.print("Prochains bus dispo dans les 30min : ");
                                             GestionGrilleHoraire.afficherTableauConverti(GestionGrilleHoraire.rechercherHoraire(horaire, colonne, 
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire, colonne, horaireSaisie),
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire, colonne, horaireSaisie+30)));
                                            }

                                case 'm' -> {}

                                case 'i' -> {}

                                case '?' -> GestionInterface.afficherAideVoyageur();

                                case 'r' -> {}
                                        
                                } 
                            }

                case 'a' -> { switch (GestionInterface.saisirOptionMenuAdministrateur()) {
                                case 'm' -> {System.out.println("Fonction non disponible dans la version 1.0");} 
                                            // TODO modifier le mdp


                                case '+' -> {desserteSaisie = GestionDesserte.saisirDesserte(); 
                                             GestionDesserte.ajouterDesserte(desserte_initiale, 
                                                                                desserteSaisie[0], 
                                                                                desserteSaisie[1]);
                                             GestionDesserte.afficherDesserte(desserte_initiale);
                                             OutilFichier.enregistrerDesserte(desserte_initiale);              
                                            }
                                    
                                case 's' -> {desserteSaisie = GestionDesserte.saisirDesserte(); 
                                             GestionDesserte.supprimerDesserte(desserte_initiale, 
                                                                                desserteSaisie[0], 
                                                                                desserteSaisie[1]);
                                             GestionDesserte.afficherDesserte(desserte_initiale);
                                             OutilFichier.enregistrerDesserte(desserte_initiale);
                                            }

                                case 'a' -> {System.out.println("Fonction non disponible dans la version 1.0");} 
                                            // TODO associer horaire à une desserte

                                case '?' -> GestionInterface.afficherAideAdministrateur();

                                case 'r' -> {}
                                }
                            }
                    
                case '?' -> GestionInterface.afficherAidePrincipal();
                    
                case 'q' -> quitter = true;
            }
        } while (quitter == false);

    }
}
