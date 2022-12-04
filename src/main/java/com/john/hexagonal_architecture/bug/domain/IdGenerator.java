package com.john.hexagonal_architecture.bug.domain;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class IdGenerator implements IdentifierGenerator {

    public static final String generatorId = "ownGeneratorId";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
