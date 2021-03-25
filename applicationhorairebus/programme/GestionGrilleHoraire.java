/*
 * Classe permettant de gérer la grille des horaires de bus
 * GestionGrilleHoraire.java                                                 02/21
 */
package applicationhorairebus.programme;
import applicationhorairebus.programme.OutilHoraire;

/**
 * Classe permettant de gérer la grille des horaires de bus. Les horaires de passage
 * des bus sont stockés en minutes. 
 * La grille des horaires est un tableau à 2 dimensions comportant 10 colonnes et 50
 * lignes :
 *   - 10 colonnes car il y aura au plus 10 déssertes dans l'application. Sur la colonne
 *      i, on trouve les horaires de passage des bus de la desserte i (celle stockée en
 *      colonne i du tableau des dessertes)
 *   - 50 lignes car pour une desserte donnée, il y a au plus 50 passages de bus
 * Les cases non significatives de la grille seront égales à -1.
 * 
 * 
 * @author INFO1
 * @version 1.0
 *
 */
public class GestionGrilleHoraire {
    
    
    
    /*       Méthodes destinées à réaliser des affichages de la grille horaire    */
    /*           (affichages utiles pour tester les autres méthodes)              */
    /* ************************************************************************** */
    
    
    /**
     * Détermine si une colonne est significative dans la grille horaire
     * La colonne doit exister et la valeur de sa première ligne doit être
     * différente de -1
     * @param horaire   grille contenant les horaies en minutes
     * @param colonne   colonne à tester
     * @return  un booléen égal à vrai ssi la colonne est significative
     */
    public static boolean colonneSignificative(int[][] grille, int colonne) {
        return colonne >= 0 && colonne < grille[0].length 
               && grille[0][colonne] != -1;
    }
    
    
    /**
     * Affiche les horaires située sur une colonne précise de la grille horaire.
     * Les horaires sont affichés dans le format cchcc (par exemple 10h15)
     * (ne doit pas afficher la valeur non significative -1)
     * @param horaire     grille contenant les horaies en minutes
     * @param colonne     colonne à consulter
     */
    public static void afficherHoraireDesserte(int[][] horaire, int colonne) {
        if (colonneSignificative(horaire, colonne)) {
            
            /*
             *  on affiche les horaires de la colonne argument
             *  Les horaires doivent être affichés dans le format cchcc
             */
            // TODO : écrire la boucle

            for(int indice = 0  ; indice < horaire.length && horaire[indice][colonne] > -1 ; indice++) {
                System.out.printf("Horaire ligne %d :  %s \n",indice, OutilHoraire.convertir(horaire[indice][colonne]) );

            }
        }
    }
    
    
    /**
     * Affiche la grille horaire argument. Seules les valeurs significatives
     * seront affichées (donc celles différentes de -1).
     * Les horaires seront affichés dans le format cchcc
     * Cette méthode sera utile en phase de test de l'application
     * Elle vous permettra de tester plus facilement l'ajout d'une liste
     * d'horaires ou la suppression d'une telle liste
     * @param horaire   tableau des horaires à afficher
     */
    public static void afficherGrille(int[][] grille) {
        // TODO : écrire le code
    }
    
    
    
    /*    Méthodes pour ajouter ou supprimer des horaires de la grille horaire    */
    /* ************************************************************************** */
    
  
    
    /**
     * Ajoute à la grille horaire les horaires situés dans le tableau horaire.
     * Les horaires sont ajoutés sur la première colonne significative.
     * TODO : compléter
     * @param grille         grille contenant les horaies en minutes
     * @param horaire        tableau contenant les horaires à ajouter en minutes
     * @return un booléen égal à vrai ssi les horaires ont pu être ajoutés
     */
    public static boolean ajouterHoraire(int [][] grille, int[] horaire) {
        return false;
    }
    
    
    
    /**
     * Supprime de la grille horaire d'une colonne précise
     * (un décalage de colonne sera effectué)
     * TODO : compléter
     * @param grille         grille contenant les horaies en minutes
     * @param colonne        numéro de la colonne dont les horaires doivent être 
     *                       supprimés
     * @return un booléen égal à vrai ssi la supression a pu être effectuée
     */
    public static boolean supprimerHoraire(int [][] grille, int colonne) {
        return false;
    }
    
    
    
    
    /*          Méthodes pour effectuer des recherches dans la grille horaire     */
    /* ************************************************************************** */
   
    
    
    /**
     * Recherche dans la colonne argument de la grille horaire argument, le premier
     * passage de bus dont l'horaire est strictement postérieur à l'horaire argument.
     * L'horaire de ce passage est le résultat renvoyé par la méthode
     * @param grille      grille contenant les horaies en minutes
     * @param colonne     numéro de la colonne dans laquelle rechercher
     * @param horaire     horaie de la recherche
     * @return  l'horaire du premier passage postérieur à l'horaire argument
     *          ou bien la valeur -1 si aucun passage postérieur
     */
    public static int rechercherProchainPassage(int [][] grille, int colonne, 
                                                int horaire) {
        return 0;
    }
    
    //TODO : compléter
    
    
    
    
    /*        Méthodes pour analyser le contenu des fichiers textes               */
    /*               contenant les horaires à intégrer à l'application            */
    /* ************************************************************************** */
   
    
    // TODO
    
    
    

}