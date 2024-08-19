package tower.climb.classes.entities.backgrounds;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;
import tower.climb.classes.entities.Entity;

/**
 * A simple class that acts as an object to visualize the games background.
 */
public class FieldBG extends Entity
{
	/**
	 * Constructor, setup for this gameobject and creates it.
	 * @param Main Reference to main class.
	 */
	public FieldBG(Main Main) 
	{
		//Sprite, framecount
		super(new Sprite("src/main/java/tower/climb/assets/fieldBG.png"), 1, Main);
		setPosition(0, 0);
		setZ(-999); //Put it in a back layer
		
		//Finally add it to the game
		Main.addGameObject(this);
	}
}
