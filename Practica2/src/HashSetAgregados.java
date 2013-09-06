import java.util.Collection;
import java.util.HashSet;

public class HashSetAgregados<E> 

{
   private HashSet<Integer> hs;
   private int cantidadAgregados = 0;
   public HashSetAgregados() {
   }
   public HashSetAgregados(int initCap, float loadFactor) {
	   hs = new HashSet<Integer>(initCap,loadFactor);
   }
   
   
   public boolean add(Integer e) {
	   cantidadAgregados++;
	   System.out.println("aca");
	   return hs.add(e); 
   }
 
   public boolean addAll(Collection<? extends E> c) {
	   System.out.println(c.size());
	   cantidadAgregados += c.size();
	   return hs.addAll((Collection<? extends Integer>) c);
   }
   public int getCantidadAgregados(){
	   return cantidadAgregados; 
   }
}