package Ventana;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SubirPedido extends JFrame {

	/**
	 * 
	 */
	JLabel label = new JLabel("texto: ");
	JTextField texto = new JTextField();
	JButton boton = new JButton("nada");
	
	private static final long serialVersionUID = 1L;
	
	public SubirPedido(){
		
		setSize(500,500);
		setLayout(null);
		
		Vector<Algo> v = new Vector<Algo>();
		Algo a = new Algo();
		a.id = 1;
		a.nombre = "cosito";
		a.desc = "algooo";
		v.add(a);
		a = new Algo();
		a.id = 2;
		a.nombre = "algomas";
		a.desc = "mucho de algo";
		v.add(a);
		a = new Algo();
		a.id = 3;
		a.nombre = "lala";
		a.desc = "lalala";
		v.add(a);
		a = new Algo();
		a.id = 1;
		a.nombre = "cosito";
		a.desc = "algooo";
		v.add(a);
		a = new Algo();
		a.id = 1;
		a.nombre = "cosito";
		a.desc = "algooo";
		v.add(a);
		JComboBox<Algo> combo = new JComboBox<Algo>(v);
		getContentPane().add(combo);
		combo.setBounds(100, 100, 100, 200);
		getContentPane().add(boton);
		boton.setBounds(100, 4, 100, 20);
		getContentPane().add(label);
		label.setBounds(0, 30, 100, 20);
		getContentPane().add(texto);
		texto.setBounds(110, 30, 100, 20);
		
		setVisible(true);
		
		
		
		
	}
	
}
