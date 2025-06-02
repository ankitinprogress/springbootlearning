package com.learning.training.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.math.BigInteger;
import java.util.List;


public class CustomUsersGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        List<?> result = session
                .createNativeQuery("SELECT MAX(CAST(SUBSTRING(id, 6) AS UNSIGNED)) FROM users")
                .getResultList();

        BigInteger max = result != null && result.get(0) != null ?
                new BigInteger(result.get(0).toString()) : BigInteger.valueOf(11999);

        return "USER_" + max.add(BigInteger.ONE);
    }
}
