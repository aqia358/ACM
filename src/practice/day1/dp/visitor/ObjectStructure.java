package practice.day1.dp.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

	private List<Element> list = new ArrayList<Element>();
	
	public void attach(Element element){
		list.add(element);
	}
	
	public void detach(Element element){
		list.remove(element);
	}
	
	public void display(Visitor visitor){
		for(Element v : list){
			v.accept(visitor);
		}
	}
}
