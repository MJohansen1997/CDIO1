public class Test {
    public static void main(String[] args) {
        PasswordGenerator passObj = new PasswordGenerator();
        String password;
        password = passObj.generatePassword();
        System.out.println(password);
    }
}
