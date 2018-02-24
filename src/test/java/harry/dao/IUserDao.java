package harry.dao;

import harry.entities.User;

/**
 * 
 * @author harry
 *
 */
public interface IUserDao {
	public User queryUserById(Integer id);
	
	public void saveUser(User user);
}
