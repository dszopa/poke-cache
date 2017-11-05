package dto;

public class ErrorDTO {

    private String attribute;
    private String errorMessage;

    public ErrorDTO() {}

    public ErrorDTO(String attribute, String errorMessage) {
        this.attribute = attribute;
        this.errorMessage = errorMessage;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
