package me.devleo.lancador.project;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("lancador")) {
			if (!sender.hasPermission("lancador.admin")) {
				sender.sendMessage("§cVoce não possui permissão!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage("§cUso correto: /lancador <jogador>!");
				return true;
			}
			Player p = Bukkit.getPlayer(args[0]);
			if (p == null) {
				sender.sendMessage("§cJogador nao encontrado!");
				return true;
			}
			p.getInventory().addItem(Manager.getItem());
			sender.sendMessage("§eLancador enviado com sucesso!");
		}
		return false;
	}
}