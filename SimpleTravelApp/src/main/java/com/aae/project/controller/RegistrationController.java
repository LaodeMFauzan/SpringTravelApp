package com.aae.project.controller;

import com.aae.project.model.User;
import com.aae.project.service.UserServiceInterface;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fauzan
 */
@Controller
public class RegistrationController {
    private final UserServiceInterface userService;
    
    @Autowired
    public RegistrationController(UserServiceInterface userService){
        this.userService=userService;
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public ModelAndView registration(){
    	ModelAndView mav=new ModelAndView();
    	User user=new User();
    	mav.addObject("user",user);
    	mav.setViewName("/registration");
    	return mav;
    }

    @RequestMapping(value="/registration",method=RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user,BindingResult bindingResult){
    	if (userService.findByEmail(user.getEmail()).isPresent()) {
    		bindingResult.rejectValue("email","error.user","Email already used");
    	}
    	if (userService.findByUsername(user.getUsername()).isPresent()) {
    		bindingResult.rejectValue("email","error.user","username already used");
    	}

    	ModelAndView mav=new ModelAndView();

    	if (bindingResult.hasErrors()) {
    		mav.setViewName("/registration");
    	} else{
    		userService.saveUser(user);

    		mav.addObject("successMessage","Registration Success");
    		mav.addObject("user",new User());
    		mav.setViewName("/login");
    	}

    	return mav;
    }

}
