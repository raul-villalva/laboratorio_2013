package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import Modelo.Menu;

import dao.MenuDao;
import dao.MenuDaoMysql;

public class AltaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param args
	 */
	
	JTextField nombre = new JTextField();
	JTextArea desc = new JTextArea();
	JTextField precio = new JTextField();
	JButton boton = new JButton("Enviar");
	
	
	public AltaMenu(){
		JLabel label = new JLabel("nombre: ");
		this.setSize(300, 400);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(null);
		{
			
			getContentPane().add(label);
			label.setBounds(0,0,70,20);
			getContentPane().add(nombre);
			nombre.setBounds(80, 0, 70, 20);
		}
		{
			label = new JLabel("Descripción: ");
			getContentPane().add(label);
			label.setBounds(0, 30, 100, 20);
			getContentPane().add(desc);
			desc.setBounds(100, 30, 100, 100);
		}
		
		{
			label = new JLabel("precio: ");
			getContentPane().add(label);
			label.setBounds(0, 200, 70, 20);
			getContentPane();add(precio);
			precio.setBounds(80, 200, 70, 20);;
		}
		
		{
			boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MenuDao md = new MenuDaoMysql();
					Menu m = new Menu();
					m.nombre = nombre.getText();
					m.desc = desc.getText();
					m.precio = Integer.parseInt(precio.getText());
					md.guardar(m);
					
				}
			});
			getContentPane().add(boton);
			boton.setBounds(30,250,100,30);
		}
		
		
		
		
		
		setVisible(true);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		AltaMenu alta = new AltaMenu();

	}

}
