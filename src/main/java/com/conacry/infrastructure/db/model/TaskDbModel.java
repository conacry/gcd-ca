package com.conacry.infrastructure.db.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "gcd_task")
public class TaskDbModel {

    @Id
    private UUID identifier;

    @Column(name = "n1_param", nullable = false)
    private int n1;

    @Column(name = "n2_param", nullable = false)
    private int n2;

    @Column(name = "result")
    private int result;

    @Column(name = "status", nullable = false)
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TaskDbModel that = (TaskDbModel) o;
        return identifier != null && Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

