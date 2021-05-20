
package net.mrscauthd.boss_tools.gui;

import net.mrscauthd.boss_tools.BossToolsMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Tier3mainMenu3GuiWindow extends ContainerScreen<Tier3mainMenu3Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public Tier3mainMenu3GuiWindow(Tier3mainMenu3Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 512;
		this.ySize = 512;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
        int Width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        int Heigh = Minecraft.getInstance().getMainWindow().getScaledHeight();
        Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/rocket_menu_background.png"));
        this.blit(ms, 0, 0, 0, 0, Width, Heigh, Width, Heigh);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/milky_way.png"));
		this.blit(ms, this.guiLeft + 278, this.guiTop + 223, 0, 0, 175, 101, 175, 101);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/sun_main_menu.png"));
		this.blit(ms, this.guiLeft + 362, this.guiTop + 270, 0, 0, 8, 8, 8, 8);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/earth_main_menu.png"));
		this.blit(ms, this.guiLeft + 328, this.guiTop + 254, 0, 0, 8, 8, 8, 8);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/mars_main_menu.png"));
		this.blit(ms, this.guiLeft + 398, this.guiTop + 239, 0, 0, 8, 8, 8, 8);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/mercury.png"));
		this.blit(ms, this.guiLeft + 377, this.guiTop + 278, 0, 0, 8, 8, 8, 8);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("boss_tools:textures/rocket_menu_list2.png"));
		this.blit(ms, this.guiLeft + 43, this.guiTop + 174, 0, 0, 260, 160, 260, 160);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "CATALOG", 65, 191, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 51, this.guiTop + 223, 70, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				BossToolsMod.PACKET_HANDLER.sendToServer(new Tier3mainMenu3Gui.ButtonPressedMessage(0, x, y, z));
				Tier3mainMenu3Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 51, this.guiTop + 246, 70, 20, new StringTextComponent("Mars"), e -> {
			if (true) {
				BossToolsMod.PACKET_HANDLER.sendToServer(new Tier3mainMenu3Gui.ButtonPressedMessage(1, x, y, z));
				Tier3mainMenu3Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 246, 37, 20, new StringTextComponent("Orbit"), e -> {
			if (true) {
				BossToolsMod.PACKET_HANDLER.sendToServer(new Tier3mainMenu3Gui.ButtonPressedMessage(2, x, y, z));
				Tier3mainMenu3Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 168, this.guiTop + 246, 75, 20, new StringTextComponent("Space Station"), e -> {
			if (true) {
				BossToolsMod.PACKET_HANDLER.sendToServer(new Tier3mainMenu3Gui.ButtonPressedMessage(3, x, y, z));
				Tier3mainMenu3Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
