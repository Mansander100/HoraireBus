/*
 * Classe avec des méthodes outils pour effectuer des saisies
 * OutilSaisie.java                                 01/21
 */
package coo.applicationhorairebus.programme;

import java.util.Scanner;

/**
 * Cette classe contient des méthodes outils pour effectuer des saisies :
 *      - saisie d'une chaîne de caractères non vide
 *      - saisie d'une lettre majuscule
 * @author INFO1
 * @version 1.0
 *
 */
public class OutilSaisie {
    
    /** Objet Scanner pour effectuer des saisies */
    private static Scanner entree = new Scanner(System.in);
    
    
    /**
     * Effectue la saisie d'une chaîne de caractères non vide.
     * La saisie est recommencée en cas d'erreur
     * @param message   message affiché pour inviter l'utilisateur à entrer
     *                  la chaîne
     * @return  la chaîne non vide entrée par l'utilisateur
     */
    public static String lireChaineNonVide(String message) {
        String chaineLue;
        do {
            System.out.print(message);
            chaineLue = entree.nextLine();
            if (chaineLue.length() == 0) {
                System.out.println("Erreur. Le texte entré ne doit pas être vide\n");
            }
        } while (chaineLue.length() == 0);
        return chaineLue;
    }
   
    
    /**
     * Effectue la saisie d'une lettre majuscule.
     * La saisie est recommencée en cas d'erreur
     * @param message   message affiché pour inviter l'utilisateur à entrer
     *                  la lettre majuscule
     * @return  la lettre majuscule entrée par l'utilisateur
     */
    public static char lireMajuscule(String message) {
        String chaineLue;
        do {
            System.out.print(message);
            chaineLue = entree.nextLine();
            if (chaineLue.length() != 1 || ! Character.isUpperCase(chaineLue.charAt(0)) ) {
                System.out.println("Erreur. Il faut donner une lettre majuscule.\n");
            }
        } while (chaineLue.length() != 1 || ! Character.isUpperCase(chaineLue.charAt(0)));
        return chaineLue.charAt(0);
    }
     
}
