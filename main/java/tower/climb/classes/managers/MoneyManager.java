package tower.climb.classes.managers;

import tower.climb.Main;
import tower.climb.classes.menu.menuMoney;

/**
 * The manager that holds all the info about the money and handles the functions surrounding it.
 */
public class MoneyManager 
{
	//Main reference
	public Main Main;
	
	//variables
	private menuMoney menuMoney;
	private float money;
	
	/**
	 * Constructor
	 * @param Main Reference to main class.
	 */
	public MoneyManager(Main Main)
	{
		this.Main = Main;
	}
	
	/**
	 * Setup for manager, this gets called from main class at the start of the game after all managers are created.
	 * Creates a new menuMoney item and updates this with the set money.
	 */
	public void setup()
	{
		menuMoney = new menuMoney(Main);
		money = 10;
		updateMenuMoney();
	}
	
	/**
	 * Adds a specified amount of money to the current amount.
	 * @param amount The amount getting added to the players money.
	 */
	public void AddMoney(float amount)
	{
		money += amount;
		updateMenuMoney();
	}
	
	/**
	 * Checks if the player can afford a specific cost, if so it automatically removes that amount from the money.
	 * @param cost The amount the player is trying to spent.
	 * @return Returns true or false based on if the player could afford it.
	 */
	public boolean CanBuyUpgrade(float cost)
	{
		if (cost > money)
		{
			return false;
		}
		
		money -= cost;
		updateMenuMoney();
		return true;
	}
	
	/**
	 * Updates the UI element. Call this whenever the value of money changes
	 */
	public void updateMenuMoney()
	{
		menuMoney.setMoneyText(money);
	}
	
	/**
	 * Getter
	 * @return Returns the current amount of money the player has
	 */
	public float GetMoney()
	{
		return money;
	}
}
