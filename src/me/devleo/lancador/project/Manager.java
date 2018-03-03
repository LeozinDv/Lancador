package me.devleo.lancador.project;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class Manager implements Listener {

	@EventHandler
	private void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() != null
					&& p.getItemInHand().isSimilar(getItem())) {
				e.setCancelled(true);
				p.setVelocity(p
						.getEyeLocation()
						.getDirection()
						.multiply(
								Main.plugin.getConfig().getInt(
										"Configuration.Frente"))
						.add(new Vector(0, Main.plugin.getConfig().getInt(
								"Configuration.Altura"), 0)));
				if (p.getItemInHand().getAmount() == 1) {
					p.setItemInHand(new ItemStack(Material.AIR));
					p.updateInventory();
				} else {
					p.getItemInHand().setAmount(
							p.getItemInHand().getAmount() - 1);
					p.updateInventory();
				}
			}
		}
	}

	public static ItemStack getItem() {
		ItemStack item = new ItemStack(Material.getMaterial(Main.plugin
				.getConfig().getInt("Item.ID")));
		item.setDurability(Short.valueOf(Main.plugin.getConfig().getString(
				"Item.Data")));
		ItemMeta item2 = item.getItemMeta();
		item2.setDisplayName(Main.plugin.getConfig().getString("Item.Nome")
				.replace("&", "§").replace("Lancador", "Lançador"));
		List<String> lore = new ArrayList();
		for (String lores : Main.plugin.getConfig().getStringList("Item.Lore")) {
			lore.add(lores.replace("&", "§"));
		}
		item2.setLore(lore);
		item.setItemMeta(item2);
		return item;
	}
}