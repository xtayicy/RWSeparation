package harry.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import harry.dao.IUserDao;
import harry.entities.User;

/**
 * 
 * @author harry
 *
 */
@Repository
public class UserDao implements IUserDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public User queryUserById(Integer id) {
		return sqlSessionTemplate.selectOne("harry.dao.IUserDao.queryUserById", id);
	}

	@Override
	public void saveUser(User user) {
		sqlSessionTemplate.insert("harry.dao.IUserDao.saveUser", user);
	}

}
