import java.applet.Applet;
import java.awt.Graphics;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;


public class Apple extends Applet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea = new JTextArea(100,100);
	int[] arreglo = new int[20];
	boolean llegue = false; 
	     
	      class Hilo implements Runnable {
            
	    	  int id;
	    	  
	    	public Hilo(int i){
	    		this.id = i;
	    	}  
	    	  
	    	  
			@Override
			public void run() {
				for(int i = 0;i<20;i++){
					arreglo[id] += 20;
					if(i==19 && ! llegue){
						
							llegue= true;
						     System.out.println("gane yo y soy el numero "+id);
						
					}
					repaint();
					
					Thread.currentThread();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
					 
						
						
						
					
					
					
				}
				
			}
	    	  
	      
	      
	      Thread[] ts = new Thread[20];
	      
	
	
	      
	      
	
	
	     public void init() {
	    	 this.setSize(200, 200);
	    	 this.add(textArea);
	    	 textArea.setText("lineass                     ");
	    	 for(int i=0; i< 5 ; i++){
	    		arreglo[i] = 0;
	    		 
	    		 Hilo h = new Hilo(i);
	    	
	    		 
	    	 }
	    	 
	    	 
	    	 
	     }
	
	     public void start() {
	    	 
	    	 
	    	 Executor e = Executors.newCachedThreadPool();
	    	 for(int i=0; i< 20 ; i++){
	    		 
	    		e.execute(new Hilo(i));
	    		/*= new Thread(new Hilo(i));
	    		t.start();*/
	    		 
	    	 }
			
		 }
	     
	     public void paint(Graphics g) {
	    	 
	    	 for(int i = 0;i<20;i++){
	    		 g.drawString(i+"-", 0, i*20);
	    		 g.drawRect(15, i*20, arreglo[i], 10);
	    		 
	    	 }
	    	 
	    	 
	     }
}
