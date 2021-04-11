/*
 * ApplicationBus.java                                         01 avril 2021
 * IUT Rodez info1 2020-2021, pas de droits
 */
package applicationhorairebus.programme;



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


        String[][] desserte_initiale = OutilFichier.restaurerDesserte();
        int[][] horaire = OutilFichier.restaurerHoraireBus();

        String[] desserte;

        switch (GestionInterface.saisirOptionMenuPrincipal()) {
            case 'v' -> { GestionInterface.afficherMenuVoyageur();
                            switch (GestionInterface.saisirOptionMenuVoyageur()) {
                                case 'c' -> {}

                                case 'a' -> {}

                                case 'm' -> {}

                                case 'i' -> {}

                                case '?' -> {GestionInterface.afficherAideVoyageur();}

                                case 'r' -> {GestionInterface.afficherMenuPrincipal();}
                                    
                            } 
                        }

            case 'a' -> { GestionInterface.afficherAideAdministrateur();
                            GestionInterface.afficherMenuAdministrateur();
                            switch (GestionInterface.saisirOptionMenuAdministrateur()) {
                                case 'm' -> {}

                                case '+' -> {desserte = GestionDesserte.saisirDesserte(); GestionDesserte.ajouterDesserte(desserte_initiale , desserte[0], desserte[1]);
                                            for (int i = 0; i < desserte_initiale [0].length; i++) {
                                                System.out.print(desserte_initiale[0][i] + " " + desserte_initiale[1][i]);
                                            }                
                                }
                                
                                case 's' -> {}

                                case 'a' -> {}

                                case 'r' -> {GestionInterface.afficherMenuPrincipal();}
                                    
                            }
                        }
                
            case '?' -> GestionInterface.afficherAidePrincipal();
                
            case 'q' -> System.exit(0);
                
        }


    }
}
