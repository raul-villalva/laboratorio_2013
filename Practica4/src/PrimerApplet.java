import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PrimerApplet extends Applet implements MouseListener {

	int x = 20;
	int y = 20;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g){
		   g.setColor(Color.RED);
		   this.setBackground(Color.BLUE);
		   
	   g.drawOval(x, y, 15, 25);
	}
	
    public void start(){
    	
    	
    	repaint();
    	this.addMouseListener(this);
    	
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	     
		x = e.getX();
		y = e.getY();
		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
