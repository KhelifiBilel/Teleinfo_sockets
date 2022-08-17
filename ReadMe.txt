Vous devez suivre ces étapes pour la bonne exécution de l'application .
   On commence par importer tout le projet nommé 'téléinformatique' dans i'IDE Eclipse .
       1.Créer un projet java dans Eclipse ,clic droit sur ce dossier et choisir import .
       2.Choisir 'File System' , faire entrer l 'emplacement du projet et sélectionner tous les fichiers contenus puis finir et choisir 'Yes to All'  .

 NB: Il se peut qu'on rencontre un problème de connection avec la base de Donnée , on doit ainsi ajouter le fichier .jar du Driver :
       1.Clic droit su le projet déja ouvert dans Eclipse .
       2.Build Path --> Configure Build Path --> Add External Jars .
       3.Choisir ce fichier jar : sqlite-jdbc-3.30.1.jar contenu dans le dossier du projet et confirmer .
      
Maintenant , si tout va bien , on ouvre les deux fichiers contenus dans le dossier src / teleinfo (toujours dans Eclipse) :
  Commencer par lancer monserveur.java puis client.java .

         
   
Vous trouvez le code des différentes classes dans le dossier src . En fait, on distingue 2 packages : lrc et teleinfo .
    * Le premier contient deux classes juste pour le traitement de La Méthode de Correction d'ERREUR  : LRC ou La parité Matricielle . Ce package contient deux classes       server.java et client.java qui présentent les différentes méthodes pour le serveur d'une part et le client d'une autre part .
    * Le deuxième nommé 'teleinfo' contient les deux classes principales : monserveur et client  qu'on doit les exécuter pour lancer notre Application .    

On trouve le Code de la Base de Donnée dans le fichier sql suivant :database/DataBase_Script .