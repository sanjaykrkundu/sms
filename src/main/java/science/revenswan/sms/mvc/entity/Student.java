package science.revenswan.sms.mvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
	@Id
	@Size(min = 7, max = 7)
	private String studentId;

	@NotNull
	@Size(min = 3, max = 20)
	private String studentName;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	@NotNull
	@Size(min = 3, max = 20)
	private String father;

	@NotNull
	@Size(min = 3, max = 20)
	private String mother;

	@Column(unique = true)
	@NotNull
	@Size(min = 12, max = 12)
	private String uid;

	@NotNull
	@Size(min = 10, max = 10)
	@Pattern(regexp = "[6789][0-9]{9}")
	private String phone;

	@Size(min = 0, max = 10)
	@Pattern(regexp = "([6789][0-9]{9})")
	private String altPhone;

	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2)
	private String state;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 20)
	private String city;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30)
	private String addr;

	public Student() {
		studentId = null;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAltPhone() {
		return altPhone;
	}

	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "{\n\t\"studentId\":" + studentId + ",\n\t \"studentName\":" + studentName + ",\n\t \"dob\":" + dob
				+ ",\n\t \"father\":" + father + ",\n\t \"mother\":" + mother + ",\n\t \"uid\":" + uid
				+ ",\n\t \"phone\":" + phone + ",\n\t \"altPhone\":" + altPhone + ",\n\t \"email\":" + email
				+ ",\n\t \"state\":" + state + ",\n\t \"city\":" + city + ",\n\t \"addr\":" + addr + "\n}";
	}

	

}
