package net.mrscauthd.boss_tools.procedures;

import net.mrscauthd.boss_tools.BossToolsMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.tags.FluidTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class SpaceArmorBodyTickEventProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BossToolsMod.LOGGER.warn("Failed to load dependency itemstack for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BossToolsMod.LOGGER.warn("Failed to load dependency world for procedure SpaceArmorBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if (((!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) && (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))))) {
			if (((entity.getPersistentData().getBoolean("Oxygen_Bullet_Generator")) == (false))) {
				if ((((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
						.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:moon"))))
						|| (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
								.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:mars"))))
								|| (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
										.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:orbit_overworld"))))
										|| (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
												.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:mercury"))))
												|| (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey
														.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("boss_tools:orbit_moon"))))
														|| (((world instanceof World
																? (((World) world).getDimensionKey())
																: World.OVERWORLD) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
																		new ResourceLocation("boss_tools:orbit_mars"))))
																|| (((world instanceof World
																		? (((World) world).getDimensionKey())
																		: World.OVERWORLD) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
																				new ResourceLocation("boss_tools:orbit_mercury"))))
																		|| (((world instanceof World
																				? (((World) world).getDimensionKey())
																				: World.OVERWORLD) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
																						new ResourceLocation("boss_tools:venus"))))
																				|| (((world instanceof World
																						? (((World) world).getDimensionKey())
																						: World.OVERWORLD) == (RegistryKey.getOrCreateKey(
																								Registry.WORLD_KEY,
																								new ResourceLocation("boss_tools:orbit_venus"))))
																						|| (entity.areEyesInFluid(FluidTags.WATER)))))))))))) {
					if ((((itemstack).getOrCreateTag().getDouble("Energy")) >= 1)) {
						(itemstack).getOrCreateTag().putDouble("Energytick", (((itemstack).getOrCreateTag().getDouble("Energytick")) + 1));
						if ((((itemstack).getOrCreateTag().getDouble("Energytick")) >= 2)) {
							(itemstack).getOrCreateTag().putDouble("Energy", (((itemstack).getOrCreateTag().getDouble("Energy")) - 1));
							if ((((itemstack).getOrCreateTag().getDouble("Energy")) == 1000)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A761000 \u00A79Oxygen!"),
											(false));
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A761000 \u00A79Oxygen!"),
											(true));
								}
							}
							if ((((itemstack).getOrCreateTag().getDouble("Energy")) == 1)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A760 \u00A79Oxygen!"),
											(false));
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cWARNING! \u00A760 \u00A79Oxygen!"),
											(true));
								}
							}
							(itemstack).getOrCreateTag().putDouble("Energytick", 0);
						}
						entity.getPersistentData().putBoolean("SpaceSuitC", (true));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setAir((int) 300);
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("Energy")) <= 1)) {
					entity.getPersistentData().putBoolean("SpaceSuitC", (false));
				}
			}
		}
	}
}
