package net.mrscauthd.boss_tools.procedures;

import net.mrscauthd.boss_tools.BossToolsModVariables;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;
import java.util.Collections;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ConfigProcedure {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			executeProcedure(Collections.emptyMap());
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		File boss_tools = new File(((System.getProperty("user.dir")) + "" + ("//config/")), File.separator + "space-bosstools-config.json");
		if (!boss_tools.exists()) {
			try {
				boss_tools.createNewFile();
				// new
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonObject Config = new JsonObject();
				Config.addProperty("Alien Spawn", (true));
				Config.addProperty("Star Crawler Spawn", (true));
				Config.addProperty("Alien Zombie Spawn", (true));
				Config.addProperty("Alien Village Structure", (true));
				Config.addProperty("Meteor Structure", (true));
				Config.addProperty("Venus Bullet Structure", (true));
				Config.addProperty("Player Oxygen System", (true));
				Config.addProperty("Entity Oxygen System", (true));
				try {
					FileWriter boss_toolsfw = new FileWriter(boss_tools);
					boss_toolsfw.write(gson.toJson(Config));
					boss_toolsfw.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			try {
				BufferedReader boss_toolsReader = new BufferedReader(new FileReader(boss_tools));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = boss_toolsReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				JsonObject Config = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
				// First
				if (Config == null) { // Category check
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					Config = new JsonObject();
					Config.addProperty("Alien Spawn", (true));
					Config.addProperty("Star Crawler Spawn", (true));
					Config.addProperty("Alien Zombie Spawn", (true));
					Config.addProperty("Alien Village Structure", (true));
					Config.addProperty("Meteor Structure", (true));
					Config.addProperty("Venus Bullet Structure", (true));
					Config.addProperty("Player Oxygen System", (true));
					Config.addProperty("Entity Oxygen System", (true));
					try {
						FileWriter boss_toolsfw = new FileWriter(boss_tools);
						boss_toolsfw.write(gson.toJson(Config));
						boss_toolsfw.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
				// in category check
				if (Config.get("Alien Spawn") == null || Config.get("Star Crawler Spawn") == null || Config.get("Alien Zombie Spawn") == null
						|| Config.get("Alien Village Structure") == null || Config.get("Meteor Structure") == null
						|| Config.get("Player Oxygen System") == null || Config.get("Entity Oxygen System") == null || Config.get("Venus Bullet Structure") == null) {
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					Config = new JsonObject();
					Config.addProperty("Alien Spawn", (true));
					Config.addProperty("Star Crawler Spawn", (true));
					Config.addProperty("Alien Zombie Spawn", (true));
					Config.addProperty("Alien Village Structure", (true));
					Config.addProperty("Meteor Structure", (true));
					Config.addProperty("Venus Bullet Structure", (true));
					Config.addProperty("Player Oxygen System", (true));
					Config.addProperty("Entity Oxygen System", (true));
					try {
						FileWriter boss_toolsfw = new FileWriter(boss_tools);
						boss_toolsfw.write(gson.toJson(Config));
						boss_toolsfw.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
				// first end
				boss_toolsReader.close();
				// first
				BossToolsModVariables.AlienSpawing = (boolean) Config.get("Alien Spawn").getAsBoolean();
				BossToolsModVariables.StarCrawlerSpawn = (boolean) Config.get("Star Crawler Spawn").getAsBoolean();
				BossToolsModVariables.AlienZombieSpawn = (boolean) Config.get("Alien Zombie Spawn").getAsBoolean();
				// Category structures
				BossToolsModVariables.AlienVillageStructure = (boolean) Config.get("Alien Village Structure").getAsBoolean();
				BossToolsModVariables.MeteorStructure = (boolean) Config.get("Meteor Structure").getAsBoolean();
				BossToolsModVariables.VenusBulletStructure = (boolean) Config.get("Venus Bullet Structure").getAsBoolean();
				// Oxygen System
				BossToolsModVariables.PlayerOxygenSystem = (boolean) Config.get("Player Oxygen System").getAsBoolean();
				BossToolsModVariables.EntityOxygenSystem = (boolean) Config.get("Entity Oxygen System").getAsBoolean();
				// next
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
