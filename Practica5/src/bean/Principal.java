package bean;


import java.lang.reflect.Field;
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	Usuario u = new Usuario();
	u.setApellido("gil de cuarta");
	u.setLegajo("nada");
	u.setNombre("nombre");
	Class<? extends Usuario> c = u.getClass();
	
	
	for(Field f : c.getFields()){
		if(f.isAnnotationPresent(AlmacenarAtributo.class)){
			try {
				System.out.println(f.getName()+"  "+f.get(u));
				//AlmacenarAtributo aa= f.getAnnotation(AlmacenarAtributo.class);
				
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
				e.printStackTrace();
			}
			
		//	Annotation[] as = f.getAnnotations();
			
					
				
			}
			
		}
		
	}


	}


