package com.mayssa.test;

import com.mayssa.dao.EtudiantDao;
import com.mayssa.entities.Etudiant;
public class EtudiantTest {
public static void main(String[] args) {
//créer un objet etudiant
	Etudiant c = new Etudiant();
c.setNom("moussa");
c.setPrenom("mayssa");
c.setDateNaiss("17-06-2002");
c.setAdresse("nabeul");
c.setEmail("mayssa@gmail.com");
c.setAnneeEtudes(2023);
c.setDep("IT");
//ajouter l'objet client à la BD
EtudiantDao etudDao = new EtudiantDao();
etudDao.ajouter(c);
System.out.println("Appel de la méthode listerTous");
for (Etudiant et : etudDao.listerTous())
System.out.println(et.getIdEtudiant()+" "+et.getNom()+" "+et.getPrenom());
System.out.println("Appel de la méthode listerParNom");
for (Etudiant et : etudDao.listerParNom("mo"))

System.out.println(et.getIdEtudiant()+" "+et.getNom()+" "+et.getPrenom());

//tester les autres méthodes de la classe ClientDao
//tester la méthode modifier
c.setAnneeEtudes(2024);
etudDao.modifier(c);
// Consulter un étudiant
Etudiant etudiantConsulte = etudDao.consulter(c, c.getIdEtudiant());
System.out.println("Etudiant consulté : " + etudiantConsulte.getNom() + " " + etudiantConsulte.getPrenom());
//tester la méthode supprimer
//etudDao.supprimer(c);
}
}
