/*
 * Classe contenant des méthodes outils pour gérer l'interface utilisateur
 * GestionInterface.java                                            01/21
 */
package applicationhorairebus.programme;

import java.util.Scanner;

/**
 * Cette classe contient différentes méthodes outils correspondant à l'interface
 * utilisateur de l'application "gestion des horaires de bus".
 *    - affichage et saisie de l'option pour le menu principal
 *    - affichage et saisie de l'option pour le menu voyageur
 *    - affichage et saisie de l'option pour le menu administrateur
 *    - saisie du mot de passe
 *    - saisie du nom d'un arrêt
 *    - saisie d'une ligne de bus
 *    
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 *
 */
public class GestionInterface {
    
    /** Objet Scanner pour les saisies au clavier */
    private static Scanner entree = new Scanner(System.in);
 
    
    /** Nombre maximum de caractères pour le nom d'un arrêt */
    private static final int LG_MAX_ARRET = 25;
        
    
    /* **************************************************************************** */
    /* ***       Textes utilisés pour le menu principal et options de celui-ci   ** */
    /* **************************************************************************** */
    
    /**
     * Texte de titre pour le menu principal
     */
    private static final String TITRE_MENU_PRINCIPAL = 
            "------------------------------------------------------------------\n"
            + "|                      MENU PRINCIPAL                            |\n"
            + "------------------------------------------------------------------\n";
    
    /**
     * Liste des options possibles pour le menu principal
     */
    private static final char[] OPTION_MENU_PRINCIPAL = { 'v', 'a', '?', 'c', 'q'};   
    
    /**
     * Liste des libellés associés à chacune des options du menu principal
     */
    private static final String[] LIBELLE_MENU_PRINCIPAL = {
                "Afficher menu voyageur",
                "Afficher menu administrateur",
                "Obtenir de l'aide sur l'application",
                "Credits",
                "Quitter l'application"};
    
    /** Texte affiché pour l'aide en ligne */
    public static final String TEXTE_AIDE_MENU_PRINCIPAL = 
        "---------------------------------------------------------------------------\n"
        + "|                             AIDE EN LIGNE                               |\n"
        + "---------------------------------------------------------------------------\n\n"
        + " Bienvenue sur l'aide en ligne du menu principal. Voici les fonctionnalites\n"
        + "   -> Acceder aux fonctionnalites du mode voyageur                         \n\n"
        + "   -> Acceder aux fonctionnalites du mode administrateur                   \n\n"
        + "   -> Afficher l'aide en ligne (vous y etes deja)                          \n\n"
        + "   -> Afficher les credits                                                 \n\n"
        + "   -> Quitter le programme                                                 \n\n";


        
    /** Texte affiché pour les crédits */
    public static final String TEXTE_CREDITS = 
    "---------------------------------------------------------------------------\n"
    + "|                             CREDITS                                     |\n"
    + "---------------------------------------------------------------------------\n\n"
    + " Application realisee par Lucas Serieys, Mehdi Sahari, Valentin Simon et   \n\n"
    + " Clement Pauline dans le cadre de notre apprentissage en 1ere annee        \n\n"
    + " d'informatique a l'IUT de Rodez.                                          \n\n"
    + "                                                                           \n\n"
    + " Sous la tutelle de Mme Servieres, afin d'apprendre la programmation OO    \n\n"
    + " INFO1 2020-2021 IUT Rodez.                                                 \n\n";


    /**
     * Affiche les credits de l'application
     */
    public static void afficherCredits() {
        System.out.println(TEXTE_CREDITS);
    }
    
    
    /* **************************************************************************** */
    /* ************           gestion du menu principal             *************** */
    /* ***************************************************************************  */
    
    /**
     * Affiche le menu principal de l'application
     */
    public static void afficherMenuPrincipal() {
        System.out.println(TITRE_MENU_PRINCIPAL);
        
        // on affiche toutes les options et les libellés
        for(int i = 0; i < OPTION_MENU_PRINCIPAL.length; i++) {
            System.out.print("   => " + OPTION_MENU_PRINCIPAL[i] 
                             + " - " + LIBELLE_MENU_PRINCIPAL[i] + "\n");
        }
        System.out.print("\n       ====> ");
    }
       
    
    /**
     * Affiche le menu principal pour l'utilisateur et saisit son choix.
     * L'action est répétée jusqu'à obtenir un choix valide
     * @return un caractère contenant le choix de l'utilisateur
     */
    public static char saisirOptionMenuPrincipal() {
        String reponse;       // utilisé pour la lecture de la réponse de l'utilisateur
        
        // affiche le menu et saisit le choix, répété jusqu'à obtenir un choix valide
        do {            
            afficherMenuPrincipal();
            reponse = entree.nextLine();
            if (! reponseValide(reponse, OPTION_MENU_PRINCIPAL)) {
                System.out.println("\n       ==> Ce choix n'est pas valide."
                                   + " Recommencez.\n\n");
            }
        } while (! reponseValide(reponse, OPTION_MENU_PRINCIPAL));     
        System.out.println();
        return reponse.charAt(0);
    }

