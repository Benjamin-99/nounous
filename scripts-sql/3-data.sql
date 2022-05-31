SET search_path TO nounous;


-- Supprime toutes les données
DELETE FROM telephone;
DELETE FROM personne;
DELETE FROM categorie;
DELETE FROM role;
DELETE FROM compte;


-- Insère les données

INSERT INTO compte (IdCompte, Pseudo, MotDePasse, Email,Role ) VALUES 
  (1, 'geek', 'geek', 'geek@3il.fr','ADMINISTRATEUR' ),
  (2, 'chef', 'chef', 'chef@3il.fr','UTILISATEUR'  ),
  (3, 'job', 'job', 'job@3il.fr','UTILISATEUR'  );

ALTER TABLE compte ALTER COLUMN IdCompte RESTART WITH 4;

  
INSERT INTO role (IdCompte, Role) VALUES 
  ( 1, 'ADMINISTRATEUR' ),
  ( 1, 'UTILISATEUR' ),
  ( 2, 'UTILISATEUR' ),
  ( 3, 'PARENT' );
  
  
INSERT INTO categorie (IdCategorie, Libelle ) VALUES 
  (1, 'Employés' ),
  (2, 'Partenaires' ),
  (3, 'Clients'),
  (4, 'Fournisseurs' ),
  (5, 'Dirigeants' );

ALTER TABLE categorie ALTER COLUMN IdCategorie RESTART WITH 6;
  
  
INSERT INTO personne (IdPersonne, IdCategorie, Nom, Prenom) VALUES 
  ( 1, 1, 'DESVALOIS', 'Christian' ),
  ( 2, 1, 'BELABDELLI', 'Fethi' ),
  ( 3, 1, 'AMBLARD', 'Emmanuel');

ALTER TABLE personne ALTER COLUMN IdPersonne RESTART WITH 4;
  
INSERT INTO parent (IdParent,IdCompte,  Adresse, Nom, Prenom) VALUES 
  ( 1, 1,'re', 'DESVALOIS', 'Christian' ),
  ( 2, 2,'re', 'BELABDELLI', 'Fethi' ),
  ( 3, 3,'re', 'AMBLARD', 'Emmanuel' );

ALTER TABLE parent ALTER COLUMN IdParent RESTART WITH 4;

INSERT INTO nounou (IdNounou,IdCompte,  Adresse, Nom, Prenom) VALUES 
  ( 1, 1,'re', 'DESVALOIS', 'Christian' ),
  ( 2, 2,'re', 'BELABDELLI', 'Fethi' ),
  ( 3, 3,'re', 'AMBLARD', 'Emmanuel' );

ALTER TABLE nounou ALTER COLUMN IdNounou RESTART WITH 4;

INSERT INTO enfant (IdEnfant, IdParent,NomEnfant, PrenomEnfant, DateNaissance) VALUES 
  ( 1, 1,'DESVALOIS', 'Christian','19/10/2022' ),
  ( 2, 2,'BELABDELLI', 'Fethi','19/10/2022' ),
  ( 3, 3,'AMBLARD', 'Emmanuel','19/10/2022' );

ALTER TABLE nounou ALTER COLUMN IdNounou RESTART WITH 4;


INSERT INTO contrat (IdContrat,TarifHoraire, NbreHeuresEntretien, TarifRepas, IdParent,IdNounou,DateDeGarde,HeureArrivee,HeureDepart,Repas ) VALUES 
  ( 1,5, '02:15:00',1,1, 1,'19/11/2022','03:15:00','02:15:00',TRUE ),
  ( 2,5, '02:15:00',1,2, 2 ,'19/11/2022','03:15:00','02:15:00',TRUE),
  ( 3,5, '02:15:00',1,3, 3 ,'19/11/2022','03:15:00','02:15:00',TRUE);

ALTER TABLE contrat  ALTER COLUMN IdContrat RESTART WITH 4;

INSERT INTO telephone (IdTelephone, IdPersonne, IdParent, IdNounou, Libelle, Numero ) VALUES 
  ( 11, 1,1,1, 'Portable', '06 11 11 11 11' ),
  ( 12, 1,1,1, 'Fax', '05 55 99 11 11' ),
  ( 13, 1,1,1, 'Bureau', '05 55 11 11 11' ),
  ( 21, 2,2,2,  'Portable', '06 22 22 22 22' ),
  ( 22, 2,2,2, 'Fax', '05 55 99 22 22' ),
  ( 23, 2,2,2, 'Bureau', '05 55 22 22 22' ),
  ( 31, 3,3,3, 'Portable', '06 33 33 33 33' ),
  ( 32, 3, 3,3,'Fax', '05 55 99 33 33' ),
  ( 33, 3,3,3, 'Bureau', '05 55 33 33 33' );

ALTER TABLE telephone ALTER COLUMN IdTelephone RESTART WITH 100;
 
