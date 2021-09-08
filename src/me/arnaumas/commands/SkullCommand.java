package me.arnaumas.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.arnaumas.UhcMain;

public class SkullCommand {
	
	private static CommandSender staticSender;
	
	public static void run(CommandSender sender, String[] args) {
		staticSender = sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("[ERROR] No es pot executar des de consola.");
			return;
		}
		Player p = (Player) sender;
		if (args.length == 0) {
			p.sendMessage(UhcMain.color("&6Has rebut el teu cap :D"));
			p.getInventory().addItem(getPlayerHead(p.getName()));
			return;
		}
		p.sendMessage(UhcMain.color("&6Has rebut el cap de ") + args[0]);
		p.getInventory().addItem(getPlayerHead(args[0]));
	}

	@SuppressWarnings({ "deprecation", "unused" })
	private static ItemStack getPlayerHead(String name) {
		ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        Player p = ((Player)staticSender).getPlayer();
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(name);
		item.setItemMeta(meta);
		return item;
	}
}