    /**
     * Affiche le menu principal pour l'utilisateur et saisit son choix.
     * L'action est répétée jusqu'à obtenir un choix valide
     * @return un caractère contenant le choix de l'utilisateur
     */
    public static char saisirOptionAidePrincipal() {
        String reponse;       // utilisé pour la lecture de la réponse de l'utilisateur
        
        // affiche le menu et saisit le choix, répété jusqu'à obtenir un choix valide
        do {            
            afficherMenuPrincipal();
            reponse = entree.nextLine();
            if (! reponseValide(reponse, OPTION_MENU_PRINCIPAL)) {
                System.out.println("\n       ==> Ce choix n'est pas valide."
                                   + " Recommencez.\n\n");
            }
        } while (! reponseValide(reponse, OPTION_MENU_PRINCIPAL));     
        System.out.println();
        return reponse.charAt(0);
    }
    
    
    /**
     * Affiche l'aide en ligne 
     */
    public static void afficherAidePrincipal() {
        System.out.println(TEXTE_AIDE_MENU_PRINCIPAL);
    }



    /* **************************************************************************** */
    /* ***    Textes utilisés pour le menu voyageur et options de celui-ci       ** */
    /* **************************************************************************** */
   
    /**
     * Texte de titre pour le menu voyageur
     */
    private static final String TITRE_MENU_VOYAGEUR = 
            "------------------------------------------------------------------\n"
            + "|                      MENU VOYAGEUR                             |\n"
            + "------------------------------------------------------------------\n";
    
    /**
     * Liste des options possibles pour le menu voyageur
     */
    private static final char[] OPTION_MENU_VOYAGEUR = { 'c', 'a', 'm', 'i', '?', 'r'};   
    
    /**
     * Liste des libellés associés à chacune des options du menu voyageur
     */
    private static final String[] LIBELLE_MENU_VOYAGEUR = {
            "Consulter toutes les dessertes possibles",
            "Afficher les bus accessibles 30min apres une horaire donnee",
            "Bus accessibles dans la demi-heure",
            "Afficher les bus accessibles selon un intervalle donne",
            "Consultation de l'aide",
            "Retour en arriere"};
    
    /** Texte affiché pour l'aide en ligne */
    public static final String TEXTE_AIDE_MENU_VOYAGEUR = 
            "--------------------------------------------------------------------------\n"
            + "|                             AIDE EN LIGNE                              |\n"
            + "--------------------------------------------------------------------------\n\n"
            + " Bienvenue sur l'aide en ligne du menu voyageur. Voici les fonctionnalites\n"
            + "   -> Consulter toutes les dessertes possibles                            \n\n"
            + "   -> Rechercher des horaires de passage des bus (3 manieres) :           \n\n"
            + "         Saisir un horaire, et l'application affichera tous les bus       \n"
            + "         accessibles dans les 30 minutes qui suivent cet horaire.         \n\n"
            + "         Ne saisir aucun horaire, et la recherche                         \n"
            + "         precedente s'effectuera a partir de l'heure courante.            \n\n"
            + "         Saisir un intervalle de deux horaires, et l'application          \n"
            + "         affichera tous les bus accessibles et dont l'horaire de passage  \n"
            + "         est inclus dans l'intervalle des deux horaires                   \n"
            + "         (ces 2 horaires compris dans la recherche)                       \n\n";
    
    
    /* **************************************************************************** */
    /* ************           gestion du menu voyageur              *************** */
    /* ***************************************************************************  */
    
	public static void afficherMenuVoyageur() {
        System.out.println(TITRE_MENU_VOYAGEUR);    

        // on affiche toutes les options et les libellés
        for(int i = 0; i < OPTION_MENU_VOYAGEUR.length; i++) {
            System.out.print("   => " + OPTION_MENU_VOYAGEUR[i] 
                                 + " - " + LIBELLE_MENU_VOYAGEUR[i] + "\n");
        }
        System.out.print("\n       ====> ");	
    }
    
