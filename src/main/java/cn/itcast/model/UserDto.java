package cn.itcast.model;

import java.util.Set;

@SuppressWarnings("all")
public class UserDto {
	public static final String SESSION_KEY = "_user";
	private Set<String> authors;// 用户权限

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	private String id;
	private String username;
	private String password;
	private String fullname;
	private String mobile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserDto [authors=" + authors + ", id=" + id + ", username=" + username + ", password=" + password
				+ ", fullname=" + fullname + ", mobile=" + mobile + "]";
	}

}
