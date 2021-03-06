/*
 * Classe avec des méthodes outils qui s'appliquent à des horaires
 * OutilHoraire.java                                                    01/19
 */
package applicationhorairebus.programme;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Cette classe contient des méthodes outils qui s'appliquent à des horaires : 
 *    - une méthode pour saisir un horaire (d'abord les heures, ensuite les minutes)
 *    - une méthode pour saisir 2 horaires dans l'ordre chronologique
 *    - une méthode qui vérifie si une chaîne de caractères contient bien un
 *           horaire dans un format valide  : cchcc
 *    - une méthode qui convertit une chaîne de caractères contenant un horaire,
 *           en entier (un horaire en minutes)
 *    - une méthode qui convertit un horaire exprimé en minutes en chaîne de caracères
 *    - une méthode qui renvoie l'heure courante (convertie en minutes)
 * La classe contient aussi des méthodes outils, méthodes privées : 
 *    - une méthode outil pour saisir un entier compris dans un intervalle précis   
 *    - une méthode qui détermine si un caractère est un chiffre
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 */
public class OutilHoraire {

    /** Objet Scanner pour effecuer les saisies */
    private static Scanner entree = new Scanner(System.in); 
    
    
     /**
      * Saisie d'un entier compris dans l'intervalle spécifié en argument
      * La saisie est recommencée en cas d'erreur
      * @param min       valeur minimum de l'entier à saisir
      * @param max       valeur maximum pour l'entier à saisir (doit être
      *                  supérieur ou égal à min)
      * @param message   message affiché pour inviter l'utilisateur à saisir
      *                  l'entier (par exemple "Entrez les heures : " ou 
      *                  "Entrez les minutes : ")
      * @return  l'entier saisi
      */
     public static int saisirEntierIntervalle(int min, int max, String message) {
         int entierSaisi = min - 1;   // entier qui sera renvoyé à l'appelant

         do {
             System.out.print(message);             
             if (entree.hasNextInt()) {     // l'utilisateur a tapé un entier
                 entierSaisi = entree.nextInt();                 
                 if (entierSaisi < min || entierSaisi > max) {
                     System.out.println("Erreur. Il faut donner un entier compris entre "
                                        + min + " et " + max + ".\n");
                 }
             } else {
                 System.out.println("Erreur. Il faut saisir un nombre entier.\n");                 
             }
             entree.nextLine();        // vider le tampon
         } while (entierSaisi < min || entierSaisi > max);
         return entierSaisi;
     }
 
    
    /**
     * Effectue la saisie d'un horaire valide. Il s'agit de saisir d'abord les heures
     * puis les minutes. La saisie de chacune des 2 valeurs est recommencée en cas
     * d'erreur. Un horaire est valide si les heures sont comprises entre 0 et 23
     * et les minutes entre 0 et 59
     * @return un entier égal à la conversion de l'horaire saisi en minutes
     */
    public static int saisirHoraire() {
        int heure;      // heure saisie
        int minute;     // minute saisie
        
        /* saisie des heures (en appelant la méthode saisirEntierIntervalle) */
        heure = saisirEntierIntervalle(0, 23, "Veuillez saisir le nombre d'heures : ");


        /* saisie des minutes (en appelant la méthode saisirEntierIntervalle) */
        minute = saisirEntierIntervalle(0, 59, "Veuillez saisir le nombre de minutes : ");

        /* renvoie les heures/minutes en minutes */
        return heure * 60 + minute; 

    }
 
    
    /**
     * Effectue la saisie de 2 horaires. Le premier horaire doit être antérieur
     * ou égal au deuxième, sinon la saisie des 2 horaires est recommencée.
     * @return  un tableau de 2 entiers contenant les 2 horaires convertis en 
     *          minutes
     */
    public static int[] saisir2HorairesOrdonnes() {
        int[] lesHoraires = new int[2];     // les 2 horaires saisis en minutes
        

        /* recommence la saisie jusqu'à obtenir 2 horaires ordonnées ou égaux */
        do { 
			
            /* saisi de la première horaire */
            lesHoraires[0] = saisirHoraire();

            /* saisi de la deuxieme horaire */
            lesHoraires[1] = saisirHoraire();

            /* verification horaires valides */
            if (lesHoraires[0] > lesHoraires[1]) {
                System.out.println("Erreur les horaires ne sont pas valides."
                                 + " La 1ere horaire doit être inférieure ou égale à la 2eme horaire.");
                            
            }
        } while (lesHoraires[0] > lesHoraires[1]); 
        return lesHoraires;
    }
    
    
    /**
     * Détermine si le caractère argument est un chiffre
     * @param caractere  un caractère à tester
     * @return vrai ssi le caractère argument contient un chiffre
     */
    public static boolean estChiffre(char caractere) {
        return caractere >= '0' && caractere <= '9';
    } 
    
     
    /**
     * Détermine si une chaîne de caractères contient bien un horaire dans le format
     * "cchcc" où c est un chiffre, et h est la lettre 'h'.  
     * De plus, l'horaire doit être un horaire de la journée (donc heure compris entre
     * 0 et 23 et minute entre 0 et 59)
     * @param aTester  chaîne contenant l'horaire à tester
     * @return un booléen égal à vrai ssi l'horaire testé est valide
     */
    public static boolean estValide(String aTester) {

        boolean resultat = false;           // vai ssi l'horaire à tester est valide
		
        // on peut vérifier d'abord si l'horaire contient bien 5 caractères
        if (aTester.length() == 5) {
            resultat = true;
        }

        // vérification que la lettre h est au milieu
        if (resultat) {
            if (aTester.charAt(2) != 'h') {
                resultat = false;
            }
        }

		//vérification que les heures sont des entiers
		for(int i = 0; i < 1 && resultat == true; i++) {
			resultat = Character.isDigit(aTester.charAt(i)) ? true : false;
        }
		
		//vérification que les minutes sont des entiers
        for(int i = 3; i < 4 && resultat == true; i++) {
            resultat = Character.isDigit(aTester.charAt(i)) ? true : false;
        }
		
        // vérification que les min sont correctes
        if (resultat) {
            if (Integer.parseInt(aTester.substring(3,5)) < 0 
                    || Integer.parseInt(aTester.substring(3,5)) > 59) {
                resultat = false;
            }
        }

        // vérification que les heures sont valides
        if (resultat) {
            if (Integer.parseInt(aTester.substring(0,2)) < 0 
                    || Integer.parseInt(aTester.substring(0,2)) > 23) {
                resultat = false;
            }
        }
        
        return resultat;
    }
    
    
    /**
     * Convertit l'horaire arguement en chaîne. L'horaire argument doit être valide,
     * donc compris entre 0 et 1439 (horaire de la journée entre 0 et 23h59).
     * La chaîne renvoyée est dans le format cchcc, où c est un chiffre
     * @param horaire   entier qui exprime un horaire en minutes
     * @return une chaîne dans le format cchcc, ou bien le texte "erreur" si 
     *         l'horaire argument n'est pas valide
     */
    public static String convertir(int horaire) {
        /* constante égale à la chaîne renvoyée en cas d'erreur de format */
        final String RESULTAT_ERREUR = "-1";
        
        /* résultat de la conversion qui sera renvoyé */
        String resultatConvertir;
        
        /* déclarer conversion */
        StringBuilder conversion = new StringBuilder(""); 
       
        int heure,      // heure de l'horaire
            minute;     // minute après conversion en heure et minute
        
        /* on vérifie que l'argument horaire est valide (entre 0 et 1439) */
        if (horaire < 0 || horaire > 1439) {
            resultatConvertir = RESULTAT_ERREUR;
        } else {
            heure = horaire / 60;
            minute = horaire % 60;
			
			/* ajout du zéro devant les chiffres < 10 */
			if (heure < 10) {
				conversion.append("0");
			}
			conversion.append(heure);
            conversion.append("h");
			/* ajout du zéro devant les chiffres < 10 */
			if (minute < 10) {
				conversion.append("0");
			}
            /* ajout des minutes */
            conversion.append(minute);
            resultatConvertir = conversion.toString();
        }
        return resultatConvertir;
    }
    
    
    /**
     * Convertit l'horaire argument en entier (résultat en minutes)
     * Si l'horaire argument n'est pas valide, c'est l'entier -1 qui sera renvoyé
     * @param horaire  chaîne contenant l'horaire à convertir
     * @return un entier égal à la conversion en minutes de l'horaire argument
     *                   ou bien à -1 si l'horaire argument n'est pas valide
     */
    public static int convertir(String horaire) {
        int conversion = -1,            // résultat de la conversion en minutes
            heure,                      // heures qui résultent de la conversion
            minute;                     // minutes qui résultent de la conversion

			
		boolean resultat;           // vai ssi l'horaire à tester est valide
        
        /* on vérifie d'abord que l'horaire argument est valide */
		resultat = estValide(horaire);
        
        heure = 0;
        minute = 0;

		if (resultat) {
			
			/* on recupere les minutes */
            minute = Integer.parseInt(horaire.substring(3,5));

            
            /* on recupere les heures */
            heure = Integer.parseInt(horaire.substring(0,2));

            /* convertit les heures/minutes en minutes */
            conversion = (heure * 60) + minute;  
        }	
        return conversion;
    }
    
    
    /**
     * Renvoie l'heure courante convertie en minutes
     * @return un entier égal à l'heure courante convertie en minutes
     */
    public static int heureCourante() {
        // on récupère une instance de type Calendar (elle répresente un calendrier)
        Calendar calendrier = Calendar.getInstance();
        int heure,      // heure courante à renvoyer 
            minute;     // minute courante 
        
        heure = 0;
        minute = 0;

        /* récupération de l'heure courante */
        heure = calendrier.get(Calendar.HOUR_OF_DAY);
        minute = calendrier.get(Calendar.MINUTE);

        /* convertit les heures/minutes en minutes */ 
        minute = (heure * 60) + minute;

        return minute;
    } 
}
