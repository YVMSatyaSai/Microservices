package com.example.alert.repository;

import com.example.alert.entity.EmailAlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmailAlertRepository extends JpaRepository<EmailAlertEntity, Long> {
    List<EmailAlertEntity> findByFlag(String flag);
}
