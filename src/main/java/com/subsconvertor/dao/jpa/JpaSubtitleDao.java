package com.subsconvertor.dao.jpa;

import com.subsconvertor.model.Subtitle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * User: cristian.popovici
 */
@Repository("JpaSubtitleDao")
public class JpaSubtitleDao {

    @PersistenceContext
    private EntityManager em;


    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED
    )
    public void save(Subtitle item) {
        em.persist(item);
    }

    @Transactional(
            readOnly = true,
            propagation = Propagation.REQUIRED
    )
    public Subtitle find(Long id, Class type) {
        return (Subtitle) em.find(type, id);
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED
    )
    public void delete(Subtitle item) {
        item = em.merge(item);
        em.remove(item);
    }

    @Transactional(
            readOnly = false,
            propagation = Propagation.REQUIRED
    )
    public Subtitle update(Subtitle item) {
        return em.merge(item);
    }

}
