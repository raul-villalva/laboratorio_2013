
public class Calc  {
	boolean[] tachado = new boolean[10000];
	
	public void inicializar(){
		for(int i = 0; i < 10000; i++){
			tachado[i] = true;
		}
	}


	public static void main(String[] args) {
		
	Calc c = new Calc();
	c.inicializar();
	long startTime = System.currentTimeMillis();

  
			for(int i = 0; i< 10000 ;i++){
			
			if(c.tachado[i])
				for(int k =2 ; k<i;k++)
					if(i % k == 0){
					
		              c.tachado[i] = false;
				
					for(int j=i;j<10000;j+=i)
				
								c.tachado[j] = false;
						
					
						
					}
			}
			for(int i=2;i<10000;i++){
				if(c.tachado[i])
			    	System.out.println(i+" es un numero primo");
				
			}
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);
	}
}


				
