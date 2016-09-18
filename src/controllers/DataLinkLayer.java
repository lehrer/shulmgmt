package controllers;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import models.ScheduledItem;

public class DataLinkLayer {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShulMgmgtPU");;
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction tx;

	public static void makeScheduledItemPersistent(ScheduledItem scheduledItem) {
		// open connectie
		tx = em.getTransaction();
		tx.begin();
		em.persist(scheduledItem);
		tx.commit();
	}

	public static List<ScheduledItem> getAllScheduledItems() {
		String JPQLquery = "SELECT s FROM ScheduledItem s";

		TypedQuery<ScheduledItem> queryItems = em.createQuery(JPQLquery, ScheduledItem.class);
		List<ScheduledItem> items = queryItems.getResultList();

		return items;

	}

	public static int deleteScheduledItem(UUID id) {
		tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("DELETE FROM ScheduledItem s WHERE s.id = :p");
		int deletedCount = query.setParameter("p", id).executeUpdate();
		tx.commit();
		return deletedCount;
	}

	public static int clearDatabase() {
		tx = em.getTransaction();
		tx.begin();
		int deletedCount = em.createQuery("DELETE FROM ScheduledItem").executeUpdate();
		tx.commit();
		return deletedCount;
	}

	public static void closeConnection() {
		if (em.isOpen())
			em.close();
		if (emf.isOpen())
			emf.close();
	}
}
