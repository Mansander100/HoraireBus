/*
 * Test de la classe GestionInterface
 * TestGestionInterface.java                                        01/21
 * 
 */
package applicationhorairebus.test;

import applicationhorairebus.programme.GestionInterface;
import applicationhorairebus.programme.OutilHoraire;

import java.util.Scanner;


/**
 * Classe qui contient une fonction main permettant de tester les différentes
 * méthodes de la classe GestionInterface :
 *    - affichage et saisie de l'option pour les 3 menus
 *    - saisie du mot de passe
 *    - saisie du nom d'un arrêt de bus
 *    - saisie du nom d'une ligne de bus
 * @author INFO1 Semestre 2
 * @version 1.0
 *
 */
public class TestGestionInterface {
    
    
    /** Objet Scanner pour effectuer les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
    
    /**
     * Nombre de répétitions des tests réalisés plusieurs fois
     */
    private static int NB_TEST = 3;
    
    
   /********************   2 méthodes outils pour gérer les tests   ******************/
    
    
    /**
     * Demande à l'utilisateur d'appuyer sur entrée pour continuer
     */
    private static void continuer() {
        System.out.println("\n\n\nAppuyer sur entrée pour continuer les tests.") ;
        entree.nextLine();
        System.out.println("\n\n");
    }
    
    
    /**
     * Affiche le résultat d'un test : le nombre de tests réussis et le 
     * nombre de tests total
     * @param nbTestTotal       nombre total de tests effectués
     * @param nbTestOk          nombre de tests réussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println(nbTestOk + " test(s) ont réussi sur un total de "
                + nbTestTotal + " tests réalisés.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                        "Tous les tests sont OK" 
                        : "Au moins un test a échoué.") + "\n");
    }
    
    
    
    
    /* ********************   test unitaire de la méthode générale   ************** */
    /*                    qui vérifie si une option de menu est correcte            */                   
    
    
    /** 
     * Test de la méthode reponseValide  (test automatique)
     */
    public static void testReponseValide() {        
        // listes des options valides
        final char[] OPTION_VALIDE = { 'a', 't', 'c', 'm', 'e', 's', '?', 'q'};
        
        // liste de réponses incorrectes que l'utilisateur pourrait donner
        final String[] VALEUR_INCORRECTE = {"b",  "B", "h",  "H", "", "Ajouter", "A A",
                                           " a", "help", "t+", "*" , "ee", " e", "e ",
                                           " M"};
        
        // liste de toutes les réponses correctes
        final String[] VALEUR_CORRECTE = {"a",  "t", "c",  "m", "e", "e", "?", "q", "A",
                                          "T", "C",  "M", "E", "Q"};  
                

        int nbTestCorrect;    // nombre de tests réussis
        
        System.out.println ("TEST : méthode reponseValide (test automatique)\n"
                + "-----------------------------------------------");
        
        // Etape 1 : test avec des valeurs correctes
        System.out.println("========> Etape 1/2 - Tests avec des valeurs correctes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < VALEUR_CORRECTE.length; i++) {
            if (! GestionInterface.reponseValide(VALEUR_CORRECTE[i], OPTION_VALIDE)) {
                System.out.println("Erreur - L'option " + VALEUR_CORRECTE[i] 
                                   + " a été considérée comme invalide.");
            } else {
                nbTestCorrect++;
            }
           
        }
        afficherResultatTest(VALEUR_CORRECTE.length, nbTestCorrect);
                    
        // Etape 2 : test avec des valeurs incorrectes
        System.out.println("\n========> Etape 2/2 - Tests avec des valeurs incorrectes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < VALEUR_INCORRECTE.length; i++) {
            if ( GestionInterface.reponseValide(VALEUR_INCORRECTE[i], OPTION_VALIDE)) {
                System.out.println("Erreur - L'option " + VALEUR_INCORRECTE[i] 
                                   + " a été considérée comme valide.");
            } else {
                nbTestCorrect++;
            }            
        }
        afficherResultatTest(VALEUR_INCORRECTE.length, nbTestCorrect);        
        continuer();    
    }    
    
    
    /* *********************   méthodes de tests unitaires   ********************** */
    /*                            pour le menu principal                            */
    
    /** 
     * Test de la méthode afficherAidePrincipal qui affiche l'aide en ligne (test visuel)
     */
    public static void testAfficherAidePrincipal() {
        System.out.println ("TEST : méthode afficherAidePrincipal (test visuel)\n"
                + "-----------------------------------------\n");
        GestionInterface.afficherAidePrincipal();
        continuer();
    }
    

