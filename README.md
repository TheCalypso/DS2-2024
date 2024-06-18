# Régulation Hygrométrique

Ce projet Android permet de réguler l'hygrométrie de différentes pièces d'un logement. L'application offre la possibilité de gérer des consignes d'humidité pour des pièces pré-définies, d'ajouter de nouvelles pièces et de définir des consignes spécifiques pour chaque pièce.

## Fonctionnalités

1. **Liste déroulante des pièces** : Affiche les pièces disponibles dans le logement.
2. **Ajouter une pièce** : Permet d'ajouter une nouvelle pièce via une activité dédiée.
3. **Définir des consignes** : Permet de définir une consigne d'humidité pour la pièce sélectionnée via une autre activité.
4. **Synchronisation des consignes** : Met à jour et affiche la consigne d'humidité correspondante à la pièce sélectionnée.

## Installation

1. Clonez ce dépôt sur votre machine locale :
    ```bash
    git clone https://github.com/TheCalypso/DS2-2024.git
    ```

2. Ouvrez le projet dans Android Studio.

3. Compilez et exécutez l'application sur un émulateur ou un appareil physique.

## Structure du projet

- **MainActivity.java** : Activité principale qui affiche la liste des pièces et leurs consignes.
- **ActivityRoom.java** : Activité pour ajouter une nouvelle pièce.
- **ActivityConsigne.java** : Activité pour définir la consigne d'humidité d'une pièce.
- **res/layout** : Contient les fichiers de layout XML pour les différentes activités.
    - `activity_main.xml` : Layout pour l'activité principale.
    - `activity_room.xml` : Layout pour l'activité d'ajout de pièce.
    - `activity_consigne.xml` : Layout pour l'activité de définition des consignes.