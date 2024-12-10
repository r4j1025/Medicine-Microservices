package com.medms.medicine_db;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedController {

    private Logger logger = LoggerFactory.getLogger(MedController.class);

    @Autowired
    private MedRepo medicineRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/by-name")
    public List<Medicine> getMedicinesByName(@RequestParam("keyword") String nameKeyword) {
        logger.info("getMedicinesByName called with keyword: {}", nameKeyword);
        
        List<Medicine> medicines = medicineRepository.findByNameContainingIgnoreCase(nameKeyword);
        if (medicines.isEmpty()) {
            logger.warn("No medicines found with name containing keyword: {}", nameKeyword);
        } else {
            logger.info("Found {} medicines matching the name keyword.", medicines.size());
        }
        
        logEnvironmentDetails();
        
        return medicines;
    }

  
    @GetMapping("/by-usecase")
    public List<Medicine> getMedicinesByUseCase(@RequestParam("keyword") String useCaseKeyword) {
        logger.info("getMedicinesByUseCase called with keyword: {}", useCaseKeyword);
        
        List<Medicine> medicines = medicineRepository.findByUseCasesContainingIgnoreCase(useCaseKeyword);
        if (medicines.isEmpty()) {
            logger.warn("No medicines found with use case containing keyword: {}", useCaseKeyword);
        } else {
            logger.info("Found {} medicines matching the use case keyword.", medicines.size());
        }
        
        logEnvironmentDetails();
        return medicines;
    }

    /**
     * Logs environment details like the server port.
     */
    private void logEnvironmentDetails() {
        String port = environment.getProperty("local.server.port");
        logger.info("Service is running on port: {}", port);
    }
}