    /** 
     * Test de la méthode afficherMenuPrincipal qui affiche le menu principal (test visuel)
     */
    public static void testAfficherMenuPrincipal() {
        System.out.println ("TEST : méthode afficherMenuPrincipal (test visuel)\n"
                + "-------------------------------------------------\n");
        GestionInterface.afficherMenuPrincipal();
        continuer();
    }
     
    /**
     * Test de la méthode saisirOptionMenuPrincipal (test interactif)
     */
    public static void testSaisirOptionMenuPrincipal() {
        char option;        // option saisie pour le menu
        
        System.out.println ("TEST : méthode saisirOptionMenuPrincipal (test interactif "
                            + "recommencé " + NB_TEST + " fois)\n--------------------"
                            + "------------------------------------------------------");
        for (int i = 1; i <= NB_TEST; i++) {
            System.out.println("TEST NUMERO " + i + "\n");
            option = GestionInterface.saisirOptionMenuPrincipal();  
            System.out.println("\n\nPOUR LE TEST NUMERO " + i 
                               + " C'EST L'OPTION " + option
                               + " QUI A ETE CHOISIE.\n\n");
        }
        continuer();
    }
    
    
    /* *********************   méthodes de tests unitaires   ********************** */
    /*                            pour le menu voyageur                             */
     
   public static void testAfficherMenuVoyageur() {        
        // listes des options valides
        final char[] OPTION_VALIDE = { 'c', 'a', 'm', 'i', '?', 'r'};
        
        // liste de réponses incorrectes que l'utilisateur pourrait donner
        final String[] VALEUR_INCORRECTE = {"b",  "B", "h",  "H", "", "Ajouter", "A A",
                                           " a", "help", "t+", "*" , "ee", " e", "e ",
                                           " M"};
        
        // liste de toutes les réponses correctes
        final String[] VALEUR_CORRECTE = {"c", "a", "m", "i","?", "r"};
                
        int nbTestCorrect;    // nombre de tests réussis
        
        System.out.println ("TEST : méthode reponseValide (test automatique)\n"
                + "-----------------------------------------------");
        
        // Etape 1 : test avec des valeurs correctes
        System.out.println("========> Etape 1/2 - Tests avec des valeurs correctes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < VALEUR_CORRECTE.length; i++) {
            if (! GestionInterface.reponseValide(VALEUR_CORRECTE[i], OPTION_VALIDE)) {
                System.out.println("Erreur - L'option " + VALEUR_CORRECTE[i] 
                                   + " a été considérée comme invalide.");
            } else {
                nbTestCorrect++;
            }
           
        }
        afficherResultatTest(VALEUR_CORRECTE.length, nbTestCorrect);
                    
        // Etape 2 : test avec des valeurs incorrectes
        System.out.println("\n========> Etape 2/2 - Tests avec des valeurs incorrectes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < VALEUR_INCORRECTE.length; i++) {
            if ( GestionInterface.reponseValide(VALEUR_INCORRECTE[i], OPTION_VALIDE)) {
                System.out.println("Erreur - L'option " + VALEUR_INCORRECTE[i] 
                                   + " a été considérée comme valide.");
            } else {
                nbTestCorrect++;
            }            
        }
        afficherResultatTest(VALEUR_INCORRECTE.length, nbTestCorrect);        
        continuer();    
    }    
    

    /**
     * Test de la méthode saisirOptionMenuVoyageur (test interactif)
     */
    public static void testSaisirOptionMenuVoyageur() {
        char option;        // option saisie pour le menu
        
        System.out.println ("TEST : méthode saisirOptionMenuVoyageur (test interactif "
                            + "recommencé " + NB_TEST + " fois)\n--------------------"
                            + "------------------------------------------------------");
        for (int i = 1; i <= NB_TEST; i++) {
            System.out.println("TEST NUMERO " + i + "\n");
            option = GestionInterface.saisirOptionMenuVoyageur();  
            System.out.println("\n\nPOUR LE TEST NUMERO " + i 
                               + " C'EST L'OPTION " + option
                               + " QUI A ETE CHOISIE.\n\n");
        }
        continuer();
    }
    

