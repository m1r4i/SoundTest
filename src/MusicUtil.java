import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;

public class MusicUtil {
    public static void addAllPlayers(){
        for(Player pp : Bukkit.getOnlinePlayers()) {
            Main.musicp.addPlayer(pp);
        }
    }
    public static void removeAllPlayers(){
        for(Player pp : Bukkit.getOnlinePlayers()) {
            Main.musicp.removePlayer(pp);
        }
    }
    public static void reload(){
        File folder = new File("plugins/musics/");
        Main.musicList.clear();
        for (File fileEntry : folder.listFiles()) {
            Main.musicList.put(fileEntry.getName().replace(".nbs",""),fileEntry);
            System.out.println(fileEntry.getName().replace(".nbs",""));
        }
    }
}
