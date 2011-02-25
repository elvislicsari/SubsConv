package com.subsconvertor.dao.jpa;

import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: cristian.popovici
 */

public class SingletonEntityManagerFactory extends LocalEntityManagerFactoryBean {

    private Map<String, EntityManagerFactory> cache = new ConcurrentHashMap<String, EntityManagerFactory>();

    @Override
    protected EntityManagerFactory createNativeEntityManagerFactory() throws PersistenceException {
        String providerName = getPersistenceUnitName();
        if (cache.containsKey(providerName)) {
            return cache.get(providerName);
        }

        EntityManagerFactory factory = super.createNativeEntityManagerFactory();
        cache.put(providerName, factory);

        return factory;

    }
}