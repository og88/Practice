/**
 * This is the Invaders class.  It's a container class that will perform actions relevant
 * to all of the aliens in the game.
 *
 * @author Darius Harvey
 * @version Lab 5
 */

package spaceinvaders;

/*
 * import statements
 */

import objectdraw.ActiveObject;
import objectdraw.DrawingCanvas;

import java.awt.Image;
import java.applet.AudioClip;
import javax.swing.JApplet;

/*
 * class declaration
 */

public class Invaders extends ActiveObject
{
	/*
	 * constants
	 */

	private enum Direction {LEFT, RIGHT}

	private static final int DELAY = 300;
        
        Alien[] top;
        Alien[] bottom;
        Alien[] middle;
    
    private final int Width = SpaceInvaders.RIGHT_BORDER /50;

	/*
	 * instance fields
	 */

	private AudioClip moveClip;		// the sound aliens make when they move

	/**
	 * Invaders constructor with images for the different alien views as well as one
	 * being hit.
	 *
	 * @param topDown image of the top row alien with hands down
	 * @param topUp image of the top row alien with hands up
	 * @param midDown image of the top row alien with hands down
	 * @param midUp image of the top row alien with hands up
	 * @param botDown image of the top row alien with hands down
	 * @param botUp image of the top row alien with hands up
	 * @param hit the image to represent a dead alien
	 * @param canvas the canvas in which the image is created
	 */

	public Invaders (Image topDown, Image topUp, Image midDown, Image midUp,
					 Image botDown, Image botUp, Image hit, DrawingCanvas canvas)
	{
		/*
		 * create and initialize point values
		 */
        int[] points = {1,2,3};
        /*
		 * create the arrays that will contain aliens
		 */
        top = new Alien[Width];
        bottom = new Alien [Width];
        middle = new Alien [Width];
		/*
		 * create the aliens
		 */
        for (int i = 0; i < Width; i++)
        {
        top[i] = new Alien (topDown, topUp, hit, 30*i, 0.0, points[2], canvas);
	middle[i] = new Alien (midDown, midUp, hit, 30*i, 30.0, points[1], canvas);
	bottom[i] = new Alien (botDown, botUp, hit, 30*i, 60.0, points[0], canvas);
        }
		/*
		 * set up the sound file for alien movement
		 */

		Class metaObject = getClass ();
		moveClip = JApplet.newAudioClip (metaObject.getResource ("SImove.wav"));

		start ();						// set the object in motion
	}

	/**
	 * Determine if the aliens are at the left border.
	 *
	 * @return true or false depending whether or not any one of the aliens is at the
	 *         left border
	 */
        public boolean atLeftBorder(){
            for (int i = 0; i < Width; i++)
        {
        if(top[i].atLeftBorder()){
            return true;
        }
	if(middle[i].atLeftBorder()){
            return true;
        }
	if(bottom[i].atLeftBorder()){
            return true;
        }
        }
            return false;
        }

	/**
	 * Determine if the aliens are at the right border.
	 *
	 * @return true or false depending whether or not any one of the aliens is at the
	 *         right border
	 */
        
        public boolean atRightBorder(){
            for (int i = Width - 1; i >= 0; i--)
        {
        if(top[i].atRightBorder()){
            return true;
        }
	if(middle[i].atRightBorder()){
            return true;
        }
	if(bottom[i].atRightBorder()){
            return true;
        }
        }
            return false;
        }

	/**
	 * Determine if the aliens have landed.
	 *
	 * @return true or false depending whether or not any one of the aliens has landed
	 */
        public boolean haveLanded(){
          for (int i = 0; i < Width; i++)
        {
        if(bottom[i].hasLanded()){
            return true;
        }
        if(middle[i].hasLanded()){
            return true;
        }
        if(top[i].hasLanded()){
            return true;
        }
        } 
          return false;
        }
        

	/**
	 * Move all of the visible aliens down
	 */

        public void moveDown(){
            for (int i = 0; i < Width; i++)
            {
            bottom[i].moveDown();
            }
            for (int i = 0; i < Width; i++)
            {
            middle[i].moveDown();
            }
            for (int i = 0; i < Width; i++)
            {
            top[i].moveDown();
            }
        }
        
	/**
	 * Move all of the visible aliens left
	 */
        
        public void moveLeft(){
            for (int i = 0; i < Width; i++)
        {
        top[i].moveLeft();
	middle[i].moveLeft();
	bottom[i].moveLeft();
        }
        }
        
	/**
	 * Move all of the visible aliens right
	 */
        
        public void moveRight(){
            for (int i = Width - 1; i >= 0; i--)
        {
        top[i].moveRight();
	middle[i].moveRight();
	bottom[i].moveRight();
        }
        }

	/**
	 * Run the aliens until the game is over
	 */

	public void run ()
	{
		Direction direction = Direction.RIGHT;

		while (!this.haveLanded ())
		{
			if ((direction == Direction.RIGHT) && this.atRightBorder())
			{
				this.moveDown ();
				direction = Direction.LEFT;
			}
			else if	((direction == Direction.LEFT) && this.atLeftBorder ())
			{
				this.moveDown ();
				direction = Direction.RIGHT;
			}
			else if (direction == Direction.RIGHT)
			{
				this.moveRight ();
			}
			else
			{
				this.moveLeft ();
			}

			moveClip.play ();
			pause (DELAY);
		}
		System.out.println ("GAME OVER!");
	}
}