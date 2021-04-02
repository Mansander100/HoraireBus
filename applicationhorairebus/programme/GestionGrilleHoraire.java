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
 * Cette classe contient des methodes permettant de : 
 *     - Indiquer si une colonne est significative c'est-à-dire retourne un booleen 
 *       si celle-ci contient -1 ou non 
 *     - Afficher la colonne d'une grille, les deux étant donnés en argument 
 *     - Afficher une grille, celle-ci est donnée en argument
 *     - Indiquer si une grille est pleine ou non, cette derniere 
 *       étant donné en argument
 *     - Ajouter une horaire dans une desserte, le tableau et la colonne sont 
 *       donné en argument retourne un booleen si l'action a été réalisée ou non 
 *     - Supprimer une colonne, celle si est donnée en argument et éffectue 
 *       un décalage si les colonnes suivantes sont pleines 
 *     - Rechercher un horaire postérieur à l'horaire de le colonne de la grille 
 *       tous trois donnés en argument 
 *     - Rechercher dans la colonne argument de la grille horaire argument, les
 *       horaires situés sur la colonne argument et compris entre borneInf et borneSup
 *       Le tableau contenant ces horaires est le résultat renvoyé par la méthode
 *     - Vérifier si le tableau argument contient des horaires cchcc valides
 *       Pour cela on utilise la méthode estValide de la classe OutilHoraire
 *     - Convertit un tableau argument avec des horaires cchcc sous la forme 
 *       d'un tableau d'entier.
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
     * @param grille   grille contenant les horaies en minutes
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

            /* permet d'afficher les horaires de la |colonne| et si valeur = -1 on arrête */
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
        


        for (int ligne = 0 ; ligne < grille.length ; ligne++) {
            for ( int colonne = 0 ; colonne < 10 ; colonne++ ) {
                if ( grille[ligne][colonne] > -1 ) {
                    System.out.print("  " + OutilHoraire.convertir(grille[ligne][colonne]) + "  ");
                } else {
                    System.out.print("  " + "     " + "  ");
                }
            }
            System.out.print("\n");
        }
        
    }
    
    
    
    /*    Méthodes pour ajouter ou supprimer des horaires de la grille horaire    */
    /* ************************************************************************** */

    /**
     * Indique si le taleau est plein ou pas 
     * 
     * 
     * @param grille         grille contenant les horaies en minutes
     * @return un booléen égal à vrai ssi le tableau est plein 
     */
    
    public static boolean tableauHorairesDessertePlein(int[][] grille) {
    
        int i; 
        for (i=0; i < 10 && colonneSignificative(grille,i);i++ ); // corps vide
        return i == 10;  
    
    }
    
    
    /**
     * Ajoute à la grille horaire les horaires situés dans le tableau horaire.
     * Les horaires sont ajoutés sur la première colonne significative.
     * 
     * @param grille         grille contenant les horaies en minutes
     * @param horaire        tableau contenant les horaires à ajouter en minutes
     * @return un booléen égal à vrai ssi les horaires ont pu être ajoutés
     */
    public static boolean ajouterHoraire(int [][] grille, int[] horaire) {

 

        int colonne,
            ligne; 
        // si le tableau n'est pas plein 
        if( !tableauHorairesDessertePlein( grille ) ) { 

            /* donne l'indice de la colonne */
            for ( colonne = 0,ligne = 0 ; grille[ligne][colonne] > -1; colonne++);

            /* affecte les valeurs du tableau en argument à la grille */
            for (ligne = 0; ligne < horaire.length; ligne++) {
                grille[ligne][colonne] = horaire[ligne];
            }
 
            System.out.printf("La desserte a ete ajoutee a la colonne %d \n",colonne);
            // Affiche la grille après ajout 
            return true;
        } else {
            System.out.print("La desserte n'a pas ete ajoutee le tableau est deja plein  \n");
            return false; 
        }
    }
    
    
    
    /**
     * Supprime de la grille horaire d'une colonne précise
     * (un décalage de colonne sera effectué)
     * 
     * @param grille         grille contenant les horaies en minutes
     * @param colonne        numéro de la colonne dont les horaires doivent être 
     *                       supprimés
     * @return un booléen égal à vrai ssi la supression a pu être effectuée
     */
    public static boolean supprimerHoraire(int [][] grille, int colonne) {

                
        /* Cas où la colonne suivante est vide 
         * On utilise la methode colonneSignificative 
         * Si la colonne est la dernier (9) ou si la colonne 
         * qui suit celle en argument alors inutile de faire un decalage
         */
        if (   colonne == 9 || !colonneSignificative(grille,colonne+1)) {
            for ( int ligne = 0 ; ligne < grille.length ; ligne++) {
                grille[ligne][colonne]= -1;
            } 
            System.out.printf("\nLa colonne %d a bien etre supprimee \n"
                            + "\n (la premiere colonne commence a 0)",colonne);


        } else { // Cas où un décalage est nécéssaire 
            /* permet de passer à la colonne suivante  */
            for (int n = 0; colonne + n < 9; n++) {
                /* affecte à la colonne la colonne suivante  */
                for ( int ligne = 0 ; ligne < grille.length ; ligne++) {
                    grille[ligne][colonne + n] = grille[ligne][colonne + n + 1];
                }
            }
            System.out.printf("\nLa colonne %d a bien ete supprimee et le decalage a pu "
                               +"etre realise \n (la premiere colonne commence à 0)"
                               + "\n",colonne);
            // Affiche la grille après supression 
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
     * @param horaire       horaire de la recherche
     * @return l'horaire du premier passage postérieur à l'horaire argument
     *          ou bien la valeur -1 si aucun passage postérieur
     */
    public static int rechercherProchainPassage(int [][] grille, int colonne, 
                                                int horaire) {
        int ligne;
        int passagePosterieur = -1;

        /* on parcourt chaque |colonne| à la recherche de horaireGrille > |horaire| */
        for(ligne = 0; 
            ligne < grille[ligne].length && grille[ligne][colonne] <= horaire; 
            ligne++); // corps vide

        passagePosterieur = grille[ligne][colonne];

        return passagePosterieur;
    }
    

    /**
     * Recherche dans la colonne argument de la grille horaire argument, les
     * horaires situés sur la colonne argument et compris entre borneInf et borneSup
     * Le tableau contenant ces horaires est le résultat renvoyé par la méthode
     * @param grille        grille contenant les horaies en minutes
     * @param colonne       numéro de la colonne dans laquelle rechercher
     * @param borneInf      borne inférieure du tableau
     * @param borneSup      borne supérieure du tableau
     * @return le tableau compris dans la |colonne| et les bornes
     */
    public static int[] rechercherHoraire(int[][] grille, int colonne, 
                                            int borneInf, int borneSup) {

        int tableResultat[] = new int[borneSup-borneInf];

        /* on parcourt les bornes de la |colonne| à la recherche des horaires */
        for(int i = 0, ligne = borneInf; ligne < borneSup; ligne++, i++) {
            tableResultat[i] = grille[ligne][colonne];
        }
        return tableResultat;
    }

    
    /*        Méthodes pour analyser le contenu des fichiers textes               */
    /*               contenant les horaires à intégrer à l'application            */
    /* ************************************************************************** */
   

    /**
     * Vérifie si le tableau argument contient des horaires cchcc valides
     * Pour cela on utilise la méthode estValide de la classe OutilHoraire
     * @param aVerifier       grille contenant les horaies sous forme cchcc
     * @return true si le tableau contient des horaires valides,
     *         false sinon
     */
    public static boolean tableauHoraireCorrect(String [] aVerifier) {
        boolean resultat = false;
        int i;

        /* on s'arrête lorsqu'une heure n'est pas valide */
        for(i = 0; i < aVerifier.length && OutilHoraire.estValide(aVerifier[i]); i++); // empty body

        if (i == aVerifier.length) {
            return true;
        } else { 
            System.out.println(aVerifier[i] + " n'est pas valide");
            return false;
        }
    }


    /**
     * Convertit un tableau argument avec des horaires cchcc sous la forme 
     * d'un tableau d'entier.
     * Pour cela on utilise la méthode convertir de la classe OutilHoraire
     * @param aVerifier       grille contenant les horaies sous forme cchcc
     * @return true si le tableau contient des horaires valides,
     *         false sinon
     */
    public static int[] convertirTableauHoraire(String [] aConvertir) {

        int[] tableConvertie = new int[aConvertir.length];

        if(tableauHoraireCorrect(aConvertir)) {
            for(int i = 0; i < aConvertir.length; i++) {
                tableConvertie[i] = OutilHoraire.convertir(aConvertir[i]);
            } 
        }
        return tableConvertie;
    }
}