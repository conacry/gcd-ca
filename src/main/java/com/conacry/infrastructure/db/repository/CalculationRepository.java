package com.conacry.infrastructure.db.repository;

import com.conacry.application.port.CalculationGateway;
import com.conacry.domain.value.Calculation;
import com.conacry.infrastructure.db.dao.CalculationDao;
import com.conacry.infrastructure.db.mapper.CalculationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
public class CalculationRepository implements CalculationGateway {

    private final CalculationDao calculationDao;
    private final CalculationMapper calculationMapper;

    public CalculationRepository(CalculationDao calculationDao,
            CalculationMapper calculationMapper) {
        this.calculationDao = calculationDao;
        this.calculationMapper = calculationMapper;
    }

    @Override
    public Optional<Calculation> findByParam(Integer n1, Integer n2) {
        var model = calculationDao.findByN1AndN2(n1, n2);

        if (model == null) {
            return Optional.empty();
        }

        var calculation = calculationMapper.fromModel(model);

        return Optional.of(calculation);
    }

    @Override
    public boolean existsByParam(Integer n1, Integer n2) {
        return calculationDao.existsByN1AndN2(n1, n2);
    }

    @Override
    @Transactional
    public void save(@Nonnull Calculation calculation) {
        Objects.requireNonNull(calculation);
        var model = calculationMapper.toModel(calculation);
        calculationDao.save(model);
    }
}
