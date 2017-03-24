import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class BouncingBox extends JComponent {

	private ArrayList<BouncingFigure> figures = new ArrayList<BouncingFigure>();

	public void add(BouncingFigure f) {
		figures.add(f);
	}

	public void paintComponent(Graphics g) {
		for (BouncingFigure f : figures) {
			f.draw(g); f.move();
			
			if(f.leftBorderCollision()){
				f.setTrajectory(f.getTrajectory()-180);
			} else if(f.rightBorderCollision(getWidth())){
				f.setTrajectory(180-f.getTrajectory());
			} else if(f.lowerBorderCollision(getHeight())){
				f.setTrajectory(90+(270-f.getTrajectory()));
			} else if(f.upperBorderCollision()){
				f.setTrajectory(270+(90-f.getTrajectory()));
			}
		}
	}
}
