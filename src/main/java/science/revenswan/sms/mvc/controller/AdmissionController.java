package science.revenswan.sms.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import science.revenswan.sms.mvc.entity.Admission;
import science.revenswan.sms.mvc.service.AdmissionService;

@Controller
@RequestMapping("/admissions")
public class AdmissionController {

	@Autowired
	private AdmissionService admissionService;

	/*
	 * READ
	 */

	@RequestMapping("")
	public String admissionList(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "") String query) {
		admissionService.findAll(page).forEach(System.out::println);
		//if (query.length() == 0) {
			model.addAttribute("data", admissionService.findAll(page));
		/*} else {
			model.addAttribute("data", admissionService.findbyNameLike(query, page));
		}*/
		
		return "admission/admissions";
	}

	/*
	 * CREATE
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String createCourse(Admission admission) {
		System.out.println(admission);
		System.out.println(admissionService.save(admission));

		return "redirect:/admissions";
	}

	@RequestMapping("/new")
	public String create(Model model) {
		model.addAttribute("admission", new Admission());
		return  "admission/create";
	}

	/*
	 * UPDATE
	 */

	@RequestMapping(method = RequestMethod.PUT)
	public String updateCourse(Admission admission) {
		System.out.println(admission);
		System.out.println(admissionService.save(admission));
		return "redirect:/admissions";
	}

	@RequestMapping("/{id}")
	public String update(Model model, @PathVariable String id) {
		model.addAttribute("admission", admissionService.findOne(id));
		return "admission/create";
	}

	/*
	 * DELETE
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(Model model, @PathVariable String id) {
		admissionService.delete(id);
		return "redirect:/admissions";
	}

}
