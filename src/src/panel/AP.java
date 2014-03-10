package src.panel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
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
			p.sendMessage(ChatColor.GREEN + "[AdminPanel] Admin Panel V1.7 Made by Knight_Ghast");
			p.sendMessage(ChatColor.GREEN + "[AdminPanel] Panel seems to be working fine...");
		}
	}
	
	//CommandLabelForTheFeather
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
				Player player = (Player) sender;
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				PlayerInventory inventory = player.getInventory();

					//AdminPanelFeather
					ItemStack Fea = new ItemStack(Material.FEATHER, 1);
						ItemMeta FM = Fea.getItemMeta();
							FM.setDisplayName(ChatColor.GREEN + "Feather");
									Fea.setItemMeta(FM);

							//AdminPanelFeatherCommand
									if(commandLabel.equalsIgnoreCase("AdminF")){
										if(args.length == 0){
											if(player.hasPermission("AP.APF")){
												inventory.addItem(Fea);
											}
										}
											
									}				
				return false;
		}
	
   	 public static Inventory AdminP = Bukkit.createInventory(null, 45, ChatColor.RED + "AdminPanel ");
   		static {
               //ItemStacks
   			
   			//Vanish
              ItemStack Vanish = new ItemStack(Material.POTION, 1);
               	ItemMeta DM = Vanish.getItemMeta();
               	DM.setDisplayName(ChatColor.GRAY + "Vanish");
               	DM.setLore(Arrays.asList(ChatColor.GREEN + "Vanish to spy on others"));
               	Vanish.setItemMeta(DM);
               		AdminP.setItem(2, Vanish);
               	
            //UnVanish
               	ItemStack UnVanish = new ItemStack(Material.GLASS_BOTTLE, 1);
               	ItemMeta UM = UnVanish.getItemMeta();
               	UM.setDisplayName(ChatColor.GRAY + "UnVanish");
               	UM.setLore(Arrays.asList(ChatColor.GREEN + "Exit out of Vanish"));
               	UnVanish.setItemMeta(UM);
               		AdminP.setItem(4, UnVanish);
            
            //GamemodeCreative
               	ItemStack Cr = new ItemStack(Material.STONE, 1);
               	ItemMeta CM = Cr.getItemMeta();
               	CM.setDisplayName(ChatColor.YELLOW + "Creative");
               	CM.setLore(Arrays.asList(ChatColor.GREEN + "Changes your GameMode to Creative."));
               	Cr.setItemMeta(CM);
               		AdminP.setItem(12, Cr);
           //GamemodeSurvival
               	ItemStack Sr = new ItemStack(Material.GRASS, 1);
               	ItemMeta SM = Sr.getItemMeta();
               	SM.setDisplayName(ChatColor.GOLD + "Survival");
               	SM.setLore(Arrays.asList(ChatColor.GREEN + "Changes your GameMode to Survival"));
               	Sr.setItemMeta(SM);
               		AdminP.setItem(14, Sr);
           //AnnounceRestart
               		ItemStack Ar = new ItemStack(Material.REDSTONE);
               		ItemMeta AM = Ar.getItemMeta();
               		AM.setDisplayName(ChatColor.RED + "Announce Server restart");
               		AM.setLore(Arrays.asList(ChatColor.RED + "Annouce a Server restart (Manual Restart)"));
               		Ar.setItemMeta(AM);
               			AdminP.setItem(33, Ar);
           //ReloadPlugins
               			ItemStack Pr = new ItemStack(Material.REDSTONE);
               			ItemMeta PM = Pr.getItemMeta();
               			PM.setDisplayName(ChatColor.GREEN + "Reload plugins");
               			PM.setLore(Arrays.asList(ChatColor.GREEN + "Reload the Server Plugins and Whitelist"
               					+ ""));
               			Pr.setItemMeta(PM);
               				AdminP.setItem(31, Pr);
           //KillAllEntities[MOBS]
               			ItemStack Ka = new ItemStack(Material.DIAMOND_SWORD, 1);
               			ItemMeta Km = Ka.getItemMeta();
               			Km.setDisplayName(ChatColor.DARK_RED + "Kill all Mobs in world");
               			Km.setLore(Arrays.asList(ChatColor.RED + "Kill all Mobs in the current World."));
               			Ka.setItemMeta(Km);
               				AdminP.setItem(19, Ka);
           //KillAllEntitiesRadius[MOBS]
   						ItemStack KAR = new ItemStack(Material.IRON_SWORD, 1);
   						ItemMeta KAM = KAR.getItemMeta();
   						KAM.setDisplayName(ChatColor.RED + "Kill all Mobs (Radius)");
   						KAM.setLore(Arrays.asList(ChatColor.RED + "Kill all Mobs in Radius(100)"));
   						KAR.setItemMeta(KAM);
   							AdminP.setItem(21, KAR);
   			//KILLALLANIMALS
   							ItemStack SA = new ItemStack(Material.STONE_SWORD, 1);
   							ItemMeta Sm = SA.getItemMeta();
   							Sm.setDisplayName(ChatColor.GREEN + "Kill all Animals");
   							Sm.setLore(Arrays.asList(ChatColor.GOLD + "Kill all Animals in current World"));
   							SA.setItemMeta(Sm);
   								AdminP.setItem(23, SA);
   			//KillAllAnimalsRadius
   	   							ItemStack qa = new ItemStack(Material.WOOD_SWORD, 1);
   	   							ItemMeta qm = qa.getItemMeta();
   	   							qm.setDisplayName(ChatColor.GREEN + "Kill all Animals (Radius)");
   	   							qm.setLore(Arrays.asList(ChatColor.GOLD + "Kill all Animals in Radius(100)"));
   	   							qa.setItemMeta(qm);
   	   								AdminP.setItem(25, qa);
   			//GetPlayerAmount
   								
   								List<String> players = new ArrayList<String>();
   								for(Player GA : Bukkit.getServer().getOnlinePlayers()){
   									players.add(GA.getName());
   								}
   								
   								
   								int GPA = Bukkit.getServer().getOnlinePlayers().length;
   								ItemStack Gp = new ItemStack(Material.REDSTONE, 1);
   	   							ItemMeta Gmp = Gp.getItemMeta();
   	   							Gmp.setDisplayName(ChatColor.GREEN + "Online Players : " +ChatColor.RED + GPA);
   	   							Gp.setItemMeta(Gmp);
   	   								AdminP.setItem(29, Gp);
             //TPRANDOM
   	   							ItemStack Kicka = new ItemStack(Material.ENDER_PEARL, 1);
   	   							ItemMeta Kickm = Kicka.getItemMeta();
   	   							Kickm.setDisplayName(ChatColor.RED + "Teleport to random Player");
   	   							Kickm.setLore(Arrays.asList(ChatColor.DARK_RED + "Teleports you to a random Player In-Game"));
   	   							Kicka.setItemMeta(Kickm);
   	   								AdminP.setItem(40, Kicka);
   	   		
   	   		//HealPlayer
   	    							ItemStack Ha = new ItemStack(Material.COOKED_BEEF, 1);
   	    							ItemMeta Hm = Ha.getItemMeta();
   	    							Hm.setDisplayName(ChatColor.GREEN + "Heal yourself");
   	    							Hm.setLore(Arrays.asList(ChatColor.GOLD + "Heal yourself and fill your hunger"));
   	    							Ha.setItemMeta(Hm);
   	    								AdminP.setItem(6, Ha);			
   	   						
   		}
   		

   		
   		
   		//ItemClickEvents
   	@SuppressWarnings("deprecation")
	@EventHandler
   	public void onInventoryClick(InventoryClickEvent event){
   		Player player = (Player) event.getWhoClicked();
   		ItemStack clicked = event.getCurrentItem();
   		Inventory inventory = event.getInventory();
   			if(inventory.getName().equals(AdminP.getName())){
   				
   				//Vanish
   				if(event.getSlot() == 2){
   				event.setCancelled(true);
   					player.closeInventory();
   					player.sendMessage(ChatColor.GRAY + "[AdminPanel] Vanished");
   					if (!Vanish.contains(player.getName())){
   						
   						
   						player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
   						Vanish.add(player.getName());
   						player.sendMessage(ChatColor.GRAY + "[AdminPanel] Use the UnVanish button in your Admin Panel if you wish to exit out of vanish mode");
   					}else{
   						player.sendMessage(ChatColor.DARK_RED + "[AdminPanel] You already Vanished!");
   				}
   			}
   				//Unvanish
   				if(event.getSlot() == 4){
   					event.setCancelled(true);
   					player.closeInventory();	
   					player.sendMessage(ChatColor.GRAY + "[AdminPanel] UnVanished");
   					player.removePotionEffect(PotionEffectType.INVISIBILITY);
   					Vanish.remove(player.getName());
   				}
   				
   				if(event.getSlot() == 12){
   					event.setCancelled(true);
   					player.closeInventory();
   					player.sendMessage(ChatColor.GREEN + "[AdminPanel] GameMode changed to Creative");
   					player.setGameMode(GameMode.CREATIVE);
   				}
   				if(event.getSlot() == 14){
   					event.setCancelled(true);
   					player.closeInventory();
   					player.sendMessage(ChatColor.GREEN + "[AdminPanel] GameMode changed to Survival");
   					player.setGameMode(GameMode.SURVIVAL);
   				}
   				if(event.getSlot() == 33){
   					event.setCancelled(true);
   					player.closeInventory();
   					Bukkit.broadcastMessage(ChatColor.DARK_RED + "[Server] Server restart soon!");
   				}
   				if(event.getSlot() == 31){
   					event.setCancelled(true);
   					player.closeInventory();
   					Bukkit.reload();
   					Bukkit.reloadWhitelist();
   					player.sendMessage(ChatColor.GREEN + "[AdminPanel] Reloaded Server Whitelist and Plugins");
   				}
   				if(event.getSlot() == 19){
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
   				if(event.getSlot() == 21){
   					event.setCancelled(true);
   					player.closeInventory();
   					List<Entity> ir = player.getNearbyEntities(100, 100, 100);
   						for(Entity ent : ir){
   						if(ent instanceof Monster){
   							ent.remove();
   			       }
   				}
   		    }
   				//killallradiusanimal
   				if(event.getSlot() == 25){
   					event.setCancelled(true);
   					player.closeInventory();
   					List<Entity> iu = player.getNearbyEntities(100, 100, 100);
   					for(Entity ent : iu){
   						if(ent instanceof Animals){
   							ent.remove();
   						}
   					}
   					
   				}
   				
   				
   				//HEAL
   						if(event.getSlot() == 6){
   							event.setCancelled(true);
   							player.closeInventory();
   								player.setHealth(20);
   								player.setFoodLevel(20);
   								player.sendMessage(ChatColor.GREEN + "[AdminPanel] Healed");
   			}
   						if(event.getSlot() == 29){
								List<String> players = new ArrayList<String>();
								for(Player GA : Bukkit.getServer().getOnlinePlayers()){
									players.add(GA.getName());
								}
   							
   							event.setCancelled(true);
   							player.closeInventory();
   								int GPA = this.getServer().getOnlinePlayers().length;
   							if(GPA == 1){
   								player.sendMessage(ChatColor.GOLD + "[AdminPanel] There is currently 1 player");
   							}else
   								player.sendMessage(ChatColor.GOLD + "[AdminPanel] There are currently " +GPA + " Players online");
   								player.sendMessage(ChatColor.GOLD + "[AdminPanel] Currently connected Players : " + ChatColor.GRAY + players);
   				}
   						if(event.getSlot() == 40){
   						int random = new Random().nextInt(Bukkit.getOnlinePlayers().length);
   							Player R = Bukkit.getOnlinePlayers()[random];
   						
   							 event.setCancelled(true);
   							 player.closeInventory();
   							Player random1 = Bukkit.getOnlinePlayers()[new Random().nextInt(Bukkit.getOnlinePlayers().length)];
   							if(random1 == player){
   								player.sendMessage(ChatColor.RED + "[AdminPanel] Error you were the selected random Player, Try again ");
   							}else{
   							
   						     player.teleport(random1);
   						     player.sendMessage(ChatColor.GREEN + "[AdminPanel] You have teleported to a random Player");
   						     player.sendMessage(ChatColor.GREEN + "[AdminPanel] You have been teleported to " + random1.getName());
   								
   							}
   						}
   						
   						if(event.getSlot() == 23){
   							event.setCancelled(true);
   							player.closeInventory();
   							World w = player.getWorld();
   		   					List<Entity> ip = w.getEntities();
   		   					for(Entity ent : ip){
   		   						if(ent instanceof Animals){
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
				if(player.hasPermission("AP.AdminPanel")){
				if(mat == Material.FEATHER){
					player.openInventory(AdminP);
		   }
		}
	}
  }
	
 }
}
