/*
 * Test de la classe GestionIDesserte
 * TestGestionDesserte.java                                        01/19
 */
package applicationhorairebus.test;

import java.util.Scanner;
import applicationhorairebus.programme.GestionDesserte;



/**
 * Classe qui contient une fonction main permettant de tester les différentes
 * méthodes de la classe GestionDesserte :
 *    - saisir une desserte valide
 *    - afficher le tableau des dessertes
 *    - rechercher une desserte
 *    - ajouter une desserte
 *    - supprimer une desserte
 *    
 * Plusieurs jeux de données sont définis. Parmi eux, 4 tableaux de dessertes
 * ayant les caractéristiques suivantes :
 *    - un tableau qui correspond à l'exemple du cahier des charges
 *    - un tableau contenant une seule desserte
 *    - un tableau ne contenant aucune desserte
 *    - un tableau contenant 10 dessertes (donc un tableau plein)
 *    
 * Des tableaux constants contiennent les résultats que la méthode 
 * rechercherDesserte est supposée renvoyer lorsqu'elle est appliquée aux
 * différents tableaux de dessertes
 * 
 * @author INFO1 Semestre 2
 * @version 1.0
 *
 */
public class TestGestionDesserte {
    
    
    /** Objet Scanner pour effectuer les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
    
    /**
    * Nombre de répétitions des tests réalisés plusieurs fois
    */
   private static int NB_TEST = 3;
   
    
   
