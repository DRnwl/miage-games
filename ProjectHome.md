## Quelques contraintes vous sont imposées néanmoins : ##

  * Template de présentation du site avec header, footer, menus, et champs de saisie pour la connexion.

  * Gestion de la session de connexion comme dans les TPs, mais en AJAX (à l'aide de jQuery ou de Dojo) : la page ne va pas se ré afficher lorsqu'on entre un mauvais login/password mais simplement afficher un message d'erreur.

  * Vous devrez utiliser un modèle de données avec des relations, à vous de voir quel modèle utiliser. On vous recommande de partir des classes entités pour générer les tables, comme dans les derniers TPs.

  * On distinguera des catégories de supports pour les jeux : PC, xbox360, PS3, etc. A vous de voir si il faut une relation ici ou pas... vous justifierez le choix dans le rapport qui sera rendu avec le projet.

  * On peut associer des "tags" (des mots-clé) aux produits (un ou plusieurs), comme sur youtube, flickr, etc. On pourra rechercher des produits par tags (plusieurs tags possibles). Par exemple, le jeu "Crysis2" appartiendra aux catégories PS3, PC, xbox360, et sera taggué avec "fps, action, multi-joueur".

  * Un jeu a un code pour la catégorie d'âge à laquelle il est destiné (voir http://www.pegi.info/fr/).

  * Un jeu a une description résumée, un prix, une référence (un id), le nom du distributeur (on veut pouvoir faire des recherches par distributeurs, catégorie ou pas ?), une ou plusieurs photos, etc.

  * Gestion des comptes des clients + un ou plusieurs admins.

  * On veut pouvoir mettre des jeux dans son panier et passer la commande.

  * On veut un jeu de plusieurs dizaines (voir centaines) de données. A vous de vous débrouiller pour le générer.

  * Le logiciel, lorsqu'on le lance, doit par défaut peupler la base de données avec le jeu de test, sauf si la base est déjà pleine. (comme igift)

  * Vous devrez utiliser quelques fonctionnalités Ajax + quelques widgets et effets javascript dans votre application, à l'aide de Dojo ou jQuery (pas d'autres choix svp!).

  * Vous documenterez dans le rapport les éléments de ces frameworks que vous aurez utilisé. Obligatoire : valider tout ce que l'on peut dans les formulaires en javascript avant de les envoyer sur le serveur.

## Facultatif : ##

  * Interface d'administration : faites ce que vous pouvez. Par exemple, le degré zéro c'est de ne rien faire ! Les produits sont créés par programme, les images sont dans un rep sur le serveur, etc. Degré un : on peut rajouter un produit, on donnera l'url de l'image sur le web, degré deux : on peut uploader les images, etc.

  * Associer des vidéos youtube ou dailymotion aux produits,

  * Noter les produits (avec des étoiles), tri par popularité (stats de consultation), par note (étoiles),

  * Poser des commentaires sur les produits (il faut être loggué),

  * Mettre plein de gadgets supplémentaires dans l'interface (un caroussel pour animer les photos, des dialogues qui se poppent enb javascript, etc)