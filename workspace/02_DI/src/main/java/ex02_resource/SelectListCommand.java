package ex02_resource;

import javax.annotation.Resource;

/*
 @Resource
  1.객체의 이름bean id이 일치하는 객체를 자동으로 주입
  2.필드 setter를 대상으로 한다. 생성자 불가
  */
public class SelectListCommand {
	/*1.
	@Resource
	private Dao boardDao;
	*/
	private Dao boardDao;
	@Resource
	public void setBoardDao(Dao boardDao) {//주입
		this.boardDao=boardDao;
	}
	public Dao getBoardDao() {
		return boardDao;
	}
	public void execute() {
		boardDao.selectList();
	}
}
