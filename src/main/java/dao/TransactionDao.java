package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TransactionDao {
    public static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("currencyPU");

    public void saveTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
        em.close();
    }
}
