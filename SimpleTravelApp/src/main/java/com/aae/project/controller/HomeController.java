package com.aae.project.controller;

import com.aae.project.model.Wisata;
import com.aae.project.service.WisataServiceInterface;
import com.aae.project.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
/**
 *
 * @author fauzan
 */
@Controller
public class HomeController {
    
    private static int INITIAL_PAGE=0;
    
    private final WisataServiceInterface wisataService;
    
    @Autowired
    public HomeController(WisataServiceInterface wisataService){
    	this.wisataService=wisataService;
    }

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional <Integer> page){

    	int evalPage=(page.orElse(0)<1)? INITIAL_PAGE :	page.get() - 1;

    	Page<Wisata> wisata =wisataService.findAllWisataPageable(PageRequest.of(evalPage, 5));
	Pager pager=new Pager(wisata);

	ModelAndView mav=new ModelAndView();
	mav.addObject("wisata",wisata);
	mav.addObject("pager",pager);
	mav.setViewName("/home");
	return mav;    		
    }
}
