package com.conacry.infrastructure.db.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "calculation")
public class CalculationDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calculation_id_seq")
    @SequenceGenerator(name = "calculation_id_seq", sequenceName = "calculation_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "n1_param", nullable = false)
    private Integer n1;

    @Column(name = "n2_param", nullable = false)
    private Integer n2;

    @Column(name = "result", nullable = false)
    private Integer result;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        CalculationDbModel that = (CalculationDbModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
