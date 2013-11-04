package vista;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.Reserva;
import dao.daoMySql;
import dao.interfaceDao;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JComboBox<String> destino,origen, niños,adultos, tipo, pais;
	JButton boton = new JButton("enviar");
	
	
	
	
	public Ventana(){
	
		setSize(500,150);
		String[] arreglo = {"","Buenos Aires", "Montevideo", "Mar Del Plata", "Punta Del Este"};
		destino = new JComboBox<>(arreglo);
		origen = new JComboBox<>(arreglo);
		String[] arr= {"1","2", "3", "4", "5"};
		niños = new JComboBox<String>(arr);
		adultos = new JComboBox<String>(arr);
		String[] paises= {"Argentina","Uruguay", "Brasil"};
		pais = new JComboBox<String>(paises);
		String[] tipos = {"turista", "primera clase", "jubilados"};
		tipo = new JComboBox<String>(tipos);
		
		
		panel1.add(new JLabel("Origen: "));
		panel1.add(origen);
	    panel1.add(new JLabel("Destino: "));
	    panel1.add(destino);
	    
	    this.getContentPane().add(panel1,BorderLayout.NORTH);
	    
	    panel2.add(new JLabel("Adultos: "));
	    panel2.add(adultos);
	    panel2.add(new JLabel("Niños: "));
	    panel2.add(niños);
	    panel2.add(new JLabel("Pais: "));
	    panel2.add(pais);
	    
	    this.getContentPane().add(panel2,BorderLayout.CENTER);
	    
	    panel3.add(new JLabel("Tipo: "));
	    panel3.add(tipo);
	    panel3.add(boton);
	    
	    this.getContentPane().add(panel3,BorderLayout.SOUTH);
	    
	    boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interfaceDao dao = new daoMySql();
				Reserva r = new Reserva();
				r.origen  = (String) origen.getSelectedItem(); 
				r.destino = (String) destino.getSelectedItem();
				r.ninos = (String) niños.getSelectedItem();
				r.adultos = (String) niños.getSelectedItem();
				r.pais = (String) pais.getSelectedItem();
				r.categoria = (String) tipo.getSelectedItem();
				dao.guardar(r);
	
				
			}
		});
	}
	
	
	
	
	
		
	

	    
		
	
	
	public static void main(String[] args) {
		
		Ventana ventana  = new Ventana();
		ventana.setVisible(true);
		
		
		

	}

}
