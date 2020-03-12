package tui;

import dal.IUserDAO;
import dal.UserDAO;
import dto.UserDTO;

import java.util.Scanner;

public class UserTUI {

    public static void chooseMenu(int UserIID, String Username, String Ini) throws IUserDAO.DALException {
        Scanner input = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = new UserDTO();

        int choice = input.nextInt();

        System.out.println("Welcome to the main menu. Write the menu-nr. you will like to choose" +
                "\nThe menus are:\n 1. Create\n 2. Show\n 3. Update \n 4. Exit");

        switch (choice) {
            case 1:
                //create
                System.out.println("Choose your UserID. It must be an integer between 11 and 99");
                UserIID = input.nextInt();
                System.out.println("Type your Username. It may be min 2 or max 20 characters");
                Username = input.nextLine();
                System.out.println("Choose your initials. It must be an integer between 2 and 4");
                Ini = input.nextLine();
                System.out.println("Enter your role");
                role = input.nextLine();

                userDAO.createUser(user);
                System.out.println("Your password is:" + generate());
                break;
            case 2:
                //show
                System.out.println("The list of all users");
                userDAO.getUserList(userId);
                break;
            case 3:
                //update
                System.out.println("What information do you want to update?\n1. username\n2.initials \n 3.password \n 4. all informations");
                int updatenr = input.nextInt();
                userDAO.updateUser();
                if (updatenr==1){
                    userDAO.updateUserName(userID,  userName);
                }
                if (updatenr==2){
                    userDAO.updateInitials(userID, Ini);
                }
                if (updatenr==3){
                    userDAO.updatePassword(userID, pass);
                }
                if (updatenr==4){
                    userDAO.updateUserName(userID,  userName);
                    userDAO.updateInitials(userID, Ini);
                    userDAO.updatePassword(userID, pass);
                }
                break;
            case 4:
                //delete
                System.out.println("Enter the userid of the user your want to delete");
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