package tower.climb.classes.entities;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;

/**
 * A skeleton class for a gameobject that has health, This is used for enemies and allies
 */
public class Interactable extends Entity
{
	//Main reference
	public Main Main;
	
	protected float health;
	protected float maxHealth;
	protected boolean isDead;
	
	/**
	 * Constructor
	 * @param sprite The sprite that belongs to this game object, only here to get passed to super
	 * @param frameCount , the framecount that comes with the sprite, only here to get passed to super
	 * @param Main Reference to main class
	 */
	public Interactable(Sprite sprite, int frameCount, Main Main) 
	{
		super(sprite, frameCount, Main);
		this.Main = Main;
		isDead = false;
	}
	
	/**
	 * Setter for the health of this object
	 * @param amount The amount this object should be set to
	 */
	public void setHealth(float amount)
	{
		health = amount;
		if(health > 0)
		{
			isDead = false;
		}
	}
	
	/**
	 * Gets called when this object is being damaged, reduces the health.
	 * When its 0 or below calls the died function
	 * @param amount The amount of damage the object takes
	 */
	public void takeDamage(float amount)
	{
		if(isDead)
		{
			return;
		}
		health -= amount;
		if(health <= 0)
		{
			health = 0;
			died();
		}
	}
	
	/**
	 * Gets called when the game object dies
	 */
	protected void died()
	{
		isDead = true;
		Main.deleteGameObject(this);
	}
	
	/**
	 * Getter to check if game object is alive or not
	 * @return Returns a true or false
	 */
	public boolean getIsDead()
	{
		return isDead;
	}
	
	/**
	 * Getter to check what the max health of this object is
	 * @return Returns the maxHealth as a float
	 */
	public float getMaxHealth()
	{
		return maxHealth;
	}
}
