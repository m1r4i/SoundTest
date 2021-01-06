import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    public static void setLoop(Boolean loop){
        Main.musicp.setLoop(loop);
    }
    public static void setVolume(int vol){
        Main.musicp.setVolume((byte) vol);
    }
    public static void reload(){
        if(!Files.exists(Paths.get("plugins/musics/"))){
            try {
                Files.createFile(Paths.get("plugins/musics/"));
            } catch (IOException e) {
            }
        }
        File folder = new File("plugins/musics/");
        Main.musicList.clear();
        for (File fileEntry : folder.listFiles()) {
            Main.musicList.put(fileEntry.getName().replace(".nbs",""),fileEntry);
            System.out.println(fileEntry.getName().replace(".nbs",""));
        }
    }
}
