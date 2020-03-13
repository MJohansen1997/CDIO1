package CDIO.dal;

import CDIO.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.*;
import java.util.HashSet;
import java.util.List;

public class UserDAO implements IUserDAO {
    MySQLCon newCon = new MySQLCon();

    public UserDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public UserDTO getUser(int userId) throws DALException, SQLException, ClassNotFoundException {
            newCon.setup();
            try {
                Statement stmt = newCon.connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + userId);
                if(rs.next())
                {
                    return extractUserFromResultSet(rs);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }

    @Override
    public List<UserDTO> getUserList() throws DALException, SQLException, ClassNotFoundException {
        newCon.setup();
        try {
            Statement stmt = newCon.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            HashSet users = new HashSet();
            while(rs.next())
            {
                UserDTO user = extractUserFromResultSet(rs);
                users.add(user);
            }
            return (List<UserDTO>) users;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void createUser(UserDTO user) throws DALException, SQLException, ClassNotFoundException {
        newCon.setup();

        try{
        int nRowsInserted = 0;
        PreparedStatement preparedStatement = newCon.connection.prepareStatement("INSERT INTO userInformations (userID, userName, pass, ini) VALUES (?, ?, ?, ?);");

        int nRowsUpdated;
        preparedStatement.setInt(1, user.getUserId());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getIni());
        nRowsUpdated = preparedStatement.executeUpdate();
        System.out.println("Inserted" + nRowsUpdated + "row(s) of data.");
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement.", e);
        }
    }

    @Override
    public void updateUserName(int userID, String userName) throws DALException, SQLException, ClassNotFoundException {
        newCon.setup();

        try{
        int nRowsUpdated = 0;
        PreparedStatement preparedStatement = newCon.connection.prepareStatement("UPDATE userInformations SET pass = ? WHERE userID = ?");
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, userID);
        nRowsUpdated += preparedStatement.executeUpdate();
        System.out.println("Inserted" + nRowsUpdated + "row(s) of data.");
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement.", e);
        }
    }


    @Override
    public void updatePassword(int userID, String pass) throws SQLException, ClassNotFoundException {
        newCon.setup();

        try{
        int nRowsUpdated = 0;
        PreparedStatement preparedStatement = newCon.connection.prepareStatement("UPDATE userInformations SET pass = ? WHERE userID = ?");
        preparedStatement.setString(1, pass);
        preparedStatement.setInt(2, userID);
        nRowsUpdated += preparedStatement.executeUpdate();
        System.out.println("Inserted" + nRowsUpdated + "row(s) of data.");
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement.", e);
        }
    }

    @Override
    public void updateInitials(int userID, String Ini) throws SQLException, ClassNotFoundException {
        newCon.setup();

        try{
        int nRowsUpdated = 0;
        PreparedStatement preparedStatement = newCon.connection.prepareStatement("UPDATE userInformations SET ini = ? WHERE userID = ?");
        preparedStatement.setString(1, Ini);
        preparedStatement.setInt(2, userID);
        nRowsUpdated += preparedStatement.executeUpdate();
        System.out.println("Inserted" + nRowsUpdated + "row(s) of data.");
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement.", e);
        }
    }

    @Override
    public void deleteUser(int ID) throws SQLException, ClassNotFoundException {
        newCon.setup();

        try{
        int nRowsDeleted = 0;
        PreparedStatement preparedStatement = newCon.connection.prepareStatement("DELETE FROM userInformations WHERE name = ?;");
        preparedStatement.setInt(1, ID);
        nRowsDeleted += preparedStatement.executeUpdate();
        System.out.println("Inserted" + nRowsDeleted + "row(s) of data.");
        }
        catch (SQLException e)
        {
            throw new SQLException("Encountered an error when executing given sql statement.", e);
        }
    }

    private UserDTO extractUserFromResultSet(ResultSet rs) throws SQLException {
        UserDTO user = new UserDTO(rs.getInt("userID"), rs.getString("userName"), rs.getString("ini"), rs.getString("pass"));
        return user;
    }

}
