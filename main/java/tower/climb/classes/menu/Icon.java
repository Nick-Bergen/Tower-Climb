package tower.climb.classes.menu;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import tower.climb.Main;
import tower.climb.classes.menu.menuclasses.menuItem;

/**
 * A class to manage a sprite.
 * This is used for setting up HUD elements
 */
public class Icon extends SpriteObject
{
	private final int xOffset = 13;
	private final int yOffset = 14;
	private menuItem parent;
	
	/**
	 * Constructor for the Icon
	 * @param sprite The Image being used.
	 * @param parent What menuItem this Icon is meant for
	 * @param Main Reference to the main class
	 */
	public Icon(Sprite sprite, menuItem parent, Main Main) 
	{
		super(sprite);
		this.parent = parent;
		Main.addGameObject(this);
	}

	/**
	 * update override, though no update functionality is needed
	 */
	@Override
	public void update() 
	{
	}
	
	/**
	 * A setter to manage the position of the Icon
	 */
	public void setSpritePos()
	{
		this.setX(parent.getX() + xOffset);
		this.setY(parent.getY() + yOffset);
		this.setZ(parent.getZ() + 1); //move in front of parent
	}
}
