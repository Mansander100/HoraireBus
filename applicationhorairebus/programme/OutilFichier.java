/*
 * Méthodes pour gérer les fichiers de l'application "gestion des horaires de bus"
 */
package applicationhorairebus.programme;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * Cette classe contient des méthodes pour gérer les fichiers de l'application
 * "gestion des horaires de bus". Ces méthodes permettent de 
 *     - lire les lignes d'un fichier texte et renvoyer leur contenu sous la forme
 *       d'un tableau de String
 *     - enregistrer dans un fichier un tableau à 2 dimensions contenant des 
 *       chaînes de caractères. Ce tableau est supposé contenir les dessertes
 *     - lire le contenu d'un fichier supposé contenir le tableau des dessertes
 *        et renvoyer celui-ci sous la forme d'un tableau à
 *       2 dimensions contenant des chaînes de caractères
 *     - enregistrer dans un fichier un tableau à 2 dimensions contenant des 
 *       entiers. Ce tableau est supposé contenir les horaires de bus.
 *     - lire le contenu d'un fichier supposé contenir le tableau des horaires
 *       et renvoyer celui-ci sous la forme d'un tableau à 2 dimensions 
 *       contenant des entiers
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 */
public class OutilFichier {
    
    /**
     * Nombre maximum de lignes qui pourront être lues dans le fichier texte
     * Constante utilisée dans la méthode lectureHoraire
     */
    private final static int NB_MAX_LIGNE = 100;
        
    /**
     * Nom du fichier dans lequel est enregistré le tableau à 2 dimensions
     * contenant les dessertes.
     */
    private final static String NOM_FICHIER_DESSERTE = "fichier_desserte.bin";
    
    /**
     * Nom du fichier dans lequel est enregistré le tableau à 2 dimensions
     * contenant les horaires de bus.
     */
    private final static String NOM_FICHIER_HORAIRE = "fichier_horaire_bus.bin";
    
    /**
     * Nom du fichier dans lequel le mot de passe est enregistré
     */    
    private final static String NOM_FICHIER_MOT_PASSE = "fichier_mot_de_passe.txt";
    
    
    /**
     * Lit les lignes du fichier texte argument et les place dans un tableau de 
     * chaînes de caractères qui est renvoyé par la méthode.
     * Si un problème empêche l'accès au fichier (par exemple si le fichier 
     * n'existe pas) la méthode renverra la valeur null.
     * Si par contre, le fichier existe mais est vide, la méthode renverra
     * un tableau vide.
     * Seules les NB_MAX_LIGNE premières ligne du fichier pourront être renvoyées.
     * Les autres seront ignorées.
     * @param nomFichier    nom du fichier supposé contenir les lignes de texte
     * @return un tableau de chaînes de caractères. Chacune contient une ligne du
     *         texte lu dans le fichier. En cas d'erreur, la valeur null est renvoyée
     */
    public static String[] lectureFichierHoraire(String nomFichier) {
        
        // tampon dans lequel sont placées les lignes lues
        String[] tampon = new String[NB_MAX_LIGNE];    
        
        /*
         *  tableau résultat qui sera renvoyé par la méthode
         *  Sa taille est égale au nombre de lignes lues dans le fichier
         */
        String[] resultat = null;
        String ligne;               // ligne lue dans le fichier
        int numero = 0;             // numéro de la ligne lue
       
        try ( // déclaration et création de l'objet fichier
              BufferedReader fichier = new BufferedReader(
                                              new FileReader(nomFichier))) {
          
            /*
             * on lit une ligne dans le fichier et on la place dans le 
             * tableau résultat
             * jusqu'à ce que la valeur null soit lue (ce sera le cas
             * lorsque la fin du fichier sera atteinte) ou bien jusqu'à
             * avoir lu NB_MAX_LIGNE lignes dans le fichier
             */
            while (((ligne = fichier.readLine()) != null) 
                    && numero < NB_MAX_LIGNE) {
                  tampon[numero++] = ligne;
            } 

            // fermeture du fichier automatique avec try-with-ressource          
        } catch (IOException ex) {      
            
            // problème d'accès au fichier
            tampon = null;
        }
        
        /*
         *  on crée le tableau résultat avec la taille adéquate
         *  et on recopie dans ce tableau les chaînes du tableau tampon
         */
        if (tampon != null) {
            resultat = new String[numero];
            for (int i = 0; i < numero; i++) {
                resultat[i] = tampon[i];
            }
        }
        return resultat;
    }
    
    
    /**
     * Enregistre dans le fichier ayant pour nom NOM_FICHIER_DESSERTE
     * le tableau contenant les dessertes. Il s'agit d'un tableau
     * à 2 dimensions contenant des valeurs de type String.
     * @param table  tableau à 2 dimensions contenant des String
     * @return un booléen égal à vrai ssi la sauvegarde a bien été effecuée
     */
    public static boolean enregistrerDesserte(String[][] table) {
        boolean reussi = true;      // vrai ssi l'enregistrement a réussi
        
        // création et ouverture du fichier NOM_FICHIER_PAIRE
        try(ObjectOutputStream fichier = new ObjectOutputStream(
                    new FileOutputStream(NOM_FICHIER_DESSERTE))) {
                       
            // on écrit l'objet argument dans le fichier
            fichier.writeObject(table);  
        }  catch (IOException erreur) {
            
            // une erreur s'est produite lors de l'accès au fichier
            reussi = false;
        }
        return reussi;        
    }
    
    
    /**
     * Restauration des dessertes.
     * Les dessertes sont supposées être présentes dans le fichier de nom 
     * NOM_FICHIER_DESSERTE, sous la forme d'un tableau à 2 dimensions contenant
     * des valeurs de type String
     * @return un tableau à 2 dimensions contenant des chaînes de caractères
     *         ou bien la valeur null si un problème empêche l'accès au fichier
     */
    public static String[][] restaurerDesserte()  {
        
        // objet tampon dans lequel est placé l'objet lu dans le fichier  
        String[][] tampon = null;  
        
        // ouverture du fichier et lecture de l'objet qu'il contient
        try(ObjectInputStream fichier = new ObjectInputStream(
                    new FileInputStream(NOM_FICHIER_DESSERTE))) {           
            
            // lecture de l'objet contenu dans le fichier
            tampon = (String[][]) fichier.readObject();
            
        } catch (ClassNotFoundException erreur) {
            
            // la donnée présente dans le fichier n'est pas un objet           
        } catch (ClassCastException erreur) {
                
            // la donnée lue dans le fichier n'est pas un objet à 2 dimensions    
        } catch (IOException erreur) {
            
            // problème d'accès au fichier
        }
        return tampon;
    }
    
    
    /**
     * Enregistre dans le fichier ayant pour nom NOM_FICHIER_HORAIRE
     * le tableau à 2 dimensions contenant les horaires de bus.
     * Ce tableau contient des entiers
     * @param table  tableau à 2 dimensions contenant des entiers
     * @return un booléen égal à vrai ssi la sauvegarde a bien été effecuée
     */
    public static boolean enregistrerHoraireBus(int[][] table) {
        boolean reussi = true;      // vrai ssi l'enregistrement a réussi
        
        // création et ouverture du fichier NOM_FICHIER_HORAIRE
        try(ObjectOutputStream fichier = new ObjectOutputStream(
                    new FileOutputStream(NOM_FICHIER_HORAIRE))) {
                       
            // on écrit l'objet argument dans le fichier
            fichier.writeObject(table);  
        }  catch (IOException erreur) {
            
            // une erreur s'est produite lors de l'accès au fichier
            reussi = false;
        }
        return reussi;        
    }
    
    
    /**
     * Restauration des horaires de bus.
     * Les horaires sont supposés être présents dans le fichier de nom 
     * NOM_FICHIER_HORAIRE, sous la forme d'un tableau à 2 dimensions contenant
     * des valeurs de type entier
     * @return un tableau à 2 dimensions contenant des entiers
     *         ou bien la valeur null si un problème empêche l'accès au fichier
     */
    public static int[][] restaurerHoraireBus()  {
        
        // objet tampon dans lequel est placé l'objet lu dans le fichier  
        int[][] tampon = null;  
        
        // ouverture du fichier et lecture de l'objet qu'il contient
        try(ObjectInputStream fichier = new ObjectInputStream(
                    new FileInputStream(NOM_FICHIER_HORAIRE))) {           
            
            // lecture de l'objet contenu dans le fichier
            tampon = (int[][]) fichier.readObject();
            
        } catch (ClassNotFoundException erreur) {
            
            // la donnée présente dans le fichier n'est pas un objet           
        } catch (ClassCastException erreur) {
                
            // la donnée lue dans le fichier n'est pas un objet à 2 dimensions    
        } catch (IOException erreur) {
            
            // problème d'accès au fichier
        }
        return tampon;
    }

