package nl.han.ica.oopg.objects;

import processing.core.PGraphics;
import processing.core.PImage;

/**
 * The SpriteObject is a extension of GameObject. Instead of having a draw implementation you will need to provide an image/sprite.
 */
public abstract class SpriteObject extends GameObject {

	private Sprite sprite;
	
	/**
	 * Create a new SpriteObject with a Sprite object.
	 * @param sprite	The sprite
	 */
	public SpriteObject(Sprite sprite) {
		super();
		
		this.sprite = sprite;
		
		setWidth(sprite.getWidth());
		setHeight(sprite.getHeight());
	}
	
	/**
	 * Draws the image on the PGraphics object, this is fired by the GameEngine.
	 */
	@Override
	public void draw(PGraphics g)
	{
		g.image(sprite.getPImage(), x, y);
	}
	
	/**
	 * Get the PImage of the Sprite.
	 * @return PImage
	 */
	public PImage getImage()
	{
		return sprite.getPImage();
	}
	
	/**
	 * Set the sprite of the Sprite object
	 * @param sprite
	 */
	public void setSprite(Sprite sprite)
	{
		this.sprite = sprite;
	}
}
