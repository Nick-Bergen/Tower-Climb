package tower.climb.classes.menu.menuclasses;

import java.text.DecimalFormat;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import tower.climb.Main;

/**
 * The menuUpgrade class acts as a skeleton for all of the Upgrade items on the HUD
 */
public class menuUpgrade extends menuItem 
{
	//Main reference
	public Main Main;
	
	protected TextObject priceObj;
	
	/**
	 * Constructor
	 * @param icon The icon from the child class, this gets passed to the super
	 * @param Main Reference to main class
	 */
	public menuUpgrade(Sprite icon, Main Main) 
	{
		super(icon, Main);
		this.Main = Main;
		createPriceTag();
		updatePositions();
	}
	
	/**
	 * Changes the position of this menuItem 
	 */
	@Override
	public void updatePositions()
	{
		super.updatePositions();
		if(priceObj != null)
		{
			setPriceTagPos();
		}
	}
	
	/**
	 * Creates a new text object for the pricetag
	 */
	private void createPriceTag()
	{
		priceObj = new TextObject("$0", 18);
		Main.addGameObject(priceObj);
	}
	
	/**
	 * Updates the position of the price tag
	 * This gets called during the updating of the position of the entire menuItem
	 */
	private void setPriceTagPos()
	{
		float x = (titleObj.getCenterX());
		float y = (this.getCenterY());
		priceObj.setX(x);
		priceObj.setY(y);
		priceObj.setZ(this.getZ() + 1); //move to foreground
	}
	
	/**
	 * Setter for the current price
	 * @param price The price that the pricetag should show
	 */
	public void setPriceTag(float price)
	{
		String PriceTag = Main.df.format(price);
		PriceTag = "$" + PriceTag;
		priceObj.setText(PriceTag);
	}
}
