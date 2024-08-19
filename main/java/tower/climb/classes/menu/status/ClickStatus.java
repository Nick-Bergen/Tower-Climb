package tower.climb.classes.menu.status;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.classes.menu.interfaces.MenuStatusInterface;
import tower.climb.classes.menu.menuclasses.menuStatus;
import tower.climb.Main;

/**
 * the menuStatus class for handling the information of the Click status.
 * This contains the level, price and damage functionality amongst other things.
 */
public class ClickStatus extends menuStatus implements MenuStatusInterface 
{
	private final Sprite SPRITE = new Sprite("src/main/java/tower/climb/assets/Hand-Icon.png");
	private final String title = "Click damage";
	private final float baseCost = 5;
	private final float increaseFactor = 1.5f;
	private float damage;
	
	/**
	 * Constructor, starts at level 1
	 * @param Main Reference to the main class
	 */
	public ClickStatus(Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/Hand-Icon.png"), Main);
		this.setTitle(title);
		addLevel();
	}
	
	/**
	 * updates the current cost of the upgrade based on a calculation
	 */
	private void calculatePrice()
	{
		price = (float) (baseCost + (Math.pow(level, increaseFactor) * Math.pow(baseCost, increaseFactor / 3)) * (level - 1));
	}
	
	/**
	 *  updates the current damage that the clicks do
	 */
	private void calculateDamage()
	{
		damage = level + level * increaseFactor - increaseFactor;
	}
	
	/**
	 * Adds a level and recalculates the status values
	 */
	@Override
	public void addLevel() 
	{
		super.addLevel();
		calculatePrice();
		calculateDamage();
	}

	/**
	 * Getter for the title
	 * @return title Returns the name of the status
	 */
	@Override
	public String getTitle() 
	{
		return title;
	}

	/**
	 * Getter for the level
	 * @return level Returns the current level of the status
	 */
	@Override
	public int getLevel() 
	{
		return level;
	}
	
	/**
	 * Getter for the damage
	 * @return damage Returns the damage that the clicks do
	 */
	public float getDamage()
	{
		return damage;
	}

	/**
	 * Getter for the sprite
	 * @return SPRITE Returns the current image for this upgrade
	 */
	@Override
	public Sprite getSprite() 
	{
		return SPRITE;
	}

}
