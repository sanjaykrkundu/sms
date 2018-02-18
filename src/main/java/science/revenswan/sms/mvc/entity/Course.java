package science.revenswan.sms.mvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course {
	@Id
	@Size(min = 4, max = 4)
	@Pattern(regexp = "C[0-9]{3}", message = "Invalid ID")
	private String courseId;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 15)
	private String courseName;

	@NotNull
	@Min(1)
	@Max(18)
	private short duration;

	@NotNull
	private float fee;

	@NotNull
	private float installmentFee;

	@NotNull
	private boolean isActive;

	public Course() {
	}

	public Course(String courseName, short duration, float fee, float installmentFee, boolean isActive) {
		this();
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.installmentFee = installmentFee;
		this.isActive = isActive;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public float getInstallmentFee() {
		return installmentFee;
	}

	public void setInstallmentFee(float installmentFee) {
		this.installmentFee = installmentFee;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", fee=" + fee
				+ ", installmentFee=" + installmentFee + ", isActive=" + isActive + "]";
	}

}
