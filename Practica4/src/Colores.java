import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Colores extends JApplet {

	/**
	 * 
	 */
	JComboBox<String> combo = new JComboBox<String>();
	JTextField texto = new JTextField(4);
	JButton agregar = new JButton("agregar");
	JButton borrar = new JButton("borrar");
	DefaultComboBoxModel<String> modelo;
	
	Vector<String> colores = new Vector<String>();
	private static final long serialVersionUID = 1L;
	
	
	public void start(){
		JPanel panel = new JPanel();
		modelo= new DefaultComboBoxModel<String>(colores);
		this.getContentPane().add(panel);
		combo = new JComboBox<>(modelo);
		panel.add(combo);
		panel.add(texto);
		panel.add(agregar);
		panel.add(borrar);
		
		agregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(texto.getText() != ""){
					
					modelo.addElement(texto.getText());
					combo.setModel(modelo);
				}
				
			
				texto.setText("");
				
			}
		});
		
		
		
		
	}
	
	

}
