import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class Discord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        MusicUtil ut = new MusicUtil();
        if(strings.length < 1){
            commandSender.sendMessage("§cファイル名を入力してください。");
            return true;
        }
        if(Main.musicList.containsKey(strings[0])){
            if(Main.isPlaying) {
                ut.removeAllPlayers();
            }
            Main.song = NBSDecoder.parse(Main.musicList.get(strings[0]));
            Main.musicp = new RadioSongPlayer(Main.song);
            ut.addAllPlayers();
            Main.isPlaying = true;
            Main.musicp.setPlaying(true);
        }else if(strings[0].equalsIgnoreCase("reload")){
            ut.reload();
            commandSender.sendMessage("§aリロードしました");
        } else if(strings[0].equalsIgnoreCase("stop")){
            if(Main.isPlaying) {
                ut.removeAllPlayers();
            }
        }      else{
            commandSender.sendMessage("§cそのファイルは存在しません。");
        }

        return true;
    }
}
