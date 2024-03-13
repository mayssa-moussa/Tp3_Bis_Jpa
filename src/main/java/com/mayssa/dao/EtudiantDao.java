package com.mayssa.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.mayssa.entities.Etudiant;
import com.mayssa.util.JPAutil;
public class EtudiantDao {
	private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA_Etudiant");
	//méthode ajouter d'une entité à la bd
	public void ajouter(Etudiant e)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(e);
	tx.commit();
	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(Etudiant e)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(e);
	tx.commit();
	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Etudiant e)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	e=entityManager.merge(e); // important
	entityManager.remove(e);
	tx.commit();
	}
	//méthode Consulter d'une entité à partir de la bd
	public Etudiant consulter(Etudiant e,Object id)
	{
	return entityManager.find(e.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<Etudiant> listerTous() {
	List<Etudiant> etudiants =
	entityManager.createQuery(
	"select c from Etudiant c").getResultList();

	return etudiants;
	}
	//méthode pour lister tous les client dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<Etudiant> listerParNom(String nom) {List<Etudiant> etudiants
	=entityManager.createQuery( "select c from Etudiant c where c.nom like :pnom")
	.setParameter("pnom","%"+nom+"%").getResultList();

	return etudiants; 
	}}

