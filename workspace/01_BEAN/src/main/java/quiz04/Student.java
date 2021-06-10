package quiz04;

public class Student {
	private String name;
	private Lecture lecture;
	
	public Student() {}

	public Student(String name, Lecture lecture) {
		super();
		this.name = name;
		this.lecture = lecture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	public void info() {
		System.out.println("이름 : " +name);
		System.out.println("강의 명 : " + lecture.getName());
		System.out.println("교수님 : " + lecture.getProfessor());
	}
}
