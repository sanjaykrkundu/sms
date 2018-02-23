package science.revenswan.sms.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import science.revenswan.sms.mvc.entity.Student;
import science.revenswan.sms.mvc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Page<Student> findAll(int page) {
		return studentRepository.findAll(new PageRequest(page - 1, 10));
	}

	public boolean save(Student student) {
		try {
			studentRepository.save(student);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Student findOne(String id) {
		return studentRepository.findOne(id);
	}

	public boolean delete(String id) {
		try {
			studentRepository.delete(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Page<Student> findByStudentName(String name, int page, boolean startswith) {
		try {
			if (startswith)
				return studentRepository.findByStudentNameStartingWith(name, new PageRequest(page - 1, 10));
			else
				return studentRepository.findByStudentNameContaining(name, new PageRequest(page - 1, 10));
		} catch (Exception e) {
			return null;
		}

	}
}
