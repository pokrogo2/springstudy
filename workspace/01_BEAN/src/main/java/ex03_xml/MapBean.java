package ex03_xml;

import java.util.Map;

public class MapBean {

	private Map<String, String> map;
	
	public void info() {
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" +entry.getValue());
		}
		
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
}
