package jg.ou.commom;

public class Course {
	
	private int course_id;
	private String course_name;
	private String course_dept;
	private String course_teacher;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_dept() {
		return course_dept;
	}
	public void setCourse_dept(String course_dept) {
		this.course_dept = course_dept;
	}
	public String getCourse_teacher() {
		return course_teacher;
	}
	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_dept=" + course_dept
				+ ", course_teacher=" + course_teacher + "]";
	}
	
	

}
