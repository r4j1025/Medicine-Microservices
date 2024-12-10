package com.medms.medicine_getter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/medicine-getter")
public class MedicineGetterController {

    @Autowired
    private MedicineDbClient medicineDbClient;

    
    @GetMapping("/by-name")
    public List<Medicine> getMedicinesByName(@RequestParam("keyword") String nameKeyword) {
        return medicineDbClient.getMedicinesByName(nameKeyword);
    }

   
    @GetMapping("/by-usecase")
    public List<Medicine> getMedicinesByUseCase(@RequestParam("keyword") String useCaseKeyword) {
        return medicineDbClient.getMedicinesByUseCase(useCaseKeyword);
    }
}
