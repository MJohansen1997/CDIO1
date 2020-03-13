package CDIO.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 4545864587995944260L;
	private int	userId;                     
	private String userName;
	private String password;
	private String ini;                 
	private List<String> roles;
	private CDIO.dto.passwordGenerator passwordGenerator = new passwordGenerator();

	public UserDTO(int userId, String userName, String password,  String ini) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.ini = ini;
	}

	public UserDTO(int userId, String userName,  String ini) {
		this.userId = userId;
		this.userName = userName;
		this.password = passwordGenerator.generatePassword();
		this.ini = ini;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}

	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public void addRole(String role){
		this.roles.add(role);
	}
	/**
	 * 
	 * @param role
	 * @return true if role existed, false if not
	 */
	public boolean removeRole(String role){
		return this.roles.remove(role);
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword(){ return password; }

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", pass=" + password + ", ini=" + ini + "]";
	}

}
