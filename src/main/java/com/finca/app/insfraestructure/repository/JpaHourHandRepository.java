package com.finca.app.insfraestructure.repository;

import com.finca.app.insfraestructure.entities.HourHandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHourHandRepository extends JpaRepository<HourHandEntity, Long> {

}
