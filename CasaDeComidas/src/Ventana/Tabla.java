package Ventana;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class Tabla extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2499672780602884915L;
	JTable tabla = new JTable();
	
	public Tabla(){
		          setSize(500,500);
		          tabla.setSize(100, 50);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		String[] st = {"nombre", "apellido"};
		//m.addRow(st);
		String[] val = {"raul","villalva"};
		
		
		String[][] valores = {
					              {"raul","villalva"},
					              {"pedro","alfonzo"},
					              {"juan","perez"}
				              };
		DefaultTableModel m = new DefaultTableModel(valores,st);
	
		tabla.setModel(m);
		
		
		/*tabla.setValueAt("apellido", , 1);
		tabla.setValueAt("gato gato", 3, 1);
		tabla.setV*/
		add(tabla);
	}
	
	
	public static void main(String[] arg){
		
		Tabla t = new Tabla();
		t.setVisible(true);
		
	}
}
