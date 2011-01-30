package com.subsconvertor.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: cristian.popovici
 */
@Repository(value = "SubtitleDao")
public class SubtitleDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Subtitle saveSubtitle(Subtitle sub) {
        return em.merge(sub);
    }

}