    /** 
     * Test de la méthode afficherAideVoyageur qui affiche l'aide en ligne (test visuel)
     */
    public static void testAfficherAideVoyageur() {
        System.out.println ("TEST : méthode afficherAideVoyageur (test visuel)\n"
                + "-----------------------------------------\n");
        GestionInterface.afficherAideVoyageur();
        continuer();
    }

    
    /* *********************   méthodes de tests unitaires   ********************** */
    /*                         pour le menu administrateur                          */
     
    public static void testAfficherMenuAdministrateur() {        
        // listes des options valides
        final char[] OPTION_VALIDE = { 'm', '+', 's', 'a','r'};
        
        // liste de réponses incorrectes que l'utilisateur pourrait donner
        final String[] VALEUR_INCORRECTE = {"b",  "B", "h",  "H", "", "Ajouter", "A A",
                                           " a", "help", "t+", "*" , "ee", " e", "e ",
                                           " M"};
        
        // liste de toutes les réponses correctes
        final String[] VALEUR_CORRECTE = {"m", "+", "s", "a", "r"};
                
        int nbTestCorrect;    // nombre de tests réussis
        
        System.out.println ("TEST : méthode reponseValide (test automatique)\n"
                + "-----------------------------------------------");
        
        // Etape 1 : test avec des valeurs correctes
        System.out.println("========> Etape 1/2 - Tests avec des valeurs correctes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < VALEUR_CORRECTE.length; i++) {
            if (! GestionInterface.reponseValide(VALEUR_CORRECTE[i], OPTION_VALIDE)) {
                System.out.println("Erreur - L'option " + VALEUR_CORRECTE[i] 
                                   + " a été considérée comme invalide.");
            } else {
                nbTestCorrect++;
            }
           
        }
        afficherResultatTest(VALEUR_CORRECTE.length, nbTestCorrect);
                    
        // Etape 2 : test avec des valeurs incorrectes
        System.out.println("\n========> Etape 2/2 - Tests avec des valeurs incorrectes \n");
        nbTestCorrect = 0;
        for(int i = 0; i < VALEUR_INCORRECTE.length; i++) {
            if ( GestionInterface.reponseValide(VALEUR_INCORRECTE[i], OPTION_VALIDE)) {
                System.out.println("Erreur - L'option " + VALEUR_INCORRECTE[i] 
                                   + " a été considérée comme valide.");
            } else {
                nbTestCorrect++;
            }            
        }
        afficherResultatTest(VALEUR_INCORRECTE.length, nbTestCorrect);        
        continuer();    
    } 
    
    
    /**
     * Test de la méthode saisirOptionMenuAdministrateur (test interactif)
     */
    public static void testSaisirOptionMenuAdministrateur() {
        char option;        // option saisie pour le menu
        
        System.out.println ("TEST : méthode saisirOptionMenuAdministrateur (test interactif "
                            + "recommencé " + NB_TEST + " fois)\n--------------------"
                            + "------------------------------------------------------");
        for (int i = 1; i <= NB_TEST; i++) {
            System.out.println("TEST NUMERO " + i + "\n");
            option = GestionInterface.saisirOptionMenuAdministrateur();  
            System.out.println("\n\nPOUR LE TEST NUMERO " + i 
                               + " C'EST L'OPTION " + option
                               + " QUI A ETE CHOISIE.\n\n");
        }
        continuer();
    }
    

    /** 
     * Test de la méthode afficherAideAdministrateur qui affiche l'aide en ligne (test visuel)
     */
    public static void testAfficherAideAdministrateur() {
        System.out.println ("TEST : méthode afficherAideAdministrateur (test visuel)\n"
                + "-----------------------------------------\n");
        GestionInterface.afficherAideAdministrateur();
        continuer();
    }


    
    /* *********************   méthodes de tests unitaires   ********************** */
    /*      pour les saisies : mot de passe, nom d'arrêt,  identifiant de ligne     */
     
    
    /** 
     * Test de la méthode saisirMotDePasse (test visuel)
     */
    public static void testSaisirMotDePasse() {
        boolean saisieCorrecte;    // vrai ssi la saisie du mot de passe est
                                   // correcte (au plus tard à la 5ème tentative)
        System.out.println ("TEST : méthode saisirMotDePasse (test visuel)\n"
                + "---------------------------------------------\n"
                + "Vous allez saisir " + NB_TEST + " fois un mot et vérifier "
                + "visuellement que la méthode effectue correctement la saisie.\n"
                + "N'hésitez pas à commettre des erreurs de saisie.");

        // on recommence plusieurs fois la saisie d'un mot de passe
        for (int i = 0; i < NB_TEST; i++) {
            System.out.println("\nSaisie numéro " + (i + 1)
                               + ". Le mot de passe correct est iutbus" + i + " :");
            saisieCorrecte = GestionInterface.saisirMotDePasse("iutbus" + i);
            if (saisieCorrecte) {
                System.out.println("\nLe mot de passe a été correctement saisi.");
            } else {
                System.out.println("\nAu bout de 5 tentatives le mot de passe "
                                   + "n'a pas été saisi correctement"); 
            }
        }
        continuer();
    }
    

