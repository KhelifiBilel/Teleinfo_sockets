Vous devez suivre ces �tapes pour la bonne ex�cution de l'application .
   On commence par importer tout le projet nomm� 't�l�informatique' dans i'IDE Eclipse .
       1.Cr�er un projet java dans Eclipse ,clic droit sur ce dossier et choisir import .
       2.Choisir 'File System' , faire entrer l 'emplacement du projet et s�lectionner tous les fichiers contenus puis finir et choisir 'Yes to All'  .

 NB: Il se peut qu'on rencontre un probl�me de connection avec la base de Donn�e , on doit ainsi ajouter le fichier .jar du Driver :
       1.Clic droit su le projet d�ja ouvert dans Eclipse .
       2.Build Path --> Configure Build Path --> Add External Jars .
       3.Choisir ce fichier jar : sqlite-jdbc-3.30.1.jar contenu dans le dossier du projet et confirmer .
      
Maintenant , si tout va bien , on ouvre les deux fichiers contenus dans le dossier src / teleinfo (toujours dans Eclipse) :
  Commencer par lancer monserveur.java puis client.java .

         
   
Vous trouvez le code des diff�rentes classes dans le dossier src . En fait, on distingue 2 packages : lrc et teleinfo .
    * Le premier contient deux classes juste pour le traitement de La M�thode de Correction d'ERREUR  : LRC ou La parit� Matricielle . Ce package contient deux classes       server.java et client.java qui pr�sentent les diff�rentes m�thodes pour le serveur d'une part et le client d'une autre part .
    * Le deuxi�me nomm� 'teleinfo' contient les deux classes principales : monserveur et client  qu'on doit les ex�cuter pour lancer notre Application .    

On trouve le Code de la Base de Donn�e dans le fichier sql suivant :database/DataBase_Script .