package tower.climb.classes.managers;

import java.util.ArrayList;

import tower.climb.Main;
import tower.climb.classes.menu.*;
import tower.climb.classes.menu.menuclasses.*;
import tower.climb.classes.menu.status.*;
import tower.climb.classes.menu.upgrades.*;

/**
 * The manager that contains and manages all of the upgrades and statusses
 */
public class UpgradeManager 
{
	//Main reference
	public Main Main;
	
	//variables
	private final int statusListTopMargin = 100;
	private final int statusListYMargin = 15;
	private final int statusListXMargin = 25;
	private final int upgradeListLeftMargin = 15;
	private final int upgradeListYMargin = 50;
	private final int upgradeListXMargin = 15;
	
	private menuMoney menuMoney;
	public ClickStatus clickStatus; //Separate for referencing
	public ArrayList<menuItem> statuses;
	public ArrayList<menuItem> upgrades;

	
	/**
	 * Constructor
	 * @param Main Reference to main class
	 */
	public UpgradeManager(Main Main)
	{
		this.Main = Main;
	}

	/**
	 * Setup for manager, this gets called from main class at the start of the game after all managers are created.
	 * Sets up the lists, the money HUD element and creates all of the (currently only 1) status/upgrade combo's 
	 */
	public void setup()
	{
		statuses = new ArrayList<menuItem>();
		upgrades = new ArrayList<menuItem>();
		menuMoney = new menuMoney(Main);
		//Click
		clickStatus = new ClickStatus(Main);
		ClickUpgrade clickUpgrade = new ClickUpgrade(clickStatus, Main);
		addStatusUpgradeCombo(clickStatus, clickUpgrade);
	}
	
	/**
	 * A function that links a status and upgrade to the list at the same time so they have the same index.
	 * @param status The menuStatus that gets added to the list.
	 * @param upgrade The menuUpgrade that gets added to the list.
	 */
	public void addStatusUpgradeCombo(menuStatus status, menuUpgrade upgrade)
	{
		addStatus(status);
		addUpgrade(upgrade);
		upgrade.setPriceTag(status.getPrice());
	}
	
	/**
	 * Adds a new status to the list and sets it HUD element position
	 * @param status The status being added to the list
	 */
	private void addStatus(menuStatus status)
	{
		status.spawn(0, 0);
		statuses.add(status);
		setStatusPos(status);
	}
	
	/**
	 * Adds a new upgrade to the list and sets it HUD element position
	 * @param upgrade The upgrade being added to the list
	 */
	private void addUpgrade(menuUpgrade upgrade)
	{
		upgrade.spawn(0, 0);
		upgrades.add(upgrade);
		setUpgradePos(upgrade);
	}
	
	/**
	 * Sets the HUD element of the status to its position based on the index in the status array
	 * @param status The status that has his position updated
	 */
	private void setStatusPos(menuStatus status)
	{
		//Check validity of menuStatus
		if (!statuses.contains(status))
		{
			return;
		}
		int index = statuses.indexOf(status);
		float x = Main.getWorldWidth() - status.getWidth() - statusListXMargin;
		float y = statusListTopMargin + index * (status.getHeight() + statusListYMargin);
		statuses.get(index).setPosition(x, y);
		status.updatePositions();
	}
	
	/**
	 * Sets the HUD element of the upgrade to its position based on the index in the upgrade array
	 * @param upgrade The upgrade that has his position updated
	 */
	private void setUpgradePos(menuUpgrade upgrade)
	{
		//Check validity of menuUpgrade
		if (!upgrades.contains(upgrade))
		{
			return;
		}
		int index = upgrades.indexOf(upgrade);
		float x = upgradeListLeftMargin + index * (upgrade.getWidth() + upgradeListXMargin);
		float y = Main.getWorldHeight() - upgrade.getHeight() - upgradeListYMargin;
		upgrades.get(index).setPosition(x, y);
		upgrade.updatePositions();
	}
	
	/**
	 * Getter, Returns the status menuItem based on the given index
	 * @param index The index of the desired status menuItem
	 * @return The returned menuItem
	 */
	public menuItem getMenuItem(int index)
	{
		return statuses.get(index);
	}
}