    /** 
     * Test de la méthode saisirNomArret (test visuel)
     */
    public static void testSaisirNomArret() {
        
        // liste de toutes les réponses correctes
        final String[] ARRET_VALIDE = { "Buanton", "Vallon", "Centre de secours", "Marechal "
                                            + "Joffre", "Je suis effectivement tro" };  
                                            
        String arret;
        int compteur,
            NB_TEST_ARRET;

        NB_TEST_ARRET = ARRET_VALIDE.length;

        System.out.println ("TEST : méthode saisirNomArret (test visuel)\n"
                + "---------------------------------------------\n"
                + "Vous allez saisir " + NB_TEST_ARRET + " fois un mot et vérifier "
                + "visuellement que la méthode effectue correctement la saisie.\n"
                + "N'hésitez pas à commettre des erreurs de saisie.");

        // on recommence plusieurs fois la saisie d'un arret
        for (int i = 0; i < NB_TEST_ARRET; i++) {
            System.out.println("\nSaisie numéro " + (i + 1)
                               + ". La saisi correcte est : " + ARRET_VALIDE[i]);
            arret = GestionInterface.saisirNomArret();

            for (compteur = 0 ; compteur < ARRET_VALIDE.length-1 && ! arret.equals(ARRET_VALIDE[compteur]); compteur++ );
            // empty body

            if (arret.equals(ARRET_VALIDE[compteur])) {
                System.out.println("\nL'arrêt a été correctement saisi.");
            } else {
                System.out.println("\nL'arrêt n'a pas été saisi correctement."); 
            }
        }
         
        continuer();
    }


    /** 
     * Test de la méthode saisirNomLigne (test visuel)
     */
    public static void testSaisirNomLigne() {

        // liste de toutes les réponses correctes
        final String[] LIGNE_VALIDE = { "A", "B", "C", "D"}; 
                                            
        String ligne;
        int compteur,
            NB_TEST_LIGNE;

        NB_TEST_LIGNE = LIGNE_VALIDE.length;

        System.out.println ("TEST : méthode saisirNomLigne (test visuel)\n"
                + "---------------------------------------------\n"
                + "Vous allez saisir " + NB_TEST_LIGNE + " fois un mot et vérifier "
                + "visuellement que la méthode effectue correctement la saisie.\n"
                + "N'hésitez pas à commettre des erreurs de saisie.");

        // on recommence plusieurs fois la saisie d'une ligne
        for (int i = 0; i < NB_TEST_LIGNE; i++) {
            System.out.println("\nSaisie numéro " + (i + 1)
                               + ". La saisi correcte est : " + LIGNE_VALIDE[i]);
            ligne = GestionInterface.saisirNomLigne();

            for (compteur = 0 ; compteur < LIGNE_VALIDE.length-1 && ! ligne.equals(LIGNE_VALIDE[compteur]); compteur++ );
            // empty body

            if (ligne.equals(LIGNE_VALIDE[compteur])) {
                System.out.println("\nLa ligne a été correctement saisie.");
            } else {
                System.out.println("\nLa ligne n'a pas été saisie correctement."); 
            }
        }
    }
    
    
    
    /**
     * Programme principal. Point d'entrée pour lancer les tests
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------\n"
                + "     TESTS DE LA CLASSE  GESTION INTERFACE   \n"
                + "-----------------------------------------------\n");
        
        
        
        //testAfficherAidePrincipal();
        //testAfficherMenuPrincipal();
        //testReponseValide();
        //testSaisirOptionMenuPrincipal();

        //testAfficherAideVoyageur();
        //testAfficherMenuVoyageur();
        //testSaisirOptionMenuVoyageur();

        //testAfficherAideAdministrateur();
        // Prochaine capture à faire
        //testAfficherMenuAdministrateur();
        //testSaisirOptionMenuAdministrateur();

        //testSaisirMotDePasse(); 
        //testSaisirNomArret();
        //testSaisirNomLigne();
    }
}
