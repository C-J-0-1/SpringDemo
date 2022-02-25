package com.practice.conferencethymeleaf.repositories;

import com.practice.conferencethymeleaf.models.PricingCategory;
import com.practice.conferencethymeleaf.models.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PricingCategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PricingCategory find(String id) {
        return entityManager.find(PricingCategory.class, id);
    }

}
