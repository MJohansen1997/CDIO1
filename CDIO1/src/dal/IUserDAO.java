package dal;
import java.sql.SQLException;
import java.util.List;

import dto.UserDTO;

public interface IUserDAO {

	UserDTO getUser(int userId) throws DALException, SQLException, ClassNotFoundException;
	List<UserDTO> getUserList() throws DALException, SQLException, ClassNotFoundException;
	void createUser(UserDTO user) throws DALException, SQLException, ClassNotFoundException;
	void updateUserName(int userID, String userName) throws DALException, SQLException, ClassNotFoundException;
	void updatePassword(int userID, String pass) throws SQLException, ClassNotFoundException;
	void updateInitials(int userID, String Ini) throws SQLException, ClassNotFoundException;
	void deleteUser(int userId) throws DALException, SQLException, ClassNotFoundException;


	public class DALException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7355418246336739229L;

		public DALException(String msg, Throwable e) {
			super(msg,e);
		}

		public DALException(String msg) {
			super(msg);
		}

	}

}
