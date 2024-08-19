package tower.climb.classes.menu;

import java.text.DecimalFormat;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import tower.climb.Main;
import tower.climb.classes.entities.Entity;
import tower.climb.classes.managers.TowerManager;

/**
 * A class for creating the HUD item that displays the amount of money the player has during the game.
 */
public class menuMoney extends Entity
{
	//Main reference
	public Main Main;
	
	//Sprite
	private final Sprite SPRITE = new Sprite("src/main/java/tower/climb/assets/moneyMenu.png");
	
	//Objects in this class
	TextObject dollarSign;
	TextObject moneyText;
	
	/**
	 * Constructor for the class, this calls the setup functions needed to display the money menu item
	 * @param Main A reference to the main class
	 */
	public menuMoney(Main Main) 
	{
		super(new Sprite("src/main/java/tower/climb/assets/moneyMenu.png"), 1, Main);
		this.Main = Main;
		createHolder();
		createText();
	}
	
	//Holder is this object
	/**
	 * Creates the HUD item that will contain the text information.
	 */
	private void createHolder()
	{
		final int xOffset = 25;
		final int yOffset = 25;
		
		int xPos = Main.getWorldWidth() - SPRITE.getWidth() - xOffset;
		int yPos = yOffset;
		setZ(-1); //Put it in a back layer
		Main.addGameObject(this, xPos, yPos);
	}
	
	/**
	 * Creates the HUD text on top of the holder.
	 * The text contains the money information.
	 * The text is generated as seperate objects
	 */
	private void createText()
	{
		//Text offsets
		final int xOffset = 5;
		final int yOffset = 12;
		final int Size = 40;
		
		//Dollar sign
		dollarSign = new TextObject("$", Size);
		dollarSign.setForeColor(0, 0, 0, 255);
		float dolXPos = this.getX() + xOffset;
		float dolYPos = this.getY() + yOffset;
		Main.addGameObject(dollarSign, dolXPos, dolYPos);
		
		//Amount text
		moneyText = new TextObject("", Size);
		moneyText.setForeColor(0, 0, 0, 255);
		float monXPos = dollarSign.getX() + (Size / 2);
		float monYPos = dollarSign.getY();
		Main.addGameObject(moneyText, monXPos, monYPos);
	}
	
	/**
	 * Setter than overrides the current amount of money
	 * @param money The amount to override the current amount with
	 */
	public void setMoneyText(float money)
	{
		String moneyString = Main.df.format(money);
		moneyText.setText(moneyString);
	}

}
