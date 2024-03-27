package cl.leonelalejandroppp.api.excel_processor.services;

import cl.leonelalejandroppp.api.excel_processor.entities.AddressEntity;
import cl.leonelalejandroppp.api.excel_processor.entities.PersonEntity;
import cl.leonelalejandroppp.api.excel_processor.exceptions.FileEmptyException;
import cl.leonelalejandroppp.api.excel_processor.exceptions.FileNotValid;
import cl.leonelalejandroppp.api.excel_processor.repositories.AddressEntityRepository;
import cl.leonelalejandroppp.api.excel_processor.repositories.PersonEntityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelProcessorService {

    private final PersonEntityRepository personRepository;
    private final AddressEntityRepository addressRepository;
    private static final int MIN_ROWS = 6;
    private static final int ACTIVE_SHEET = 0;
    private static final int NAME_INDEX = 0;
    private static final int RUT_INDEX = 1;
    private static final int ADDRESS_INDEX = 2;
    private static final int COUNTRY_INDEX = 3;


    public void uploadFile (MultipartFile file) {
        if(file.isEmpty()){
            throw new FileEmptyException();
        }

        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(ACTIVE_SHEET);

            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount < MIN_ROWS) {
                throw new FileNotValid();
            }

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    this.saveEntities(row);
                }
            }

            workbook.close();

        } catch (IOException | EncryptedDocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<PersonEntity> getData () {
        return this.personRepository.findAll();
    }

    private void saveEntities (Row row) {
        String name = row.getCell(NAME_INDEX).toString();
        String rut = row.getCell(RUT_INDEX).toString();
        String address = row.getCell(ADDRESS_INDEX).toString();
        String country = row.getCell(COUNTRY_INDEX).toString();

        System.out.println(name + "\t");
        System.out.println(rut + "\t");
        System.out.println(address + "\t");
        System.out.println(country + "\t");

        PersonEntity personEntity = this.personRepository.save(PersonEntity.builder()
                .name(name)
                .rut(rut)
                .build()
        );

        this.addressRepository.save(AddressEntity.builder()
                .address(address)
                .country(country)
                .personEntity(personEntity)
                .build()
        );


    }
}
