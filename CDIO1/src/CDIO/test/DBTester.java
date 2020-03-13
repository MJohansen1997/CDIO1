package CDIO.test;


//import CDIO.dal.UserDAODiscImpl;

/*
public class DBTester {
	//TODO refactor as JUnit CDIO.test???
	public static void CDIO.main(String[] args) {
		//IUserDAO iDAO = new UserDAODiscImpl();
		UserDTO newUser = new UserDTO();
		//printUsers(iDAO);
		//TODO CDIO.test new fields...
		newUser.setIni("CDIO.test");
		newUser.addRole("Admin");
		newUser.setUserName("testName");
		newUser.setUserId(0);
		try {
			iDAO.createUser(newUser);
		} catch (DALException e) {
			e.printStackTrace();
		}

		try {
			iDAO.createUser(newUser);
		} catch (DALException e1) {
			System.out.println("User already existed - OK");
		}
	
		newUser.setUserId(1);
		newUser.setUserName("2ND user");
		try {
			iDAO.createUser(newUser);
		} catch (DALException e1) {
			e1.printStackTrace();
		}
		printUsers(iDAO);
		newUser.setUserId(0);
		newUser.setUserName("ModifiedName");
		try {
			iDAO.updateUser(newUser);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printUsers(iDAO);
		
		try {
			iDAO.deleteUser(1);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		printUsers(iDAO);
		
		
	}

	private static void printUsers(IUserDAO iDAO) {
		try {
			System.out.println("Printing users...");
			List<UserDTO> userList = iDAO.getUserList();
			for (UserDTO userDTO : userList) {
				System.out.println(userDTO);
			}

		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
*/