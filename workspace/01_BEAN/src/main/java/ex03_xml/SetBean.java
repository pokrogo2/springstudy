package ex03_xml;

import java.util.Iterator;
import java.util.Set;

public class SetBean {
	private Set<String> set;
	
	
	public void info() {
		Iterator<String> itr=set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}


	public Set<String> getSet() {
		return set;
	}


	public void setSet(Set<String> set) {
		this.set = set;
	}
	
}
