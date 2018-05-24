package com.viesys.viesysmachines.network;

import com.viesys.viesysmachines.api.References;
import com.viesys.viesysmachines.network.client.MessageConfig;
import com.viesys.viesysmachines.network.server.airship.MessageDropBombBig;
import com.viesys.viesysmachines.network.server.airship.MessageDropBombScatter;
import com.viesys.viesysmachines.network.server.airship.MessageDropBombSmall;
import com.viesys.viesysmachines.network.server.airship.MessageGuiPlayMusic;
import com.viesys.viesysmachines.network.server.airship.MessageGuiPlayMusicArea;
import com.viesys.viesysmachines.network.server.airship.MessageGuiRandomMusic;
import com.viesys.viesysmachines.network.server.airship.MessageGuiStopMusic;
import com.viesys.viesysmachines.network.server.airship.MessageGuiStopMusicArea;
import com.viesys.viesysmachines.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesys.viesysmachines.network.server.airship.customize.MessageGuiCustomizeMenuChangeName;
import com.viesys.viesysmachines.network.server.airship.customize.MessageHelperGuiCustomizeMenuChangeName;
import com.viesys.viesysmachines.network.server.airship.customize.MessageHelperGuiCustomizeMenuUndo;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonColor;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonColorUndo;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonMain;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonColor;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonColorDefault;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonTransparent;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier1Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier1Pg2;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier2Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier3Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier4Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier5Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.balloon.sub.MessageHelperGuiCustomizeMenuBalloonTier;
import com.viesys.viesysmachines.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.viesys.viesysmachines.network.server.airship.customize.core.sub.MessageGuiCustomizeMenuCoreModelBalloonPg1;
import com.viesys.viesysmachines.network.server.airship.customize.core.sub.MessageGuiCustomizeMenuCoreModelEnginePg1;
import com.viesys.viesysmachines.network.server.airship.customize.core.sub.MessageGuiCustomizeMenuCoreModelFramePg1;
import com.viesys.viesysmachines.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelBalloon;
import com.viesys.viesysmachines.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelEngine;
import com.viesys.viesysmachines.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelFrame;
import com.viesys.viesysmachines.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayBlockItemPg1;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayHeadPg1;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayParticlePg1;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplaySymbolPg1;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItem;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItemDefault;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayHead;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayHeadDefault;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayParticle;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbol;
import com.viesys.viesysmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbolDefault;
import com.viesys.viesysmachines.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColor;
import com.viesys.viesysmachines.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColorUndo;
import com.viesys.viesysmachines.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesys.viesysmachines.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColor;
import com.viesys.viesysmachines.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColorDefault;
import com.viesys.viesysmachines.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameTransparent;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg2;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier2Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier3Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier4Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier5Pg1;
import com.viesys.viesysmachines.network.server.airship.customize.frame.sub.MessageHelperGuiCustomizeMenuFrameTier;
import com.viesys.viesysmachines.network.server.airship.main.MessageGuiMainMenu;
import com.viesys.viesysmachines.network.server.airship.main.MessageHelperGuiMainMenuConsumeBomb1;
import com.viesys.viesysmachines.network.server.airship.main.MessageHelperGuiMainMenuConsumeBomb2;
import com.viesys.viesysmachines.network.server.airship.main.MessageHelperGuiMainMenuConsumeBomb3;
import com.viesys.viesysmachines.network.server.airship.module.MessageGuiModuleMenu;
import com.viesys.viesysmachines.network.server.airship.module.MessageHelperGuiModuleBombActive;
import com.viesys.viesysmachines.network.server.airship.module.MessageHelperGuiModuleBombArmed;
import com.viesys.viesysmachines.network.server.airship.module.MessageHelperGuiModuleLearn;
import com.viesys.viesysmachines.network.server.airship.module.MessageHelperGuiModuleToggleSlot1;
import com.viesys.viesysmachines.network.server.airship.redstone.MessageGuiRedstoneMenu;
import com.viesys.viesysmachines.network.server.airship.redstone.MessageHelperGuiRedstoneMenuConsume;
import com.viesys.viesysmachines.network.server.airship.upgrade.MessageGuiUpgradeMenu;
import com.viesys.viesysmachines.network.server.airship.upgrade.MessageHelperGuiUpgradeBalloonVC;
import com.viesys.viesysmachines.network.server.airship.upgrade.MessageHelperGuiUpgradeCoreVC;
import com.viesys.viesysmachines.network.server.airship.upgrade.MessageHelperGuiUpgradeEngineVC;
import com.viesys.viesysmachines.network.server.airship.upgrade.MessageHelperGuiUpgradeFrameVC;
import com.viesys.viesysmachines.network.server.song.MessageGuiMusicPg1;
import com.viesys.viesysmachines.network.server.song.MessageHelperGuiMusicPg1;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	private static int entityID = 1;
	
	public static void preInit()
	{
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel(References.MOD_ID);
		
		register(MessageConfig.class, MessageConfig.class, Side.SERVER);
		
		register(MessageGuiMainMenu.class, MessageGuiMainMenu.class, Side.SERVER);
		
		register(MessageGuiUpgradeMenu.class, MessageGuiUpgradeMenu.class, Side.SERVER);
		register(MessageGuiCustomizeMenu.class, MessageGuiCustomizeMenu.class, Side.SERVER);
		register(MessageGuiModuleMenu.class, MessageGuiModuleMenu.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuChangeName.class, MessageGuiCustomizeMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuChangeName.class, MessageHelperGuiCustomizeMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuUndo.class, MessageHelperGuiCustomizeMenuUndo.class, Side.SERVER);
		register(MessageGuiRedstoneMenu.class, MessageGuiRedstoneMenu.class, Side.SERVER);
		register(MessageHelperGuiRedstoneMenuConsume.class, MessageHelperGuiRedstoneMenuConsume.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuCoreMain.class, MessageGuiCustomizeMenuCoreMain.class, Side.SERVER);
		register(MessageGuiCustomizeMenuCoreModelFramePg1.class, MessageGuiCustomizeMenuCoreModelFramePg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuCoreModelEnginePg1.class, MessageGuiCustomizeMenuCoreModelEnginePg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuCoreModelBalloonPg1.class, MessageGuiCustomizeMenuCoreModelBalloonPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuCoreModelFrame.class, MessageHelperGuiCustomizeMenuCoreModelFrame.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuCoreModelEngine.class, MessageHelperGuiCustomizeMenuCoreModelEngine.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuCoreModelBalloon.class, MessageHelperGuiCustomizeMenuCoreModelBalloon.class, Side.SERVER);
		
		
		register(MessageGuiCustomizeMenuFrameMain.class, MessageGuiCustomizeMenuFrameMain.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameTransparent.class, MessageHelperGuiCustomizeMenuFrameTransparent.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameColor.class, MessageGuiCustomizeMenuFrameColor.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameColorUndo.class, MessageGuiCustomizeMenuFrameColorUndo.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameColor.class, MessageHelperGuiCustomizeMenuFrameColor.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameColorDefault.class, MessageHelperGuiCustomizeMenuFrameColorDefault.class, Side.SERVER);
		
		
		register(MessageGuiCustomizeMenuFrameTier1Pg1.class, MessageGuiCustomizeMenuFrameTier1Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier1Pg2.class, MessageGuiCustomizeMenuFrameTier1Pg2.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier2Pg1.class, MessageGuiCustomizeMenuFrameTier2Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier3Pg1.class, MessageGuiCustomizeMenuFrameTier3Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier4Pg1.class, MessageGuiCustomizeMenuFrameTier4Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier5Pg1.class, MessageGuiCustomizeMenuFrameTier5Pg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameTier.class, MessageHelperGuiCustomizeMenuFrameTier.class, Side.SERVER);
		
		
		
		register(MessageGuiCustomizeMenuEngineMain.class, MessageGuiCustomizeMenuEngineMain.class, Side.SERVER);
		register(MessageGuiCustomizeMenuEngineDisplaySymbolPg1.class, MessageGuiCustomizeMenuEngineDisplaySymbolPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbol.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbol.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbolDefault.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbolDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuEngineDisplayBlockItemPg1.class, MessageGuiCustomizeMenuEngineDisplayBlockItemPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem.class, MessageHelperGuiCustomizeMenuEngineDisplayBlockItem.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayBlockItemDefault.class, MessageHelperGuiCustomizeMenuEngineDisplayBlockItemDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuEngineDisplayHeadPg1.class, MessageGuiCustomizeMenuEngineDisplayHeadPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayHead.class, MessageHelperGuiCustomizeMenuEngineDisplayHead.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayHeadDefault.class, MessageHelperGuiCustomizeMenuEngineDisplayHeadDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1.class, MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead.class, MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault.class, MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuEngineDisplayParticlePg1.class, MessageGuiCustomizeMenuEngineDisplayParticlePg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayParticle.class, MessageHelperGuiCustomizeMenuEngineDisplayParticle.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault.class, MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault.class, Side.SERVER);
		
		
		
		register(MessageGuiCustomizeMenuBalloonMain.class, MessageGuiCustomizeMenuBalloonMain.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonTransparent.class, MessageHelperGuiCustomizeMenuBalloonTransparent.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonColor.class, MessageGuiCustomizeMenuBalloonColor.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonColorUndo.class, MessageGuiCustomizeMenuBalloonColorUndo.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonColor.class, MessageHelperGuiCustomizeMenuBalloonColor.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonColorDefault.class, MessageHelperGuiCustomizeMenuBalloonColorDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuBalloonTier1Pg1.class, MessageGuiCustomizeMenuBalloonTier1Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier1Pg2.class, MessageGuiCustomizeMenuBalloonTier1Pg2.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier2Pg1.class, MessageGuiCustomizeMenuBalloonTier2Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier3Pg1.class, MessageGuiCustomizeMenuBalloonTier3Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier4Pg1.class, MessageGuiCustomizeMenuBalloonTier4Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier5Pg1.class, MessageGuiCustomizeMenuBalloonTier5Pg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonTier.class, MessageHelperGuiCustomizeMenuBalloonTier.class, Side.SERVER);
		
		
		
		
		
		register(MessageHelperGuiUpgradeFrameVC.class, MessageHelperGuiUpgradeFrameVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeCoreVC.class, MessageHelperGuiUpgradeCoreVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeEngineVC.class, MessageHelperGuiUpgradeEngineVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeBalloonVC.class, MessageHelperGuiUpgradeBalloonVC.class, Side.SERVER);
		
		
		
		
		
		
		
		
		
		
		register(MessageHelperGuiModuleLearn.class, MessageHelperGuiModuleLearn.class, Side.SERVER);
		register(MessageHelperGuiModuleToggleSlot1.class, MessageHelperGuiModuleToggleSlot1.class, Side.SERVER);
		
		register(MessageGuiPlayMusic.class, MessageGuiPlayMusic.class, Side.SERVER);
		register(MessageGuiPlayMusicArea.class, MessageGuiPlayMusicArea.class, Side.CLIENT);
		register(MessageGuiRandomMusic.class, MessageGuiRandomMusic.class, Side.SERVER);
		register(MessageGuiStopMusic.class, MessageGuiStopMusic.class, Side.SERVER);
		register(MessageGuiStopMusicArea.class, MessageGuiStopMusicArea.class, Side.CLIENT);
		
		register(MessageGuiMusicPg1.class, MessageGuiMusicPg1.class, Side.SERVER);
		register(MessageHelperGuiMusicPg1.class, MessageHelperGuiMusicPg1.class, Side.SERVER);
		
		register(MessageHelperGuiModuleBombArmed.class, MessageHelperGuiModuleBombArmed.class, Side.SERVER);
		register(MessageDropBombSmall.class, MessageDropBombSmall.class, Side.SERVER);
		register(MessageDropBombBig.class, MessageDropBombBig.class, Side.SERVER);
		register(MessageDropBombScatter.class, MessageDropBombScatter.class, Side.SERVER);
		register(MessageHelperGuiModuleBombActive.class, MessageHelperGuiModuleBombActive.class, Side.SERVER);
		
		register(MessageHelperGuiMainMenuConsumeBomb1.class, MessageHelperGuiMainMenuConsumeBomb1.class, Side.SERVER);
		register(MessageHelperGuiMainMenuConsumeBomb2.class, MessageHelperGuiMainMenuConsumeBomb2.class, Side.SERVER);
		register(MessageHelperGuiMainMenuConsumeBomb3.class, MessageHelperGuiMainMenuConsumeBomb3.class, Side.SERVER);
		
	}
	
	public static <REQ extends IMessage, REPLY extends IMessage> void register(Class<? extends IMessageHandler<REQ, REPLY>> message1, Class<REQ> message2, Side side)
	{
		INSTANCE.registerMessage(message1, message2, entityID++, side);
	}
	
	public static void sendToServer(IMessage message)
	{
		INSTANCE.sendToServer(message);
	}
	
	public static void sendToClient(IMessage message, EntityPlayerMP player)
	{
		INSTANCE.sendTo(message, player);
	}
	
	public static void sendToAllAround(IMessage message, TargetPoint point)
	{
		INSTANCE.sendToAllAround(message, point);
	}
	
	public static void sendToAll(IMessage message)
	{
		INSTANCE.sendToAll(message);
	}
	
	public static void sendToDimension(IMessage message, int dimensionId)
	{
		INSTANCE.sendToDimension(message, dimensionId);
	}
}
