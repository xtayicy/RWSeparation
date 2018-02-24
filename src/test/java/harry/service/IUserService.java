package harry.service;

import harry.entities.User;

/**
 * 
 * @author harry
 *
 */
public interface IUserService {
	public User queryUserById(Integer id);
	
	public void saveUser(User user);
}
