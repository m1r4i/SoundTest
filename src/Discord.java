import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Discord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        for(Player pp : Bukkit.getOnlinePlayers()) {
            Main.musicp.addPlayer(pp);
        }
        Main.musicp.setPlaying(true);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                Main.musicp.setPlaying(false);
                for(Player pp : Bukkit.getOnlinePlayers()) {
                    Main.musicp.removePlayer(pp);
                }
            }
        }, 160L);
        return true;
    }
}
