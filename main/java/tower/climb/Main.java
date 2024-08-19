package tower.climb;

import java.text.DecimalFormat;

//Imports
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.*;
import nl.han.ica.oopg.view.View;
import processing.core.PApplet;
import processing.core.PImage;
import tower.climb.classes.entities.backgrounds.FieldBG;
import tower.climb.classes.managers.MoneyManager;
import tower.climb.classes.managers.TowerManager;
import tower.climb.classes.managers.UpgradeManager;

/**
 *	The main class that manages the setups, updates and references
 */
public class Main extends GameEngine
{
	//Global decimal format
	public final DecimalFormat df = new DecimalFormat("###.##");
	//Managers
	public TowerManager tm;
	public MoneyManager mm;
	public UpgradeManager um;
	
	//Variables
	final int worldWidth = 1280;
	final int worldHeight = 720;
	private final PImage HUD = loadImage("src/main/java/tower/climb/assets/HUD.png");
	
	private long millis;
	
	/**
	 * 	The constructor for the Main class, when this gets called the game starts
	 */
	public static void main() 
	{
		String[] processingArgs = {"tower.climb.Main"};
		Main mySketch = new Main();
		//Start the game
		PApplet.runSketch(processingArgs, mySketch);
	}
	
	/**
	 * The setup that gets run at the start of the game. This creates all the main managers and calls their setup in turn.
	 * It also sets the screensize, Makes the HUD and background
	 */
	@Override
	public void setupGame() 
	{
		//Create managers - send Main as reference
		tm = new TowerManager(this);
		mm = new MoneyManager(this);
		um = new UpgradeManager(this);
		
		//Setup managers
		tm.setup();
		mm.setup();
		um.setup();
		
		//Setup world objects
		size(worldWidth, worldHeight);
		
		//HUD
		View view = new View(worldWidth, worldHeight);
		view.setBackground(HUD);
		setView(view);
		
		//fieldBG
		SpriteObject fieldbg = new FieldBG(this);
	}
	

	/**
	 * This function loops and calls updates to every gameObject
	 */
	@Override
	public void update() 
	{
		millis = millis();
		updateGame(); //Calls update for every gameObject
	}
	
	//Getters
	/**
	 * @return The width of the game
	 */
	public int getWorldWidth()
	{
		return worldWidth;
	}
	
	/**
	 * @return The height of the game
	 */
	public int getWorldHeight()
	{
		return worldHeight;
	}
	
	/**
	 * @return The time the game has been running for
	 */
	public long getMillis()
	{
		return millis;
	}
}
