package tower.climb.classes.menu.menuclasses;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import tower.climb.Main;
import tower.climb.classes.entities.Entity;
import tower.climb.classes.menu.Icon;

/**
 * A HUD element that is a skeleton for any upgrade and status HUD element
 */
public class menuItem extends Entity
{
	//Main reference
	public Main Main;
	
	private final float TITLEXOFFSET = 125;
	private final float TITLEYOFFSET = 10;
	private final float LEVELYOFFSET = 15;
	protected Icon iconImg;
	protected TextObject titleObj;
	protected TextObject levelObj;
	
	/**
	 * Constructor, This also calls the functions to create the main HUD element for the menuItem
	 * @param icon The image that is linked to the specific status/upgrade combo.
	 * @param Main Reference to main class
	 */
	public menuItem(Sprite icon, Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/MenuItem.png"), 1, Main);
		this.Main = Main;
		createIcon(icon);
		createTitle();
		createLevelText();
		updatePositions();
	}
	
	/**
	 * Updates the position of all the elements bound to this HUD element
	 */
	public void updatePositions()
	{
		iconImg.setSpritePos();
		setTitlePos();
		setLevelPos();
	}
	
	/**
	 * Creates a new Icon thats linked to this menuItem
	 * @param icon The icon for the menuItem
	 */
	private void createIcon(Sprite icon)
	{
		iconImg = new Icon(icon, this, Main);
	}
	
	/**
	 * Setter to change the current Icon
	 * @param icon The Icon to replace the existing sprite with.
	 */
	protected void setIcon(Sprite icon)
	{
		iconImg.setSprite(icon);
	}
	
	/**
	 * Creates a new textObject that acts as the title for this menuItem
	 */
	private void createTitle()
	{
		titleObj = new TextObject("EmptyTitle", 18);
		Main.addGameObject(titleObj);
	}
	
	/**
	 * Updates the position of the linked Title
	 */
	private void setTitlePos()
	{
		float x = (this.getX() + TITLEXOFFSET);
		float y = (this.getY() + TITLEYOFFSET);
		titleObj.setX(x);
		titleObj.setY(y);
		titleObj.setZ(this.getZ() + 1); //move to foreground
	}
	
	/**
	 * Setter for the linked title
	 * @param title New title for the menuItem
	 */
	protected void setTitle(String title)
	{
		titleObj.setText(title);
	}
	
	/**
	 * Creates a new textObject that acts as the level for this menuItem
	 */
	private void createLevelText()
	{
		levelObj = new TextObject("Lvl: 0", 18);
		Main.addGameObject(levelObj);
	}
	
	/**
	 * Updates the position of the linked LevelText
	 */
	private void setLevelPos()
	{
		float x = (titleObj.getCenterX());
		float y = (titleObj.getY() + LEVELYOFFSET);
		levelObj.setX(x);
		levelObj.setY(y);
		levelObj.setZ(this.getZ() + 1); //move to foreground
	}
	
	/**
	 * Setter for the linked LevelText
	 * @param level new Level for the menuItem
	 */
	protected void setLevel(int level)
	{
		String newLevelString = "Lvl: " + level;
		levelObj.setText(newLevelString);
	}
	
}
