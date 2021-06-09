package ex03_xml;

import java.util.List;

public class ListBean {
	private List<String> list;
	
	public void info() {
		for(int i=0,length =list.size(); i<length; i++) {
			System.out.println((i+1)+"번째 요소 :"+list.get(i));
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}
