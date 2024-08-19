package tower.climb.classes.entities.objects;

import java.io.Console;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;
import tower.climb.classes.entities.Enemy;
import tower.climb.classes.entities.Entity;
import tower.climb.classes.managers.TowerManager;

/**
 * The floor class holds all the info and functions that manage a single floor.
 * This includes all the objects that appear in it.
 */
public class Floor extends Entity
{
	//Main reference
	public Main Main;
	public TowerManager tm; 
		
	//Variables
	private final Sprite SPRITE = new Sprite("src/main/java/tower/climb/assets/floor-long.png");
	private final int SPRITEFRAMECOUNT = 1;
	private final float DOOROFFSET = 20;
	private final float YOFFSET = 7;
	private Door entry;
	private Door exit;
	
	private int floorNumber;
	private boolean toRight;
	private float[] entryCords = new float[2];
	private float[] exitCords = new float[2];
	private float[] monsterCords = new float[2];
	
	private EnemySpawn spawner;
	private AllySpawn allySpawner;
	
	/**
	 * Constructor, Adds all the needed game objects upon creation.
	 * @param floorNumber The floor number of the tower.
	 * @param Main Reference to main class.
	 */
	public Floor(int floorNumber, Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/floor-long.png"), 1, Main);
		this.Main = Main;
		//floor info
		this.floorNumber = floorNumber;
		toRight = floorNumber % 2 == 0;
		
		System.out.println("[TESTING] sprite sizes: w:[" + SPRITE.getWidth() + "] h:[" + SPRITE.getHeight() + "]");
		//position
		setPosition(250, 375 - (floorNumber - 1) * SPRITE.getHeight());
		
		//Add internal objects
		addDoors();
		addSpawner();
		addAllySpawner();
		
		//Finally add it to the game
		Main.addGameObject(this);
	}
	
	/**
	 * Calls the children update classes that are timer based.
	 */
	@Override
	public void update()
	{
		spawner.update();
		allySpawner.update();
	}
	
	/**
	 * Updates the values of the objects bound to the floor.
	 */
	private void setCords()
	{
		entryCords[1] = this.getY() + this.getHeight() - entry.getHeight() - YOFFSET;
		exitCords[1] = this.getY() + this.getHeight()  - exit.getHeight() - YOFFSET;
		if(toRight)
		{
			entryCords[0] = this.getX() + DOOROFFSET;
			exitCords[0] = this.getX() + this.getWidth() - exit.getWidth() - DOOROFFSET;
			monsterCords[0] = exitCords[0] - DOOROFFSET - exit.getWidth();
		}
		else
		{
			entryCords[0] = this.getX() + this.getWidth() - entry.getWidth() - DOOROFFSET;
			exitCords[0] = this.getX() + DOOROFFSET;
			monsterCords[0] = exitCords[0] + DOOROFFSET + entry.getWidth();
		}
	}
	

	/**
	 * Adds the 2 doors as entrance and exit to the floor.
	 */
	private void addDoors()
	{
		//Create doors
		entry = new Door(floorNumber, true, Main);
		exit = new Door(floorNumber, false, Main);
		
		//right positions
		setCords();
		
		//Set the newly created objects at the created positions
		entry.setPosition(entryCords[0], entryCords[1]);
		exit.setPosition(exitCords[0], exitCords[1]);
	}
	
	/**
	 * Adds a spawner object for the Enemy that belongs on this floor
	 */
	private void addSpawner()
	{
		//Get enemy type from TowerManager
		Enemy enemy = Main.tm.getEnemyTypeForFloor(floorNumber);
		//Calculate enemy y level
		monsterCords[1] = this.getY() + this.getHeight() - enemy.getHeight() - YOFFSET;
		
		//Create enemyspawn for this floor with provided enemy
		spawner = new EnemySpawn(enemy, monsterCords, Main);
	}
	
	/**
	 * Adds the spawn location for the allies at the entrance door location
	 */
	private void addAllySpawner()
	{
		float[] allyCords = new float[2];
		allyCords[0] = entryCords[0];
		allyCords[1] = entryCords[1] + 7;
		allySpawner = new AllySpawn(allyCords, Main);
	}
	
	/**
	 * Getter
	 * @return Returns floorNumber as int
	 */
	public int getFloorNumber()
	{
		return floorNumber;
	}
	
	/**
	 * Getter, Returns if the orientation of the floor is from left to right or vice versa.
	 * @return Returns True if the entrance of the floor is located left and the exit right.
	 */
	public boolean getToRight()
	{
		return toRight;
	}
	
	/**
	 * Getter for the entry door
	 * @return Returns float array with the entry doors coordinates.
	 */
	public float[] getEntryCords()
	{
		setCords();
		return entryCords;
	}
	
	/**
	 * Getter for exit door
	 * @return Returns float array with the exit doors coordinates.
	 */
	public float[] getExitCords()
	{
		setCords();
		return exitCords;
	}
	
	/**
	 * Getter for the monster location
	 * @return Returns float array with the monster coordinates
	 */
	public float[] getMonsterCords()
	{
		setCords();
		return monsterCords;
	}
}
