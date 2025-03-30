package HealthSphereApplication.doctor;


import org.springframework.context.MessageSourceResolvable;

public class DefaultMessageSourceResolvable implements MessageSourceResolvable {

    private final String[] codes;
    private final Object[] arguments;
    private final String defaultMessage;

    public DefaultMessageSourceResolvable(String[] codes, Object[] arguments, String defaultMessage) {
        this.codes = codes;
        this.arguments = arguments;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String[] getCodes() {
        return codes;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public String getDefaultMessage() {
        return defaultMessage;
    }
}