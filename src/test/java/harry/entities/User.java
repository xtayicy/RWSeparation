package harry.entities;

import java.io.Serializable;

/**
 * 
 * @author harry
 *
 */
public class User implements Serializable{
	private Integer id;
	private String name;
	
	public User(String name) {
		super();
		this.name = name;
	}
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
