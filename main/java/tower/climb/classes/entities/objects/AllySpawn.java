package tower.climb.classes.entities.objects;

import tower.climb.Main;
import tower.climb.classes.entities.allies.Soldier;

/**
 * The class that holds the position of an Ally spawn location.
 * Also handles the spawning of the Ally itself
 */
public class AllySpawn 
{
	//Main reference
	public Main Main;
	
	//Variables
	private Soldier Soldier;
	private boolean respawning;
	private float deathTime; //Time of death of enemy
	private float[] pos;
	
	/**
	 * Constructor, Creates a new Soldier that is bound to this specific spawner
	 * @param pos The spawning location for this specific Ally
	 * @param Main Reference to the main class
	 */
	public AllySpawn(float[] pos, Main Main) 
	{
		this.Main = Main;
		this.pos = pos;
		Soldier = new Soldier(Main);
		Soldier.spawn(pos[0], pos[1]);
	}

	/**
	 * Gameplay loop.
	 * Checks if the Ally is dead and times the respawntime if so.
	 * Respawns Ally when timer reaches respawntime.
	 */
	public void update()
	{
		//If ally isn't dead, move like normal
		if(!Soldier.getIsDead())
		{
			return;
		}
		//When ally dies start respawn timer
		else if(!respawning)
		{
			System.out.println("Starting Ally respawn timer now");
			deathTime = Main.getMillis();
			respawning = true;
			return;
		}
		//Spawn the Ally when timer hits
		else if(ReachedRespawnTimer())
		{
			System.out.println("Respawning Ally");
			Soldier.setHealth(Soldier.getMaxHealth());
			Soldier.spawn(pos[0], pos[1]);
			respawning = false;
		}
	}
	
	/**
	 * @return Returns true when timer reaches the allocated respawntime relative to death time
	 */
	private boolean ReachedRespawnTimer()
	{
		return Main.getMillis() > deathTime + Soldier.getRespawnTimer();
	}
	
	/**
	 * Getter
	 * @return Returns position of Ally spawn location.
	 */
	public float[] getPos()
	{
		return pos;
	}
	
}
