package tower.climb.classes.managers;

//Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Imports Local
import tower.climb.Main;
import tower.climb.classes.entities.objects.Floor;
import tower.climb.classes.entities.Enemy;
import tower.climb.classes.entities.enemies.*;

/**
 * The manager that contains the information about all the floors and what is in them.
 */
public class TowerManager 
{
	//Main reference
	public Main Main;
	
	//Variables
	private int minLevel;
	private int maxLevel;
	private ArrayList<Floor> floors;
	
	//A dictionary that holds all the floors with non-default enemies
	private Map<Integer, Enemy> enemyDict = new HashMap<Integer, Enemy>();
	
	/**
	 * Constructor
	 * @param Main Reference to main class
	 */
	public TowerManager(Main Main)
	{
		this.Main = Main;
	}
	
	/**
	 * Setup for manager, this gets called from main class at the start of the game after all managers are created.
	 * Sets the current level of the floors to 1 and creates the first floor
	 */
	public void setup()
	{
		minLevel = 1;
		maxLevel = 1;
		floors = new ArrayList<Floor>();
		addFloor(); //Add the 1st floor;
		System.out.println("setupFloor done");
	}
	
	/**
	 * Adds a new floor to the floors list
	 */
	public void addFloor()
	{
		floors.add(new Floor(floors.size() + 1, Main));
	}
	
	/**
	 * Getter
	 * @return returns an array with all the floors
	 */
	public ArrayList<Floor> getFloors()
	{
		return floors;
	}
	
	/**
	 * Getter for what type of enemy should be on the specified floor
	 * @param floor The specific floor for which the enemy needs to be checked
	 * @return returns a specific Enemy
	 */
	public Enemy getEnemyTypeForFloor(int floor)
	{
		if(enemyDict.containsKey(floor))
		{
			return enemyDict.get(floor);
		}
		else //Default enemy
		{
			return new StandardEnemy(floor, Main);
		}
	}
}
