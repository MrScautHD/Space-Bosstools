package net.mrscauthd.boss_tools.procedures;

import net.mrscauthd.boss_tools.BossToolsModVariables;
import net.mrscauthd.boss_tools.BossToolsMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class EntityisinSpaceProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
			Entity entity = event.getEntityLiving();
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure EntityisinSpace!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BossToolsMod.LOGGER.warn("Failed to load dependency x for procedure EntityisinSpace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BossToolsMod.LOGGER.warn("Failed to load dependency y for procedure EntityisinSpace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BossToolsMod.LOGGER.warn("Failed to load dependency z for procedure EntityisinSpace!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BossToolsMod.LOGGER.warn("Failed to load dependency world for procedure EntityisinSpace!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		// Config
		if ((BossToolsModVariables.EntityOxygenSystem == (true))) {
			if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("forge:entities/space").toLowerCase(java.util.Locale.ENGLISH)))
					.contains(entity.getType()))) {
				if ((((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:moon"))))
						|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
								new ResourceLocation("boss_tools:mars"))))
								|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("boss_tools:orbit_overworld"))))
										|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("boss_tools:mercury"))))
												|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
														new ResourceLocation("boss_tools:orbit_moon"))))
														|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
																new ResourceLocation("boss_tools:orbit_mars"))))
																|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																		Registry.WORLD_KEY, new ResourceLocation("boss_tools:orbit_mercury"))))
																		|| (((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																				Registry.WORLD_KEY, new ResourceLocation("boss_tools:venus"))))
																				|| ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																						Registry.WORLD_KEY,
																						new ResourceLocation("boss_tools:orbit_venus"))))))))))))) {
					entity.getPersistentData().putDouble("tick", ((entity.getPersistentData().getDouble("tick")) + 1));
					if (((entity.getPersistentData().getDouble("tick")) >= 15)) {
						world.addParticle(ParticleTypes.SMOKE, x, (y + 1), z, 0, 0, 0);
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).attackEntityFrom(new DamageSource("space").setDamageBypassesArmor(), (float) 1);
						}
						entity.getPersistentData().putDouble("tick", 0);
					}
				}
			}
		}
	}
}
