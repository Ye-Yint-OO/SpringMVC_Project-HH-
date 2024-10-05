package crud.model;

import lombok.Data;

@Data
public class BookBean {
	private int id;
	private String title;
	private String author;
	private double price;
	private int status;
}
