/*
 * Classe de test des méthodes de la classe OutilHoraire
 * TestOutilHoraire.java                                               01/19
 */
package applicationhorairebus.test;

import java.util.Scanner;
import applicationhorairebus.programme.OutilHoraire;

/**
 * Classe de tests unitaires qui contient les méthodes de test 
 * des méthodes de la classe OutilHoraire.
 * 
 * Des tableaux sont définis en tant que jeu de données :
 *     CH_VALIDE  contient des horaires valides (des chaînes de caractères)
 *                ils serviront à tester le bon fonctionnement de la méthode
 *                convertir
 *     CH_INVALIDE contient des chaînes de caractères ne respectant pas 
 *                 le format d'un horaire. Pour tester la méthode convertir
 *     CONVERSION  contient des entiers égaux à des minutes. Ils correspondent
 *                 à la conversion en minutes des horaires du tableau CH_VALIDE
 *                 
 *     CHIFFRE     tableau de caractères qui 
 *                 contient la liste des caractères qui sont des chiffres
 *                 (pour tester la méthode estChiffre)
 *     NON_CHIFFRE contient des caractères qui ne sont pas des chiffres
 *     
 * La classe contient 2 méthodes générales :
 *    - l'une qui affiche un texte de synthèse indiquant le nombre de tests
 *      corrects par rapport à un nombre total de test
 *    - l'autre qui invite l'utilisateur à taper sur 'entrée' pour continuer
 *    
 * Les méthodes de test de la classe permettent de tester les méthodes suivantes 
 * de la classe OutilHoraire :
 *    - saisirEntierIntervalle
 *    - saisirHoraire
 *    - saisir2HorairesOrdonnes
 *    - estChiffre
 *    - estValide 
 *    - convertir en entier
 *    - convertir en chaîne
 *    - heureCourante
 *              
 * @author INFO1
 * @version 1.0
 */
public class TestOutilHoraire {
    
    
    /** Objet Scanner pour effectuer les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
    
    /** jeu de test avec des chaînes invalides (pour un horaire) */
    private static final String CH_INVALIDE[] = { 
                                   "test", "", "blablabla", "hhhhh", "20h20h",
                                   "123h25", "12k12", "12112", "20h9", "9h12",
                                   "24h00", "23h60", "56h20", "12h74", "1h125"};
    
    /** jeu de test avec des chaînes valides (pour un horaire) */
    private static final String[] CH_VALIDE = {"00h00", "23h59", "09h25", "08h02", 
                                               "10h07", "12h12", "11h59", "10h00", 
                                               "07h10", "15h01"};
    
    /** Conversion des chaînes précédentes en minutes */
    private static final int[] CONVERSION = {0, 1439, 565, 482, 
                                      607, 732, 719, 600, 
                                      430, 901};
    
    /** jeu de test pour la méthode estChiffre : valeurs correctes */
    private static final char[] CHIFFRE = { '0', '1', '2', '3', '4', '5', 
                                            '6', '7', '8', '9'}; 
    
    /** jeu de test pour la méthode estChiffre : valeurs incorrectes */
    private static final char[] NON_CHIFFRE = { 'l', '+', '-', '!', '*', 'P', 
                                                'c', 'C', ',', '<'}; 
    
    
    
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
    
    
    /********************      méthodes de tests unitaires    ******************/
   
    
    
