/**
 * This is the Laser Base class. It will contain all the information relevant to the laser
 * such as movement, shooting, and being hit.
 *
 * @author
 * @version
 */

package spaceinvaders;

/*
 * import statements
 */

import objectdraw.DrawingCanvas;
import objectdraw.ActiveObject;
import objectdraw.VisibleImage;

import java.applet.AudioClip;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Image;
import javax.swing.JApplet;

/*
 * class declaration
 */

public class LaserBase extends ActiveObject implements KeyListener
{
 	/*
	 * constants
	 */

	private static final double DISTANCE = 5.0;

 	/*
	 * instance fields
	 */

	private VisibleImage crntImage;			// the .gif image of the laser base
	private Image deadBase;					// the .gif image of the hit laser base
	private DrawingCanvas theCanvas;		// the canvas for the game
	private AudioClip shootClip;			// the sound when base shoots

	/**
	 * Laser base constructor with the image and the aliens that it can shoot.
	 *
	 * @param image the base image that will appear on the canvas
	 * @param hitImage the base image when it is hit
	 * @param keyListener the component to use to listen to key events
	 * @param canvas the canvas in which the image is created
	 */

    public LaserBase (Image image, Image hitImage, Component keyListener,
    				  DrawingCanvas canvas)
    {
		canvas.addKeyListener (this);		// add key listener to the canvas
	  	keyListener.addKeyListener (this);	// add key listener to the active window
	  	keyListener.setFocusable (true);	// inform system that our applet gains focus

		crntImage = new VisibleImage (image, SpaceInvaders.RIGHT_BORDER / 2 - 13,
									  SpaceInvaders.BOTTOM_BORDER - 20, canvas);

		/*
		 * remember the values of relevant variables
		 */

		theCanvas = canvas;
		deadBase = hitImage;

		/*
		 * set up the sound file for a laser base shot
		 */

		Class metaObject = getClass ();
		shootClip = JApplet.newAudioClip (metaObject.getResource ("SIbaseShoot.wav"));
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
	 * Activates action when a key is pressed.
	 *
	 * @param e the key that was activated
	 */

	public void keyPressed (KeyEvent e)
	{
		switch (e.getKeyCode ())
		{
			case KeyEvent.VK_LEFT:  if (!this.atLeftBorder ())
									{
										this.moveLeft ();
									}
									break;
			case KeyEvent.VK_RIGHT: if (!this.atRightBorder ())
									{
										this.moveRight ();
									}
									break;
		}
	}

	/**
	 * Activates action when a key is released.
	 *
	 * @param e the key that was activated
	 */

	public void keyReleased (KeyEvent e)
	{
	}

	/**
	 * Activates action when a key is pressed and released.
	 *
	 * @param e the key that was activated
	 */

	public void keyTyped (KeyEvent e)
	{
	}

	/**
	 * Move the visible image the appropriate x,y pixels
	 *
	 * @param dx number of pixels to move on the X axis
	 * @param dy number of pixels to move on the Y axis
	 */

	public void move (double dx, double dy)
	{
		crntImage.moveTo (crntImage.getX () + dx, crntImage.getY () + dy);
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