    /**
     * Affiche le menu principal pour l'utilisateur et saisit son choix.
     * L'action est répétée jusqu'à obtenir un choix valide
     * @return un caractère contenant le choix de l'utilisateur
     */
    public static char saisirOptionMenuVoyageur() {
        String reponse;       // utilisé pour la lecture de la réponse de l'utilisateur
        
        // affiche le menu et saisit le choix, répété jusqu'à obtenir un choix valide
        do {            
            afficherMenuVoyageur();
            reponse = entree.nextLine();
            if (! reponseValide(reponse, OPTION_MENU_VOYAGEUR)) {
                System.out.println("\n       ==> Ce choix n'est pas valide."
                                   + " Recommencez.\n\n");
            }
        } while (! reponseValide(reponse, OPTION_MENU_VOYAGEUR));     
        System.out.println();
        return reponse.charAt(0);
    }
    
    
    /**
     * Affiche l'aide en ligne 
     */
    public static void afficherAideVoyageur() {
        System.out.println(TEXTE_AIDE_MENU_VOYAGEUR); 
    }





    /* **************************************************************************** */
    /* ***  Textes utilisés pour le menu administrateur et options de celui-ci   ** */
    /* **************************************************************************** */
   
    /**
     * Texte de titre pour le menu administrateur
     */
    private static final String TITRE_MENU_ADMINISTRATEUR = 
            "------------------------------------------------------------------\n"
            + "|                   MENU ADMINISTRATEUR                          |\n"
            + "------------------------------------------------------------------\n";

    /**
     * Liste des options possibles pour le menu voyageur
     */
    private static final char[] OPTION_MENU_ADMINISTRATEUR = { 'm', '+', 's', 'a', '?', 'r'};   
    
    /**
     * Liste des libellés associés à chacune des options du menu voyageur
     */
    private static final String[] LIBELLE_MENU_ADMINISTRATEUR = {
            "Modifier votre mot de passe",
            "Ajouter une nouvelle desserte",
            "Supprimer une desserte existante",
            "Associer des horaires de passage a une desserte",
            "Consulter de l'aide",
            "Retour en arriere"};
    
    /** Texte affiché pour l'aide en ligne */
    public static final String TEXTE_AIDE_MENU_ADMINISTRATEUR = 
        "--------------------------------------------------------------------------------\n"
        + "|                             AIDE EN LIGNE                                    |\n"
        + "--------------------------------------------------------------------------------\n\n"
        + " Bienvenue sur l'aide en ligne du menu administrateur. Voici les fonctionnalites\n"
        + "   -> Modifier le mot de passe. Toute chaine non vide sera acceptee.            \n\n"
        + "   -> Ajouter une nouvelle desserte. Si l'utilisateur entre un nom d'arret      \n"
        + "      comportant plus de 25 caracteres, il sera informe de son erreur. Seuls les\n" 
        + "      25 premiers caracteres seront pris en compte.                             \n\n"
        + "   -> Supprimer une desserte existante et les horaires qui lui sont associes.   \n"
        + "      Une confirmation sera demandee a l'administrateur.                        \n\n"
        + "   -> Associer des horaires de passage a une desserte. Cette operation          \n"
        + "      s'effectuera via un fichier texte, ceci dans le but de faciliter la saisie\n"
        + "      des horaires. Plus precisement, l'administrateur preparera en dehors de   \n"
        + "      l'application, un fichier texte contenant les horaires de bus. Pour       \n"
        + "      associer des horaires a une desserte precise, il saisira le nom du fichier\n"
        + "      texte contenant les horaires.                                             \n\n";

    /* **************************************************************************** */
    /* ************        gestion du menu administrateur           *************** */
    /* **************************************************************************** */
    
    public static void afficherMenuAdministrateur() {
        
        System.out.println(TITRE_MENU_ADMINISTRATEUR); 
                    
        // on affiche toutes les options et les libellés
        for(int i = 0; i < OPTION_MENU_ADMINISTRATEUR.length; i++) {
            System.out.print("   => " + OPTION_MENU_ADMINISTRATEUR[i] 
                            + " - " + LIBELLE_MENU_ADMINISTRATEUR[i] + "\n");
        }
        System.out.print("\n       ====> ");	
    }
    
    /**
     * Affiche le menu principal pour l'utilisateur et saisit son choix.
     * L'action est répétée jusqu'à obtenir un choix valide
     * @return un caractère contenant le choix de l'utilisateur
     */
    public static char saisirOptionMenuAdministrateur() {
        String reponse;       // utilisé pour la lecture de la réponse de l'utilisateur
        
        // affiche le menu et saisit le choix, répété jusqu'à obtenir un choix valide
        do {            
            afficherMenuAdministrateur();
            reponse = entree.nextLine();
            if (! reponseValide(reponse, OPTION_MENU_ADMINISTRATEUR)) {
                System.out.println("\n       ==> Ce choix n'est pas valide."
                                   + " Recommencez.\n\n");
            }
        } while (! reponseValide(reponse, OPTION_MENU_ADMINISTRATEUR));     
        System.out.println();
        return reponse.charAt(0);
    }
    
    
    /**
     * Affiche l'aide en ligne 
     */
    public static void afficherAideAdministrateur() {
        System.out.println(TEXTE_AIDE_MENU_ADMINISTRATEUR); // à compléter
    }
    