    /**
     * Lit le mot de passe placé dans le fichier NOM_FICHIER_MOT_PASSE
     * et le renvoie
     * Si le fichier n'existe pas, c'est une chaîne vide qui est renvoyée
     * @return une chaîne contenant le mot de passe lu dans le fichier ou bien
     *         une chaîne vide si le fichier n'existe pas
     */
    public static String lectureFichierMotDePasse() {        
        String motLu;           // mot lu dans le fichier
        
        motLu = "";
        try ( // déclaration et création de l'objet fichier
              BufferedReader fichier = new BufferedReader(
                                              new FileReader(NOM_FICHIER_MOT_PASSE))) {
          
            // on lit une ligne dans le fichier
            motLu = fichier.readLine();
                       
            // fermeture du fichier automatique avec try-with-ressource          
        } catch (IOException ex) {                  
            // problème d'accès au fichier  : motLu sera égal à ""         
        }
                
        return motLu;
    }
    
    /**
     * Ecriture du mot de passe dans le fichier NOM_FICHIER_MOT_PASSE
     * (si le fichier existe déjà, son ancien contenu sera écrasé)
     * @param motAEcrire   mot à écrire dans le fichier
     * @return  un booléen égal à vrai ssi l'écriture a pu être effectuée
     */
    public static boolean ecritureFichierMotDePasse(String motAEcrire) {
        boolean resultatEcriture;       // vrai ssi l'écriture a pu être effecutée
                                        // valeur renvoyée à l'appelant
        try ( // déclaration et création de l'objet fichier
              PrintWriter fichier = new PrintWriter(NOM_FICHIER_MOT_PASSE)) {
            
              // on écrit le mot dans le fichier
              fichier.println(motAEcrire);
              resultatEcriture = true;
                         
              // fermeture du fichier automatique avec try-with-ressource          
          } catch (IOException ex) {                  
              // problème d'accès au fichier    
              resultatEcriture = false;
          }
        return resultatEcriture;
    }
}