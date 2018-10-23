package harry.service.impl;

import harry.dao.IUserDao;
import harry.entities.User;
import harry.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author harry
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserService implements IUserService {
	@Autowired
	IUserDao userDao;

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	//@SlaveDB
	public User queryUserById(Integer id) {
		return userDao.queryUserById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
}