    /* **************************************************************************** */
    /* ***   Méthode utilisée pour vérifier si un choix utilisateur est valide   ** */
    /* ***      sera utilisée pour les vérifications faites dans les 3 menus     ** */
    /* **************************************************************************** */
    
    
    /**
     * Détermine si la chaîne argument est valide, c'est-à-dire contient un unique
     * caractère égal à l'un des caractères du tableau choixCorrect
     * @param aTester  chaîne de caractères à tester
     * @return un booléen égal à vrai ssi la chaîne arguement est valdie
     */
    public static boolean reponseValide(String aTester, char[] choixCorrect) {
        boolean resultat;           // résultat renvoyé par la méthode
                                    // vrai ssi la réponse argument est valide
                
        if (aTester == null || aTester.length() != 1) {
            
           //  la réponse ne contient pas un caractère unique
           resultat = false;     
        } else {
        
            // on vérifie si la réponse est présente dans le tableau OPTION ou OPTION_MAJ
            int i;  // indice de parcours
            for (i = 0; i < choixCorrect.length && Character.toLowerCase(aTester.charAt(0))!= choixCorrect[i] ; i++);

            resultat = i < choixCorrect.length;    
        }
        return resultat; 
    }


    
    /* **************************************************************************** */
    /* ****     saisies : mot de passe, nom d'arrêt, identifiant ligne       ****** */
    /* **************************************************************************** */
   
   
    /**
     * Effectue la saisie du mot de passe. La saisie du mot de passe est
     * recommencée en cas d'erreur. Au bout de 5 ereurs, la saisie s'arrête
     * @param  motDePasseCorrect   mot de passe administrateur
     *                             c'est celui-ci qui doit être saisi par l'utilisateur
     *                             pour que la méthode renvoie la valeur vrai
     * @return un booleén égal à vrai ssi l'utilisateur a saisi le mot 
               au plus tard au 5ème essai
     */
    public static boolean saisirMotDePasse(String motDePasseCorrect) {

        final int NB_VERIF = 5;

        boolean saisieOk = false; // true si le mdp est correct

        String mdpSaisie = "";

        for (int i = 0; i < NB_VERIF && saisieOk == false; i++){
            System.out.print("Saisir le mot de passe administrateur : ");
            mdpSaisie = entree.nextLine();
            if (mdpSaisie.equals(motDePasseCorrect)) {
                saisieOk =  true; 
            } else {
                saisieOk =  false;
            }
        }
        return saisieOk;   // renvoyer true ou false selon les erreurs commises 
        
    }
    
    
    /**
     * Effectue la saisie du nom d'un arrêt. La saisie est recommencée
     * jusqu'à obtenir une chaîne non vide. Si celle-ci comporte plus de
     * LG_MAX_ARRET caractères, elle sera tronquée. L'utilisateur en est
     * informé.
       @return nomArret nom de l'arrêt saisi, éventuellement tronqué        
     */
    public static String saisirNomArret() {

        String nomArret = "";        // nom de l'arrêt saisi par l'utilisateur

        /* gestion d'erreur et redemmande si chaine vide */
        nomArret = OutilSaisie.lireChaineNonVide("Veuillez entrer un nom d'arret : "); 
        if (nomArret.length() > LG_MAX_ARRET) {     // algo de tronquage
            nomArret = nomArret.substring(0,25); 
            System.out.println("Votre nom d'arret a ete tronque ! " + nomArret);
        }
        return nomArret.trim();
    }

    
    
    /**
     * Effectue la saisie du nom d'une ligne de bus. La saisie est recommencée
     * jusqu'à obtenir une lettre majuscule. 
       @return nomLigne une chaîne contenant l'identifiant de la ligne de bus
                        (un seul caractère, une lettre majuscule)        
     */
    public static String saisirNomLigne() {
        char nomLigne = ' ';        // nom de la ligne saisie par l'utilisateur
        
        /* gestion d'erreur et redemmande si non majuscule */
        nomLigne = OutilSaisie.lireMajuscule("Veuillez entrer un nom de ligne : ");
        String nomLigneChaine = String.valueOf(nomLigne);

        return nomLigneChaine;
    }
}
