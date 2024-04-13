/**
 * This program is designed to simulate the game of space invaders. It will create all
 * of the necessary images and objects relevant to the game.
 *
 * @author Darius 
 * @version Unit 4
 */

package spaceinvaders;

/*
 * import statements
 */

import objectdraw.WindowController;
import objectdraw.FilledRect;
import java.awt.Image;

/*
 * class declaration
 */

public class SpaceInvaders extends WindowController
{
	/*
	 * constants
	 */

	public static final int LEFT_BORDER = 0;
	public static final int RIGHT_BORDER = 400;

	public static final int TOP_BORDER = 0;
	public static final int BOTTOM_BORDER = 300;

	/*
	 * Create the images and any other objects necessary to run the game.
	 */

	public void begin ()
	{
		/*
		 * create the canvas for the game
		 */

		new FilledRect (LEFT_BORDER, TOP_BORDER, RIGHT_BORDER, BOTTOM_BORDER, canvas);
		this.resize (RIGHT_BORDER, BOTTOM_BORDER);

		/*
		 * create the image of the laser base
		 */

		Image siBaseImage = getImage ("SIbase.gif");
		Image siBaseBlast = getImage ("SIbaseBlast.gif");

		LaserBase base = new LaserBase (siBaseImage, siBaseBlast, this,	canvas);

		/*
		 * create the images of the aliens and the hit alien
		 */

		Image siTopDown = getImage ("SItop0.gif");
		Image siTopUp = getImage ("SItop1.gif");

		Image siMiddleDown = getImage ("SImiddle0.gif");
		Image siMiddleUp = getImage ("SImiddle1.gif");

		Image siBottomDown = getImage ("SIbottom0.gif");
		Image siBottomUp = getImage ("SIbottom1.gif");

		Image siHitAlien = getImage ("SIinvaderBlast.gif");

		Invaders spaceinvaders = new Invaders(siTopDown, siTopUp, 
                                      siMiddleDown, siMiddleUp, siBottomDown, 
                                      siBottomUp, siHitAlien, canvas);
	}
}