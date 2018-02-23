package science.revenswan.sms.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import science.revenswan.sms.mvc.entity.Course;
import science.revenswan.sms.mvc.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	/*
	 * READ
	 */

	@RequestMapping("")
	public String courseList(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "") String query) {

		if (query.length() == 0) {
			model.addAttribute("data", courseService.findAll(page));
		} else {
			model.addAttribute("data", courseService.findbyNameLike(query, page));
		}
		
		return "course/courses";
	}

	/*
	 * CREATE
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String createCourse(Course course) {
		System.out.println(course);
		System.out.println(courseService.save(course));

		return "redirect:/courses";
	}

	@RequestMapping("/new")
	public String create(Model model) {
		model.addAttribute("course", new Course());
		return  "course/create";
	}

	/*
	 * UPDATE
	 */

	@RequestMapping(method = RequestMethod.PUT)
	public String updateCourse(Course course) {
		System.out.println(course);
		System.out.println(courseService.save(course));

		return "redirect:/courses";
	}

	@RequestMapping("/{id}")
	public String update(Model model, @PathVariable String id) {
		model.addAttribute("course", courseService.findOne(id));
		return "course/create";
	}

	/*
	 * DELETE
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(Model model, @PathVariable String id) {
		courseService.delete(id);
		return "redirect:/courses";
	}

}
