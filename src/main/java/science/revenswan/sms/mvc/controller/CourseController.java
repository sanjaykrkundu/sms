package science.revenswan.sms.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import science.revenswan.sms.mvc.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	
	@RequestMapping("")
	public String courseList(Model model,@RequestParam(defaultValue="1")int page) {
		model.addAttribute("data",courseService.findAll(page));
		return "courses";
	}
	
	
}
