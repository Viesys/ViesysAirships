package com.vies.viesmachines.network;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.network.client.MessageConfig;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger01Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger02Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger04Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger05Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger11Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger12Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger13Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger21Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger22Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger23Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger31Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger32Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger33Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger41Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger42Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger43Client;
import com.vies.viesmachines.network.client.tileentity.MessageGuiExtractorSyncClientOn;
import com.vies.viesmachines.network.client.tileentity.MessageGuiKitFabricatorSyncClientGem;
import com.vies.viesmachines.network.client.tileentity.MessageGuiKitFabricatorSyncClientOn;
import com.vies.viesmachines.network.server.machine.MessageFlyingThunderStrike;
import com.vies.viesmachines.network.server.machine.MessageMachineProjectileShoot;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger01Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger02Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger04Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger05Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger11Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger12Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger13Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger21Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger22Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger23Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger31Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger32Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger33Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger41Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger42Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger43Server;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizePrimaryDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizePrimaryTransparent;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizeSecondaryDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizeSecondaryTransparent;
import com.vies.viesmachines.network.server.machine.gui.customize.activemodels.MessageGuiMachineMenuCustomizeActiveModels;
import com.vies.viesmachines.network.server.machine.gui.customize.activemodels.MessageHelperGuiMachineMenuCustomizeActiveModelApply;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.MessageGuiMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplayBlockItemPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplayHeadPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplaySymbolPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItem;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayClear;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayHead;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbol;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday4thofJuly;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayChristmas;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayEaster;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayNewYears;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayThanksgiving;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayValentinesDay;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday4thofJuly;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayChristmas;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayHalloween;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayNewYears;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayThanksgiving;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayValentinesDay;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHoliday4thofJuly;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayChristmas;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayEaster;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayNewYears;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayThanksgiving;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayValentinesDay;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageHelperGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageGuiMachineMenuCustomizePrimarySkinColor;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageGuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageGuiMachineMenuCustomizeSecondarySkinColor;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainArmed;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainAutorun;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainCompress;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainCompressClientAll;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainPowered;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageGuiMachineMenuChangeName;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeName;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeNameColor;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeNameUndo;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageGuiMachineMenuSelectProjectile;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletConsume;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletElectrical;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletExplosive;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletNormal;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageGuiMachineMenuSelectMusic;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicPlay;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicPlayArea;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicRandom;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicSet;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicStop;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicStopArea;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuStats;
import com.vies.viesmachines.network.server.tileentity.MessageGuiExtractorSyncServerOn;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerGem;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerOn;
import com.vies.viesmachines.network.server.world.PlayerMessageAutorunDisabled;
import com.vies.viesmachines.network.server.world.PlayerMessageAutorunEnabled;
import com.vies.viesmachines.network.server.world.PlayerMessageMachineBroken;
import com.vies.viesmachines.network.server.world.PlayerMessageNameColor;
import com.vies.viesmachines.network.server.world.PlayerMessagePoweredOnDisabled;
import com.vies.viesmachines.network.server.world.PlayerMessagePoweredOnEnabled;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualPrimaryColorSelected;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualPrimaryTextureSelected;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualPrimaryTransparentDisabled;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualPrimaryTransparentEnabled;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualSecondaryColorSelected;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualSecondaryTextureSelected;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualSecondaryTransparentDisabled;
import com.vies.viesmachines.network.server.world.PlayerMessageVisualSecondaryTransparentEnabled;
import com.vies.viesmachines.network.server.world.PlayerMessageWeaponSystemDisabled;
import com.vies.viesmachines.network.server.world.PlayerMessageWeaponSystemEnabled;
import com.vies.viesmachines.network.server.world.PlayerMessageWeaponSystemError;
import com.vies.viesmachines.network.server.world.PlayerMessageWeaponSystemOutOfAmmo;

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
		
		
		
		register(MessageGuiMachineMenuMain.class, MessageGuiMachineMenuMain.class, Side.SERVER);
		register(MessageGuiMachineMenuSelectMusic.class, MessageGuiMachineMenuSelectMusic.class, Side.SERVER);
		register(MessageGuiMachineMenuChangeName.class, MessageGuiMachineMenuChangeName.class, Side.SERVER);
		register(MessageGuiMachineMenuSelectProjectile.class, MessageGuiMachineMenuSelectProjectile.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMusicSet.class, MessageHelperGuiMachineMusicSet.class, Side.SERVER);
		register(MessageHelperGuiMachineMusicPlay.class, MessageHelperGuiMachineMusicPlay.class, Side.SERVER);
		register(MessageHelperGuiMachineMusicPlayArea.class, MessageHelperGuiMachineMusicPlayArea.class, Side.CLIENT);
		register(MessageHelperGuiMachineMusicStop.class, MessageHelperGuiMachineMusicStop.class, Side.SERVER);
		register(MessageHelperGuiMachineMusicStopArea.class, MessageHelperGuiMachineMusicStopArea.class, Side.CLIENT);
		register(MessageHelperGuiMachineMusicRandom.class, MessageHelperGuiMachineMusicRandom.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuChangeName.class, MessageHelperGuiMachineMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuChangeNameUndo.class, MessageHelperGuiMachineMenuChangeNameUndo.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuChangeNameColor.class, MessageHelperGuiMachineMenuChangeNameColor.class, Side.SERVER);
		
		
		register(MessageHelperGuiMachineMenuMainCompress.class, MessageHelperGuiMachineMenuMainCompress.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainCompressClientAll.class, MessageHelperGuiMachineMenuMainCompressClientAll.class, Side.CLIENT);
		register(MessageHelperGuiMachineMenuMainPowered.class, MessageHelperGuiMachineMenuMainPowered.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainAutorun.class, MessageHelperGuiMachineMenuMainAutorun.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainArmed.class, MessageHelperGuiMachineMenuMainArmed.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuSelectProjectileBulletConsume.class, MessageHelperGuiMachineMenuSelectProjectileBulletConsume.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletNormal.class, MessageHelperGuiMachineMenuSelectProjectileBulletNormal.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletElectrical.class, MessageHelperGuiMachineMenuSelectProjectileBulletElectrical.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletExplosive.class, MessageHelperGuiMachineMenuSelectProjectileBulletExplosive.class, Side.SERVER);
		
		
		register(MessageGuiMachineMenuStats.class, MessageGuiMachineMenuStats.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomize.class, MessageGuiMachineMenuCustomize.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuCustomizePrimaryTransparent.class, MessageHelperGuiMachineMenuCustomizePrimaryTransparent.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondaryTransparent.class, MessageHelperGuiMachineMenuCustomizeSecondaryTransparent.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimaryDefault.class, MessageHelperGuiMachineMenuCustomizePrimaryDefault.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondaryDefault.class, MessageHelperGuiMachineMenuCustomizeSecondaryDefault.class, Side.SERVER);
		
		
		
		register(MessageGuiMachineMenuCustomizeActiveModels.class, MessageGuiMachineMenuCustomizeActiveModels.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplayBanner.class, MessageGuiMachineMenuCustomizeDisplayBanner.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayClear.class, MessageHelperGuiCustomizeMenuEngineDisplayClear.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbol.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbol.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayNewYears.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayNewYears.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayValentinesDay.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayValentinesDay.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayEaster.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayEaster.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday4thofJuly.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday4thofJuly.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayThanksgiving.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayThanksgiving.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayChristmas.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayChristmas.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday.class, Side.SERVER);
		
		
		
		register(MessageGuiMachineMenuCustomizeDisplayBlockItemPg1.class, MessageGuiMachineMenuCustomizeDisplayBlockItemPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem.class, MessageHelperGuiCustomizeMenuEngineDisplayBlockItem.class, Side.SERVER);
		
		
		register(MessageGuiMachineMenuCustomizeDisplayHeadPg1.class, MessageGuiMachineMenuCustomizeDisplayHeadPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayHead.class, MessageHelperGuiCustomizeMenuEngineDisplayHead.class, Side.SERVER);
		
		
		register(MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1.class, MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead.class, MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead.class, Side.SERVER);
		
		
		
		
		register(MessageGuiMachineMenuCustomizePrimarySkinTexture.class, MessageGuiMachineMenuCustomizePrimarySkinTexture.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayNewYears.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayNewYears.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayValentinesDay.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayValentinesDay.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday4thofJuly.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday4thofJuly.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayHalloween.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayHalloween.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayThanksgiving.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayThanksgiving.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayChristmas.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayChristmas.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday.class, MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday.class, Side.SERVER);
		
		
		register(MessageGuiMachineMenuCustomizePrimarySkinColor.class, MessageGuiMachineMenuCustomizePrimarySkinColor.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply.class, MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault.class, MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault.class, Side.SERVER);
		
		
		register(MessageGuiMachineMenuCustomizeSecondarySkinTexture.class, MessageGuiMachineMenuCustomizeSecondarySkinTexture.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayNewYears.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayNewYears.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayValentinesDay.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayValentinesDay.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayEaster.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayEaster.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHoliday4thofJuly.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHoliday4thofJuly.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayThanksgiving.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayThanksgiving.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayChristmas.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayChristmas.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday.class, Side.SERVER);
		
		
		register(MessageGuiMachineMenuCustomizeSecondarySkinColor.class, MessageGuiMachineMenuCustomizeSecondarySkinColor.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault.class, Side.SERVER);
		
		
		register(MessageHelperGuiMachineMenuCustomizeActiveModelApply.class, MessageHelperGuiMachineMenuCustomizeActiveModelApply.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinTexture.class, MessageHelperGuiMachineMenuCustomizePrimarySkinTexture.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture.class, Side.SERVER);
		
		
		
		
		
		register(MessageFlyingThunderStrike.class, MessageFlyingThunderStrike.class, Side.SERVER);
		register(MessageMachineProjectileShoot.class, MessageMachineProjectileShoot.class, Side.SERVER);
		
		
		
		
		
		
		register(PlayerMessagePoweredOnEnabled.class, PlayerMessagePoweredOnEnabled.class, Side.SERVER);
		register(PlayerMessagePoweredOnDisabled.class, PlayerMessagePoweredOnDisabled.class, Side.SERVER);
		
		register(PlayerMessageWeaponSystemError.class, PlayerMessageWeaponSystemError.class, Side.SERVER);
		register(PlayerMessageWeaponSystemEnabled.class, PlayerMessageWeaponSystemEnabled.class, Side.SERVER);
		register(PlayerMessageWeaponSystemDisabled.class, PlayerMessageWeaponSystemDisabled.class, Side.SERVER);
		register(PlayerMessageWeaponSystemOutOfAmmo.class, PlayerMessageWeaponSystemOutOfAmmo.class, Side.SERVER);
		
		register(PlayerMessageAutorunEnabled.class, PlayerMessageAutorunEnabled.class, Side.SERVER);
		register(PlayerMessageAutorunDisabled.class, PlayerMessageAutorunDisabled.class, Side.SERVER);
		
		register(PlayerMessageNameColor.class, PlayerMessageNameColor.class, Side.SERVER);
		register(PlayerMessageMachineBroken.class, PlayerMessageMachineBroken.class, Side.SERVER);
		
		register(PlayerMessageVisualPrimaryColorSelected.class, PlayerMessageVisualPrimaryColorSelected.class, Side.SERVER);
		
		
		register(PlayerMessageVisualPrimaryTextureSelected.class, PlayerMessageVisualPrimaryTextureSelected.class, Side.SERVER);
		register(PlayerMessageVisualPrimaryTransparentDisabled.class, PlayerMessageVisualPrimaryTransparentDisabled.class, Side.SERVER);
		register(PlayerMessageVisualPrimaryTransparentEnabled.class, PlayerMessageVisualPrimaryTransparentEnabled.class, Side.SERVER);
		
		register(PlayerMessageVisualSecondaryColorSelected.class, PlayerMessageVisualSecondaryColorSelected.class, Side.SERVER);
		
		
		
		register(PlayerMessageVisualSecondaryTextureSelected.class, PlayerMessageVisualSecondaryTextureSelected.class, Side.SERVER);
		register(PlayerMessageVisualSecondaryTransparentDisabled.class, PlayerMessageVisualSecondaryTransparentDisabled.class, Side.SERVER);
		register(PlayerMessageVisualSecondaryTransparentEnabled.class, PlayerMessageVisualSecondaryTransparentEnabled.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuCustomizeActiveModelApply.class, MessageHelperGuiMachineMenuCustomizeActiveModelApply.class, Side.SERVER);
		
		register(MessageGuiExtractorSyncClientOn.class, MessageGuiExtractorSyncClientOn.class, Side.CLIENT);
		register(MessageGuiExtractorSyncServerOn.class, MessageGuiExtractorSyncServerOn.class, Side.SERVER);
		
		register(MessageGuiKitFabricatorSyncClientOn.class, MessageGuiKitFabricatorSyncClientOn.class, Side.CLIENT);
		register(MessageGuiKitFabricatorSyncServerOn.class, MessageGuiKitFabricatorSyncServerOn.class, Side.SERVER);
		register(MessageGuiKitFabricatorSyncClientGem.class, MessageGuiKitFabricatorSyncClientGem.class, Side.CLIENT);
		register(MessageGuiKitFabricatorSyncServerGem.class, MessageGuiKitFabricatorSyncServerGem.class, Side.SERVER);
		
		
		
		register(MessageHelperEventTrigger01Client.class, MessageHelperEventTrigger01Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger02Client.class, MessageHelperEventTrigger02Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger04Client.class, MessageHelperEventTrigger04Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger05Client.class, MessageHelperEventTrigger05Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger11Client.class, MessageHelperEventTrigger11Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger12Client.class, MessageHelperEventTrigger12Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger13Client.class, MessageHelperEventTrigger13Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger21Client.class, MessageHelperEventTrigger21Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger22Client.class, MessageHelperEventTrigger22Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger23Client.class, MessageHelperEventTrigger23Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger31Client.class, MessageHelperEventTrigger31Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger32Client.class, MessageHelperEventTrigger32Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger33Client.class, MessageHelperEventTrigger33Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger41Client.class, MessageHelperEventTrigger41Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger42Client.class, MessageHelperEventTrigger42Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger43Client.class, MessageHelperEventTrigger43Client.class, Side.CLIENT);
		
		register(MessageHelperEventTrigger01Server.class, MessageHelperEventTrigger01Server.class, Side.SERVER);
		register(MessageHelperEventTrigger02Server.class, MessageHelperEventTrigger02Server.class, Side.SERVER);
		register(MessageHelperEventTrigger04Server.class, MessageHelperEventTrigger04Server.class, Side.SERVER);
		register(MessageHelperEventTrigger05Server.class, MessageHelperEventTrigger05Server.class, Side.SERVER);
		register(MessageHelperEventTrigger11Server.class, MessageHelperEventTrigger11Server.class, Side.SERVER);
		register(MessageHelperEventTrigger12Server.class, MessageHelperEventTrigger12Server.class, Side.SERVER);
		register(MessageHelperEventTrigger13Server.class, MessageHelperEventTrigger13Server.class, Side.SERVER);
		register(MessageHelperEventTrigger21Server.class, MessageHelperEventTrigger21Server.class, Side.SERVER);
		register(MessageHelperEventTrigger22Server.class, MessageHelperEventTrigger22Server.class, Side.SERVER);
		register(MessageHelperEventTrigger23Server.class, MessageHelperEventTrigger23Server.class, Side.SERVER);
		register(MessageHelperEventTrigger31Server.class, MessageHelperEventTrigger31Server.class, Side.SERVER);
		register(MessageHelperEventTrigger32Server.class, MessageHelperEventTrigger32Server.class, Side.SERVER);
		register(MessageHelperEventTrigger33Server.class, MessageHelperEventTrigger33Server.class, Side.SERVER);
		register(MessageHelperEventTrigger41Server.class, MessageHelperEventTrigger41Server.class, Side.SERVER);
		register(MessageHelperEventTrigger42Server.class, MessageHelperEventTrigger42Server.class, Side.SERVER);
		register(MessageHelperEventTrigger43Server.class, MessageHelperEventTrigger43Server.class, Side.SERVER);
		
		
		
		//register(.class, .class, Side.SERVER);
		
		
		
		
		/**
		//register(MessageBrokenMachineParticles.class, MessageBrokenMachineParticles.class, Side.SERVER);
		//register(MessageBrokenMachineParticlesArea.class, MessageBrokenMachineParticlesArea.class, Side.CLIENT);
		
		
		
		
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
		*/
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
