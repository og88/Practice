/**
 * This is the Alien class. It will contain all the information relevant for the alien
 * including the actions the alien will perform and the images associated with the alien.
 *
 * @author
 * @version
 */

package spaceinvaders;

/*
 * import statements
 */

import objectdraw.DrawingCanvas;
import objectdraw.VisibleImage;


import java.awt.Image;

/*
 * class declaration
 */

public class Alien
{
	/*
	 * constants
	 */

	private static final double DISTANCE = 10.0;

	/*
	 * instance fields
	 */

	private VisibleImage crntImage;		// current image visible on the coanvas
	private Image upImage, downImage;	// the two different images for the alien
	private Image deadAlien;			// the image to represent dead alien
	private DrawingCanvas canvas;		// the canvas for the game
	private int points;					// the point value of the alien

	/**
	 * Alien constructor with the two different images that will simulate movement and
	 * another to simulate the alien being hit.
	 *
	 * @param firstImage the first image that will appear on the canvas
	 * @param secondImage the second image that will appear on the canvas when the
	 *        alien moves
	 * @param deadImage the image to represent a dead alien
	 * @param x the X coordinate where the alien appears
	 * @param y the Y coordinate where the alien appears
	 * @param points the point value of the alien
	 * @param canvas the canvas in which the image is created
	 */
        
        new Alien(img1, img2, 1.0,2.0,5,canvas);

	public Alien (Image firstImage, Image secondImage, Image deadImage, double x,
				  double y, int points, DrawingCanvas canvas)
	{
		/*
		 * remember the values of relevant variables
		 */

		downImage = firstImage;
		upImage = secondImage;
		deadAlien = deadImage;
		this.points = points;
		this.canvas = canvas;

		crntImage = new VisibleImage (downImage, x, y, canvas);
	}

	/**
	 * Determine if the visible image is at the left border.
	 *
	 * @return true or false depending whether or not the visible image is at the left
	 *         border
	 */

	public boolean atLeftBorder ()
	{
		return ((crntImage.getX () - DISTANCE) < SpaceInvaders.LEFT_BORDER);
	}

	/**
	 * Determine if the visible image is at the right border.
	 *
	 * @return true or false depending whether or not the visible image is at the right
	 *         border
	 */

	public boolean atRightBorder ()
	{
		return ((crntImage.getX () + crntImage.getWidth () + DISTANCE) >
				SpaceInvaders.RIGHT_BORDER);
	}

	/**
	 * Determine if the visible image is at the bottom of the canvas.
	 *
	 * @return true or false depending whether or not the visible image is at the bottom
	 *         border
	 */

	public boolean hasLanded ()
	{
		return ((crntImage.getY () + crntImage.getHeight () * 2) >=
				SpaceInvaders.BOTTOM_BORDER);
	}

	/**
	 * Move the visible image the appropriate x,y pixels
	 *
	 * @param dx number of pixels to move on the X axis
	 * @param dy number of pixels to move on the Y axis
	 */

	public void move (double dx, double dy)
	{
		/*
		 * Flip the image so it looks like the alien is walking
		 */

		if (crntImage.getImage () == upImage)
		{
			crntImage.setImage (downImage);
		}
		else
		{
			crntImage.setImage (upImage);
		}

		crntImage.moveTo (crntImage.getX () + dx, crntImage.getY () + dy);
	}

	/**
	 * Move the appropriate number of pixels down.
	 */

	public void moveDown ()
	{
		this.move (0.0, DISTANCE);
	}

	/**
	 * Move the appropriate number of pixels left.
	 */

	public void moveLeft ()
	{
		this.move (-DISTANCE, 0.0);
	}

	/**
	 * Move the appropriate number of pixels right.
	 */

	public void moveRight ()
	{
		this.move (DISTANCE, 0.0);
	}
}