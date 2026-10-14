import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PasswordAnalyzer analyzer = new PasswordAnalyzer();

        System.out.println("==========================================");
        System.out.println("       PASSWORD SECURITY ANALYZER");
        System.out.println("==========================================");

        while (true) {

            System.out.print("\nEnter password (or type 'exit' to quit): ");

            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using Password Security Analyzer.");
                break;
            }

            if (password.isEmpty()) {
                System.out.println("Password cannot be empty.");
                continue;
            }

            PasswordResult result = analyzer.analyze(password);

            System.out.println("\n========== PASSWORD ANALYSIS ==========");

            System.out.println("Length              : " + result.getLength());

            System.out.println(
                    "Uppercase           : " +
                            (result.hasUppercase() ? "Yes" : "No"));

            System.out.println(
                    "Lowercase           : " +
                            (result.hasLowercase() ? "Yes" : "No"));

            System.out.println(
                    "Number              : " +
                            (result.hasNumber() ? "Yes" : "No"));

            System.out.println(
                    "Special Character   : " +
                            (result.hasSpecialCharacter() ? "Yes" : "No"));

            System.out.println("----------------------------------------");

            System.out.println(
                    "Security Score      : " +
                            result.getScore() + "/100");

            System.out.println(
                    "Password Strength   : " +
                            result.getStrength());

            System.out.println("----------------------------------------");

            showSuggestions(result);

            System.out.println("========================================");
        }

        scanner.close();
    }

    private static void showSuggestions(PasswordResult result) {

        System.out.println("\nSecurity Suggestions:");

        boolean hasSuggestion = false;

        if (result.getLength() < SecurityRules.MIN_LENGTH) {
            System.out.println("- Use at least 8 characters.");
            hasSuggestion = true;
        }

        if (!result.hasUppercase()) {
            System.out.println("- Add at least one uppercase letter.");
            hasSuggestion = true;
        }

        if (!result.hasLowercase()) {
            System.out.println("- Add at least one lowercase letter.");
            hasSuggestion = true;
        }

        if (!result.hasNumber()) {
            System.out.println("- Add at least one number.");
            hasSuggestion = true;
        }

        if (!result.hasSpecialCharacter()) {
            System.out.println("- Add at least one special character.");
            hasSuggestion = true;
        }

        if (!hasSuggestion) {
            System.out.println(
                    "- Your password follows the basic security rules.");
        }
    }
}
