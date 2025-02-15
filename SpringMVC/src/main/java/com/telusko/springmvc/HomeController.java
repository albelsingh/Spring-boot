package com.telusko.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.springmvc.dao.AlienDao;
import com.telusko.springmvc.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	private AlienDao dao;
	
	
	@ModelAttribute                                //before calling RequestMapping this method will call
	public void modelData(Model m)
	{
		/* System.out.println("Before Home Page Requested"); */
		m.addAttribute("name", "Albel");
	}
    
	@RequestMapping("/")  //Whenever requested home page than only call this method
	public String home()
	{
		/* System.out.println("Home Page Requested"); */
		return "index";    //DispatcherServlet calling the jsp page
	}
	
	/*
	 * @RequestMapping("add") public ModelAndView add(@RequestParam("num1") int
	 * a,@RequestParam("num2") int b) {
	 * 
	 * ModelAndView mv=new ModelAndView(); mv.setViewName("result");
	 * 
	 * int result=a+b; mv.addObject("result",result); return mv; }
	 */
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int a,@RequestParam("num2") int b,ModelMap m)
	{
		 
		int result=a+b;
		m.addAttribute("result",result);
		return "result";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a)  //ModelAttribute also responsibe to add the data into model
	{
        
		dao.addAlien(a);
		return 	"result";
		
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		m.addAttribute("showAliens",dao.getAliens());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m)
	{
		m.addAttribute("result",dao.getAlien(aid));
		return "result";
	}
}
