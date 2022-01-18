import org.bukkit.Bukkit
import org.bukkit.GameRule
import org.bukkit.plugin.java.JavaPlugin

class SamplePlugin : JavaPlugin() {
    override fun onEnable() {
        for (world in Bukkit.getWorlds()) {
            world.setGameRule(GameRule.SPAWN_RADIUS, 0)
        }
    }
}