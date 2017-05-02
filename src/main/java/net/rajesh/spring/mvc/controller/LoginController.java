package net.rajesh.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.rajesh.spring.config.CustomGenericException;
import net.rajesh.spring.dao.LoginDao;
import net.rajesh.spring.mvc.dto.LoginDto;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@Controller
public class LoginController {

	@Autowired
	LoginDao loginDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestBody LoginDto loginDto) {

		final ModelAndView model = new ModelAndView();
		if (loginDao.verifyUser(loginDto.getUserName(), loginDto.getPassword())) {
			model.setViewName("home");
			model.addObject("login", loginDto);
		} else {
			model.setViewName("login");
			model.addObject("login",
					new CustomGenericException(HttpStatus.BAD_REQUEST.toString(), "invalid credentials"));
		}

		return model;
	}

}
