package me.devleo.lancador.project;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main plugin;

	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		getCommand("lancador").setExecutor(new Comando());
		getServer().getPluginManager().registerEvents(new Manager(), this);
		getServer().getConsoleSender().sendMessage(
				"§e[Pedido - Lancador] Plugin ativado com sucesso!");
		getServer().getConsoleSender().sendMessage(
				"§e[Pedido - Lancador] Versao: "
						+ getDescription().getVersion());
		getServer().getConsoleSender().sendMessage(
				"§e[Pedido - Lancador] Author: "
						+ getDescription().getAuthors());
		getServer().getConsoleSender().sendMessage(
				"§e[Pedido - Lancador] Site: " + getDescription().getWebsite());
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage(
				"§e[Pedido - Lancador] Plugin desativado com sucesso!");
		getServer().getConsoleSender().sendMessage(
				"§e[Pedido - Lancador] Site: " + getDescription().getWebsite());
	}
}