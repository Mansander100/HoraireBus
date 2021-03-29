/*
 * Classe permettant de gérer la grille des horaires de bus
 * GestionGrilleHoraire.java                                               25 mars 2021
 */
package applicationhorairebus.programme;

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
 * @author Serieys, Simon
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

            /* boucle permettant afficher les horaires de la |colonne| et si valeur = -1 on arrête */
            for(int ligne = 0; ligne < horaire.length && horaire[ligne][colonne] > -1; ligne++) {
                System.out.printf("Horaire ligne %d :  %s \n",
                                  ligne, OutilHoraire.convertir(horaire[ligne][colonne]));
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
     * @param grille   tableau des horaires à afficher
     */
    public static void afficherGrille(int[][] grille) {

        /*
        *  on affiche les horaires de la colonne argument
        *  Les horaires doivent être affichés dans le format cchcc
        */
        

        /* boucle permettant d'afficher les horaires de la |grille| */
        for(int ligne = 0; ligne < grille.length; ligne++) { // parcourir les lignes
            /* parcourir les colonnes et si une valeur = -1 on arrête et passe à la ligne suivante */
            for(int colonne = 0; colonne < 10 && grille[ligne][colonne] > -1; colonne++ ) { 
                /* affiche les valeurs par ligne */
                System.out.print(OutilHoraire.convertir(grille[ligne][colonne]) + "\t");
            }
            System.out.print("\n");
        }
    }
    
    
    
    /*    Méthodes pour ajouter ou supprimer des horaires de la grille horaire    */
    /* ************************************************************************** */

    /**
     * Ajoute à la grille horaire les horaires situés dans le tableau horaire.
     * Les horaires sont ajoutés sur la première colonne significative.
     * TODO : compléter
     * @param grille         grille contenant les horaies en minutes
     * @return un booléen égal à vrai ssi le tableau est plein 
     */
    
    public static boolean tableauHorairesDessertePlein(int[][] grille) {
    
     // TODO Afficher la grille pour que l'on voit si elle est pleine ou pas visuellement 
        afficherGrille(grille);
        int colonne = 0;
        int ligne = 0;

        /* boucle permettant d'afficher les horaires de la |grille| */
        for( ligne = 0; ligne < grille.length && grille[ligne][colonne] > -1 ; ligne++) { // parcourir les lignes
    
            /* parcourir les colonnes et si une valeur = -1 on arrête et passe à la ligne suivante */
            for(  colonne = 0; colonne < 10 && grille[ligne][colonne] > -1; colonne++ ) ;
            
        }
        if ( ligne < grille.length || colonne < 10) {

            System.out.println("\n La grille n'est pas remplie !");
            return false;
        } else {

            System.out.println("\n La grille est remplie... ");
            return true;
        }       
    
    }
    
    
    /**
     * Ajoute à la grille horaire les horaires situés dans le tableau horaire.
     * Les horaires sont ajoutés sur la première colonne significative.
     * TODO : compléter
     * @param grille         grille contenant les horaies en minutes
     * @param horaire        tableau contenant les horaires à ajouter en minutes
     * @return un booléen égal à vrai ssi les horaires ont pu être ajoutés
     */
    public static boolean ajouterHoraire(int [][] grille, int[] horaire) {

// TODO afficher ancienne grille 

        int colonne,
            ligne; 
        if( !tableauHorairesDessertePlein( grille ) ) { 

            /* Cette boucle donne l'indice de la colonne */
            for ( colonne = 0,ligne = 0 ; grille[ligne][colonne] > -1; colonne++);

            /* Cette boucle affecte les valeurs du tableau en argument à la grille */
            for (ligne = 0; ligne < horaire.length; ligne++) {
                grille[ligne][colonne] = horaire[ligne];
            }
            // TODO afficher nouvelle grille 
            System.out.printf("La desserte a ete ajoutee a la colonne %d \n",colonne);
            afficherGrille(grille);
            return true;
        } else {
            System.out.print("La desserte n'a pas ete ajoutee \n");
            return false; 
        }
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
        afficherGrille(grille); 
        int ligne = 0;
        /* Cas où la colonne suivante est vide  */
        if ( grille[ligne][colonne +1 ] <= -1 || colonne == 9) {
            for (ligne = 0 ; ligne < grille.length ; ligne++) {
                grille[ligne][colonne]= -1;
            } 
            System.out.print("La colonne a bien été supprimée \n");
            afficherGrille(grille);

        } else { // Cas où un décalage est nécéssaire 
            /* Boucle qui indique si les colonne suivantes sont vide ou pas  */
            for (int n = 0; colonne + n < 9; n++) {
                /*  */
                for (ligne = 0 ; ligne < grille.length ; ligne++) {
                    grille[ligne][colonne + n] = grille[ligne][colonne + n + 1];
                }
            }
            System.out.print("La colonne a bien été supprimée \n");
            afficherGrille(grille);
        }
        return true;
    }
    
    
    
    
    /*          Méthodes pour effectuer des recherches dans la grille horaire     */
    /* ************************************************************************** */
   
    
    
    /**
     * Recherche dans la colonne argument de la grille horaire argument, le premier
     * passage de bus dont l'horaire est strictement postérieur à l'horaire argument.
     * L'horaire de ce passage est le résultat renvoyé par la méthode
     * @param grille        grille contenant les horaies en minutes
     * @param colonne       numéro de la colonne dans laquelle rechercher
     * @param horaire       horaie de la recherche
     * @return l'horaire du premier passage postérieur à l'horaire argument
     *          ou bien la valeur -1 si aucun passage postérieur
     */
    public static int rechercherProchainPassage(int [][] grille, int colonne, 
                                                int horaire) {
        int ligne;
        int v = -1;
        /* on parcourt chaque |colonne| à la recherche de horaireGrille > |horaire| */
        for(ligne = 0; ligne < grille.length && grille[ligne][colonne] < horaire; ligne++) {
        // TODO à finir, problème de détection passage de bus supérieur à l'horaire argument
        
            if (ligne == grille.length) {
                v = -1;
            } else {
                v = grille[ligne+1][colonne];
            }
        }    
        return v;
    }
    
    //TODO : compléter
    
    
    
    
    /*        Méthodes pour analyser le contenu des fichiers textes               */
    /*               contenant les horaires à intégrer à l'application            */
    /* ************************************************************************** */
   
    
    // TODO
    
    
    

}