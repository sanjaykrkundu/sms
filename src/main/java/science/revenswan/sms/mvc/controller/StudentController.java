package science.revenswan.sms.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import science.revenswan.sms.mvc.entity.Student;
import science.revenswan.sms.mvc.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/*
	 * READ
	 */
	@RequestMapping("")
	public String studentList(Model model, @RequestParam(defaultValue = "1") int page) {
		model.addAttribute("data", studentService.findAll(page));
		return "student/students";
	}

	@RequestMapping("/name/{name}")
	@ResponseBody
	public Page<Student> search(@PathVariable String name, @RequestParam(defaultValue = "1") int page) {
		return studentService.findByStudentName(name, page, false);
	}

	/*
	 * CREATE
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String createStudent(Student student) {
		System.out.println(student);
		System.out.println(studentService.save(student));
		return "redirect:/students";
	}

	@RequestMapping("/new")
	public String create(Model model) {
		model.addAttribute("student", new Student());
		return "student/create";
	}

	/*
	 * UPDATE
	 */

	@RequestMapping(method = RequestMethod.PUT)
	public String updateStudent(Student student) {
		System.out.println(student);
		System.out.println(studentService.save(student));

		return "redirect:/students";
	}

	@RequestMapping("/{id}")
	public String update(Model model, @PathVariable String id) {
		model.addAttribute("student", studentService.findOne(id));
		return "student/create";
	}

	/*
	 * DELETE
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(Model model, @PathVariable String id) {
		studentService.delete(id);
		return "redirect:/students";
	}
}
