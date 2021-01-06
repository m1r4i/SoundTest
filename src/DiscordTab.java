import org.apache.logging.log4j.util.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.craftbukkit.libs.jline.console.completer.Completer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DiscordTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 2){
            if(strings[0].equalsIgnoreCase("settings")){
                List<String> aList = new ArrayList<String>(2);
                List<String> bList = new ArrayList<String>(2);
                aList.add("setVolume");
                aList.add("setLoop");
                try{
                    for(String a : aList){
                        if(a.startsWith(strings[1])){
                            bList.add(a);
                        }else if(a.toLowerCase().startsWith(strings[1])){
                            bList.add(a);
                        }else if(a.toUpperCase().startsWith(strings[1])){
                            bList.add(a);
                        }
                    }
                }catch (Exception e){
                    bList = aList;
                }
                return bList;
            }
        }else if(strings.length == 3){
            List<String> aList = new ArrayList<String>(2);
            if(strings[1].equalsIgnoreCase("setLoop")) {
                aList.add("on");
                aList.add("off");
                return aList;
            }else{
                return null;
            }
        }
        Set<String> sets = Main.musicList.keySet();
        List<String> aList = new ArrayList<String>(sets.size());
        List<String> bList = new ArrayList<String>(sets.size());
        for (String x : sets)
            aList.add(x);
        aList.add("reload");
        aList.add("stop");
        aList.add("settings");
        try{
            for(String a : aList){
                if(a.startsWith(strings[0])){
                    bList.add(a);
                }else if(a.toLowerCase().startsWith(strings[0])){
                    bList.add(a);
                }else if(a.toUpperCase().startsWith(strings[0])){
                    bList.add(a);
                }
            }
        }catch (Exception e){
            bList = aList;
        }
        return bList;
    }
}
