import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class buildingDRIVER extends Applet
 
{

	private BarHeights building;

	//-----------------------------------------------------------------
	//  Initializes the characteristics of the group of buildings
	//-----------------------------------------------------------------
	public void init()
	{
		//Random generator function
		Random generator = new Random();
		int num;
		num = generator.nextInt(5) + 10;
		
		building = new BarHeights (300, 9, num);
		
		setBackground (Color.black);
	}
	
	//-----------------------------------------------------------------
	//  Paints the buildings on the applet.
	//-----------------------------------------------------------------
	public void paint (Graphics page)
	{
		building.paint (page);
	}
	
}