    /**
     * Test de la méthode de saisie d'un entier appartenant à un intervalle
     * La méthode demandera à l'utilisateur de saisir 3 entiers.
     * L'utilisateur devra vérifier visuellement le bon comportement de la
     * méthode. Elle est supposée recommencer la saisie en cas d'erreur.  
     */   
    public static void testSaisirEntierIntervalle() {
        final int QUANTITE = 3;     // nombre de tests effectués
        int valeur;                 // valeur en minutes de l'horaire saisi
        System.out.println("\nTest de la méthode de saisie d'un entier\n"
                           + "------------------------------------------\n"
                           + "Vous allez saisir " + QUANTITE + " entiers supposés"
                           + " être dans l'intervalle 0 - 59\n"
                           + "Vous devez vérifier visuellement que la méthode "
                           + " gère correctement les cas d'erreur\n"
                           + "N'hésitez pas à commettre des erreurs de saisie.");
        
        // on recommence plusieurs fois la saisie d'un entier compris entre 0 et 59
        for (int i = 0; i < QUANTITE; i++) {
            System.out.println("\nSaisie numéro " + (i + 1) + " :");
            valeur = OutilHoraire.saisirEntierIntervalle(0, 59, 
                            "Entrez un entier compris entre 0 et 59 : ");
            System.out.println("\nVous avez saisi " + valeur);            
        }
    }
   
    
    /**
     * Test de la méthode de saisie d'un horaire.
     * La méthode demandera à l'utilisateur de saisir 3 horaires.
     * L'utilisateur devra vérifier visuellement que l'horaire saisi
     * est bien celui entré
     */
    public static void testSaisirHoraire() {
        final int QUANTITE = 3;     // nombre de tests effectués
        int valeur;                 // valeur en minutes de l'horaire saisi
        System.out.println("\nTest de la méthode de saisie d'un horaire\n"
                           + "--------------------------------------------\n"
                           + "Vous allez saisir " + QUANTITE + " horaires et vérifier "
                           + "visuellement que la méthode effectue correctement la saisie.\n"
                           + "N'hésitez pas à commettre des erreurs de saisie.");
        
        // on recommence plusieurs fois la saisie d'un horaire
        for (int i = 0; i < QUANTITE; i++) {
            System.out.println("\nSaisie numéro " + (i + 1) + " :");
            valeur = OutilHoraire.saisirHoraire();
            System.out.println("L'horaire saisi est " + valeur + " minutes");            
        }
    }
    
    
    /**
     * Test de la méthode de saisie de 2 horaires ordonnés
     * La méthode demandera à l'utilisateur de saisir 3 fois 2 horaires
     * supposés ordonnés.
     * L'utilisateur devra vérifier visuellement que la saisie des 2 horaires
     * est recommencée lorsqu'ils ne sont pas ordonnés.
     */
    public static void testSaisir2HorairesOrdonnes() {
        final int QUANTITE = 3;     // nombre de tests effectués
	    int[] saisie = new int[2];                 // valeur en minutes de l'horaire saisi
        System.out.println("\nTest de la méthode de saisie de 2 horaires ordonnées\n"
                           + "--------------------------------------------\n"
                           + "Vous allez saisir " + QUANTITE + " horaires et vérifier "
                           + "visuellement que la méthode effectue correctement la saisie.\n"
                           + "N'hésitez pas à commettre des erreurs de saisie.");
        
        // on recommence plusieurs fois la saisie d'un horaire
        for (int i = 0; i < QUANTITE; i++) {
            System.out.println("\nSaisie numéro " + (i + 1) + " :");
            saisie = OutilHoraire.saisir2HorairesOrdonnes();
            System.out.println("Horaire 1 : " + saisie[0] 
							   + "\nHoraire 2 : " + saisie[1]);            
        }
    }
    
    
    /**
     * Test de la méthode qui détermine si un caractère est un chiffre.
     * (test automatique)     
     */
    public static void testEstChiffre() {       
        int nbTestOK;                 // nombre de tests corrects
        System.out.print("\nTest de la méthode estChiffre\n"
                         + "------------------------------\n"
                         + "    ==> a) Tests avec des chiffres : ");
        
        // on vérifie que la méthode renvoie vrai pour tous chiffres
        nbTestOK = 0;
        for (int i = 0; i < CHIFFRE.length; i++) {
            if (OutilHoraire.estChiffre(CHIFFRE[i])) {
                nbTestOK++;
            } else {
                System.out.println("Erreur : la méthode a détecté que "
                                   + CHIFFRE[i] + " n'est pas un chiffre.");
            }
        }
        
        // on affiche une synthèse des tests effectués
        afficherResultatTest(CHIFFRE.length, nbTestOK);
        
        
        // vérification : renvoie faux pour les caractères différents d'un chiffre
        System.out.print("\n    ==> b) Tests autres caractères : ");
        nbTestOK = 0;
        for (int i = 0; i < NON_CHIFFRE.length; i++) {
            if (! OutilHoraire.estChiffre(NON_CHIFFRE[i])) {
                nbTestOK++;
            } else {
                System.out.println("Erreur : la méthode a détecté que "
                                   + NON_CHIFFRE[i] + " est un chiffre.");
            }
        }
        
        // on affiche une synthèse des tests effectués
        afficherResultatTest(NON_CHIFFRE.length, nbTestOK);   
    }
    
    
    
