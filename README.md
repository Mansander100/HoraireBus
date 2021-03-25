# HoraireBus : Introduction

![Image de l'IUT de Rodez](http://www.iut-rodez.fr/logo.jpg)

[Lien du site](http://www.iut-rodez.fr/)


## Contexte
+ Plusieurs  lignes de  bus passent à  proximité  de  l’IUT et permettent de  se  rendre au centre  ville.  
Les arrêts  les  plus  proches  de  l’IUT  sont :
A Buanton, B Vallon, C Centre de secours, D Maréchal Joffre, F Maréchal Joffre  

+ L’objectif est de disposer d’une **application facilitant la recherche des horaires de passage des bus**.
Les lignes de bus sont identifiées par une lettre majuscule (de ‘A’ à ‘Z’).
Un nom d’arrêt est un texte non vide d’au plus 25 caractères (tout caractère est autorisé).

+ On entend par desserte une paire formée des deux informations suivantes : nom de l’arrêt et ligne qui passe à cet arrêt. 

+ On suppose qu’il n’y aura pas plus de 10 dessertes. Deux dessertes identiques ne peuvent pas exister.
L’application est destinée à 2 types d’utilisateurs : voyageurs et administrateurs.


## Les pages du site
+ Page d'accueil (**index.html**)
Cette page est la première de couverture du site,
il est d'autant plus important de garder un certain
style qui sera s'accorder a toutes les autres pages.
Celle-ci montre les différents jeux disponibles sur la plateforme
et en regroupe certains par catégories, qui pourrais intéresser le
visiteur.

+ Page qui liste tout les Jeux (html/**listeJeux.html**)
Cette page affiche la totalité des jeux sous la forme d'un tableau complet.

+ Page d'un jeu (html/**jeu.html**)
Cette page est assez spéciale, dans le sens où elle vas s'adapter
par rapport au jeu choisis. Une variable vas transiter dans la barre d'URL pour afficher
le jeu choisis. (données stockées dans le data.js)
Il affiche une représentation du jeu avec une vidéo (si la vidéo n'as pas pu se charger,
une image la présentara). A sa droite une petite section de description et en bas les informations
complémentaires au site.

+ Page d'abonnement (html/**abonnement.html**)
Page qui propose au visiteur de s'abonner au site
avec un prix mensuel (factisse) pous bénéficier de
bonus et de jeux gratuits sur le site (entre autre).

+ Page de contact (html.**contact.html**)
Page contenant un formulaire de contact qui invite l'utilisateur
à s'exprimer sur le site. Le message et toutes les informations
saisies seront retranscrites sur le serveur Discord du groupe
de développement via un Webhook (outils Discord pour transmettre des
informations par requetes HTTP).
+ Page "à propos" (html/**aPropos.html**)
Page qui présentera l'équipe qui a réalisé le site
Mettra a disposition des iconnes de réseaux sociaux pour
suivre l'investissement du projet. (seul le lien du server Discord sera fonctionnel).
	
+ Pages Cachées
	+ Page de développement (html/**dev.html**)
	Cette page référence toutes les données stockées sur le site,
	elle était destinée à l'équipe lors de l'ajout de nouveaux jeux et
	de nouvelles fonctionnalités.

	+ Page EasterEgg (html/**cliker.html**)
	Etant donné que nous avons a faire a un site qui référence des jeux,
	pourquoi ne pas donner la possibilité de jouer sur ce site aussi ?
	C'est pourquoi nous avons décidé de créer une petite page caché qui
	s'ouvre après avoir tapé la suite de lettre *cookie*
	sur la page **index.html** que s'ouvre cette page secrète.
	Le jeu consiste à cliquer sur le cookie central pour augmenter un
	compteur. Si vous avez assez de cookie vous pourrez en dépenser dans
	le clicker auto qui cliquera pour vous (cliquez sur le petit cookie pour l'acheter).
	Ce jeu n'est pas très aboutis mais nous espérons vous avoir surpris grâce à ce petit
	Easter Egg (oeuf de paque).

## Les feuilles de Styles
+ style.css
+ card.css
+ jeu.css
+ cookieConsent.css
+ clicker.css
+ lightmode.css
+ maincolor.css
+ contact.css

## Les Scripts
+ data.js
+ jeu.js
+ konamicode.js
+ clicker.js
+ konamicode.js
+ lightmode.js
+ contact.js

## Petits modules (pour le confort visuel/navigation) :
+ Mode **Jour/Nuit** par stockage local
+ Mode Selection de couleur Principale (N'est pas encore implémenté)
