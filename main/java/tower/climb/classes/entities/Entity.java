package tower.climb.classes.entities;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;

/**
 * A skeleton for every game object in this game. It holds the functionality used by all of them
 */
public abstract class Entity extends AnimatedSpriteObject
{	
	public Main Main;
	
	/**
	 * Constructor
	 * @param sprite The sprite used for this object, only exists to be send to super
	 * @param frameCount The framecount linked to the sprite, only exists to be send to super
	 * @param Main Reference to main class
	 */
	public Entity(Sprite sprite, int frameCount, Main Main)
	{
		super(sprite, frameCount);
		this.Main = Main;
	}

	/**
	 * Update Override, needs to exist but isnt used
	 */
	@Override
	public void update() 
	{
	}
	
	/**
	 * Setter, sets the position for the game object
	 * @param x The horizontal position in the game world
	 * @param y The vertical position in the game world
	 */
	public void setPosition(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Spawn instance of this Entity at a specified location
	 * @param x The horizontal position in the game world
	 * @param y The vertical position in the game world
	 */
	public void spawn(float x, float y)
	{
		Main.addGameObject(this, x, y);
	}
}
