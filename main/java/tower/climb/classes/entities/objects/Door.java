package tower.climb.classes.entities.objects;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;
import tower.climb.classes.entities.Entity;

/**
 * Door object, each floor has an entrance and exit door.
 * This object does nothing by itself and is only really used as visual object and reference for its position.
 */
public class Door extends Entity
{
	//Variables
	private int floornumber;
	private boolean isEntry;
	
	/**
	 * Constructor
	 * @param floor The floor number this door is linked to.
	 * @param isEntry Whether the door is the entry or exit door.
	 * @param Main Reference to main class.
	 */
	public Door(int floor, boolean isEntry, Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/Door.png"), 1, Main);
		floornumber = floor;
		this.isEntry = isEntry;
		setZ(1);
		
		//Finally add it to the game
		Main.addGameObject(this);
	}
	
	/**
	 * Getter
	 * @return Returns True if this is the entry door
	 */
	public boolean getIsEntry()
	{
		return isEntry;
	}
}
