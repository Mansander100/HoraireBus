/*
 * ApplicationBus.java                                         01 avril 2021
 * IUT Rodez info1 2020-2021, pas de droits
 */
package applicationhorairebus.programme;

//import applicationhorairebus.test.TestGestionGrilleHoraire;
//import applicationhorairebus.test.TestGestionDesserte;


/**
 * Cette classe contiendra la fonction main permettant de lancer l’application 
 * ainsi que plusieurs méthodes. Chacune des méthodes correspondra à une 
 * fonctionnalité de l’application : celles du mode voyageur et celles 
 * du mode administrateur. 
 * @author Lucas Serieys, Mehdi Sahari, Valentin Simon, Clément Pauline
 * @version 1.0
 */
public class ApplicationBus {

    /**
     * Excécution des différents composants de l'applicationHoraireBus
     * avec appelle aux autres classes : voyageur et administrateur
     * Récupération et enregistrement des dessertes et horaires dans
     * des fichiers textes externes.
     * @param args non utilisé
     */
    public static void main (String[] args) {

        /* permet de créer les fichiers.bin au tout premier démarrage */
        //OutilFichier.enregistrerDesserte(TestGestionDesserte.EXEMPLE_DESSERTE);
        //OutilFichier.enregistrerHoraireBus(TestGestionGrilleHoraire.preparerGrilleExemple());

        boolean quitter = false;    // permet de quitter l'appli en appuyant sur 'q' uniquement

        int colonneSaisie,          // choisie par l'utilisateur
            horaireSaisie,          // ""
            borneInfHoraireSaisie,  // ""
            borneSupHoraireSaisie;  // ""

        String[] desserteSaisie;    // ""

        /* récupérer les dessertes et horaire dans les fichiers .bin */
        String[][] desserte_initiale = OutilFichier.restaurerDesserte();
        int[][] horaire_initiale = OutilFichier.restaurerHoraireBus();

        /* affichage menu principal */
        do {
            switch (GestionInterface.saisirOptionMenuPrincipal()) {
                case 'v' -> { switch (GestionInterface.saisirOptionMenuVoyageur()) {
                                /* afficher les dessertes et horaires récupérées des fichiers .bin */
                                case 'c' -> {GestionDesserte.afficherDesserte(desserte_initiale);
                                             GestionGrilleHoraire.afficherGrille(horaire_initiale);
                                            }
                                
                                /* permet d'afficher les horaires dispo dans les 30min après une horaire donnée */
                                case 'a' -> {colonneSaisie = OutilHoraire.saisirEntierIntervalle(0, 9, 
                                                            "Entrez la colonne dans laquelle rechercher de 0 a 9 : ");
                                             horaireSaisie = OutilHoraire.saisirHoraire();
                                             System.out.print("\nProchains bus dispo dans les 30min apres " 
                                                              + OutilHoraire.convertir(horaireSaisie) + " : ");
                                             /* affiche le tableau contenant les horaires trouvées */
                                             GestionGrilleHoraire.afficherTableauConverti(GestionGrilleHoraire.rechercherHoraire(horaire_initiale, colonneSaisie, 
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire_initiale, colonneSaisie, horaireSaisie),
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire_initiale, colonneSaisie, horaireSaisie+30)));
                                            }

                                /* permet d'afficher les horaires dispo dans les 30min après une horaire donnée */
                                case 'm' -> {colonneSaisie = OutilHoraire.saisirEntierIntervalle(0, 9, 
                                             "Entrez la colonne dans laquelle rechercher de 0 a 9 : ");
                                             horaireSaisie = OutilHoraire.heureCourante();
                                             System.out.print("\nProchains bus dispo dans la demi-heure : ");
                                             /* affiche le tableau contenant les horaires trouvées */
                                             GestionGrilleHoraire.afficherTableauConverti(GestionGrilleHoraire.rechercherHoraire(horaire_initiale, colonneSaisie, 
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire_initiale, colonneSaisie, horaireSaisie),
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire_initiale, colonneSaisie, horaireSaisie+30)));
                                            }

                                /* permet d'afficher les horaires dispo dans les 30min après une horaire donnée */
                                case 'i' -> {colonneSaisie = OutilHoraire.saisirEntierIntervalle(0, 9, 
                                             "Entrez la colonne dans laquelle rechercher de 0 a 9 : ");
                                             System.out.println("\nSaisir l'heure qui debute l'intervalle");
                                             borneInfHoraireSaisie = OutilHoraire.saisirHoraire();
                                             System.out.println("\nSaisir l'heure qui termine l'intervalle");
                                             borneSupHoraireSaisie = OutilHoraire.saisirHoraire();
                                             System.out.print("\nProchains bus dispo entre " + OutilHoraire.convertir(borneInfHoraireSaisie)
                                                              + " et " + OutilHoraire.convertir(borneSupHoraireSaisie) + " : ");
                                             /* affiche le tableau contenant les horaires trouvées */
                                             GestionGrilleHoraire.afficherTableauConverti(GestionGrilleHoraire.rechercherHoraire(horaire_initiale, colonneSaisie, 
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire_initiale, colonneSaisie, borneInfHoraireSaisie),
                                                                GestionGrilleHoraire.rechercherProchainPassage(horaire_initiale, colonneSaisie, borneSupHoraireSaisie)));
                                            }

                                /* affiche aide voyageur */
                                case '?' -> GestionInterface.afficherAideVoyageur();
                                
                                /* retour en arrière grâce au do while */
                                case 'r' -> {}
                                } 
                            }

                    case 'a' -> { if (GestionInterface.saisirMotDePasse("iut12000")) {
                                    switch (GestionInterface.saisirOptionMenuAdministrateur()) {
                                    /* modification du mdp */
                                    case 'm' -> {System.out.println("Fonction non disponible dans la version 1.0");} 

                                    /* ajouter une desserte au tableau en local et l'enregistre dans le .bin */
                                    case '+' -> {desserteSaisie = GestionDesserte.saisirDesserte(); 
                                                GestionDesserte.ajouterDesserte(desserte_initiale, 
                                                                                    desserteSaisie[0], 
                                                                                    desserteSaisie[1]);
                                                GestionDesserte.afficherDesserte(desserte_initiale);
                                                OutilFichier.enregistrerDesserte(desserte_initiale);              
                                                }
                                        
                                    /* supprimer une desserte du tableau en local et l'enregistre dans le .bin */
                                    case 's' -> {desserteSaisie = GestionDesserte.saisirDesserte(); 
                                                GestionDesserte.supprimerDesserte(desserte_initiale, 
                                                                                    desserteSaisie[0], 
                                                                                    desserteSaisie[1]);
                                                GestionDesserte.afficherDesserte(desserte_initiale);
                                                OutilFichier.enregistrerDesserte(desserte_initiale);
                                                }

                                    /* associer des horaires à une desserte */
                                    case 'a' -> {System.out.println("Fonction non disponible dans la version 1.0");} 

                                    /* afficher aide administrateur */
                                    case '?' -> GestionInterface.afficherAideAdministrateur();

                                    /* retour en arrière grâce au do while */
                                    case 'r' -> {}
                                    }
                                  }
                                }
                
                /* afficher aide principal */
                case '?' -> GestionInterface.afficherAidePrincipal();
                    
                /* quitter l'application */
                case 'q' -> quitter = true;
            }
        } while (quitter == false);
    }
}
