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
		return courseRepository.findAll(new PageRequest(page - 1, 10));
	}

	public boolean save(Course course) {
		try {
			courseRepository.save(course);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Course findOne(String id) {
		return courseRepository.findOne(id);
	}

	public boolean delete(String id) {
		try {
			courseRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Page<Course> findbyId(String id, int page) {
		return courseRepository.findByCourseId(id, new PageRequest(page - 1, 10));
	}

	public Page<Course> findbyNameLike(String name, int page) {
		return courseRepository.findByCourseNameContaining(name, new PageRequest(page - 1, 10));
	}

}
