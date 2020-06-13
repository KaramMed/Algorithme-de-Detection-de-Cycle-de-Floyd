package Cycle_de_Floyd;

import java.util.ArrayList;
import java.util.List;

public class Algorithme_de_Lievre_et_Tortue {
	
	
	
	// methode de detection de duplication
	public static int detecter_index(List<String> A) {
		int i = 0;
		int j = i + 2;
		String tortue = A.get(i);
		String lapin = A.get(j);
		
		int taille = A.size();
		int k;
		/*System.out.println(" A["+i+"] : "+tortue+" <==> A["+j+"] : "+lapin);*/
		while (true){
			i = ( i + 1 ) % ( taille );
			
			tortue = A.get(i);
			/*System.out.println(" A["+i+"] : "+tortue+" <==> A["+j+"] : "+lapin);*/
			if(tortue.equals(lapin)) break;
			
			j = ( j + 2 ) % ( taille );
			
			lapin = A.get(j);
			/*System.out.println(" A["+i+"] : "+tortue+" <==> A["+j+"] : "+lapin);*/
			if(tortue.equals(lapin)) break;
		}
		
		
		k = i;
		i = 0;
		lapin = A.get(k);
		tortue = A.get(i);
		
		while (!lapin.equals(tortue)){
			i = ( i + 1 ) % ( taille );
			k = ( k + 1 ) % ( taille );
			lapin = A.get(k);
			tortue = A.get(i);
			/*System.out.println(" A["+i+"] : "+lapin+" <==> A["+k+"] : "+lapin);*/
		}
		
		return i;
	}
	
	
	
	
	
public static void main(String[] args) {
	List<String> A = new ArrayList<String>();
	A.add("a"); A.add("b"); A.add("c"); A.add("d"); A.add("e");A.add("f");
	A.add("e");
	
	int i = detecter_index(A);
	System.out.println(" L element dupliqué A["+i+"] = "+A.get(i));
}
}
