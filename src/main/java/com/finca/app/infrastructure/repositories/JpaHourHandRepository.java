package com.finca.app.infrastructure.repositories;


import com.finca.app.infrastructure.entities.HourHandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHourHandRepository extends JpaRepository<HourHandEntity, Long> {

}
