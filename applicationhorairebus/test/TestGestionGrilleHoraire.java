/*
 * Test de la classe GestionGrilleHoraire
 * TestGestionGrilleHoraire.java                                        02/21
 */
package applicationhorairebus.test;

import java.util.Scanner;

import applicationhorairebus.programme.GestionGrilleHoraire;


/**
 * Differente tableaux sont definis pour les jeux de données 
 *     - DESSERTE Ces tableaux sont là pour tester les cas correct d'horaires 
 *     - HORAIRE_A_TESTER est utilisée pour les cas ou un autre tableau est 
 *       necessaire en argument comme par exemple le methode d'ajout 
 *     - TABLEAU_PLEIN est utilisee pour l'unique cas d'un tableau entierement remplie 
 *       le contenu importe peu 
 *     - VALIDE est utilise pour les cas ou les chaîne sont valides format cchcc
 *     - INVALIDE est les chaines sont invalides chaque cas d'erreur est explique
 *     - COLONNE_EXEMPLE est utilise dans le cas ou une colonnne est demandee en argument 
 *     - BORNE_XXX_EXEMPLE sont les bornes utilisee pour les methodes les necessitant 
 *
 * Ce programme teste les methodes de GestionGrilleHoraire suivante : 
 *    afficherHoraireDesserte
 *    afficherGrille
 *    tableauHoraireDessertePlein
 *    ajouterHoraire
 *    suppromerHoraire
 *    rechercheProchainPassage
 *    rechercheHoraire
 *    tableauHoraireCorrect
 *    convertirTableauHoraire
 *    
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 *
 */
public class TestGestionGrilleHoraire {
    
    
    /** Objet Scanner pour effectuer les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
   
    
    /** Premier tableau avec des horaires de passages */
    private static final int[] DESSERTE0 =
        {430, 445, 460, 475, 490, 505, 520, 535, 550, 565, 580, 595, 610,
            625, 640, 655, 670, 685, 700, 715, 
            730, 745, 760, 775, 790, 805, 820, 835, 850, 865, 880, 895, 910,
            925, 940, 955, 970, 985, 1000, 1015,
            1030, 1045, 1060, 1075, 1090, 1105, 1120, 1135, 1150, 1165};
    
    /** deuxième tableau avec des horaires de passages */
    private static final int[] DESSERTE1 =
        {449, 483, 523/*520*/, 563, 603, 643, 683, 723, 763, 803, 
                843, 883, 923, 964, 1004, 1044, 1083, 1123, 1163};
    
    
    /** troisième tableau avec des horaires de passages */
    private static final int[] DESSERTE2 =
        {434, 483, 515, 555, 595, 635, 675, 715, 755, 795, 
                835, 875, 915, 955, 995, 1035, 1075, 1115, 1155};
    
    /** quatrième tableau avec des horaires de passages */
    private static final int[] DESSERTE3 =
        {471/*441*/, 501, 541, 581, 621, 661, 701, 741, 781,/*,821*/
                861, 901, 941, 981, 1021, 1061, 1101, 1141, 1181};
    
    /** cinquième tableau avec des horaires de passages */
    private static final int[] DESSERTE4 =
        {363/*362*/, 478/*477*/, 613/*612*/, 738/*737*/, 868/*867*/,
        1063/*1062*/, 1143/*null*/};
        

    
    /** tableau d'horaire inférieur à tester pour les ajouts par exemple */
    private static final int[] HORAIRE_A_TESTER =
        {465, 185, 611, 47, 737, 999, 45, 87, 1172, 1200};




        
    /** tableau de chaines invalides */
    private static final String[][] INVALIDES =
        {
        /* cas caractère min en trop */
        {"08h30", "08h52A", "08h35"},
        /* cas caractère heure en trop */
        {"08h30", "08h35", "A08h52"},
        /* cas heure avec un seul chiffre */
        {"8h30", "08h35", "08h40"},
        /* cas min avec un seul chiffre */
        {"08h6", "08h35", "08h40"},
        /* cas heure > 23 */
        {"08h30", "25h35", "08h45"},
        /* cas heure < 0 et 3 caractères */
        {"08h30", "-10h35", "08h45"},
        /* cas heure < 0 et 2 caractères */
        {"08h30", "08h45", "-1h35"},
        /* cas min > 59 */
        {"08h68", "08h45", "08h35"},
        /* cas min < 0 et 3 caractères */
        {"08h-30", "10h35", "08h45"},
        /* cas heure < 0 et 2 caractères */
        {"08h30", "10h35", "08h-5"}
        };     


