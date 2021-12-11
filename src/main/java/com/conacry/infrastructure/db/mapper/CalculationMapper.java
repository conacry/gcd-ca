package com.conacry.infrastructure.db.mapper;

import com.conacry.domain.value.Calculation;
import com.conacry.domain.value.Param;
import com.conacry.infrastructure.db.model.CalculationDbModel;
import org.springframework.stereotype.Component;

@Component
public class CalculationMapper {

    public CalculationDbModel toModel(Calculation calculation) {
        var model = new CalculationDbModel();
        model.setN1(calculation.getN1().getValue());
        model.setN2(calculation.getN2().getValue());
        model.setResult(calculation.getResult());

        return model;
    }

    public Calculation fromModel(CalculationDbModel model) {
        var n1 = Param.of(model.getN1());
        var n2 = Param.of(model.getN2());

        return Calculation.of(n1, n2, model.getResult());
    }
}
