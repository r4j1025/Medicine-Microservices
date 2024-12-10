package com.medms.medicine_getter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "medicine-db", url = "http://localhost:8000/api/medicines")
public interface MedicineDbClient {

    @GetMapping("/by-name")
    List<Medicine> getMedicinesByName(@RequestParam("keyword") String nameKeyword);

    @GetMapping("/by-usecase")
    List<Medicine> getMedicinesByUseCase(@RequestParam("keyword") String useCaseKeyword);
}
