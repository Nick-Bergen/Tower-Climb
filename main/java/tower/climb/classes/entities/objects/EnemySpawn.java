package tower.climb.classes.entities.objects;

import nl.han.ica.oopg.objects.Sprite;
import tower.climb.Main;
import tower.climb.classes.entities.Enemy;
import tower.climb.classes.entities.Entity;

/**
 * The class that holds the position of the Enemy spawn location.
 * Also handles the spawning of the Enemy itself
 */
public class EnemySpawn
{
	//Main reference
	public Main Main;
		
	//Variables
	private Enemy enemy;
	private boolean respawning;
	private float deathTime; //Time of death of enemy
	private float[] pos;
	
	/**
	 * Constructor, This spawns the enemy on location upon creation.
	 * @param enemy The specific Enemy this spawner spawns.
	 * @param pos The position the Enemy spawns at.
	 * @param Main Reference to main class.
	 */
	public EnemySpawn(Enemy enemy, float[] pos, Main Main) 
	{
		this.Main = Main;
		this.enemy = enemy;
		this.pos = pos;
		enemy.spawn(pos[0], pos[1]);
	}
	
	/**
	 * Gameplay loop.
	 * Checks if the Enemy is dead and times the respawntime if so.
	 * Respawns enemy when timer reaches respawntime.
	 */
	public void update()
	{
		//Check if enemy has died
		if(!enemy.getIsDead())
		{
			return;
		}
		//When enemy dies start respawn timer
		else if(!respawning)
		{
			System.out.println("Starting respawn timer now");
			deathTime = Main.getMillis();
			respawning = true;
			return;
		}
		//Spawn the enemy when timer hits
		else if(ReachedRespawnTimer())
		{
			System.out.println("Respawning enemy");
			enemy.setHealth(enemy.getMaxHealth());
			enemy.spawn(pos[0], pos[1]);
			respawning = false;
		}
	}
	
	/**
	 * @return Returns true when timer reaches the allocated respawntime relative to death time
	 */
	private boolean ReachedRespawnTimer()
	{
		return Main.getMillis() > deathTime + enemy.getRespawnTimer();
	}
	
	/**
	 * Getter
	 * @return Returns position of Enemy spawn location.
	 */
	public float[] getPos()
	{
		return pos;
	}
}
