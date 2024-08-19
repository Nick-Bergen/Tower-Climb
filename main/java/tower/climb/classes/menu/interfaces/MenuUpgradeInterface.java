package tower.climb.classes.menu.interfaces;

import tower.climb.classes.menu.menuclasses.menuStatus;

/**
 * An interface that the MenuUpgrades are bound to.
 * They are all required to have a menuStatus.
 */
public interface MenuUpgradeInterface 
{
	//Get
	public menuStatus getLinkedStatus();
}
