package com.patrickzhong.levelreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelReader extends JavaPlugin{
	String path = "../Skript/variables.csv";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("lv")){
			String target = ((Player)sender).getUniqueId().toString();
			if(args.length > 0){
				target = Bukkit.getServer().getPlayer(args[1]).getUniqueId().toString();
			}
			
			((Player)sender).sendMessage(target);
			
			BufferedReader br = null;
			String line = "";
			
			try {
				br = new BufferedReader(new FileReader(path));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				while ((line = br.readLine()) != null) {
				    String[] arr = line.split(",");
				    ((Player)sender).sendMessage(arr[2]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return true;
		}
		
		return false;
	}
}
