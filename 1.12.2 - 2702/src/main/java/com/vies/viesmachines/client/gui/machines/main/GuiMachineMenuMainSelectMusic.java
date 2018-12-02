package com.vies.viesmachines.client.gui.machines.main;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.client.gui.GuiScrollingListVC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VC;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicSet;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;
import com.vies.viesmachines.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.client.GuiScrollingList;

public class GuiMachineMenuMainSelectMusic extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_machine_music.png");
	
	private ArrayList<ResourceLocation> songs;
	private GuiScrollingListVC songList;
	
    private GuiScreen mainMenu;
    private GuiScrollingList songInfo;
    private int selected = -1;
    private ResourceLocation selectedSong;
    private int listWidth;
    private int buttonMargin = 1;
    
    public static int setSong;
    
	public GuiMachineMenuMainSelectMusic(IInventory playerInv, EntityMachineBase machineIn)
	{
		super(new ContainerMachineNoSlots(playerInv, machineIn), playerInv, machineIn);
		
        this.songs = ClientProxy.musicListRecord;
        this.zLevel = 0.0F;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	int slotHeight = 35;
    	
    	for (ResourceLocation mod : songs)
        {
            this.listWidth = Math.max(this.listWidth,getFontRenderer().getStringWidth(mod.getResourcePath()) + 10);
        }
    	
    	this.listWidth = Math.min(this.listWidth, 150);
        
    	this.songList = new GuiScrollingListVC(this, this.songs, this.listWidth, slotHeight);
    	
    	GuiVM.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 60, this.guiTop + 197, 56, 14, References.localNameVC("gui.done"), 0);
    	this.buttonList.add(GuiVM.button501);
    }
    
    @Override
    protected void actionPerformed(GuiButton button)
    {
    	super.actionPerformed(button);
        
		if (button.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		// Binds the texture to use:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the background texture:
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		// Current Song label:
		this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.currentsong.0"), 88, 10, Color.BLACK.getRGB());
		
		// Song:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88, 27.5, 0);
			GlStateManager.scale(0.65F, 0.65F, 0.65F);
			
			this.centeredString(fontRenderer, 
			this.stringToFlashGolden(
			References.localNameVC("item." + SoundEvent.REGISTRY.getObject(new ResourceLocation(ClientProxy.musicListRecord.get(this.machine.selectedSong).toString())).getSoundName().getResourcePath()+ ".desc")
			, 1, false, TextFormatting.DARK_AQUA, 0)	
			, 0, 0, Color.BLUE.getRGB());
			
		}
		GlStateManager.popMatrix();
	}
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.songList.drawScreen(mouseX, mouseY, partialTicks);
        
        if (this.songInfo != null)
        {
            this.songInfo.drawScreen(mouseX, mouseY, partialTicks);
        }
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
    @Override
    public void handleMouseInput() throws IOException
    {
        int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        super.handleMouseInput();
        if (this.songInfo != null)
        {
        	this.songInfo.handleMouseInput(mouseX, mouseY);
        }
        
        this.songList.handleMouseInput(mouseX, mouseY);
    }
    
    private void updateCache()
    {
        songInfo = null;
        
        if (selectedSong == null)
        {
        	return;
        }
        
        ResourceLocation logoPath = null;
        Dimension logoDims = new Dimension(0, 0);
        List<String> lines = new ArrayList<String>();
        
        for(int i = 0; i < ClientProxy.musicListRecord.size(); i++)
		{
			if(ClientProxy.musicListRecord.get(i).toString().toLowerCase().contains(selectedSong.toString().toLowerCase()))
		    {
				this.setSong = i;
				NetworkHandler.sendToServer(new MessageHelperGuiMachineMusicSet());
		    }
		}
    }
    
    @Override
    protected void mouseClicked(int x, int y, int button) throws IOException
    {
        super.mouseClicked(x, y, button);
    }
    
    @Override
    protected void keyTyped(char c, int keyCode) throws IOException
    {
        super.keyTyped(c, keyCode);
    }
    
    public Minecraft getMinecraftInstance()
    {
        return mc;
    }
    
    public void selectModIndex(int index)
    {
        if (index == this.selected)
            return;
        this.selected = index;
        this.selectedSong = (index >= 0 && index <= songs.size()) ? songs.get(selected) : null;

        updateCache();
    }

    public boolean modIndexSelected(int index)
    {
        return index == selected;
    }
    
    
    
    private class Info extends GuiScrollingList
    {
        @Nullable
        private ResourceLocation logoPath;
        private Dimension logoDims;
        private List<ITextComponent> lines = null;

        public Info(int width, List<String> lines, @Nullable ResourceLocation logoPath, Dimension logoDims)
        {
            super(GuiMachineMenuMainSelectMusic.this.getMinecraftInstance(),
                  width,
                  GuiMachineMenuMainSelectMusic.this.height,
                  32, GuiMachineMenuMainSelectMusic.this.height - 88 + 4,
                  GuiMachineMenuMainSelectMusic.this.listWidth + 20, 60,
                  GuiMachineMenuMainSelectMusic.this.width,
                  GuiMachineMenuMainSelectMusic.this.height);
            this.lines    = resizeContent(lines);
            this.logoPath = logoPath;
            this.logoDims = logoDims;

            this.setHeaderInfo(true, getHeaderHeight());
        }

        @Override protected int getSize() { return 0; }
        @Override protected void elementClicked(int index, boolean doubleClick) { }
        @Override protected boolean isSelected(int index) { return false; }
        @Override protected void drawBackground() {}
        @Override protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) { }

        private List<ITextComponent> resizeContent(List<String> lines)
        {
            List<ITextComponent> ret = new ArrayList<ITextComponent>();
            for (String line : lines)
            {
                if (line == null)
                {
                    ret.add(null);
                    continue;
                }

                ITextComponent chat = ForgeHooks.newChatWithLinks(line, false);
                int maxTextLength = this.listWidth - 8;
                if (maxTextLength >= 0)
                {
                    ret.addAll(GuiUtilRenderComponents.splitText(chat, maxTextLength, GuiMachineMenuMainSelectMusic.this.fontRenderer, false, true));
                }
            }
            return ret;
        }

        private int getHeaderHeight()
        {
          int height = 0;
          if (logoPath != null)
          {
              double scaleX = logoDims.width / 200.0;
              double scaleY = logoDims.height / 65.0;
              double scale = 1.0;
              if (scaleX > 1 || scaleY > 1)
              {
                  scale = 1.0 / Math.max(scaleX, scaleY);
              }
              logoDims.width *= scale;
              logoDims.height *= scale;

              height += logoDims.height;
              height += 10;
          }
          height += (lines.size() * 10);
          if (height < this.bottom - this.top - 8) height = this.bottom - this.top - 8;
          return height;
        }
        
        
        @Override
        protected void drawHeader(int entryRight, int relativeY, Tessellator tess)
        {
            int top = relativeY;

            if (logoPath != null)
            {
                GlStateManager.enableBlend();
                GuiMachineMenuMainSelectMusic.this.mc.renderEngine.bindTexture(logoPath);
                BufferBuilder wr = tess.getBuffer();
                int offset = (this.left + this.listWidth/2) - (logoDims.width / 2);
                wr.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                wr.pos(offset,                  top + logoDims.height, zLevel).tex(0, 1).endVertex();
                wr.pos(offset + logoDims.width, top + logoDims.height, zLevel).tex(1, 1).endVertex();
                wr.pos(offset + logoDims.width, top,                   zLevel).tex(1, 0).endVertex();
                wr.pos(offset,                  top,                   zLevel).tex(0, 0).endVertex();
                tess.draw();
                GlStateManager.disableBlend();
                top += logoDims.height + 10;
            }

            for (ITextComponent line : lines)
            {
                if (line != null)
                {
                    GlStateManager.enableBlend();
                    GuiMachineMenuMainSelectMusic.this.fontRenderer.drawStringWithShadow(line.getFormattedText(), this.left + 4, top, 0xFFFFFF);
                    GlStateManager.disableAlpha();
                    GlStateManager.disableBlend();
                }
                top += 10;
            }
        }

        @Override
        protected void clickHeader(int x, int y)
        {
            int offset = y;
            if (logoPath != null) {
              offset -= logoDims.height + 10;
            }
            if (offset <= 0)
                return;

            int lineIdx = offset / 10;
            if (lineIdx >= lines.size())
                return;

            ITextComponent line = lines.get(lineIdx);
            if (line != null)
            {
                int k = -4;
                for (ITextComponent part : line) {
                    if (!(part instanceof TextComponentString))
                        continue;
                    k += GuiMachineMenuMainSelectMusic.this.fontRenderer.getStringWidth(((TextComponentString)part).getText());
                    if (k >= x)
                    {
                        GuiMachineMenuMainSelectMusic.this.handleComponentClick(part);
                        break;
                    }
                }
            }
        }
    }
}
