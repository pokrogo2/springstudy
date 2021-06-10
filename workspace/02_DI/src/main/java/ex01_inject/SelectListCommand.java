package ex01_inject;

import javax.inject.Inject;
/*
 * @Inject
 * 객체의 타입(<bean class=">) 일치하는 객체 자동주입
 * 필드 생성자 setter를 대상으로함
 * 
 * 필드 이용해서 주입
 * @Inject
 * priavte Dao dao;
 * 생성자 이용
 * priavte Dao dao;
 * @Inject
 * */
public class SelectListCommand {
	/*
	private Dao dao;
	@Inject
	public SelectListCommand(Dao dao) {
		this.dao= dao; //매개변수 Dao dao에 주입
		
	}
	*/
	//3. setter
	private Dao dao;
	@Inject
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	public void execute() {
		dao.selectList();
	}
}
