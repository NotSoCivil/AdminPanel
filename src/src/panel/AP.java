package src.panel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("unused")
public class AP extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable(){
		getConfig().options().copyDefaults(true);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	ArrayList<String> Vanish = new ArrayList<String>();
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent J){
		Player p = J.getPlayer();
	
		if(p.getName().equalsIgnoreCase(getConfig().getString("AdminPanelUsers"))){
			p.sendMessage(ChatColor.GREEN + "Admin Panel V1.7 Made by Knight_Ghast");
			p.sendMessage(ChatColor.GREEN + "Admin Panel seems to be working fine...");
		}
	}
	
	//CommandLabelForTheFeather
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
				Player player = (Player) sender;
				PlayerInventory inventory = player.getInventory();

					//AdminPanelFeather
					ItemStack Fea = new ItemStack(Material.FEATHER, 1);
						ItemMeta FM = Fea.getItemMeta();
							FM.setDisplayName(ChatColor.GREEN + "Feather");
									Fea.setItemMeta(FM);

							//AdminPanelFeatherCommand
									if(commandLabel.equalsIgnoreCase("AdminF")){
											if(player.hasPermission("AP.APF")){
												inventory.addItem(Fea);
											}
									}				
				return false;
		}
	

    	
   	 public static Inventory AdminP = Bukkit.createInventory(null, 18, ChatColor.BOLD + "AdminPanel");
   		static {
               //ItemStacks
   			
   			//Vanish
              ItemStack Vanish = new ItemStack(Material.DIAMOND, 1);
               	ItemMeta DM = Vanish.getItemMeta();
               	DM.setDisplayName(ChatColor.GRAY + "Vanish");
               	DM.setLore(Arrays.asList(ChatColor.GREEN + "Vanish to spy on others"));
               	Vanish.setItemMeta(DM);
               		AdminP.setItem(0, Vanish);
               	
            //UnVanish
               	ItemStack UnVanish = new ItemStack(Material.EMERALD, 1);
               	ItemMeta UM = UnVanish.getItemMeta();
               	UM.setDisplayName(ChatColor.GRAY + "UnVanish");
               	UM.setLore(Arrays.asList(ChatColor.GREEN + "Exit out of Vanish"));
               	UnVanish.setItemMeta(UM);
               		AdminP.setItem(1, UnVanish);
            
            //GamemodeCreative
               	ItemStack Cr = new ItemStack(Material.REDSTONE_TORCH_ON, 1);
               	ItemMeta CM = Cr.getItemMeta();
               	CM.setDisplayName(ChatColor.YELLOW + "Creative");
               	CM.setLore(Arrays.asList(ChatColor.GREEN + "Changes your GameMode to Creative."));
               	Cr.setItemMeta(CM);
               		AdminP.setItem(3, Cr);
           //GamemodeSurvival
               	ItemStack Sr = new ItemStack(Material.TORCH, 1);
               	ItemMeta SM = Sr.getItemMeta();
               	SM.setDisplayName(ChatColor.GOLD + "Survival");
               	SM.setLore(Arrays.asList(ChatColor.GREEN + "Changes your GameMode to Survival"));
               	Sr.setItemMeta(SM);
               		AdminP.setItem(4, Sr);
           //AnnounceRestart
               		ItemStack Ar = new ItemStack(Material.REDSTONE);
               		ItemMeta AM = Ar.getItemMeta();
               		AM.setDisplayName(ChatColor.RED + "Announce Server restart");
               		AM.setLore(Arrays.asList(ChatColor.RED + "Annouce a Server restart (Manual Restart)"));
               		Ar.setItemMeta(AM);
               			AdminP.setItem(6, Ar);
           //ReloadPlugins
               			ItemStack Pr = new ItemStack(Material.BUCKET);
               			ItemMeta PM = Pr.getItemMeta();
               			PM.setDisplayName(ChatColor.GREEN + "Reload plugins");
               			PM.setLore(Arrays.asList(ChatColor.GREEN + "Reload the Server Plugins and Whitelist"
               					+ ""));
               			Pr.setItemMeta(PM);
               				AdminP.setItem(7, Pr);
           //KillAllEntities[MOBS]
               			ItemStack Ka = new ItemStack(Material.DIAMOND_SWORD, 1);
               			ItemMeta Km = Ka.getItemMeta();
               			Km.setDisplayName(ChatColor.DARK_RED + "Kill all Mobs in world");
               			Km.setLore(Arrays.asList(ChatColor.RED + "Kill all Mobs in the current World, this does not have a raidius"));
               			Ka.setItemMeta(Km);
               				AdminP.setItem(9, Ka);
           //KillAllEntitiesRadius[MOBS]
   						ItemStack KAR = new ItemStack(Material.IRON_SWORD, 1);
   						ItemMeta KAM = KAR.getItemMeta();
   						KAM.setDisplayName(ChatColor.RED + "Kill all Mobs (Radius)");
   						KAM.setLore(Arrays.asList(ChatColor.RED + "Kill all Mobs in a radius."));
   						KAR.setItemMeta(KAM);
   							AdminP.setItem(10, KAR);
               				
   		}
   		

   		
   		
   		//ItemClickEvents
   	@EventHandler
   	public void onInventoryClick(InventoryClickEvent event){
   		Player player = (Player) event.getWhoClicked();
   		ItemStack clicked = event.getCurrentItem();
   		Inventory inventory = event.getInventory();
   			if(inventory.getName().equals(AdminP.getName())){
   				
   				//Vanish
   				if(event.getSlot() == 0){
   				event.setCancelled(true);
   					player.closeInventory();
   					player.sendMessage(ChatColor.GRAY + "Vanished");
   					if (!Vanish.contains(player.getName())){
   						
   						
   						player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
   						Vanish.add(player.getName());
   						player.sendMessage(ChatColor.GRAY + "Use the UnVanish button in your Admin Panel if you wish to exit out of vanish mode");
   					}else{
   						player.sendMessage(ChatColor.DARK_RED + "You already Vanished!");
   				}
   			}
   				//Unvanish
   				if(event.getSlot() == 1){
   					event.setCancelled(true);
   					player.closeInventory();	
   					player.sendMessage(ChatColor.GRAY + "UnVanished");
   					player.removePotionEffect(PotionEffectType.INVISIBILITY);
   					Vanish.remove(player.getName());
   				}
   				
   				if(event.getSlot() == 3){
   					event.setCancelled(true);
   					player.closeInventory();
   					player.sendMessage(ChatColor.GREEN + "GameMode changed to Creative");
   					player.setGameMode(GameMode.CREATIVE);
   				}
   				if(event.getSlot() == 4){
   					event.setCancelled(true);
   					player.closeInventory();
   					player.sendMessage(ChatColor.GREEN + "GameMode changed to Survival");
   					player.setGameMode(GameMode.SURVIVAL);
   				}
   				if(event.getSlot() == 6){
   					event.setCancelled(true);
   					player.closeInventory();
   					Bukkit.broadcastMessage(ChatColor.DARK_RED + "[Server] Server restart soon!");
   				}
   				if(event.getSlot() == 7){
   					event.setCancelled(true);
   					player.closeInventory();
   					Bukkit.reload();
   					Bukkit.reloadWhitelist();
   					player.sendMessage(ChatColor.GREEN + "Reloaded Server Whitelist and Plugins");
   				}
   				if(event.getSlot() == 9){
   					event.setCancelled(true);
   					player.closeInventory();
   					World w = player.getWorld();
   					List<Entity> ie = w.getEntities();
   					for(Entity ent : ie){
   						if(ent instanceof Monster){
   							 ent.remove();
   						}
   					}
   				}
   				if(event.getSlot() == 10){
   					event.setCancelled(true);
   					player.closeInventory();
   					List<Entity> ir = player.getNearbyEntities(200, 200, 200);
   						for(Entity ent : ir){
   						if(ent instanceof Monster){
   							ent.remove();
   			       }
   				}
   		    }
   		}
   	}
   	
   	
   	
   	
   	
   	
   	//PlayerInteractEvent
    
	@EventHandler
		public void onPlayerInteract(PlayerInteractEvent e){
			Player player = e.getPlayer();
			Material mat = player.getItemInHand().getType();
			if(player.hasPermission("AP.AdminPanel")){
			
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(mat == Material.FEATHER){
					player.openInventory(AdminP);
		   }
		}
	}
  }
	
}
