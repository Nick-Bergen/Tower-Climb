package tower.climb.classes.entities.allies;

import java.util.List;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;
import tower.climb.classes.entities.Enemy;
import tower.climb.classes.entities.Interactable;
import tower.climb.classes.entities.objects.Door;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;

/**
 * The basic Ally that fights for the player.
 */
public class Soldier extends Interactable implements ICollidableWithGameObjects
{
	//Main reference
	public Main Main;
		
	final int speed = 1;
	final float damage = 2.5f;
	protected float respawnTimer;
	
	/**
	 * Constructor, Initializes the health and spawn time for this Ally
	 * @param Main Reference to main class
	 */
	public Soldier(Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/Soldier.png"), 1, Main);
		this.Main = Main;
		this.setZ(6); //Move to foreground
		respawnTimer = 3500; //3.5 sec
		maxHealth = 10;
		setHealth(maxHealth);
	}
	
	/**
	 * Automatically move towards the left during the gameplay loop. (supposed to move in direction based on floor but not implemented)
	 */
	@Override
	public void update()
	{
		super.update();
		
		//Automatically move left
		setDirectionSpeed(270, speed);
        setCurrentFrameIndex(0);
	}
	
	/**
	 * Collision handling
	 * Deals damage to any Enemy it touches.
	 * Dies upon touching any Enemy or Door. (supposed to go to next floor but not implemented)
	 */
	@Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) 
	{
        for (GameObject g : collidedGameObjects) 
        {
        	//Touch enemy
            if (g instanceof Enemy) 
            {
                ((Interactable) g).takeDamage(damage);
                System.out.println("Ally hit enemy");
                died(); //Kill off ally after it dealt its damage
            }
            //Reach exit door
            else if (g instanceof Door && ((Door) g).getIsEntry() == false)
            {
            	died();
            }
        }
    }
	
	/**
	 * Getter
	 * @return Returns respawnTimer as float
	 */
	public float getRespawnTimer()
	{
		return respawnTimer;
	}

}
