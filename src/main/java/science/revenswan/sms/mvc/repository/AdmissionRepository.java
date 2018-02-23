package science.revenswan.sms.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import science.revenswan.sms.mvc.entity.Admission;

public interface AdmissionRepository extends JpaRepository<Admission, String>{

}
