package cl.leonelalejandroppp.api.excel_processor.exceptions;

public class FileNotValid extends RuntimeException {
    public FileNotValid() {
        super("El archivo debe contener al menos 5 registros");
    }
}
