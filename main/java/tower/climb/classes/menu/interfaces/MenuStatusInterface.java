package tower.climb.classes.menu.interfaces;

import nl.han.ica.oopg.objects.Sprite;

/**
 * An interface that the MenuStatusses are bound to.
 * They are all required to be able to level up and have getters for their information.
 */
public interface MenuStatusInterface 
{
	void addLevel();
	
	//Get
	public String getTitle();
	public int getLevel();
	public Sprite getSprite();
}
