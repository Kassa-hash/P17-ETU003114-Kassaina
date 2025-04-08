CREATE DATABASE ExamServelet;
USE ExamServelet;


CREATE TABLE Prevision (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(25),
    montant int 
);

CREATE TABLE Depense (
     id INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(25),
    montant int 
);