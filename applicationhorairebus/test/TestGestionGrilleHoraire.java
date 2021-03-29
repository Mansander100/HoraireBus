/*
 * Test de la classe GestionGrilleHoraire
 * TestGestionGrilleHoraire.java                                        02/21
 */
package applicationhorairebus.test;

import java.util.Scanner;

import applicationhorairebus.programme.GestionGrilleHoraire;
import applicationhorairebus.programme.OutilHoraire;


/**
 * Classe qui contient une fonction main permettant de tester les différentes
 * méthodes de la classe GestionGrilleHoraire :
 *    - TODO : faire la liste
 *    
 * Plusieurs jeux de données sont définis. Parmi eux, 5 tableaux contenant
 * des horaires de passage en minutes
 *    
 * TODO : compléter
 * 
 * @author Serieys, Simon
 * @version 1.0
 *
 */
public class TestGestionGrilleHoraire {
    
    
    /** Objet Scanner pour effectuer les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
    
    /**
    * Nombre de répétitions des tests réalisés plusieurs fois
    */
   private static int NB_TEST = 3;
   
    
    /** Premier tableau avec des horaires de passages */
    private static final int[] DESSERTE0 =
        {430, 445, 460, 475, 490, 505, 520, 535, 550, 565, 580, 595, 610,
            625, 640, 655, 670, 685, 700, 715, 
            730, 745, 760, 775, 790, 805, 820, 835, 850, 865, 880, 895, 910,
            925, 940, 955, 970, 985, 1000, 1015,
            1030, 1045, 1060, 1075, 1090, 1105, 1120, 1135, 1150, 1165};
    
    /** deuxième tableau avec des horaires de passages */
    private static final int[] DESSERTE1 =
        {449, 483, 520, 563, 603, 643, 683, 723, 763, 803, 
                843, 883, 923, 964, 1004, 1044, 1083, 1123, 1163};
    
    
    /** troisième tableau avec des horaires de passages */
    private static final int[] DESSERTE2 =
        {434, 483, 515, 555, 595, 635, 675, 715, 755, 795, 
                835, 875, 915, 955, 995, 1035, 1075, 1115, 1155};
    
    /** quatrième tableau avec des horaires de passages */
    private static final int[] DESSERTE3 =
        {441, 501, 541, 581, 621, 661, 701, 741, 781, 821, 
                861, 901, 941, 981, 1021, 1061, 1101, 1141, 1181};
    
    /** cinquième tableau avec des horaires de passages */
    private static final int[] DESSERTE4 =
        {362, 477, 612, 737, 867, 1062};
    
    /** tableau d'horaire inférieur à DESSERTE4 */
    private static final int[] HORAIRE_A_TESTER =
        {435, 185, 611, 47, 653, 999, 45, 87, 1172, 1200};
    
    
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
    
    
    
