import java.util.*;

public class Test {
	
	public static void main (String args[]) {
		
		HashSet <User> l = new HashSet <User> ();
		User u1 = new User("test");
		User u2 = new User("bro");
		l.add(u1);
		l.add(u2);
		for (User u: l) {
			
			System.out.println(u.name);
		}
	}
}
