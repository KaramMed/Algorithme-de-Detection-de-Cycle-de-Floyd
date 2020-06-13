package Cycle_de_Floyd;

import java.util.ArrayList;
import java.util.List;

public class Algorithme_de_Lievre_et_Tortue {
	
	
	
	// methode de detection de duplication
	public static int detecter_index(List<String> A) {
		// initialisation des index
		int i = 0;
		int j = i + 2;
		// initialisation des elements pointeurs 
		String tortue = A.get(i);
		String lapin = A.get(j);
		
		int taille = A.size();
		int k;
		
		// on va avancer le pointeur tortue d'un pas et le pointeur lapin de deux pas
		// on s'arrete quand ils pointent sur le meme element
		while (true){
			i = ( i + 1 ) % ( taille );
			
			tortue = A.get(i);
			if(tortue.equals(lapin)) break; 
			
			j = ( j + 2 ) % ( taille );
			
			lapin = A.get(j);
			if(tortue.equals(lapin)) break;
		}
		
		k = i; // l'indice 'k' : indice ou les deux pointeurs sont reunis
		i = 0;
		lapin = A.get(k);
		tortue = A.get(i);
		
		// on met l'un des pointeurs sur la case depart , et le deuxieme sur 'k'
		// on avance les pointeurs d'un pas et on s'arrete quand ils pointent sur le meme element
		
		while (!lapin.equals(tortue)){
			i = ( i + 1 ) % ( taille );
			k = ( k + 1 ) % ( taille );
			lapin = A.get(k);
			tortue = A.get(i);
		}
		
		// on retourne l'indice qui crée le cycle
		return i;
	}
	
	
	
	
	
public static void main(String[] args) {
	// Test
	List<String> A = new ArrayList<String>();
	A.add("a"); A.add("b"); A.add("c"); A.add("d"); A.add("e");A.add("f");
	A.add("e");
	
	int i = detecter_index(A);
	System.out.println(" L element dupliqué A["+i+"] = "+A.get(i));
}
}
