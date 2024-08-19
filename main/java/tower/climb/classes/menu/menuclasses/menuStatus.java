package tower.climb.classes.menu.menuclasses;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;

/**
 * A class that acts as a skeleton for the statusses and holds the price and level.
 */
public class menuStatus extends menuItem
{
	protected float price;
	protected int level;
	
	/**
	 * Constructor
	 * @param icon Icon that belongs to this specific Status, it only acts to get passed to the super
	 * @param Main reference to main class, only here to get passed to super
	 */
	public menuStatus(Sprite icon, Main Main) 
	{
		super(icon, Main);
	}
	
	public void addLevel() 
	{
		level++;
		setLevel(level);
	}
	
	//Getter
	public float getPrice() 
	{
		return price;
	}
}
