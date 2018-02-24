package harry.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import harry.dao.IUserDao;
import harry.entities.User;
import harry.service.IUserService;

/**
 * 
 * @author harry
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MasterAndSlaveDemoTest {
	@Autowired
	DataSource writeSource;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IUserService userService;
	
	@Test
	public void test(){
		userService.saveUser(new User("tom"));
		//System.out.println(userService.queryUserById(1));
	}
}
