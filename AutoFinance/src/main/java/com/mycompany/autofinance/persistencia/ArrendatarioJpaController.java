/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autofinance.persistencia;

import com.mycompany.autofinance.logica.Arrendatario;
import com.mycompany.autofinance.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Julio Cesar
 */
public class ArrendatarioJpaController implements Serializable {

    public ArrendatarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
     public ArrendatarioJpaController() {
        emf = Persistence.createEntityManagerFactory("AutoFinancePU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Arrendatario arrendatario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(arrendatario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Arrendatario arrendatario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            arrendatario = em.merge(arrendatario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = arrendatario.getId_arrendatario();
                if (findArrendatario(id) == null) {
                    throw new NonexistentEntityException("The arrendatario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Arrendatario arrendatario;
            try {
                arrendatario = em.getReference(Arrendatario.class, id);
                arrendatario.getId_arrendatario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The arrendatario with id " + id + " no longer exists.", enfe);
            }
            em.remove(arrendatario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Arrendatario> findArrendatarioEntities() {
        return findArrendatarioEntities(true, -1, -1);
    }

    public List<Arrendatario> findArrendatarioEntities(int maxResults, int firstResult) {
        return findArrendatarioEntities(false, maxResults, firstResult);
    }

    private List<Arrendatario> findArrendatarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Arrendatario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Arrendatario findArrendatario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Arrendatario.class, id);
        } finally {
            em.close();
        }
    }

    public int getArrendatarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Arrendatario> rt = cq.from(Arrendatario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
