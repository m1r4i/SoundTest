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
        }else if(strings[0].equalsIgnoreCase("settings")){
            if(strings.length < 2){
                commandSender.sendMessage("§a- setVolume [0-100]");
                commandSender.sendMessage("§a- setLoop [on/off]");
                return true;
            }
            if(strings[1].equalsIgnoreCase("setVolume")){
                if(strings.length < 3){
                    commandSender.sendMessage("§a- setVolume [0-100]");
                    return true;
                }
                if(Main.isPlaying){
                    try {
                        ut.setVolume(Integer.parseInt(strings[2]));
                    } catch(Exception e){
                        commandSender.sendMessage("§c数字で入力してください。");
                        return true;
                    }
                }
            }else if(strings[1].equalsIgnoreCase("setLoop")){
                if(strings.length < 3){
                    commandSender.sendMessage("§a- setLoop [on/off]");
                    return true;
                }
                if(Main.isPlaying){
                    if(strings[2].equalsIgnoreCase("on")){
                        ut.setLoop(true);
                    }else if(strings[2].equalsIgnoreCase("off")){
                        ut.setLoop(false);
                        ut.removeAllPlayers();
                    }else{
                        commandSender.sendMessage("§c[on/off]で入力してください。");
                        return true;
                    }
                }
            }else{
                commandSender.sendMessage("§c設定項目を入力してください。");
                return true;
            }
        }
        else if(strings[0].equalsIgnoreCase("stop")){
            if(Main.isPlaying) {
                ut.removeAllPlayers();
            }
        }      else{
            commandSender.sendMessage("§cそのファイルは存在しません。");
        }

        return true;
    }
}
