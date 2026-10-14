public class PasswordAnalyzer {

    public PasswordResult analyze(String password) {

        int score = 0;

        int length = password.length();

        boolean uppercase = SecurityRules.hasUppercase(password);
        boolean lowercase = SecurityRules.hasLowercase(password);
        boolean number = SecurityRules.hasNumber(password);
        boolean special = SecurityRules.hasSpecialCharacter(password);
        boolean common = SecurityRules.isCommonPassword(password);

        // Check password length
        if (length >= SecurityRules.MIN_LENGTH) {
            score += 20;
        }

        if (length >= SecurityRules.GOOD_LENGTH) {
            score += 10;
        }

        // Check character types
        if (uppercase) {
            score += 15;
        }

        if (lowercase) {
            score += 15;
        }

        if (number) {
            score += 15;
        }

        if (special) {
            score += 15;
        }

        // Reduce score for common passwords
        if (common) {
            score -= 40;
        }

        // Prevent negative score
        if (score < 0) {
            score = 0;
        }

        String strength;

        if (score < 30) {
            strength = "VERY WEAK";
        } else if (score < 50) {
            strength = "WEAK";
        } else if (score < 70) {
            strength = "MEDIUM";
        } else if (score < 90) {
            strength = "STRONG";
        } else {
            strength = "VERY STRONG";
        }

        return new PasswordResult(
                score,
                strength,
                uppercase,
                lowercase,
                number,
                special,
                length);
    }
}
