package com.subsconvertor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: cristian.popovici
 */
public final class EMF {

    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("transactions-optional");

    public EMF() {
    }

    public EntityManager entityManager() {
        return emfInstance.createEntityManager();
    }
}
