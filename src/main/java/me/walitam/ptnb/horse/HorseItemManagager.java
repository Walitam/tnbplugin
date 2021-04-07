package me.walitam.ptnb.horse;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import me.walitam.ptnb.PTNB;

public class HorseItemManagager implements Listener {
	
	
	private static final String FIRST_LORE = "§eCheval custom !";
	
	
	
	@EventHandler
	public void onPlayerUseItem(PlayerInteractEvent event) {
		
		
		//si clic droit sur un bloc avec une selle
		if (event.getAction()  == Action.RIGHT_CLICK_BLOCK && event.getItem().getType() == Material.SADDLE) { 
			
		
			ItemMeta meta = event.getItem().getItemMeta();
			
			//si selle bien un item custom
			if (meta.getLore().size() >= 1 && meta.getLore().get(0).equals(FIRST_LORE)) {
				
				//si cheval dedans
				if (meta.getLore().get(2).contains("§a")) {
					
					Block block1 = event.getClickedBlock().getRelative(BlockFace.UP);
					Block block2 = (block1 != null ? block1.getRelative(BlockFace.UP) : null);
					
					//si emplacement non obstruré
					if (block1 != null && block2 != null && block1.getType() == Material.AIR && block2.getType() == Material.AIR) {
						
						//spawn cheval
						Horse horse =  (Horse) block1.getWorld().spawnEntity(block1.getLocation(), EntityType.HORSE);
						horse.setAdult();
						
						//TODO mettre les caractéristiques....
						
						
					//sinon
					} else {
						event.getPlayer().sendMessage(PTNB.TAG + " §cEmplacement obstrué !");
						return;
					}
					
					
					
				//si cheval sorti
				} else if (meta.getLore().get(2).contains("§c")) {
					event.getPlayer().sendMessage(PTNB.TAG + " §cCliquez sur votre cheval pour le rentrer !");
					return;
				}
				
			}
			
			
		}
		
	}
	
	

}
