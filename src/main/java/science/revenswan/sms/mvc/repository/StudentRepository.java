package science.revenswan.sms.mvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import science.revenswan.sms.mvc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>,QueryByExampleExecutor<Student> {

	Page<Student> findByStudentNameContaining(String name, Pageable pageable);
	Page<Student> findByStudentNameStartingWith(String name, Pageable pageable);

}
