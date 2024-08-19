package tower.climb.classes.menu.upgrades;

import tower.climb.classes.menu.menuclasses.menuStatus;
import tower.climb.classes.menu.menuclasses.menuUpgrade;
import tower.climb.classes.menu.status.ClickStatus;
import tower.climb.Main;
import tower.climb.classes.managers.MoneyManager;
import tower.climb.classes.menu.interfaces.MenuUpgradeInterface;

/**
 * A menuUpgrade item specifically for the clickStatus.
 */
public class ClickUpgrade extends menuUpgrade implements MenuUpgradeInterface
{
	//Main reference
	public Main Main;
	
	private ClickStatus clickStatus;

	/**
	 * Constructor
	 * @param clickStatus the status that this menuUpgrade item is linked to
	 * @param Main Reference to the main class
	 */
	public ClickUpgrade(ClickStatus clickStatus, Main Main) 
	{
		super(clickStatus.getSprite(), Main);
		this.Main = Main;
		this.clickStatus = clickStatus;
		this.setTitle(clickStatus.getTitle());
	}

	/**
	 * Detection to see if the player clicked on this Icon.
	 * If this is the case the game attempts to purchace the upgrade for this menuUpgrade and handle it.
	 */
	@Override
	public void mousePressed(int x, int y, int button)
	{
		//Check for incorrect mouse button or if cords are within enemy sprite cords
		if(button != 37 || x < getX() || x > getX() + getWidth() || y < getY() || y > getY() + getHeight())
		{
			return;
		}
		//Can't afford the upgrade
		else if (!Main.mm.CanBuyUpgrade(clickStatus.getPrice()))
		{
			return;
		}
		clickStatus.addLevel();
		setLevel(clickStatus.getLevel());
		setPriceTag(clickStatus.getPrice());
	}
	
	/**
	 * getter that returns the status that this menuUpgrade is linked to.
	 */
	@Override
	public menuStatus getLinkedStatus() 
	{
		return clickStatus;
	}
}
