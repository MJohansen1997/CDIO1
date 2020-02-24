import java.util.Random;

public class PasswordGenerator {
    private String password;
    private char randomChar;
    private int randomInt;
    private Random rand = new Random();
    private int min, max;
    private int asciiValue;

    private char generateLowerCaseChar() {
        min = 97;
        max = 122;
        asciiValue = rand.nextInt(max - min) + 1 + min;
        randomChar = (char)asciiValue;
        return randomChar;
    }
    private char generateUpperChaseChar() {
        min = 65;
        max = 90;
        asciiValue = rand.nextInt(max - min) + 1 + min;
        randomChar = (char)asciiValue;
        return randomChar;
    }
    private int generateNumber() {
        min = 48;
        max = 57;
        randomInt = rand.nextInt(10);
        return randomInt;
    }
    private boolean checkPassword(String password) {
        int ass;
        boolean c1 = false, c2 = false, c3 = false;
        for (int i = 0; i < password.length(); i++) {
            ass = password.charAt(i);
            if (ass >= 97 && 122 >= ass) {
                c1 = true;
            } else if (ass >= 65 && 90 >= ass) {
                c2 = true;
            } else if (ass >= 0 && 9 >= ass) {
                c3 = true;
            }
        }
        return c1 && c2 && c3;
    }

    // Category 1: {a-z} Ascii Dec = 97-122
    // Category 2: {A-Z} Ascii Dec = 65-90
    // Category 3: {0-9} Ascii Dec = 48-57

    public String generatePassword() {
        int l = rand.nextInt(12-8) + 1 + 8;
        int n = rand.nextInt(3) + 1;
        do {
            StringBuilder passwordBuilder = new StringBuilder();
            for (int i = 0; i < l; i++) {
                switch (n) {
                    case 1:
                        passwordBuilder.append(generateLowerCaseChar());
                        n = rand.nextInt(3) + 1;
                        break;
                    case 2:
                        passwordBuilder.append(generateUpperChaseChar());
                        n = rand.nextInt(3) + 1;
                        break;
                    case 3:
                        passwordBuilder.append(generateNumber());
                        n = rand.nextInt(3) + 1;
                        break;
                    default:
                        System.out.println("ass");
                }
            }
            password = passwordBuilder.toString();
        } while (checkPassword(password));
        return password;
    }
}

