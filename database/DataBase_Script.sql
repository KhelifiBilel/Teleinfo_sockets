 


Create table Adresse ( 
     NUMERO                Number(8)   , 
     Ville              varchar(20), 
     Rue                varchar(20), 
     CONSTRAINT pk_Adresse     PRIMARY KEY (NUMERO)         
                               );  


Create table Etudiant ( 
     NUMERO_Carte             Number(8)   , 
     NUMERO_UNIQUE            Number(4)   ,
     
     NUMERO                   Number(8)   , 

     NOM_PRENOM               varchar(30), 
     AGE                      Number(2), 
     Nationalite              varchar(15) ,
     Email                    varchar(30),
     CONSTRAINT pk_Etudiant     PRIMARY KEY (NUMERO_Carte) ,        
     CONSTRAINT fk_Etudiant FOREIGN KEY (Numero) REFERENCES Adresse (Numero)
                               );

Create table Fiche_Scolaire ( 
     ID                           Number(8)   , 
     NUMERO_Carte                 Number(8)   , 

     Niveau                       Varchar(30),
     Filiere_Groupe               varchar(8), 
     Moyenne_Annee_Precedente     Number(5), 
     Moyenne_Bac                  Number(5) ,
     CONSTRAINT pk_Fiche_Scolaire       PRIMARY KEY (ID)   ,
     CONSTRAINT fk_Fiche_Scolaire FOREIGN KEY (Numero_Carte) REFERENCES Etudiant (Numero_Carte)
                               );  
                                       
/*   Insertion des Données */

insert into Adresse values(1,'Lyon','Rue_République');         
    insert into Etudiant values(1800363,1,1,'Laurent Grillote',20,'Française','Laurent@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (1,1800363,'Cycle preparatoire','RT2_1',11,14); 
     
      insert into Adresse values(2,'Lyon','Rue_République');         
    insert into Etudiant values(1800364,2,2,'Christelle Gaulin',21,'française','Gaulin@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (2,1800364,'Cycle preparatoire','RT2_2',12,11); 
     
      insert into Adresse values(3,'Paris','Banaudon');         
    insert into Etudiant values(1800365,3,3,'Christelle Gaulin',21,'française','Gaulin@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (3,1800365,'Cycle Ingeniur','RT3_1',12,15);
     
      insert into Adresse values(4,'Tunis','Indépendance');         
    insert into Etudiant values(1800366,4,4,'Karim Khelifi',21,'Tunisienne','Khelifi@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (4,1800366,'Cycle Ingenieur','RT3_1',12,15);

insert into Adresse values(5,'Tunis','Centre Urbain');         
    insert into Etudiant values(1800367,5,5,'Anis Yousfi',21,'Tunisienne','Yousfi@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (5,1800367,'Cycle Ingenieur','RT3_1',12,15);

insert into Adresse values(6,'Tunis','Centre Urbain nord');         
    insert into Etudiant values(1800368,6,6,'Mohammed Mrabet',21,'Tunisienne','Mrabet@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (6,1800368,'Cycle Ingenieur','RT3_1',12,15);

insert into Adresse values(7,'Tunis','Palestine');         
    insert into Etudiant values(1800369,7,7,'Malak Younsi',21,'Tunisienne','Younsi@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (7,1800369,'Cycle Ingenieur','RT3_1',12,15);
     
insert into Adresse values(8,'Tunis','Palestine');         
    insert into Etudiant values(1800370,8,8,'Yassine Melki',21,'Tunisienne','Melki@insat.u-carthage.tn');                           
     insert into fiche_scolaire values (8,1800370,'Cycle Ingenieur','RT4_1',11,12);

