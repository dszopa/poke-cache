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

    @Override
    public String toString() {
        return "StatusMessageDTO{" +
                "message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusMessageDTO that = (StatusMessageDTO) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return errors != null ? errors.equals(that.errors) : that.errors == null;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (errors != null ? errors.hashCode() : 0);
        return result;
    }
}