    /**
     * Test de la méthode estValide.
     * La méthode est appliquée sur des chaînes valides et d'autres invalides
     * (test automatique)
     */
    public static void testEstValide() {       
        int testCorrect;        // nombre de tests corrects        
        System.out.println("\nTest de la méthode de estValide\n"
                           + "--------------------------------\n");
        // tests avec des chaînes valides
        testCorrect = 0;
        for (int i = 0; i < CH_VALIDE.length; i++) {
            if (OutilHoraire.estValide(CH_VALIDE[i])) {
                testCorrect++;
            } else {
                System.out.println("Résultat inattendu : " + CH_VALIDE[i]
                                   + " a été considérée comme invalide.");
            }
        }
        
        // résultat du test avec des chaînes valides
        System.out.print("Test avec des chaînes valides : ");
        afficherResultatTest(CH_VALIDE.length, testCorrect);           
        
        // tests avec des chaînes invalides        
        testCorrect = 0;
        for (int i = 0; i < CH_INVALIDE.length; i++) {
            if (! OutilHoraire.estValide(CH_INVALIDE[i])) {
                testCorrect++;
            } else {
                System.out.println("Résultat inattendu : " + CH_INVALIDE[i]
                                   + " a été considérée comme valide.");
            }
        }
        
        // résultat du test avec des chaînes invalides
        System.out.print("Test avec des chaînes invalides : ");
        afficherResultatTest(CH_INVALIDE.length, testCorrect);        
    }
    
    
    /**
     * Test de la méthode qui convertit un horaire exprimé en minutes en un horaire 
     * chaîne de caractères dans le format cchcc (c est un chiffre) 
     * (test automatique)
     */
    public static void testConvertirEnChaine() {
        int testCorrect;        // nombre de tests corrects     
        System.out.println("\nTest de la méthode convertir (entier en chaîne)\n"
                           + "-------------------------------------------------\n");
        
        // on convertit les horaires du tableau CONVERSION (des entiers)        
        testCorrect = 0;
        for (int i = 0; i < CONVERSION.length; i++) {
            if (OutilHoraire.convertir(CONVERSION[i]).equals(CH_VALIDE[i])) {
                testCorrect++;
            } else {
                System.out.println("Résultat inattendu : " + CONVERSION[i]
                                   + " a été converti en " 
                                   + OutilHoraire.convertir(CONVERSION[i]) 
                                   + " au lieu de " + CH_VALIDE[i]);
            }
        }
        
        // on affiche le résultat du test
        System.out.print("Résultat global du test : ");
        afficherResultatTest(CONVERSION.length, testCorrect);              
    }
    
    
    /**
     * Test de la méthode qui convertit une chaîne contenant un horaire en un entier
     * égal à la conversion en minutes de cet horaire
     * (test automatique)
     */
    public static void testConvertirEnEntier() {
        int testCorrect;        // nombre de tests corrects     
        System.out.println("\nTest de la méthode convertir (chaîne en entier)\n"
                           + "-------------------------------------------------\n");
        
        // on convertit les horaires du tableau CH_VALIDE (des chaînes de caractères)
        testCorrect = 0;
        for (int i = 0; i < CH_VALIDE.length; i++) {
            if (OutilHoraire.convertir(CH_VALIDE[i]) == CONVERSION[i]) {
                testCorrect++;
            } else {
                System.out.println("Résultat inattendu : " + CH_VALIDE[i]
                                   + " a été converti en " 
                                   + OutilHoraire.convertir(CH_VALIDE[i]) 
                                   + " au lieu de " + CONVERSION[i]);
            }
        }
        
        // on affiche le résultat du test        
        System.out.print("Résultat global du test : ");
        afficherResultatTest(CH_VALIDE.length, testCorrect);                       
    }
    
    
    /**
     * Test de la méthode qui récupère l'heure courante
     * L'utilisateur doit vérifier visuellement que l'heure obtenue est correcte
     */
    public static void testHeureCourante() {
        System.out.println("\nTest de la méthode heureCourante (chaîne en entier)\n"
                + "-------------------------------------------------\n"
                + "Vous devez vérifier visuellement que l'heure affichée est bien "
                + "l'heure courante de l'ordinateur.\n");
        System.out.println("Heure courante en minutes : "
                           + OutilHoraire.heureCourante() + "\n"
                           + "Heure courante : " 
                           + OutilHoraire.convertir(OutilHoraire.heureCourante()));
    }
    
    
    
    /**
     * Programme principal qui lance les méthodes de test
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------\n"
                           + "     TESTS DE LA CLASSE  OUTIL HORAIRE \n"
                           + "-----------------------------------------------\n");
        //testSaisirEntierIntervalle();

        //testSaisirHoraire();

        //testSaisir2HorairesOrdonnes();

        //testEstChiffre();
        //continuer();

        //testEstValide(); 
        //continuer();

        //testConvertirEnChaine(); 
        //continuer();

        //testConvertirEnEntier();  
        //continuer();

        //testHeureCourante();
    }

}
