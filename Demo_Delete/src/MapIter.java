import java.awt.Event;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class MapIter {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		Map<String, String> newMap = new HashMap<String, String>() {
			{
				put("A", "B");
			}
		};
		
		//--list
		//arrayList
		List<String> lists = new ArrayList<String>() {
			{
				add("Value1");
				add("Value2");
			}
		};
		System.out.println("adfdsfg");
		ListIterator<String> itListIter = lists.listIterator();
		while (itListIter.hasPrevious()) {
			System.out.println(itListIter.next());
			
		}
		
		System.out.println();
		for (String list : lists) {
			System.out.print(list);
		}
		System.out.println();
		lists.forEach((v)->{System.out.print(v);});
		System.out.println();
		Iterator<String> value = lists.iterator();
		while(value.hasNext()) {
			System.out.print(value.next());
		}
		System.out.println();
		
		//linkedList
		LinkedList<String> listLinkedlist = new LinkedList<String>() {
			{
				add("LinkedValue1");
				add("LinkedValue2");
				addFirst("LinkedValue3");
				addLast("LinkedValue4");
			}
		};
		for (String list : listLinkedlist) {
			System.out.print(list);
		}
		System.out.println();
		listLinkedlist.forEach((v)->{System.out.print(v);});
		System.out.println();
		value = listLinkedlist.iterator();
		while(value.hasNext()) {
			System.out.print(value.next());
		}
		System.out.println();
		//vector
		Vector<String> listVector = new Vector<String>() {
			{
				add("VectorList1");
				add("VectorList2");
			}
		};
		for (String list : listVector) {
			System.out.print(list);
		}
		System.out.println();
		listVector.forEach((v)->{System.out.print(v);});
		System.out.println();
		value = listVector.iterator();
		while(value.hasNext()) {
			System.out.print(value.next());
		}
		System.out.println();
		//stack
		Stack<String> listStack = new Stack<String>() {
			{
				push("stackVal1");
				push("stackVal2");
			}
		};
		System.out.println("Stack file");
		for (int i = 0; i <= listStack.size(); i++) {
			System.out.println(listStack.pop());
			
		}
		System.out.println("Stack file");
		for (String list : listStack) {
			System.out.print(list);
		}
		System.out.println();
		listStack.forEach((v)->{System.out.print(v);});
		System.out.println();
		value = listStack.iterator();
		while(value.hasNext()) {
			System.out.print(value.next());
		}
		System.out.println("---------------------------------------------------------------------------------");
		//--Queue
		//Deque
		Queue<String> stringQueue = new LinkedList<String>() {
			{
				add("QueueValue1");
				add("QueueValue2");
			}
		};
		System.out.println();
		stringQueue.forEach((v)->{System.out.print(v);});
		System.out.println();
		//array deques
		//priority queue
		
		//--set
		//hashset
		Map<String, String> mapHash = new HashMap<String,String>() {
			{
				put("key1", "value1");
				put("key2", "value2");
			}
		};
		System.out.println();
		for(Map.Entry<String, String> mapval : mapHash.entrySet()) {
			System.out.print(mapval.getKey()+"-"+mapval.getValue()+" ");
		}
		System.out.println();
		mapHash.forEach((k,v)->{
			System.out.print(k+"-"+v+" ");
		});
		System.out.println();
		Iterator<Map.Entry<String, String>> iteratorMap = mapHash.entrySet().iterator();
		while(iteratorMap.hasNext()) {
			Map.Entry<String, String> it = iteratorMap.next();
			System.out.print(it.getKey()+"-"+it.getValue()+" ");
		}
		//linkedhashset
		//treeset
		
	}
	
}
