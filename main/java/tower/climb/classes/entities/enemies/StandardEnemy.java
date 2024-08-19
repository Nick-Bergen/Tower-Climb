package tower.climb.classes.entities.enemies;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.classes.entities.Enemy;
import tower.climb.Main;

/**
 * The default enemy that spawns on any floor without a special enemy linked to it.
 */
public class StandardEnemy extends Enemy
{
	private final float defaultRespawnTime = 5000; //5 sec
	private final float baseHealth = 5;
	private final float healthFactor = 3f;
	private final float baseMoneyDrop = 1;
	private final float moneyDropFactor = 2.7f;
	private int floor;
	
	/**
	 * Constructor, Sets health and how much money the enemy is worth.
	 * @param floor The floor this Enemy is linked to.
	 * @param Main Reference to main class
	 */
	public StandardEnemy(int floor, Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/slime_small.png"), 1, Main);
		respawnTimer = defaultRespawnTime;
		this.floor = floor;
		calculateHealth();
		calculateMoney();
	}
	
	/**
	 * Calculates the maxHealth of this Enemy and sets its current health to that.
	 */
	public void calculateHealth()
	{
		float health = (float) (baseHealth + Math.pow(floor, healthFactor));
		maxHealth = health;
		setHealth(maxHealth);
	}
	
	/**
	 * Calculates how much money this enemy should drop upon death.
	 */
	private void calculateMoney()
	{
		moneyDrop = (float) (baseMoneyDrop + Math.pow(floor - baseMoneyDrop, moneyDropFactor));
	}
	
	
	//getters
}
