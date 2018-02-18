package science.revenswan.sms.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import science.revenswan.sms.mvc.entity.Course;
import science.revenswan.sms.mvc.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Page<Course> findAll(int page) {
		return courseRepository.findAll(new PageRequest(page-1, 10));
	}

}