    /*    méthodes permettant de construire et d'initialiser une grille horaire   */
    /* ************************************************************************** */
    
    
    /**
     * Recopie un tableau contenant les horaires d'une desserte dans une grille 
     * destination, sur un colonne précise
     * @param destination       grille destination
     * @param colonne           colonne sur laquelle faire la recopie
     * @param source            tableau contenant des horaies en minutes
     */
    public static void recopierUneDesserte(int[][] destination, int colonne, int[] source) {
        for (int i = 0; i < source.length; i++) {
            destination[i][colonne] = source[i];
        }
    }
    
    
    /**
     * Méthode permettant de fabriquer une grille horaire à partir des tableaux
     * constants nommés : DESSERTE0, DESSERTE1, DESSERTE2, DESSERTE3, DESSERTE4
     * @return  grille  tableau à 2 dimensions contenant les horaires définis via
     *                  les 5 tableaux constants
     */
    public static int[][] preparerGrilleExemple() {
        int[][] grille = new int[50][10];
        
    /* on initialise toutes les cases avec la valeur non significative -1 */
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = -1;                
            }
        }
        
        // on recopie chacun des 5 tableaux d'horaires
        recopierUneDesserte(grille, 0, DESSERTE0);
        recopierUneDesserte(grille, 1, DESSERTE1);
        recopierUneDesserte(grille, 2, DESSERTE2);
        recopierUneDesserte(grille, 3, DESSERTE3);
        recopierUneDesserte(grille, 4, DESSERTE4);
        return grille;  
              
    }
    
    
    /*    méthodes permettant de tester les méthodes ajoutées à la classe       */
    /*         GestionGrilleHoraire dans le but de tester les autres méthodes   */
    /* ************************************************************************ */
    
    
    /**
     * Affiche toutes les colonnes horaires d'une grille
     */
    private static final void testAfficherHoraireDesserte() {        
        /*
         *  création d'une grille horaire exemple à partir de laquelle les tests 
         *  des autres méthodes pourront être réalisés 
         */
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();
        
        System.out.println ("TEST : méthode afficherHoraireDesserte (test visuel)\n "                
                + "---------------------------------------------------\n");
        for (int i = 0; i < 10; i++) {            
            System.out.println("Horaires de la desserte située en colonne " + i);
            GestionGrilleHoraire.afficherHoraireDesserte(HORAIRE_EXEMPLE, i);
            continuer();
        }        
    }
    
    /**
     * Affiche toute une grille entière
     */
    private static final void testAfficherGrille() {        
        /*
         *  création d'une grille horaire exemple à partir de laquelle les tests 
         *  des autres méthodes pourront être réalisés 
         */
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();
        
        System.out.println ("TEST : méthode afficherGrille (test visuel)\n "                
                + "---------------------------------------------------\n");           
        GestionGrilleHoraire.afficherGrille(HORAIRE_EXEMPLE);
    }

    /**
     * Renvoie un booleen pour savoir si une grille est pleine ou pas
     */
    private static final void testTableauHorairesDessertePlein() {
       
        /*
         *  indique si un tableau est plein ou pas 
         *   
         */
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();
        
        System.out.println ("TEST : méthode tableauHorairesDessertePlein (test visuel)\n "                
                + "---------------------------------------------------\n");           
        GestionGrilleHoraire.tableauHorairesDessertePlein(HORAIRE_EXEMPLE);
    }

    /**
     * Renvoie un booleen pour savoir si la desserte a bien pu être ajouter ou non 
     */
    private static final void testAjouterHoraire() {
       
        /*
         *  Ajoute une desserte à la grille et renvoie un booleen en fonction 
         *  de si l'action a pu être réalisé ou pas 
         */
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();
        final int[] AJOUT_EXEMPLE = { 1, 2, 456 };
        
        System.out.println ("TEST : méthode ajouterHoraire (test visuel)\n "                
                + "---------------------------------------------------\n");           
        GestionGrilleHoraire.ajouterHoraire(HORAIRE_EXEMPLE,AJOUT_EXEMPLE);
    }




    /**
     * Test de recherche horaires postérieures dans les colonnes d'une grille
     */
    private static final void testRechercheProchainPassage() {        
        
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();

        for (int i = 0; i < 10; i++) {            
            System.out.println("Prochaine horaire après " 
                               + HORAIRE_A_TESTER[i] 
                               + " de la desserte située en colonne " + i + " est : ");
            System.out.println(GestionGrilleHoraire.rechercherProchainPassage(HORAIRE_EXEMPLE, i, HORAIRE_A_TESTER[i]));
            continuer();
        }     


/*
        if (i == HORAIRE_A_TESTER.length) {
            System.out.print("Tous les tests ont réussi");
        } else {
            System.out.print(HORAIRE_A_TESTER[i] + " a échoué");
        }
*/
    }
    
    
    /*              programme principal pour lancer les  tests             */
    /* ******************************************************************* */
   
    
    
    public static void main(String[] args) {        
        //testAfficherHoraireDesserte();
        //testAfficherGrille();
        testTableauHorairesDessertePlein();
        //testAjouterHoraire();
        // testRechercheProchainPassage();
    }
    

}