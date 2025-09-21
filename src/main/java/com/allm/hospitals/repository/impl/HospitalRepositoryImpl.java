package com.allm.hospitals.repository.impl;

import com.allm.hospitals.models.Hospital;
import com.allm.hospitals.repository.HospitalRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalRepositoryImpl implements HospitalRepositoryCustom {

    EntityManager entityManager;

    @Override
    public List<Hospital> findByNameAndCity(String name, String city) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hospital> criteriaQuery = criteriaBuilder.createQuery(Hospital.class);
        Root<Hospital> hospitalRoot = criteriaQuery.from(Hospital.class);
        Predicate predicate1 = null;
        Predicate predicate2 = null;

        if (name != null && city != null) {
            predicate1 = criteriaBuilder.equal(hospitalRoot.get("name"), name);
            predicate2 = criteriaBuilder.equal(hospitalRoot.get("city"), city);
            Predicate finalPredicate = criteriaBuilder.and(predicate1, predicate2);
            criteriaQuery.where(finalPredicate);
        }

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
