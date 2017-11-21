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

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "attribute='" + attribute + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorDTO errorDTO = (ErrorDTO) o;

        if (attribute != null ? !attribute.equals(errorDTO.attribute) : errorDTO.attribute != null) return false;
        return errorMessage != null ? errorMessage.equals(errorDTO.errorMessage) : errorDTO.errorMessage == null;
    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
        return result;
    }
}
