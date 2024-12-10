package com.medms.medicine_db;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedRepo extends JpaRepository<Medicine, Long> {
	List<Medicine> findByNameContainingIgnoreCase(String keyword);

    List<Medicine> findByUseCasesContainingIgnoreCase(String keyword);
}
