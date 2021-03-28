/*
 * Classe permettant de gérer les arrêts de bus, ainsi que les noms des lignes
 * qui desservent ces arrêts ou autrement dit gestion des dessertes.
 * GestionDesserte.java                                                 01/19
 */
package applicationhorairebus.programme;

import  applicationhorairebus.programme.OutilSaisie;

/**
 * Classe permettant de gérer les arrêts de bus, ainsi que les noms des lignes de bus
 * qui desservent ces arrêts. Un nom d'arrêt est une chaîne de caractères (non vide).
 * Une ligne de bus est repérée par une lettre majuscule.
 * Les méthodes de cette classe ne permettent pas de gérer les horaires.
 * La classe gère au plus 10 dessertes (soit 10 paires ligne/arrêt).
 * Un tableau contenant une desserte est structuré de la manière suivante :
 *     - il possède 2 lignes et 10 colonnes
 *     - sur la ligne 0, on trouve les noms des arrêts
 *     - sur la ligne 1, on trouve les identifiants des lignes de bus
 * 
 * @author INFO1
 * @version 1.0
 *
 */
public class GestionDesserte {
    
    /** Nombre maximum de dessertes gérées par les méthodes */
    private static final int NB_MAX_DESSERTE = 10;


    private static final String[] ARRET = {"Buanton", "Vallon", "Centre de secours",
                                                 "Marechal Joffre"};

    private static final String[] LIGNE = {"A", "C", "D", "F"};
    
   public static String lireArret() {

        String arretLue;
        int compteur = 0;

        do {
            arretLue = OutilSaisie.lireChaineNonVide("Entrez le nom de l'arret : ");
            for (int i = 0; i < ARRET.length; i++) {
                if (arretLue.equals(ARRET[i])) {
                    compteur++;
                } 
            }

        } while (compteur == 0);

        return arretLue;
   }


   public static String lireLigne() {

    String ligneLue = "";
    char convertir = 0;
    int compteur = 0;
    do {
        convertir = ligneLue.charAt(0);
        convertir = OutilSaisie.lireMajuscule("Entrez la lettre de la ligne : ");
        ligneLue = String.valueOf(convertir); 

        for (int i = 0; i < LIGNE.length; i++) {
            if (ligneLue.equals(LIGNE[i])) {
                compteur++;
            } 
        }
    } while (compteur == 0);

    return ligneLue;
}



    /**
     * Saisie d'une desserte
     * @return  un tableau contenant 2 cases : la première avec un nom d'arrêt,
     *          la deuxième avec un identifiant de ligne de bus
     */
    public static String[] saisirDesserte() {
        String[] desserte = new String[2];
        
        // TODO : remplacer l'appel à lireChaineNonVide par la méthode adéquate
        desserte[0] = lireArret();
        desserte[1] = lireLigne();
        return desserte;         
    }
    

    /**
     * Affiche le tableau argument. Celui-ci est supposé contenir 2 lignes
     * et 10 colonnes. Sur la première ligne, on trouve les noms des arrêts,
     * et sur la deuxième les lettres majuscules repérant des noms de ligne.
     * Une case non significative est supposée contenir la valeur null
     * Si le tableau des dessertes est vide, un message doit informer l'utilisateur
     * qu'aucune desserte n'existe
     * @param table  le tableau contenant les dessertes à afficher
     */
    public static void afficherDesserte(String[][] table) {
       
        // 
        int compteur;
        compteur = 0; // intialisation du compteur
        for (int i = 0; i < NB_MAX_DESSERTE; i++) {
            if (table[0][i] != null) {
                System.out.println(table[0][i] + " " + table[1][i]);
                compteur++;
            } 
        }
        if (compteur == 0) {
            System.out.print("Aucune desserte n est geree actuellement par "
                             + "l application");
        }
    }


    
    
    /**
     * Affiche la desserte située sur une colonne précise de la table des dessertes
     * @param table   tableau de 2 lignes et 10 colonnes contenant les dessertes
     * @param indice  numéro de la colonne à afficher (l'affichage n'est réalisé que 
     *                si la colonne est valide et contient bien une desserte)
     */
    public static void afficherDesserte(String[][] table, int indice) {
        // TODO : écrire le code
    }
    
    
    /**
     * Recherche une desserte dans la table des desesertes
     * @param table   tableau de 2 lignes et 10 colonnes contenant les dessertes
     * @param arret   nom de l'arrêt recherché
     * @param ligne   identifiant de la ligne recherchée
     * @return un entier égal à -1 si la desserte n'a pas été trouvée dans la table
     *                   ou bien au numéro de la colonne contenant la desserte
     */
    public static int rechercherDesserte(String[][] table, 
                                         String arret, String ligne) {
        int indiceDesserte = -1;        // indice de colonne de la desserte
        int compteur = 0;
        do {
            if (table[0][compteur] == arret && table[1][compteur] == ligne) {
                indiceDesserte = compteur;
            }
            compteur++;
        } while (compteur != NB_MAX_DESSERTE);

        return indiceDesserte;
        
    }
    
    
    /**
     * Détermine si une desserte est valide (indépendemment de celles qui
     * existent déjà) : le nom de l'arrêt est une chaîne non vide, l'identifiant
     * de la ligne est une lettre majuscule
     * @param arret     chaîne contenant le nom de l'arrêt (doit être non vide)
     * @param ligne     chaîne contenant l'identifiant de la ligne (doit être
     *                  une lettre majuscule)
     * @return  un booléen égal à vrai ssi la desserte argument est valide
     */
    public static boolean desserteValide(String arret, String ligne) {
        
        if (arret != null && Character.isUpperCase(ligne.charAt(0)) && ligne.length() == 1 && ligne != null) {
            return true;
        } else{
            return false;
        }
        
        

        
    }
    
    
    /**
     * Ajoute une desserte à la table si c'est possible
     * @param table   tableau de 2 lignes et 10 colonnes contenant les dessertes
     * @param arret   nom de l'arrêt de la desserte à ajouter
     * @param ligne   identifiant de la ligne de la desserte à ajouter
     * @return  un entier égal au numéro de la colonne sur laquelle l'ajout de la 
     * d                  desserte a été effectué ou bien -1 si la desserte n'a pas
     *                    pu être ajoutée
     */
    public static int ajouterDesserte(String[][] table, 
                                      String arret, String ligne) {
        int indiceAjout;        // indice de l'ajout de la desserte
        
        indiceAjout = -1;
        
        // TODO : écrire le code
        return indiceAjout;
    }
    
    
    /**
     * Supprime une desserte à la table si c'est possible
     * @param table   tableau de 2 lignes et 10 colonnes contenant les dessertes
     * @param arret   nom de l'arrêt de la desserte à supprimer
     * @param ligne   identifiant de la ligne de la desserte à supprimer
     * @return  un entier égal au numéro de la colonne sur laquelle la desserte
     *                    était située, ou bien -1  si la desserte n'a pas
     *                    pu être supprimée (car non présente)
     */
    public static int supprimerDesserte(String[][] table, 
                                      String arret, String ligne) {
        int indiceSuppression;        // indice de suppression de la desserte
        indiceSuppression = -1;
        
        // TODO compléter le code
        
        return indiceSuppression;
    }
    
   
   
}