/*
 * Classe permettant de gérer les arrêts de bus, ainsi que les noms des lignes
 * qui desservent ces arrêts ou autrement dit gestion des dessertes.
 * GestionDesserte.java                                                 01/19
 */
package applicationhorairebus.programme;


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
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 *
 */
public class GestionDesserte {
    
    /** Nombre maximum de dessertes gérées par les méthodes */
    private static final int NB_MAX_DESSERTE = 10;

    /** exemple d'arrets valides */
    private static final String[] ARRET = {"Buanton", "Vallon", "Centre de secours",
                                                 "Marechal Joffre"};

    /** exemple de lignes valides */
    private static final String[] LIGNE = {"A", "C", "D", "F"};

   /**
    * Méthode permettant la saisie d'un arret valide
    * @return arretLu l'arret s'il est valide
    */ 
   public static String lireArret() {

        String arretLu = "";
        int compteur;

        do {
            arretLu = GestionInterface.saisirNomArret();
            compteur = 0;
            /* parcourir la chaine afin de voir si elle ne contient pas de chiffres */
            for (int i = 0; i < arretLu.length(); i++) {
                if (Character.isLetter(arretLu.charAt(i)) || arretLu.charAt(i) == ' ') {
                    compteur++;
                } 
            }
        } while (compteur != arretLu.length());

        return arretLu;
   }


   /**
    * Méthode permettant la saisie d'une ligne valide 
    * @return ligneLue la ligne si elle est valide
    */
   public static String lireLigne() {

    String ligneLue = "";

    /* saisie nom de ligne et vérifie si la ligne est une lettre majuscule */
    ligneLue = GestionInterface.saisirNomLigne(); 

    return ligneLue;
}



    /**
     * Saisie d'une desserte
     * @return  un tableau contenant 2 cases : la première avec un nom d'arrêt,
     *          la deuxième avec un identifiant de ligne de bus
     */
    public static String[] saisirDesserte() {
        String[] desserte = new String[2];

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
       
        /* on affiche les dessertes tant qu'elles ne sont pas null */
        for (int desserte = 0 ; desserte < table[0].length ; desserte++) {
            if ((table[0][desserte]) != null) {
                System.out.printf(" %25s %s \n",table[0][desserte],table[1][desserte]);
                
            } else {
                System.out.print("\n");
            }
        } 
    }


    
    
    /**
     * Affiche la desserte située sur une colonne précise de la table des dessertes
     * @param table   tableau de 2 lignes et 10 colonnes contenant les dessertes
     * @param indice  numéro de la colonne à afficher (l'affichage n'est réalisé que 
     *                si la colonne est valide et contient bien une desserte)
     */
    public static void afficherDessertePrecise(String[][] table, int indice) {
        int compteur;

        /* on s'arrête quand on trouve le numéro de la colonne à afficher */
        for (compteur = 0; 
             compteur < table[0].length && indice != compteur;
             compteur++); // corps vide

        /* quand on trouve une colonne remplie */
        if (compteur != table[0].length && table[0][compteur] != null) {
            System.out.print(table[0][compteur] + " " + table[1][compteur]);
        } else { 
            System.out.print("La desserte n'existe pas.");
        }
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

        int indiceDesserte = -1;    // indice de colonne de la desserte
        int compteur = 0;

        /* tant que la recherche n'a pas aboutie */
        do {
            /* lorsque la recherche aboutie */
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
        
        /* si desserte est valide */ 
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
        int compteur, // nombre d'itérations
            i;        // indice de parcous du tableau
        indiceAjout = -1;
        boolean estEgal = false;
        
        if (desserteValide(arret, ligne)) {

            /* vérification que la desserte entrée n'existe pas déjà */
            for (i = 0; i < table[0].length; i++) {
                if (arret.equals(table[0][i]) && ligne.equals(table[1][i])) {
                    estEgal = true;
                }
            }

            /* vérification d'une desserte nulle */
            for (compteur = 0; compteur < table[0].length && table[0][compteur] != null; compteur++); // corps vide
            
            
            /* s'il y a de la place dans le tableau et que la desserte n'existe déjà pas, on l'ajoute */
            if (compteur != table[0].length && !estEgal) {
                table[0][compteur] = arret;
                table[1][compteur] = ligne;
                indiceAjout = compteur;
            }
        }
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
        int compteur = 0;
        indiceSuppression = -1;
        
        if (desserteValide(arret, ligne)) {

            /* s'arrete si l'arret existe deja */
            for (compteur = 0; 
                 compteur < table[0].length 
                          && !(arret.equals(table[0][compteur]) 
                          && ligne.equals(table[1][compteur])); 
                compteur++); // corps vide

            /* vérifie et on supprime l'arret qui existe déjà */
            if (compteur != table[0].length) {
                table[0][compteur] = null;
                table[1][compteur] = null;
                indiceSuppression = compteur;
            }
        }
        return indiceSuppression;
    }
}