    /* ****************   2 méthodes outils pour gérer les tests   ************** */
    /* ************************************************************************** */
    
    
    /**
     * Demande à l'utilisateur d'appuyer sur entrée pour continuer
     */
    private static void continuer() {
        System.out.println("Appuyer sur entrée pour continuer les tests.") ;
        entree.nextLine();
        System.out.println("\n");
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
    
    
    
    /* ******   4 tableaux de dessertes utilisés comme jeux de tests    ********* */
    /* ************************************************************************** */
    
    
    /**
     * Ensemble des dessertes données en exemple dans le cahier des 
     * charges
     */
    private static final String[][] EXEMPLE_DESSERTE = 
        { {"Buanton", "Vallon", "Centre de secours", "Marechal Joffre",
        "Marechal Joffre", null, null, null, null, null},
        {"A", "C", "C", "D", "F", null, null, null, null, null} };

    /**
     * Ensemble de dessertes formé d'une seule desserte
     */
    private static final String[][] UNE_SEULE_DESSERTE = 
        { {"Buanton", null, null, null, null , null, null, null, null, null},
        {"A", null, null, null, null, null, null, null, null, null} };
    
    /**
     * Ensemble de dessertes formé d'aucune desserte
     */
    private static final String[][] AUCUNE_DESSERTE = 
        { {null, null, null, null, null , null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null, null} };
   
    
    /**
     * Ensemble des dessertes contenant le nombre maximum de
     * dessertes
     */
    private static final String[][] TOUTES_LES_DESSERTES = 
        { {"Buanton", "Vallon", "Centre de secours", "Marechal Joffre",
        "Marechal Joffre", "Buanton", "Vallon", "Centre de secours", 
        "Marechal Joffre", "Vallon"},
        {"A", "C", "C", "D", "F", "G", "H", "I", "J", "K"} };
    
    
    
    /* *****   Réponses attendues lors de l'appel à rechercherDesserte    ******* */
    /* ************************************************************************** */
    
    /**
     * Réponses attendues lors d'une recherche de dessertes dans le tableau 
     * EXEMPLE_DESSERTE (résultat de la méthode rechercherDesserte 
     */
    private static final int[] REPONSE_EXEMPLE = {0, 1, 2, 3, 4, -1, -1, -1, -1, -1};
    
    /**
     * Réponses attendues lors d'une recherche de dessertes dans le tableau 
     * UNE_SEULE_DESSERTE (résultat de la méthode rechercherDesserte 
     */
    private static final int[] REPONSE_UNE_SEULE = {0, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    
    /**
     * Réponses attendues lors d'une recherche de dessertes dans le tableau 
     * AUCUNE_DESSERTE (résultat de la méthode rechercherDesserte 
     */
    private static final int[] REPONSE_AUCUNE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    
    /**
     * Réponses attendues lors d'une recherche de dessertes dans le tableau 
     * TOUTES_LES_DESSERTES (résultat de la méthode rechercherDesserte 
     */
    private static final int[] REPONSE_TOUTES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    
    
    
    /* ********   Méthode de test pour la méthode     saisirDesserte    ********* */
    /* ************************************************************************** */
    
    /**
     * Test de la méthode saisirDesserte (test interactif)
     */
    public static void testSaisirDesserte() {
        String[] desserte;       // desserte saisie
        
        System.out.println (
            "TEST : méthode saisirDesserte (test interactif "
                            + "recommencé " + NB_TEST + " fois)\n----------------"
                            + "---------------------------------------------------");
        // 
        for (int i = 0; i < NB_TEST; i++) {
            desserte = GestionDesserte.saisirDesserte(); // incrémentation du tableau
        }
        continuer();
    }


        /* ********   Méthode de test pour la méthode     dessertValide    ********* */
    /* ************************************************************************** */
    
    /**
     * Test de la méthode dessertValide (test unitaire)
     */
    public static void testDessertValide() {
        final String[][] TEST_DESSERTE = { {"Buanton", "Vallon", "Centre de secours", "Marechal Joffre",
        "Marechal Joffre", " ", null, null, null, null},
        {"A", "C", "C", "D", "F", " ", null, null, null, null} };
        int testOk = 0;
        int testNotOk = 0;
        for (int i = 0 ; i < TEST_DESSERTE[0].length; i++){
            if (GestionDesserte.desserteValide(TEST_DESSERTE[0][i],TEST_DESSERTE[1][i])){
                testOk++;
            } else {
                testNotOk++;
            }
        }

        afficherResultatTest(TEST_DESSERTE[0].length/2, testOk); // afichage du resultat du nombre de tests correctes
        afficherResultatTest(TEST_DESSERTE[0].length/2, testNotOk); // afichage du resultat du nombre de tests incorrectes
    }
    
    
    

    /* ********   Méthode de test pour la méthode    afficherDesserte    ******** */
    /* ************************************************************************** */
    
    
    /**
     * Test de la méthode qui affiche les dessertes gérées
     */
    private static void testAfficherDesserte() {
        System.out.println("TEST DE LA METHODE afficherDesserte (test visuel) \n"
                           + "------------------------------------------------\n");
        System.out.println("Un ensemble de 5 dessertes : ");
        GestionDesserte.afficherDesserte(EXEMPLE_DESSERTE);
        
        System.out.println("\nUn ensemble contenant une seule desserte : ");
        GestionDesserte.afficherDesserte(UNE_SEULE_DESSERTE);
        
        System.out.println("\nUn ensemble contenant 10 dessertes : ");
        GestionDesserte.afficherDesserte(TOUTES_LES_DESSERTES);
       
        System.out.println("\nUn ensemble de dessertes vide : ");
        GestionDesserte.afficherDesserte(AUCUNE_DESSERTE);
        
    }


    /* ********   Méthode de test pour la méthode    afficherDessertePrecise    ******** */
    /* ************************************************************************** */
    
    
    /**
     * Test de la méthode qui affiche une desserte precise
     */
    private static void testAfficherDessertePrecise() {
        System.out.println("TEST DE LA METHODE afficherDesserte (test visuel) "
                            + "sur le tableau EXEMPLE_DESSERTE\n"
                           + "-----------------------------------------------------"
                           + "----------------------------\n");

        GestionDesserte.afficherDesserte(EXEMPLE_DESSERTE);
        System.out.println("\n");
        System.out.println("Desserte d'indice 4 : ");
        GestionDesserte.afficherDessertePrecise(EXEMPLE_DESSERTE, 4);
        
        System.out.println("\nDesserte d'indice 0 : ");
        GestionDesserte.afficherDessertePrecise(EXEMPLE_DESSERTE, 0);
        
        System.out.println("\nDesserte d'indice 5 : ");
        GestionDesserte.afficherDessertePrecise(EXEMPLE_DESSERTE, 5);
       
        System.out.println("\nDesserte d'indice 7 : ");
        GestionDesserte.afficherDessertePrecise(EXEMPLE_DESSERTE, 7);
        
    }
    
    
    /* *****   Méthodes de tests pour la méthode    rechercherDesserte    ******* */
    /* ************************************************************************** */
    
    /**
     * Test de la méthode rechercheDesserte
     * @param table         tableau de dessertes dans lequel les recherches sont 
     *                      effectuées
     * @param reponse       tableau d'entier contenant les résultats que doit
     *                      renvoyer la méthode rechercherDesserte lorsqu'elle est
     *                      appliquée au tableau de dessertes table
     */
    private static void testRechercherDesserte(String[][] table, int[] reponse) {
        int nbTestOk;               // nombre de tests avec résultat correct
        int resultatRecherche;      // résultat d'une recherche dans table
        System.out.println("Recherche de dessertes dans la table :");
        GestionDesserte.afficherDesserte(table);
        
        nbTestOk = 0;
        
        /*
         * on recherche dans le tableau table toutes les dessertes du 
         * tableau TOUTES_LES_DESSERTES
         */
        for (int i = 0; i < TOUTES_LES_DESSERTES[0].length; i++) {
            
            /*
             *  on recherche dans table la desserte située en colonne i 
             *  du tableau TOUTES_LES_DESSERTES
             */
            resultatRecherche = GestionDesserte.rechercherDesserte(
                    table, TOUTES_LES_DESSERTES[0][i], TOUTES_LES_DESSERTES[1][i]);
            if (resultatRecherche == reponse[i]) {
                
                // le résultat de la recherche est conforme à celui attendu
                nbTestOk++;
            } else {
                System.out.println("Résultat inattendu pour la desserte " 
                                   + TOUTES_LES_DESSERTES[0][i] + "  " 
                                   + TOUTES_LES_DESSERTES[1][i] 
                                   + " (indice resultat =  " + resultatRecherche
                                   + " au lieu de " + reponse[i] + ")");                       
            }
        }
        
        // on affiche une synthèse des tests
        afficherResultatTest(TOUTES_LES_DESSERTES[0].length, nbTestOk);
        continuer();
        
    }
    
    
    /**
     * Test d'un cas particulier de la méthode rechercherDesserte :
     * recherche d'une desserte absente d'une table pleine.
     */
    private static void testRechercherDesserteCasParticulier() {        
        String nomArret = "????";   // arrêt de la desserte qui sera cherchée
        String identLigne = "Z";    // ligne de la desserte recherchée 
        int resultatRecherche;      // résultat recherche desserte ci-dessus
        
        System.out.println("Cas particulier. Recherche d'une desserte absente d'une"
                           + " table de dessertes pleine. La table est :");
        GestionDesserte.afficherDesserte(TOUTES_LES_DESSERTES);
          
        /*
         *  rechercher une desserte 
         *  dans le tableau TOUTES_LES_DESSERTES (tableau plein) alors que 
         *  cette desserte est absente du tableau
         */
        resultatRecherche = GestionDesserte.rechercherDesserte(
                                     TOUTES_LES_DESSERTES, nomArret, identLigne);
        
        // on affiche le résultat du test
        if (resultatRecherche == -1) {      
            System.out.println("Le test du cas particulier a réussi.");
        } else {
            System.out.println("ECHEC. Résultat inattendu pour la desserte " 
                    + nomArret + "  " + identLigne                    
                    + " (desserte trouvée à l'indice =  " + resultatRecherche
                    + " alors qu'elle est absente)");       
        }  
        continuer();
    }
    
    
    /**
     * Test de la méthode rechercherDesserte avec plusieurs jeux de données
     * (test automatique)
     */
    private static void testRechercherDesserte() {
        System.out.println ("TEST : méthode rechercherDesserte (test automatique)\n "                
                + "---------------------------------------------------\n");
        
        testRechercherDesserte(EXEMPLE_DESSERTE, REPONSE_EXEMPLE);
        testRechercherDesserte(UNE_SEULE_DESSERTE, REPONSE_UNE_SEULE);
        testRechercherDesserte(AUCUNE_DESSERTE, REPONSE_AUCUNE);
        testRechercherDesserte(TOUTES_LES_DESSERTES, REPONSE_TOUTES);
        testRechercherDesserteCasParticulier();        
    }
    
    
    
    /* ****  Méthodes de tests pour ajouterDesserte et supprimerDesserte  ******* */
    /* ************************************************************************** */
    
    /**
     * Test de la méthode ajouterDesserte (test visuel)
     * @table table de desserte à laquelle la desserte sera ajoutée
     */
    public static void testAjouterDesserte(String[][] table) {
        String[] desserte;        // desserte saisie et à ajouter
        int resultatAjout;        // résultat de l'appel à ajouterDesserte
        System.out.println("Ajout de dessertes a la table :");
        GestionDesserte.afficherDesserte(table);
        
        // plusieurs ajouts sont effectués
        for (int i = 1; i <= NB_TEST; i++) {
            System.out.println("\n\nTEST NUMERO " + i + "\n");
            desserte = GestionDesserte.saisirDesserte();  
            resultatAjout = 
                    GestionDesserte.ajouterDesserte(table, desserte[0], desserte[1]);
            
            // on affiche le résultat de l'ajout
            System.out.print("RESULTAT =>   ");
            if (resultatAjout == -1) {
                System.out.println("La desserte n'a pas ete ajoutee.");
            } else {
                System.out.println("La desserte a ete ajoutee en colonne "
                                   + resultatAjout);
            }
            System.out.println("              Après l'opération, la table obtenue est : ");
            GestionDesserte.afficherDesserte(table);
            
        }
        continuer();        
    }
    
    /**
     * Test de la méthode ajouterDesserte (test visuel)
     */
    public static void testAjouterDesserte() {
        System.out.println ("TEST : méthode ajouterDesserte (test interactif "
                + "recommencé " + NB_TEST + " fois pour chaque table)\n"
                + "---------------------------------"
                + "---------------------------------------------------");
        testAjouterDesserte(EXEMPLE_DESSERTE);
        testAjouterDesserte(UNE_SEULE_DESSERTE);
        testAjouterDesserte(AUCUNE_DESSERTE);
        testAjouterDesserte(TOUTES_LES_DESSERTES);
    }
    




    /**
     * Test de la méthode supprimerDesserte (test visuel)
     * @table table de desserte à laquelle la desserte sera supprimee
     */
    public static void testSupprimerDesserte(String[][] table) {
        String[] desserte;       // desserte saisie et à supprimer
        int resultatSuppression ;        // résultat de l'appel à supprimerDesserte
        System.out.println("Supprimer une desserte de la table :");
        GestionDesserte.afficherDesserte(table);
        
        // plusieurs suppréssions effectués
        for (int i = 1; i <= NB_TEST; i++) {
            System.out.println("\n\nTEST NUMERO " + i + "\n");
            desserte = GestionDesserte.saisirDesserte();  
            for (int j = 0; j < desserte.length; j++) {
                System.out.print(desserte[j]);
            }
            resultatSuppression = 
                    GestionDesserte.supprimerDesserte(table, desserte[0], desserte[1]);
            
            // on affiche le résultat de la soustraction
            System.out.print("RESULTAT =>   ");
            if (resultatSuppression  == -1) {
                System.out.println("La desserte n'a pas ete supprimee.");
            } else {
                System.out.println("La desserte a ete supprimee "
                                   + resultatSuppression );
            }
            System.out.println("             Apres l'operation "
                                + "la table obtenue est : ");
            GestionDesserte.afficherDesserte(table);
            
        }
        continuer();        
    }
    
    /**
     * Test de la méthode supprimerDesserte (test visuel)
     */
    public static void testSupprimerDesserte() {
        System.out.println ("TEST : méthode supprimerDesserte (test interactif "
                + "recommencé " + NB_TEST + " fois pour chaque table)\n"
                + "---------------------------------"
                + "---------------------------------------------------");
        testSupprimerDesserte(EXEMPLE_DESSERTE);
        testSupprimerDesserte(UNE_SEULE_DESSERTE);
        testSupprimerDesserte(AUCUNE_DESSERTE);
        testSupprimerDesserte(TOUTES_LES_DESSERTES);
    }
    
   
    
    
    /* **********      Fonction main qui lance les méthodes de test  ************ */
    /* ************************************************************************** */
      
    
    public static void main(String[] args) {

        System.out.println("------------------------------------------------------------------------\n"
                         + "         TESTS DES METHODES DE LA CLASSE GESTION DESSERTE             \n"
                         + "------------------------------------------------------------------------\n");
        
        //testAfficherDesserte();
        testAfficherDessertePrecise();
        // testSaisirDesserte();   
        // testDessertValide();     
        // testRechercherDesserte();
        // testAjouterDesserte();
        // testSupprimerDesserte();
    }

}