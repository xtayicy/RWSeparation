package harry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import harry.service.IUserService;

/**
 * 
 * @author harry
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/test")
	public String test(Integer id) {
		System.out.println(userService.queryUserById(id));

		return "index";
	}

	@RequestMapping(value = "/user")
	public String test01(Integer id) {
		System.out.println("id:" + id);

		return "index";
	}
}
