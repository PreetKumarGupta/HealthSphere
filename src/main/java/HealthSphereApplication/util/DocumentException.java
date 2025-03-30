package HealthSphereApplication.util;

// Custom exception for document-related errors
public class DocumentException extends Exception {

    // Default constructor
    public DocumentException() {
        super("An error occurred while processing the document.");
    }

    // Constructor with custom error message
    public DocumentException(String message) {
        super(message);
    }

    // Constructor with custom error message and cause
    public DocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with cause only
    public DocumentException(Throwable cause) {
        super(cause);
    }
}
