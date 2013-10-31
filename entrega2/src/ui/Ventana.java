package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import modelo.Movimiento;
import modelo.Paso;
import modelo.Ritmo;

public class Ventana extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	int width = 800 ;
	int heigth = 500;
	ArrayList<modelo.Robot> robots = new ArrayList<modelo.Robot>();
	
	
	JPanel botones = new JPanel();
	JButton giro = new JButton("giro");
	JButton avance = new JButton("avance");
	JButton retroceso = new JButton("retroceso");
	JButton izquierda = new JButton("izquierda");
	JButton derecha = new JButton("derecha");
	JLabel label_velocidad = new JLabel("velocidad: ");
	JTextField velocidad  = new JTextField(3);
	JLabel label_tiempo = new JLabel("tiempo: ");
	JTextField tiempo  = new JTextField(3);
	
	
	JPanel cabeza = new JPanel();
	JLabel titulo = new JLabel("ROBOTS EN LA PISTA DE BAILE"); 
	JButton comenzar = new JButton("Comenzar");
	
	JPanel centro = new JPanel();
	JPanel eleccion = new JPanel();
	
	
	ArrayList<Pista> lista_pistas = new ArrayList<Pista>();
	JPanel pistas = new JPanel();
	int cantidad = 0;
	
	 ButtonGroup group = new ButtonGroup();
	
	class Pista extends JPanel {

		
		private static final long serialVersionUID = 1L;
		JTextArea area = new JTextArea(10,10);
		JRadioButton radioButton = new JRadioButton();
		JLabel muestra = new JLabel("muestra");
		
		public Pista(){
			
		
			setBorder(BorderFactory.createLineBorder(Color.black));
			setSize(150, 100);
			
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("images/Robot2.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				setLayout(new BorderLayout(10,10));
				
				
			
				add(picLabel,BorderLayout.NORTH);
				
				add(muestra,BorderLayout.WEST);
				add(radioButton,BorderLayout.EAST);
				group.add(radioButton);
				
				setBorder(BorderFactory.createLineBorder(Color.black));
				add(area,BorderLayout.SOUTH);
				
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public Ventana(){
		setSize(width, heigth);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		{
			this.getContentPane().add(botones,BorderLayout.SOUTH);
			botones.add(giro);
			giro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					int i = 0;
					if(cantidad > 0){
						for(Pista p : lista_pistas){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						Pista pis =lista_pistas.get(i);
						modelo.Robot roboLoco = robots.get(i);
						Paso paso= new Paso();
						paso.setMovimiento(Movimiento.GIRO);
						try
						{
							paso.setTiempo(Integer.parseInt(tiempo.getText()));
							paso.setVelocidad(Integer.parseInt(velocidad.getText()));
						  
						}
						catch (NumberFormatException nfe)
						{
							paso.setTiempo(1);
							paso.setVelocidad(1);
						}
						roboLoco.getRitmo().getPasos().add(paso);
						pis.area.append("giro; \n");
					}
					
				}
			});
			botones.add(avance);
			avance.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(Pista p : lista_pistas){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						Pista pis =lista_pistas.get(i);
						modelo.Robot roboLoco = robots.get(i);
						Paso paso= new Paso();
						paso.setMovimiento(Movimiento.AVANCE);
						try
						{
							paso.setTiempo(Integer.parseInt(tiempo.getText()));
							paso.setVelocidad(Integer.parseInt(velocidad.getText()));
						  
						}
						catch (NumberFormatException nfe)
						{
							paso.setTiempo(1);
							paso.setVelocidad(1);
						}
						roboLoco.getRitmo().getPasos().add(paso);
						pis.area.append("avance; \n");
					}
					
				}
			});
			botones.add(retroceso);
			retroceso.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(Pista p : lista_pistas){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						Pista pis =lista_pistas.get(i);
						modelo.Robot roboLoco = robots.get(i);
						Paso paso= new Paso();
						paso.setMovimiento(Movimiento.RETROCESO);
						try
						{
							paso.setTiempo(Integer.parseInt(tiempo.getText()));
							paso.setVelocidad(Integer.parseInt(velocidad.getText()));
						  
						}
						catch (NumberFormatException nfe)
						{
							paso.setTiempo(1);
							paso.setVelocidad(1);
						}
						roboLoco.getRitmo().getPasos().add(paso);
						pis.area.append("retroceso; \n");
					}
					
				}
			});
			botones.add(izquierda);
			izquierda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(Pista p : lista_pistas){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						Pista pis =lista_pistas.get(i);
						modelo.Robot roboLoco = robots.get(i);
						Paso paso= new Paso();
						paso.setMovimiento(Movimiento.IZQUIERDA);
						try
						{
							paso.setTiempo(Integer.parseInt(tiempo.getText()));
							paso.setVelocidad(Integer.parseInt(velocidad.getText()));
						  
						}
						catch (NumberFormatException nfe)
						{
							paso.setTiempo(1);
							paso.setVelocidad(1);
						}
						roboLoco.getRitmo().getPasos().add(paso);
						pis.area.append("izquierda; \n");
					}
					
				}
			});
			botones.add(derecha);
			
			derecha.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(Pista p : lista_pistas){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						Pista pis =lista_pistas.get(i);
						modelo.Robot roboLoco = robots.get(i);
						Paso paso= new Paso();
						paso.setMovimiento(Movimiento.DERECHA);
						try
						{
							paso.setTiempo(Integer.parseInt(tiempo.getText()));
							paso.setVelocidad(Integer.parseInt(velocidad.getText()));
						  
						}
						catch (NumberFormatException nfe)
						{
							paso.setTiempo(1);
							paso.setVelocidad(1);
						}
						roboLoco.getRitmo().getPasos().add(paso);
						pis.area.append("derecha; \n");
					}
					
				}
			});
			botones.add(label_velocidad);
			botones.add(velocidad);
			velocidad.setText("1");
			botones.add(label_tiempo);
			botones.add(tiempo);
			tiempo.setText("1");
	
		}
		
		{
			this.getContentPane().add(cabeza,BorderLayout.BEFORE_FIRST_LINE);
			cabeza.add(titulo);
			cabeza.add(comenzar);
			comenzar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int ritmo_maximo = 0;
					for(modelo.Robot r : robots){
						if(r.getRitmo().getPasos().size() > ritmo_maximo){
							ritmo_maximo = r.getRitmo().getPasos().size();
						}
					}
					
					int i = 0;
					modelo.Robot robot;
					while(i< ritmo_maximo){
						for(int j = 0; j < robots.size();j++){
							robot = robots.get(j);		
							Pista pista = lista_pistas.get(j);
							if(robot.getRitmo().getPasos().size()>i){
							    Paso p= robot.getRitmo().getPasos().get(i);
								String muestra = "velocidad: "+p.getVelocidad()+", tiempo: "+p.getTiempo()+", movimento: "+p.getMovimiento().name()+"\n";
						
								
								pista.area.append(muestra);
						
								
							}else{
								pista.area.append("termino. \n");
							
							
							}
							
							
						}
					
						i++;
						try {
							Thread.currentThread();
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
					}
								
					
					
				}
			});
		}
		{
			this.getContentPane().add(centro,BorderLayout.CENTER);
			centro.setLayout(new BorderLayout());
			
			
		
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("images/robot.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				eleccion.setLayout(new BorderLayout());
				centro.add(eleccion,BorderLayout.WEST);
				eleccion.add(picLabel,BorderLayout.NORTH);
				JButton boton = new JButton("agregar Robot");
				boton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
					    modelo.Robot r = new modelo.Robot();
					    r.setNombre("fulanito"+cantidad);
					    r.setRitmo(new Ritmo());
					    robots.add(r);
						Pista pista = new Pista();
						if(cantidad == 0){
							pista.radioButton.setSelected(true);
						}
						lista_pistas.add(pista);
						cantidad++;
					    pistas.add(pista);
					    
					    validate();
						repaint();
					   
					     

						
					}
				});
				eleccion.add(boton,BorderLayout.CENTER);
				
				
				centro.add(pistas);
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			
		
	}
	
	public static void main(String[] arg){
		Ventana v = new Ventana();
		v.setVisible(true);
		
	}
}
