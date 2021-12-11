package com.conacry.infrastructure.db.dao;

import com.conacry.infrastructure.db.model.TaskDbModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskDao extends JpaRepository<TaskDbModel, UUID> {

    @Modifying
    @Query("update TaskDbModel m " +
            "set m.result = :result, " +
            "m.status = :status " +
            "where m.identifier = :identifier")
    void addResult(UUID identifier, Integer result, String status);
}
