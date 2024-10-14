# Gumbull - Application de Gestion de Personnages

## Introduction
L'application Gumbull a pour but de :
- Réaliser différents types d’animations.
- Créer un écran de démarrage pour une application mobile.
- Comprendre l’utilisation de RecyclerView.
- Créer des menus dans l’application.
- Mettre en œuvre un filtrage des données dans une RecyclerView.
- Utiliser des images cerclées (CircularView, CircleImageView).
- Maîtriser la bibliothèque Glide pour le chargement des images.

## Lien du Projet
[Consultez l'application de Gumball sur GitHub](https://github.com/Salma-CHAJARI/Gumbull_Project.git)

## Énoncé du Projet
Le projet consiste à créer une galerie de caractères de la série Gumball, avec les fonctionnalités suivantes :
- Un écran de démarrage animé.
- Une liste de stars consultable avec la possibilité de filtrer par nom.

## Étapes du Projet

### Étape 1 : Création du Projet
- **Android Studio** : Création d’un projet avec les packages `adapter`, `beans`, `dao`, et `service`.
- Création des activités `ListActivity` et `SplashActivity`.

### Étape 2 : Écran de Démarrage Animé
Un écran de démarrage avec un logo animé est créé. Les animations appliquées sur le logo sont les suivantes :
- Rotation de 360° pendant 2 secondes.
- Redimensionnement à 50 % pendant 3 secondes.
- Translation verticale de 1000 pixels pendant 2 secondes.
- Disparition progressive (alpha 0) pendant 6 secondes.

Après 5 secondes, l’utilisateur est redirigé vers `ListActivity` via un thread, et l’activité `SplashActivity` est détruite après la redirection.

### Étape 3 : Création de la Couche Métier
- Création de la classe `Star` qui modélise une star avec des attributs tels que `id`, `nom`, `photo`, et `star`.
- Mise en place de l’interface `IDao`.
- La classe `StarService` gère la logique métier et l’accès aux données.

### Étape 4 : Présentation des Données avec RecyclerView
- Utilisation de `RecyclerView` pour afficher la liste des caractères.
- Création d’un Adapter pour lier les données des stars à la vue.
- Utilisation de la bibliothèque Glide pour charger les images des caractères.

#### Filtrage des Données
- Implémentation du filtrage via l’interface `Filterable` dans l’adapter.
- L’utilisateur peut rechercher une star par nom à l’aide d’un `SearchView` dans la barre de menu.

### Étape 5 : Gestion des Menus
- Ajout d’un menu avec une icône de recherche.
- Le `SearchView` permet d’afficher dynamiquement les résultats filtrés dans la `RecyclerView`.

## Rôles dans la Classe Adapter
- **Rôle de la classe `StarViewHolder`** : Encapsule les vues individuelles d’un élément dans le `RecyclerView`, améliorant les performances en évitant des appels répétitifs à `findViewById()`.
- **Rôle de la méthode `inflate()`** : Crée une instance de vue à partir d’un fichier XML de layout pour définir la structure visuelle de chaque élément dans le `RecyclerView`.
- **Rôle de la méthode `getItemCount()`** : Renvoie le nombre total d’éléments dans la liste, informant le `RecyclerView` du nombre d’éléments à afficher.
- **Rôle de la méthode `onCreateViewHolder()`** : Crée de nouveaux `ViewHolder` pour les éléments à afficher, utilisant `LayoutInflater` pour gonfler le layout XML d’un élément.
- **Rôle de la méthode `onBindViewHolder()`** : Lie les données d’un élément aux vues dans un `ViewHolder`, mettant à jour l’interface utilisateur avec les informations correspondantes à l’index donné.

## Objectif
L’objectif du TP est de développer une application mobile en Java permettant de gérer une liste de caractères dans la série Gumball et d’afficher leurs détails de manière fluide et intuitive.

## Installation
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/Salma-CHAJARI/Gumbull_Project.git







https://github.com/user-attachments/assets/d3508513-1061-4472-bc7c-4d275e20e52e



