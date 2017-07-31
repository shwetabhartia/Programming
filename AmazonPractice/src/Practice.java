import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Iterator;

public class Practice {
	
	public void arrayList () {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.set(0, 0);
		Iterator<Integer> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.print("\t"+itr.next());
		}
		//System.out.println(al.get(2));
	}
	
	public void linkedList () {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		for (Integer ll : l) {
			System.out.print("\t"+ll);
		}
		
	}
	
	public void map () {
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Shweta");
		hm.put(2, "Pramod");
		for (Map.Entry<Integer, String> e : hm.entrySet()) {
			System.out.println(e.getKey() + e.getValue());
		}
	}
	
	public static void main(String args[]){
		Practice p = new Practice();
		p.arrayList();
		System.out.println();
		//p.linkedList();
		//p.map();
	}
}
