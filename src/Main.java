import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    public static Main instance;
    public static Song song;
    public static RadioSongPlayer musicp;
    @Override
    public void onEnable(){
        song = NBSDecoder.parse(new File("plugins/musics/discord.nbs"));
        musicp = new RadioSongPlayer(song);
        getCommand("discord").setExecutor(new Discord());
        instance = this;
    }
}
