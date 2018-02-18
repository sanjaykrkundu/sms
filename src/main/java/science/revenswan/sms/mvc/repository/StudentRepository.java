package science.revenswan.sms.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import science.revenswan.sms.mvc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
