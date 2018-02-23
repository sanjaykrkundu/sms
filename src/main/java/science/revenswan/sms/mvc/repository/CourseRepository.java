package science.revenswan.sms.mvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import science.revenswan.sms.mvc.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String>{

	 Page<Course> findByCourseId(String id,Pageable pageable);
	 Page<Course> findByCourseNameContaining(String name,Pageable pageable);
	
}
