import java.util.ArrayList;


public class pruebaHash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSetAgregados<Integer> hst = new HashSetAgregados<Integer>();
		
		ArrayList<Integer> ara= new ArrayList<Integer>();
		ara.add(1);
		ara.add(3);
		hst.addAll(ara);
		System.out.println(hst.getCantidadAgregados());

	}

}
