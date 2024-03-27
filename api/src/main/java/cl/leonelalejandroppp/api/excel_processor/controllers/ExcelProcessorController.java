package cl.leonelalejandroppp.api.excel_processor.controllers;

import cl.leonelalejandroppp.api.excel_processor.entities.PersonEntity;
import cl.leonelalejandroppp.api.excel_processor.services.ExcelProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/excel-processor")
@RequiredArgsConstructor
@CrossOrigin
public class ExcelProcessorController {

    private final ExcelProcessorService excelProcessorService;

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadFile (@RequestParam("file") MultipartFile file) {
        this.excelProcessorService.uploadFile(file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-data")
    public ResponseEntity<List<PersonEntity>> getData () {
        List<PersonEntity> personEntityList = this.excelProcessorService.getData();
        return ResponseEntity.ok(personEntityList);
    }

}
