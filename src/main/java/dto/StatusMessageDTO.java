package dto;

import java.util.Map;

public class StatusMessageDTO {

    private Integer status;
    private String message;
    private Map<String, Object> errors;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }


    public static final class StatusMessageDTOBuilder {
        private Integer status;
        private String message;
        private Map<String, Object> errors;

        public StatusMessageDTOBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public StatusMessageDTOBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public StatusMessageDTOBuilder withErrors(Map<String, Object> errors) {
            this.errors = errors;
            return this;
        }

        public StatusMessageDTO build() {
            StatusMessageDTO statusMessageDTO = new StatusMessageDTO();
            statusMessageDTO.setStatus(status);
            statusMessageDTO.setMessage(message);
            statusMessageDTO.setErrors(errors);
            return statusMessageDTO;
        }
    }
}
