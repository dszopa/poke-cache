package dto;

import java.util.ArrayList;
import java.util.List;

public class StatusMessageDTO {

    private String message;
    private List<ErrorDTO> errors;

    public StatusMessageDTO() {}

    public StatusMessageDTO(String message) {
        this.message = message;
        this.errors = new ArrayList<>();
    }

    public StatusMessageDTO(String message, List<ErrorDTO> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
