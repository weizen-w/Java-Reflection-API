package example01;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class PasswordValidator {
    public String defaultMessage = "Bad password";

    private int minLength;

    public PasswordValidator(int minLength) {
        this.minLength = minLength;
    }

    public PasswordValidator() {

    }

    public PasswordValidator(String defaultMessage, int minLength) {
        this.defaultMessage = defaultMessage;
        this.minLength = minLength;
    }

    public boolean validate(String password) {
        if (password.length() < minLength) {
            System.out.println(defaultMessage);
            return false;
        }

        return true;
    }
}
