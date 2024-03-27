package cl.leonelalejandroppp.api.excel_processor.services;


import cl.leonelalejandroppp.api.excel_processor.entities.PersonEntity;
import cl.leonelalejandroppp.api.excel_processor.repositories.AddressEntityRepository;
import cl.leonelalejandroppp.api.excel_processor.repositories.PersonEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExcelProcessorServiceTest {


    @Mock
    private PersonEntityRepository personRepository;

    @InjectMocks
    private ExcelProcessorService excelProcessorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetData() {
        List<PersonEntity> testData = new ArrayList<>();
        testData.add(PersonEntity.builder()
                .name("Leonel")
                .rut("18191953")
                .build()
        );
        testData.add(PersonEntity.builder()
                .name("Juan")
                .rut("18191952")
                .build()
        );

        // Configurar comportamiento del repositorio mock
        when(personRepository.findAll()).thenReturn(testData);

        // Ejecutar el método que se está probando
        List<PersonEntity> result = excelProcessorService.getData();

        // Verificar el resultado
        assertEquals(testData.size(), result.size());
        assertEquals(testData, result);

    }
}
