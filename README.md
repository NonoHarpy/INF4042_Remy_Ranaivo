# Titre

Pokedex

# Descriptif

Projet de 4ème année en cours d'application mobile réalisé par Nora Rémy et Kevin Ranaivo en TCSI2. Pokédex étant une application permettant de voir les caractéristiques des pokémons existants.

# Important

Nos fichiers sont hébergés sur un serveur distant et il est possible que notre fichier pokemon.json mette un certain temps à upload les données en fonction de la connexion internet.
Revenir à la vue précédente et revenir sur la deuxième activité en cas de long temps d'attente.

# Fonctionnement de l'application

- Installer l'application sur le smartphone android à l'aide de l'APK

- cliquer sur le logo pour ouvrir l'application et faire apparaître la première activité.

# Uniquement sur la première activité

- Cliquer sur le bouton "retour" de votre smartphone afin de faire apparaître une boîte de dialogue vous indiquant que vous allez quitter l'application.
	- Ferme l'application si vous appuyez sur le bouton "oui"
	- Retour sur l'activité + affichage d'un "toast" traductible (Français / anglais)

- Affichage du calendrier en appuyant sur l'intitulé "Pokedex" (application externe)
	- Visualisation d'un "toast" traductible (Français / anglais)
	- Visualisation de la date entrée en cas de validation
	- Ne fais rien en cas d'annulation
	- Apparition de la notification (logo pokéball) avec pour intitulé "pokedex"

- Cliquer sur la Pokéball pour ouvrir la deuxième activité chargeant le fichier pokemon.json

# Uniquement sur la Deuxième activité

- Visualisation de la liste des pokémons ainsi que leurs caractéristiques avec une image associée pour chacun d'entre eux. (service de téléchargement JSON + RecyclerView)

- Cliquer sur la petite flèche orientée vers la gauche (bouton retour dans l'actionbar) pour revenir sur l'activité précédente. 

- Aller dans les options de votre téléphone afin de passer en format paysage et inclinez votre téléphone afin de l'adapter à l'écran (landscape)

