import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin {
    public static Main instance;
    public static Song song;
    public static RadioSongPlayer musicp;
    public static HashMap<String,File> musicList = new HashMap<>();
    public static boolean isPlaying = false;
    @Override
    public void onEnable(){
        MusicUtil ut = new MusicUtil();
        ut.reload();
        getCommand("discord").setExecutor(new Discord());
        getCommand("discord").setTabCompleter(new DiscordTab());
        instance = this;
    }
}
