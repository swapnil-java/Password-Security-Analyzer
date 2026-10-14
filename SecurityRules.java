public class SecurityRules {

    public static final int MIN_LENGTH = 8;
    public static final int GOOD_LENGTH = 12;

    public static boolean hasUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static boolean hasLowercase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    public static boolean isCommonPassword(String password) {

        String lowerPassword = password.toLowerCase();

        String[] commonPasswords = {
                "password",
                "12345678",
                "123456789",
                "qwerty",
                "password123",
                "admin",
                "admin123",
                "welcome",
                "letmein"
        };

        for (String commonPassword : commonPasswords) {
            if (lowerPassword.equals(commonPassword)) {
                return true;
            }
        }

        return false;
    }
}
