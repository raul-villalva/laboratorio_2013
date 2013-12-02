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

import anotaciones.ProcesadorDeAnotaciones;

import modelo.Movimiento;
import modelo.Paso;
import modelo.PistaDeBaile;
import modelo.Ritmo;

public class Ventana  extends JFrame implements Runnable {

	
	private static final long serialVersionUID = 1L;
	
	int width = 800 ;
	int heigth = 500;
	
	Ventana yo = this;
	
	
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
	JLabel consola = new JLabel("Estado: Listo");
	
	
	JPanel cabeza = new JPanel();
	JLabel titulo = new JLabel("ROBOTS EN LA PISTA DE BAILE"); 
	JButton comenzar = new JButton("Comenzar");
	
	JPanel centro = new JPanel();
	JPanel eleccion = new JPanel();
	
	
	ArrayList<RobotUi> lista_robotUi = new ArrayList<RobotUi>();
	JPanel pistas = new JPanel();
	int cantidad = 0;
	
	PistaDeBaile pistaDeBaile = new PistaDeBaile();
	
	ButtonGroup group = new ButtonGroup();
	
	
	class RobotUi extends JPanel {

		
		private static final long serialVersionUID = 1L;
		JTextArea area = new JTextArea(10,10);
		JRadioButton radioButton = new JRadioButton();
		JLabel muestra = new JLabel("muestra");
		
		public RobotUi(){
			
		
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
				e.printStackTrace();
			}
			
		}
		
	}
	 

		 
		 
	
	
	
	
	
	public Ventana() {
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
						for(RobotUi p : lista_robotUi){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						RobotUi robotUi =lista_robotUi.get(i);
						modelo.Robot roboLoco =pistaDeBaile.getRobots().get(i);
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
						robotUi.area.append("giro; \n");
					}
					
				}
			});
			botones.add(avance);
			avance.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(RobotUi p : lista_robotUi){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						RobotUi robotUi =lista_robotUi.get(i);
						modelo.Robot roboLoco = pistaDeBaile.getRobots().get(i);
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
						robotUi.area.append("avance; \n");
					}
					
				}
			});
			botones.add(retroceso);
			retroceso.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(RobotUi p : lista_robotUi){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						RobotUi robotUi =lista_robotUi.get(i);
						modelo.Robot roboLoco = pistaDeBaile.getRobots().get(i);
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
						robotUi.area.append("retroceso; \n");
					}
					
				}
			});
			botones.add(izquierda);
			izquierda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(RobotUi p : lista_robotUi){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						RobotUi robotUi =lista_robotUi.get(i);
						modelo.Robot roboLoco = pistaDeBaile.getRobots().get(i);
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
						robotUi.area.append("izquierda; \n");
					}
					
				}
			});
			botones.add(derecha);
			
			derecha.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					if(cantidad > 0){
						for(RobotUi p : lista_robotUi){					
							if(p.radioButton.isSelected()){					
								break;
							}
							i++;			
						}
						RobotUi robotUi =lista_robotUi.get(i);
						modelo.Robot roboLoco = pistaDeBaile.getRobots().get(i);
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
						robotUi.area.append("derecha; \n");
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
			cabeza.add(consola);
			comenzar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							Thread t = new Thread(yo);
							t.start();}
			});
		}
		
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
				boton.setSize(20, 10);
				boton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					    modelo.Robot r = new modelo.Robot();
					    r.setNombre("fulanito"+cantidad+1);
					    r.setId(cantidad+1);
					    r.setRitmo(new Ritmo());
						pistaDeBaile.getRobots().add(r);
					    RobotUi robotUi = new RobotUi();
						robotUi.radioButton.setSelected(true);
						lista_robotUi.add(robotUi);
						cantidad++;
					    pistas.add(robotUi);
					    validate();
						repaint();	
					}
				});
				eleccion.add(boton,BorderLayout.CENTER);	
				centro.add(pistas);	
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
	}
	

	@Override
	public void run() {
		ProcesadorDeAnotaciones procesador = new ProcesadorDeAnotaciones();
		//esto vendria a ser la parte de la entrega 2
		printSteps();
		//Aqui armo el json
		String query = procesador.armJson(pistaDeBaile);
		//Envio el json armado al server
		procesador.SendRequets(query,pistaDeBaile,consola);
	}

	
	
	
	
	
	
			
		
	
	
	/* Imprimo en la ventana los pasos, esto vendria a ser 
	 * la entrega dos mas una mejora, le puse todo en Thread 
	 * y no tiene ese lag e imprime todo paso por paso  */
	private void printSteps(){
		
		int ritmo_maximo = 0;
		for(modelo.Robot r : pistaDeBaile.getRobots()){
			if(r.getRitmo().getPasos().size() > ritmo_maximo){
				ritmo_maximo = r.getRitmo().getPasos().size();
			}
		}	
		int i = 0;
		modelo.Robot robot;
		while(i< ritmo_maximo){
			for(int j = 0; j < pistaDeBaile.getRobots().size();j++){
				robot = pistaDeBaile.getRobots().get(j);		
				RobotUi robotUi = lista_robotUi.get(j);
				if(robot.getRitmo().getPasos().size()>i){
				    Paso p= robot.getRitmo().getPasos().get(i);
					String muestra = "velocidad: "+p.getVelocidad()+", tiempo: "+p.getTiempo()+", movimento: "+p.getMovimiento().name()+"\n";
					robotUi.area.append(muestra);				
				}else{
					robotUi.area.append("termino. \n");			
				}			
			}
			i++;
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}	
		}
		
		
		
	}
	
	
	
	public static void main(String[] arg){
		Ventana v = new Ventana();
		v.setVisible(true);
		
	}

	
	
	
	

		
	
}
