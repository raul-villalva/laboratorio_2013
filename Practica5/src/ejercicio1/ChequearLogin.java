package ejercicio1;

import java.util.HashMap;
import java.util.Map;

public class ChequearLogin {
	Map<String,Usuario> usuarios = new HashMap<String,Usuario>();
	
	public ChequearLogin(){
		usuarios.put("juan", new Usuario("juan", "lala", "juannn"));
		usuarios.put("raul", new Usuario("raul", "alala", "raul er"));
		usuarios.put("fm9", new Usuario("fm9", "lala", "funes mori"));
		try {
			System.out.println(usuarios.get("fumala").pass);		
		} catch (NullPointerException e) {
			System.out.println("llegue");
		}
		
	

	}

}
