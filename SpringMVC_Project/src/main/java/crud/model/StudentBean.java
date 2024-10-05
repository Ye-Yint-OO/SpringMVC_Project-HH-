package crud.model;

import lombok.Data;

@Data
public class StudentBean {
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
}
