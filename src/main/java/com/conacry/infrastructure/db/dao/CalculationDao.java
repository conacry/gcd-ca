package com.conacry.infrastructure.db.dao;

import com.conacry.infrastructure.db.model.CalculationDbModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationDao extends JpaRepository<CalculationDbModel, Long> {

    CalculationDbModel findByN1AndN2(Integer n1, Integer n2);

    boolean existsByN1AndN2(Integer n1, Integer n2);
}
