package ex03_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SelectListCommand {
	/*
	 @Autowired
	 @Inject
	 * 객체의 타입(<bean class=">) 일치하는 객체 자동주입
	 * 필드 생성자 setter를 대상으로함
	 *
	 */
	//필드주입
	/*@Autowired
	private Dao dao;
	*/
	
	
	//생성자 주입
	/*
	private Dao dao;
	public SelectListCommand() {}
	@Autowired
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	 */
	private Dao dao;
	public SelectListCommand() {}
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	/*@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}*/
	public Dao getDao() {
		return dao;
	}
	@Autowired
	@Qualifier("boardDao1")
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	public void execute() {
		dao.selectList();
	}
	
}