    /** tableau de chaines valides */
    private static final String[][] VALIDES =
        {
        /* desserte_ABuanton */
        {"07h10", "07h25", "07h40", "07h55", "08h10", "08h25", "08h40", 
         "08h55", "09h10", "09h25", "09h40", "09h55", "10h10", "10h25",
         "10h40", "10h55", "11h10", "11h25", "11h40", "11h55", "12h10",
         "12h25", "12h40", "12h55", "13h10", "13h25", "13h40", "13h55",
         "14h10", "14h25", "14h40", "14h55"
        },
        /* desserte_CVallon */
        {"07h29", "08h03", "08h43", "09h23", "10h03", "10h43", "11h23",
         "12h03", "12h43", "13h23", "14h03", "14h43", "15h23", "16h04",
         "16h44", "17h24", "18h03", "18h43", "19h23"
        },
        /* desserte_CCentre */
        {"07h14", "08h03", "08h35", "09h15", "09h55", "10h35", "11h15",
         "11h55", "12h35", "13h15", "13h55", "14h35", "15h15", "15h55",
         "16h35", "17h15", "17h55", "18h35", "19h15"
        },

        /* desserte_DMarechal */
        {"07h51", "08h21", "09h01", "09h41", "10h21", "11h01", "11h41",
         "12h21", "13h01", "14h21", "15h01", "15h41", "16h21", "17h01",
         "17h41", "18h21", "19h01", "19h41"
        },
        /* desserte_FMarechal */
        {"06h03", "07h58", "10h13", "12h18", "14h28", "17h43", "19h03"}
        }; 

        /* Pour les methodes qui demande un numéro de colonne en argument  */
        private static final int COLONNE_EXEMPLE = 2;
        /* Exemple borne pour la methode de test */
        private final static int BORNE_INF_EXEMPLE = 2;
        private final static int BORNE_SUP_EXEMPLE = 10;
    
    
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

    /* On cree une grille pleine l'important n'est pas son contenu 
     * mais elle permet de voir ce que fait la methode tableauDessertePlein
     * s'il rencontre le cas d'une grille pleine
     */ 

