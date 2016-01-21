import java.awt.*;
import java.applet.Applet;
import java.util.Random;

public class BarHeights extends Applet
{
	
	private int MAX_HEIGHT;     // max height of buildings
	private int GAP;           // gap b/w buildings
	private int NUM_BARS;     // number of buildings
	
	/**
	 * This will take in three values from the driver 
	 * and initialize them to specific characteristics 
	 * of the building group.
	 * @param max_height max height of the buildings
	 * @param gap gap b/w the buildings
	 * @param num_bars the number of buildings
	 */
	public BarHeights (int max_height, int gap, int num_bars)
	{
		MAX_HEIGHT = max_height;
		GAP = gap;
		NUM_BARS = num_bars;
	}
	

	public void paint(Graphics page)
	{
		
		//Random generator function
		Random generator = new Random();
		
		//randomizes the number of buildings from 5 to 10
	    NUM_BARS = generator.nextInt(5) + 5;
		
		//Initializes the number of bars as well as the maximum height and the spacing between the bars
		// int MAX_HEIGHT = 300, GAP = 9;
		
		 int x, width, height;
		
		//Creates a white circle in the top left of the screen. This is the moon.
		page.setColor(Color.white);
	    page.fillOval (51, 50, 100, 100);
		
		//The background is set to black
		setBackground( Color.black);
		
		//The x coordinate of the first bar is set to the size of the gap between each subsequent bar
		x = GAP;
		
		//This for loop will draw a bar 'NUM_BARS' times
		for( int count = 0; count < NUM_BARS; count++)
		{
			//Generates a random height ant width for the bar
			height = generator.nextInt(MAX_HEIGHT) + 50;
			width = generator.nextInt(50) + 25;
			
			//Each integer is randomized to a number between 1 and 250, these stand for RGB values
			int r = generator.nextInt(250) + 1;
		    int g = generator.nextInt(250) + 1;
		    int b = generator.nextInt(250) + 1;
		    
		    //A color is created with the random RGB values set above
		    Color randomColor = new Color(r,g,b);
		    Color lightsOff = randomColor;
			
		    //This initializes the color of the bar to the random RGB value
		    page.setColor(randomColor);	
			
		    //A bar is drawn to represent the building
		    page.fillRect(x,  MAX_HEIGHT-height + 50, width, height);

		    	
		    	//This for loop will move up the building based on its randomized height
				for ( int i = 10; i < height - 5; i ++)
				{
					
					//A random color is created just like it was above
					r = generator.nextInt(250) + 1;
				    g = generator.nextInt(250) + 1;
				    b = generator.nextInt(250) + 1;
				    
				    //colorizes all windows unless "randLightNum" = 4 (lights will be off)
				    int randLightNum = generator.nextInt(7);
				    if (randLightNum == 4)
				    {
					    page.setColor(lightsOff);	
				    }
				    else
				    {
				    	randomColor = new Color(r,g,b);
						page.setColor(randomColor);
				    }
					
					
					
					//A square, 7X7 window is created 17 pixels to the right of the center of the building.
					//The height of the square is dictated by the "i" value, which starts at the bottom of the building.
					page.fillRect (((width)/2 - 2) + x + 6, MAX_HEIGHT - i + 50, 7, 7);
					
					//This is all the same as above, but another window is placed symmetrically to the left of the line of symmetry fot eh building.
					r = generator.nextInt(250) + 1;
				    g = generator.nextInt(250) + 1;
				    b = generator.nextInt(250) + 1;
				    
				    randLightNum = generator.nextInt(7);
				    if (randLightNum == 4)
				    {
					    page.setColor(lightsOff);	
				    }
				    else
				    {
				    	randomColor = new Color(r,g,b);
						page.setColor(randomColor);
				    }
				    
					page.fillRect (((width)/2 - 2) + x - 6, MAX_HEIGHT - i + 50, 7, 7);	
					
					//This if statement will ad another set of symmetrical windows if the building reaches a certain width
					if ( width > 50)
					{
						
						r = generator.nextInt(250) + 1;
					    g = generator.nextInt(250) + 1;
					    b = generator.nextInt(250) + 1;
					    
					    randLightNum = generator.nextInt(7);
					    if (randLightNum == 4)
					    {
						    page.setColor(lightsOff);	
					    }
					    else
					    {
					    	randomColor = new Color(r,g,b);
							page.setColor(randomColor);
					    }
					    
						page.fillRect (((width)/2 - 2) + x + 17, MAX_HEIGHT - i + 50, 7, 7);
						
						r = generator.nextInt(250) + 1;
					    g = generator.nextInt(250) + 1;
					    b = generator.nextInt(250) + 1;
					    
					    randLightNum = generator.nextInt(7);
					    if (randLightNum == 4)
					    {
						    page.setColor(lightsOff);	
					    }
					    else
					    {
					    	randomColor = new Color(r,g,b);
							page.setColor(randomColor);
					    }
						page.fillRect (((width)/2 - 2) + x - 17, MAX_HEIGHT - i + 50, 7, 7);
					}
					
					//10 is added to i, which moves the next set of mirrors up the wall.
					//If this was not in place, there would just be a line of squares in each pixel on the building
					i += 10;
				}
				
				//The color of the next building is randomized
				page.setColor(randomColor);
			
			//The location for the next building shifted to the right of the building before it
			x = x + width + GAP;
			  
			
		}
		
	}
}
