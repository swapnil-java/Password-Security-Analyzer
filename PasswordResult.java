public class PasswordResult {

    private int score;
    private String strength;
    private boolean hasUppercase;
    private boolean hasLowercase;
    private boolean hasNumber;
    private boolean hasSpecialCharacter;
    private int length;

    public PasswordResult(
            int score,
            String strength,
            boolean hasUppercase,
            boolean hasLowercase,
            boolean hasNumber,
            boolean hasSpecialCharacter,
            int length) {

        this.score = score;
        this.strength = strength;
        this.hasUppercase = hasUppercase;
        this.hasLowercase = hasLowercase;
        this.hasNumber = hasNumber;
        this.hasSpecialCharacter = hasSpecialCharacter;
        this.length = length;
    }

    public int getScore() {
        return score;
    }

    public String getStrength() {
        return strength;
    }

    public boolean hasUppercase() {
        return hasUppercase;
    }

    public boolean hasLowercase() {
        return hasLowercase;
    }

    public boolean hasNumber() {
        return hasNumber;
    }

    public boolean hasSpecialCharacter() {
        return hasSpecialCharacter;
    }

    public int getLength() {
        return length;
    }
}
