package cl.leonelalejandroppp.api.excel_processor.exceptions;

public class FileEmptyException extends RuntimeException{
    public FileEmptyException() {
        super("El archivo no puede estar vacío");
    }
}
