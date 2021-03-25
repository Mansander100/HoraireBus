# HoraireBus : Introduction


[IUT de Rodez](http://www.iut-rodez.fr/)|  [UT Capitole](https://www.ut-capitole.fr/)
:--------------------------------------:|:-------------------------:
![](http://www.iut-rodez.fr/logo.jpg)   |  ![](https://upload.wikimedia.org/wikipedia/fr/thumb/2/2f/Universit%C3%A9_Toulouse_1_%28logo%29.svg/1200px-Universit%C3%A9_Toulouse_1_%28logo%29.svg.png)



## Contexte
+ Plusieurs  lignes de  bus passent à  proximité  de  l’IUT et permettent de  se  rendre au centre  ville.  

+ L’objectif est de disposer d’une **application facilitant la recherche des horaires de passage des bus**.

+ Les lignes de bus sont identifiées par une lettre majuscule (de ‘A’ à ‘Z’).

+ Un nom d’arrêt est un texte non vide d’au plus 25 caractères (tout caractère est autorisé).

+ On entend par desserte une paire formée des deux informations suivantes : nom de l’arrêt et ligne qui passe à cet arrêt : 
A Buanton, B Vallon, C Centre de secours, D Maréchal Joffre, F Maréchal Joffre 

+ On suppose qu’il n’y aura pas plus de 10 dessertes. Deux dessertes identiques ne peuvent pas exister.

+ L’application est destinée à 2 types d’utilisateurs : voyageurs et administrateurs.


## Interface utilisateur
+ L’application  sera  dotée  d’une  interface  console.  A  son  lancement,  un  menu  sera  affiché proposant d’accéder  aux  fonctionnalités du  mode voyageur  ou  aux  fonctionnalités  administrateur, ou  encore d’afficher une aide en ligne, ou bien de quitter le programme.

+ Les fonctionnalités « voyageur » seront accessibles via un menu spécifique « voyageur », tout comme les fonctionnalités administrateurs le seront via un menu spécifique « administrateur ».  

+ Parmi les options de ces deux  menus, on trouvera : afficher un texte d’aide à propos des opérations possibles pour ce type d’utilisateur, et revenir au menu principal.

+ Les  options  des  menus  seront  identifiées  par  une  lettre  significative.  Pour  indiquer  son  choix, l’utilisateur pourra entrer la lettre aussi bien en minuscule, qu’en majuscule.

+ A tout moment, que ce soit lors de la saisie d’une option de menu, ou de toute autre saisie, une erreur de saisie provoquera l’affichage d’un message d’erreur, et cette saisie sera recommencée.


## Fonctionnalités voyageur
+ Un voyageur devra avoir la possibilité de :
 
	+ consulter toutes les dessertes possibles
	+ rechercher des horaires de passage des bus, ceci de 3 manières différentes 
	
+ En réponse à une recherche, l’application affichera tous les horaires répondant au critère de recherche. Ces horaires seront classés par ordre chronologique, et seront accompagnés de la desserte.

+ Dans  le  cas  où  aucun  bus  ne  passe  dans  l’intervalle,  l’application  en  informera  l’utilisateur  et  lui indiquera  le  premier  l’horaire  de  passage  du  prochain  bus,  hors  de  l’intervalle,  si  toutefois  un  tel  bus existe,  dans  la  journée  courante.  Si  plusieurs  dessertes  comportent  cet  horaire,  elles  seront  toutes affichées. Si plus aucun bus ne passe dans la journée, l’utilisateur en sera averti.     

+ Conformément à l’exemple, un horaire sera affiché sous la forme de   2 chiffres, suivis de la lettre h, suivie de 2 chiffres.      

+ Pour saisir un horaire, l’utilisateur sera invité à saisir d’abord l’heure (un entier entre 0 et 23), puis les minutes (un entier entre 0 et 59). La saisie de chacune des valeurs sera recommencée en cas d’erreur.       

+ Dans  le  cas  où  il  doit  saisir  deux  horaires  (troisième  recherche),  si  le  deuxième  horaire  n’est  pas postérieur (ou égal) au premier, la saisie des 2 horaires sera recommencée.

+ Lorsqu’un  voyageur  demandera  à  afficher  toutes  les  dessertes,  celles-ci  seront  triées  dans  l’ordre alphabétique des noms des arrêts, puis dans l’ordre des lettres identifiant la ligne. 

+ De plus, un voyageur aura la possibilité de visualiser tous les horaires de passage des bus, pour une desserte donnée.   


## Fonctionnalités administrateur
+ La partie administration de l’application sera accessible via un mot de passe. Au premier lancement, le mot  de  passe  sera  fixé  à  «  iutbus ».  Si  l’administrateur  commet  une  erreur  lors  de  la  saisie  du  mot  de passe, il sera invité à recommencer. Au bout de 5 erreurs, le programme reviendra au menu principal.
 
+ Les  administrateurs  ont  en  charge  la  gestion  des  lignes,  des  dessertes  et  des  horaires.  L’application devra leur permettre de : 

	+ Modifier le mot de passe. Toute chaîne non vide sera acceptée.
	+ Ajouter  une  nouvelle  desserte.  Si  l’utilisateur  entre  un  nom  d’arrêt  comportant  plus  de  25 caractères, il sera informé de son erreur. Seuls les 25 premiers caractères seront pris en compte.
	+ Supprimer  une  desserte  existante  et  les  horaires  qui  lui  sont  associés.  Une  confirmation  sera demandée à l’administrateur.
	+ Associer  des  horaires  de  passage  à  une  desserte.  Cette  opération  s’effectuera  via  un  fichier  texte, ceci  dans  le  but  de  faciliter  la  saisie  des  horaires.  Plus  précisément,  l’administrateur  préparera  en dehors de l’application, un fichier texte contenant les horaires de bus. Pour associer des horaires à une desserte précise, il saisira le nom du fichier texte contenant les horaires.

+ L’association  des  horaires  de  passage  à  une  desserte  ne  sera  possible  que  si  celle-ci  ne  possède  pas encore d’horaires associés. 

+ Le fichier texte contenant les horaires respectera le format suivant : 

	+ Un horaire par ligne
	+ Un horaire aura le format :  2 chiffres, suivis de la lettre ‘h’, suivie de 2 chiffres
	+ Les horaires seront classés par ordre chronologique
	+ 2 horaires consécutifs ne pourront pas être égaux

+ Si l’une des lignes du fichier est incorrecte, le programme signalera que le fichier est mal formaté et aucun des horaires qu’il contient ne sera pris en compte. Si le fichier comporte plus de 50 lignes, seules les 50 premières seront prises en compte et l’administrateur en sera informé.

+ Le mot de passe initial sera « iutbus12000. Un mot de passe devra comporter au moins 10 caractères, parmi lesquels au moins 2 chiffres. 

+ L'application  devra  donner  la  possibilité  de  modifier l’appellation  d’une  desserte,  donc  le  nom  de l’arrêt et/ou de la ligne de bus qui passe à cet arrêt. Cette possibilité sera utile, par exemple, si l'utilisateur se  rend  compte  qu'il  a  commis  une  erreur  de  frappe  lors  de  la  saisie  d'une  information.  Bien  sûr,  la nouvelle appellation devra respecter les règles mentionnées dans la version 1.0 de l’application.

+ L’administrateur  aura  la  possibilité  de  modifier  les  horaires  de  passage  d’une  desserte  existante  qui possède  déjà  des  horaires.  Plus  précisément,  il  s’agira  de  modifier  la  globalité  des  horaires  de  passage pour les remplacer par de nouveaux horaires présents dans un fichier texte. A la différence de la version 1.0, l’avantage sera de lui éviter d’avoir à d’abord supprimer les horaires avant d’en ajouter de nouveaux.


## Les Classes
+ OutilHoraire
+ GestionInterface
+ GestionDesserte
+ GestionGrilleHoraire
+ ApplicationBus (main)

## Consignes à respecter 
+ Le  travail  sera  réalisé  par  groupe  de  4  ou  de  5  étudiants.  Les  groupes  de  5  ajouteront  les fonctionnalités de la version 2.0. (voir cahier des charges).

+ L’ensemble  du  travail    à  rendre  sera  placé  dans  un  dossier  compressé  et  mis  à  disposition  sur  la plateforme de téléchargement [smash](http://fromsmash.com/).

+ Un lien vers le dépôt effectué sur smash sera envoyé à Mme Servières.

## Réalisation à rendre

+ Un dossier au format pdf (voir modalités dans le pdf). 

+ Les classes de l’application y compris les classes de test. 

+ Les  différents  fichiers  contenant  des  données  de  l’application,  donc  les  dessertes  et  la  grille horaire. 

+ Impérativement, un exécutable  permettant  de  lancer  directement  l’application.  Pour  générer  cet exécutable, il faudra suivre les indications fournies dans le document mis à votre disposition sur Moodle.
