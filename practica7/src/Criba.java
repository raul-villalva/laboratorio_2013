
public class Criba implements Runnable

{

	/**
	 * @param args
	 */
	int[] numeros =  new int[10000];
	static boolean[] tachado = new boolean[10000];
	
	
	public void inicializar(){
		for(int i = 0; i < 10000; i++){
			numeros[i] = i;
			tachado[i] = true;
			
		}
		
		
	};
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
         Criba c = new Criba();
         Thread[] hilos = new Thread[10];
         c.inicializar();
         for(int i=0;i<10;i++){
 			Calc r = new Calc();
 			hilos[i] = new Thread(c,"hilo n°"+i+1);
 			
 		}
         
		for(int i=0;i<10;i++){
			hilos[i].start();			
		}
		
		for(int i=2;i<10000;i++){
			if(tachado[i])
		    	System.out.println(i+" es un numero primo");
			
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);

	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10000 ;i++){
			
			if(tachado[i]){
				for(int k =2 ; k<i;k++){
					if(i % k == 0){
						synchronized (tachado) {
								tachado[i] = false;
						}
						for(int j=i;j<100;j+=i){
							synchronized (tachado) {
									tachado[j] = false;
							}		
						}
						
					}
				}
				  
				
			}
		}
		
	}

}