        public static int[][] preparerGrillePleine() {
        int[][] grille = new int[50][10];
        
    /* on initialise toutes les cases avec la valeur non significative -1 */
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = -1;                
            }
        }
        
        // on recopie chacun des tableaux d'horaires
        recopierUneDesserte(grille, 0, DESSERTE0);
        recopierUneDesserte(grille, 1, DESSERTE4);
        recopierUneDesserte(grille, 2, DESSERTE0);
        recopierUneDesserte(grille, 3, DESSERTE0);
        recopierUneDesserte(grille, 4, DESSERTE0);
        recopierUneDesserte(grille, 5, DESSERTE0);
        recopierUneDesserte(grille, 6, DESSERTE0);
        recopierUneDesserte(grille, 7, DESSERTE0);
        recopierUneDesserte(grille, 8, DESSERTE0);
        recopierUneDesserte(grille, 9, DESSERTE0);
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
            /* on affiche les dessertes une par une */
            GestionGrilleHoraire.afficherHoraireDesserte(HORAIRE_EXEMPLE, i);
            continuer(); // le programmeur doit appuyer sur entrer pour continuer le test 
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
        final int[][] HORAIRE_TEST = preparerGrilleExemple();
        final int[][] TABLEAU_PLEIN = preparerGrillePleine();

        
        System.out.println ("TEST : méthode afficherGrille (test visuel)\n "                
                + "---------------------------------------------------\n");           
        GestionGrilleHoraire.afficherGrille(HORAIRE_TEST);
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
        final int[][] TABLEAU_PLEIN = preparerGrillePleine();
        
        
        System.out.println ("TEST : méthode tableauHorairesDessertePlein (test visuel)\n "                
                + "---------------------------------------------------\n");           

        GestionGrilleHoraire.afficherGrille(HORAIRE_EXEMPLE); 

        if (GestionGrilleHoraire.tableauHorairesDessertePlein(HORAIRE_EXEMPLE)) {
            System.out.print("\n La grille est pleine  \n");
        } else {
            System.out.print("\n La grille n'est pas pleine \n");
        }
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
        final int[] AJOUT_EXEMPLE = HORAIRE_A_TESTER;
        
        System.out.println ("TEST : méthode ajouterHoraire (test visuel)\n "                
                + "---------------------------------------------------\n"
                + "\n Grille avant ajout : ");  
        GestionGrilleHoraire.afficherGrille(HORAIRE_EXEMPLE);  
           
        GestionGrilleHoraire.ajouterHoraire(HORAIRE_EXEMPLE,AJOUT_EXEMPLE);

        System.out.print("\n Grille apres ajout : \n");
        GestionGrilleHoraire.afficherGrille(HORAIRE_EXEMPLE); 
    }


    /**
     * Renvoie un booleen pour savoir si la desserte a bien pu être supprimée ou non 
     */
    private static final void testSupprimerHoraire() {
       
        /*
         *  Supprime une desserte de la colonne indiqué et renvoie un booleen en fonction 
         *  de si l'action a pu être réalisé ou pas 
         */
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();

        
        System.out.println ("TEST : méthode supprimerHoraire (test visuel)\n "                
                + "---------------------------------------------------\n"
                + " Grille avant suppression :  \n"); 
        // On affiche une première fois la grille 
        GestionGrilleHoraire.afficherGrille(HORAIRE_EXEMPLE);   

        GestionGrilleHoraire.supprimerHoraire(HORAIRE_EXEMPLE, COLONNE_EXEMPLE );

        /* 
         * On affiche la grille apres suppression pour constater si elle 
         * a bien ete effectuee 
         */

        System.out.println(" \n Grille apres suppression : \n ");
        GestionGrilleHoraire.afficherGrille(HORAIRE_EXEMPLE);  
    }



    /**
     * Test de recherche horaires postérieures dans les colonnes d'une grille
     */
    private static final void testRechercheProchainPassage() {        
        
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();

        System.out.println ("TEST : méthode rechercheProchainPassage (test visuel)\n "                
                + "---------------------------------------------------\n"); 

        for (int i = 0; i < HORAIRE_A_TESTER.length; i++) {            
            System.out.println("Indice du prochain horaire après " 
                               + HORAIRE_A_TESTER[i] 
                               + " de la desserte située en colonne " + i + " est : ");
            System.out.println(GestionGrilleHoraire.rechercherProchainPassage(HORAIRE_EXEMPLE, i, HORAIRE_A_TESTER[i]));
            continuer();
        }     
    }



    /**
     * Test de recherche horaires compris dans les colonnes et les bornes d'une grille
     */
    private static final void testRechercheHoraire() {        
        
        final int[][] HORAIRE_EXEMPLE = preparerGrilleExemple();

        System.out.println ("TEST : méthode rechercheHoraire (test visuel)\n "                
                + "---------------------------------------------------\n"); 

        int borneInf = BORNE_INF_EXEMPLE,
            borneSup = BORNE_SUP_EXEMPLE;

        for (int i = 0; i < HORAIRE_A_TESTER.length; i++) {            
            System.out.println("Horaires comprises dans [" 
                               + borneInf
                               + ";" + borneSup + "[ de la colonne " + i + " est : ");
            
            GestionGrilleHoraire.afficherTableauConverti(GestionGrilleHoraire.rechercherHoraire(HORAIRE_EXEMPLE, i, borneInf, borneSup));
            continuer();
        }     
    }



    /**
     * Test d'horaire valides dans un tableau de String
     */
    private static final void testTableauHoraireCorrecte() {        

        System.out.println ("TEST : méthode tableauHoraireCorrecte(test visuel)\n "                
                + "---------------------------------------------------\n"); 


        System.out.println ("TEST : chaines invalides(test visuel)\n"); 
        /* balaye la tableau INVALIDES */
        for (int i = 0; i < INVALIDES.length ; i++) {      
            
            /* affichage de la ligne du tableau INVALIDES */
            for(int j=0; j < INVALIDES[i].length; j++) {  
                System.out.print(INVALIDES[i][j] + " ");
            } 
            System.out.println();

            /* lorsqu'une horaire est valide */
            if (GestionGrilleHoraire.tableauHoraireCorrect(INVALIDES[i])) {
                System.out.println("Erreur ! La ligne a été considérée comme valide");
            } else {
                System.out.println("Test réussi");
            }
            continuer();
        }  

        System.out.println ("TEST : chaines valides(test visuel)\n"); 
        /* balaye la tableau VALIDES */
        for (int i = 0; i < VALIDES.length ; i++) {      
        
            /* affichage de la ligne du tableau VALIDES */
            for(int j=0; j < VALIDES[i].length; j++) {  
                System.out.print(VALIDES[i][j] + " ");
            } 
            System.out.println();

            /* lorsqu'une horaire est invalide */
            if (!GestionGrilleHoraire.tableauHoraireCorrect(VALIDES[i])) {
                System.out.println("Erreur ! La ligne a été considérée comme invalide");
            } else {
                System.out.println("Test réussi");
            }
            continuer();
        }  
    }


    /**
     * Test de conversion d'un tableau d'horaire cchcc vers entier
     */
    private static final void testConvertirTableauHoraire() {        

        System.out.println ("TEST : méthode convertirTableauHoraire(test visuel)\n "                
                + "---------------------------------------------------\n"); 


        /* balaye la tableau VALIDES */
        for (int i = 0; i < VALIDES.length ; i++) {      
            
            /* affichage de la ligne du tableau VALIDES */
            for(int j=0; j < VALIDES[i].length; j++) {  
                System.out.print(VALIDES[i][j] + " ");
            } 
            System.out.println();

            /* affiche la conversion */
            for(int j=0; j < VALIDES[i].length; j++) {  
                System.out.print(GestionGrilleHoraire.convertirTableauHoraire(VALIDES[i])[j] + " ");

                /* vérification que les horaires converties sont bien égales aux horaire int des tableaux DESSERTE|i|*/
                switch( i ) {
                    case 0 -> { if(GestionGrilleHoraire.convertirTableauHoraire(VALIDES[i])[j] != DESSERTE0[j]) {
                                    throw new IllegalArgumentException("Erreur ! " + VALIDES[i][j]
                                                                       + " != " + DESSERTE0[i]);
                                }
                              }
                            
                   case 1 -> { if(GestionGrilleHoraire.convertirTableauHoraire(VALIDES[i])[j] != DESSERTE1[j]) {
                                    throw new IllegalArgumentException("Erreur ! " + VALIDES[i][j]
                                                                   + " != " + DESSERTE1[j]);
                                }
                              }
                              
                    case 2 -> { if(GestionGrilleHoraire.convertirTableauHoraire(VALIDES[i])[j] != DESSERTE2[j]) {
                                    throw new IllegalArgumentException("Erreur ! " + VALIDES[i][j]
                                                                   + " != " + DESSERTE2[j]);
                                }
                              }

                    case 3 -> { if(GestionGrilleHoraire.convertirTableauHoraire(VALIDES[i])[j] != DESSERTE3[j]) {
                                    throw new IllegalArgumentException("Erreur ! " + VALIDES[i][j]
                                                                   + " != " + DESSERTE3[j]);
                                }
                              }

                    case 4 -> { if(GestionGrilleHoraire.convertirTableauHoraire(VALIDES[i])[j] != DESSERTE4[j]) {
                                    throw new IllegalArgumentException("Erreur ! " + VALIDES[i][j]
                                                                   + " != " + DESSERTE4[j]);
                                }
                              }
                }
            } 
            System.out.println();
            System.out.println("Test de DESSERTE" + i + " réussi");
            continuer();
        }  
    }
    
    
    /*              programme principal pour lancer les  tests             */
    /* ******************************************************************* */
   
    
    
    public static void main(String[] args) {        
        testAfficherHoraireDesserte();
        testAfficherGrille();
        testTableauHorairesDessertePlein();
        testAjouterHoraire();
        testSupprimerHoraire(); 
        testRechercheProchainPassage();
        testRechercheHoraire();
        testTableauHoraireCorrecte();
        testConvertirTableauHoraire();
    }
    

}