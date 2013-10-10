package Ventana;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Ventana(){
		
		setSize(300,100);
		
		JPanel panel= new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3= new JPanel();
		JButton boton = new JButton("lalalala");
	    panel.add(boton);
		
		add(panel,BorderLayout.CENTER);
		
	}
	
	
	public static void main(String[] args) {
	    Ventana ven = new Ventana();
	    ven.setVisible(true);
	}

}
