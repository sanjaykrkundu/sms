package science.revenswan.sms.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Admission {
	@Id
	@Size(min = 10, max = 10)
	@Pattern(regexp = "A[0-9]{9}", message = "Invalid ID")
	private String admissionId;

	@Size(min = 4, max = 4)
	@Pattern(regexp = "C[0-9]{3}", message = "Invalid Course ID")
	private String courseId;

	@Size(min = 7, max = 7)
	@Pattern(regexp = "S[0-9]{6}", message = "Invalid Student ID")
	private String studentId;

	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date admissionDate;

	public Admission() {
		this.admissionId = null;
	}

	public Admission(String courseId, String studentId, Date admissionDate) {
		this();
		this.courseId = courseId;
		this.studentId = studentId;
		this.admissionDate = admissionDate;
	}

	public String getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(String admissionId) {
		this.admissionId = admissionId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "{\n\t\"admissionId\":" + admissionId + ",\n\t \"courseId\":" + courseId + ",\n\t \"studentId\":"
				+ studentId + ",\n\t \"admissionDate\":" + admissionDate + "\n}";
	}

	
	
}
