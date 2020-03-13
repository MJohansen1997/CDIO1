import CDIO.dto.passwordGenerator;

public class Test {
    public static void main(String[] args) {
        passwordGenerator passObj = new passwordGenerator();
        String password;
        password = passObj.generatePassword();
        System.out.println(password);
    }
}
