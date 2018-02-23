package science.revenswan.sms.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import science.revenswan.sms.mvc.entity.Admission;
import science.revenswan.sms.mvc.repository.AdmissionRepository;

@Service
public class AdmissionService {

	@Autowired
	private AdmissionRepository admissionRepository;

	public Page<Admission> findAll(int page) {
		return admissionRepository.findAll(new PageRequest(page - 1, 10));
	}

	public boolean save(Admission admission) {
		try {
			admissionRepository.save(admission);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Admission findOne(String id) {
		return admissionRepository.findOne(id);
	}

	public boolean delete(String id) {
		try {
			admissionRepository.delete(id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
