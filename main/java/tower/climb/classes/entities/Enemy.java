package tower.climb.classes.entities;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;
import tower.climb.classes.managers.MoneyManager;
import tower.climb.classes.managers.UpgradeManager;
import tower.climb.classes.menu.status.ClickStatus;

/**
 * The skeleton class for any Enemy in the game.
 */
public class Enemy extends Interactable
{
	//Main reference
	public Main Main;
		
	protected float respawnTimer;
	protected float moneyDrop;
	
	/**
	 * Constructor
	 * @param sprite The sprite for this enemy, this only exists to be send to super.
	 * @param frameCount The frameCount that belongs to the sprite, this only exists to be send to super.
	 * @param Main Reference to main class.
	 */
	public Enemy(Sprite sprite, int frameCount, Main Main)
	{
		super(sprite, frameCount, Main);
		this.Main = Main;
		this.setZ(5); //Move to foreground
		System.out.println("Enemy const done");
	}
	
	/**
	 * This needs to exist to work with the engine.
	 */
	@Override
	public void update()
	{
		super.update();
	}
	
	/**
	 * Check to see if the player clicked on the enemy, if so Deal damage to it.
	 */
	@Override
	public void mousePressed(int x, int y, int button)
	{
		//Check for incorrect mouse button or if cords are within enemy sprite cords
		if(button != 37 || x < getX() || x > getX() + getWidth() || y < getY() || y > getY() + getHeight())
		{
			return;
		}
		//Get damage
		float damage = Main.um.clickStatus.getDamage();
		System.out.println("Taking " + damage + " damage.");
		takeDamage(damage);
	}
	
	/**
	 * Enemy provides money on death before calling the super death handle.
	 */
	@Override
	protected void died()
	{
		Main.mm.AddMoney(moneyDrop);
		super.died();
	}
	
	/**
	 * Getter
	 * @return Returns the respawnTimer as a float
	 */
	public float getRespawnTimer()
	{
		return respawnTimer;
	}
}
