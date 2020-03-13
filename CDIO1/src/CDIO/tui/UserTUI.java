package CDIO.tui;

import CDIO.dal.IUserDAO;
import CDIO.dal.UserDAO;
import CDIO.dto.UserDTO;
import CDIO.dto.passwordGenerator;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserTUI {
    public UserTUI() throws ClassNotFoundException, IUserDAO.DALException, SQLException {
        chooseMenu();
    }

    public void chooseMenu() throws IUserDAO.DALException, SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        passwordGenerator passGen = new passwordGenerator();


        System.out.println("Welcome to the CDIO.main menu. Write the menu-nr. you will like to choose" +
                "\nThe menus are:\n 1. Create\n 2. Show\n 3. Update \n 4. Exit");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                //create
                System.out.println("Choose your UserID. It must be an integer between 11 and 99");
                int userID = input.nextInt();
                input.nextLine();
                System.out.println("Type your Username. It may be min 2 or max 20 characters");
                String userName = input.nextLine();
                System.out.println("Choose your initials. It must be an integer between 2 and 4");
                String ini = input.nextLine();
//                System.out.println("Enter your role");
//                String role = input.nextLine();
                String passGene = passGen.generatePassword();
                UserDTO user = new UserDTO(userID, userName, passGene, ini);
                userDAO.createUser(user);
                System.out.println(user);
                break;
            case 2:
                //show
                System.out.println("The list of all users");
                List<UserDTO> allusers = userDAO.getUserList();

                for (int i = 0; i < allusers.size(); i++) {
                    System.out.println(allusers.get(i));
                }

                break;
            case 3:
                //update
                System.out.println("Please write the UserID.");
                userID = input.nextInt();
                boolean run = true;
                while (run) {
                    System.out.println("What information do you want to update? enter the number value of the options" +
                            "\n1. Username\n2. Initials\n3. Password\n4. All informations\n5. Exit");
                    int updatenr = input.nextInt();
                    input.nextLine();
                    if (updatenr == 1) {
                        System.out.println("Please write the wanted userName.");
                        userName = input.nextLine();
                        userDAO.updateUserName(userID, userName);
                    } else if (updatenr == 2) {
                        System.out.println("Please write the wanted initials.");
                        ini = input.nextLine();
                        userDAO.updateInitials(userID, ini);
                    } else if (updatenr == 3) {
                        System.out.println("Please write the wanted password");
                        String pass = input.nextLine();
                        userDAO.updatePassword(userID, pass);
                    } else if (updatenr == 4) {
                        System.out.println("Please write the wanted userName.");
                        userName = input.nextLine();
                        System.out.println("Please write the wanted initials.");
                        ini = input.nextLine();
                        System.out.println("Please write the wanted password");
                        String pass = input.nextLine();
                        userDAO.updateUserName(userID, userName);
                        userDAO.updateInitials(userID, ini);
                        userDAO.updatePassword(userID, pass);
                        run = false;
                    } else if (updatenr == 5) {
                        run = false;
                    }
                }
                break;
            case 4:
                //delete
                System.out.println("Enter the userid of the user your want to delete");
                userID = input.nextInt();
                userDAO.deleteUser(userID);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}