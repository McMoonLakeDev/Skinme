package com.minecraft.moonlake.skinme.manager;

import com.minecraft.moonlake.api.nms.packet.*;
import com.minecraft.moonlake.exception.player.PlayerNotOnlineException;
import com.minecraft.moonlake.manager.PlayerManager;
import com.minecraft.moonlake.reflect.Reflect;
import com.minecraft.moonlake.skinme.data.UserProfile;
import com.minecraft.moonlake.skinme.data.UserSkinProfile;
import com.minecraft.moonlake.skinme.data.UserSkinProperty;
import com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException;
import com.minecraft.moonlake.skinme.exception.IllegalMojangUserException;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.entity.Player;

/**
 * Created by MoonLake on 2016/7/24.
 */
public final class SkinmeManager {

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangUserException 如果目标玩家不是正版用户则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    public static void setSkinme(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException {

        Player player = PlayerManager.fromName(source);

        if(player == null || !player.isOnline()) {

            throw new PlayerNotOnlineException();
        }
        UserProfile targetProfile = NetManager.getUserProfile(target);

        if(targetProfile == null) {

            throw new IllegalMojangUserException();
        }
        UserSkinProfile targetSkinProfile = NetManager.getUserSkinProfile(targetProfile);

        if(targetSkinProfile == null || !targetSkinProfile.hasSkinProfile()) {

            throw new IllegalMojangSkinmeException();
        }
        UserSkinProperty targetSkinProperty = targetSkinProfile.getFirstSkinProfile();
        Property targetProperty = targetSkinProperty.toMojangProperty();
        GameProfile sourceGameProfile = PlayerManager.getProfile(player);

        sourceGameProfile.getProperties().get("textures").clear();
        sourceGameProfile.getProperties().put(targetProperty.getName(), targetProperty);

        updateSkinme(player, sourceGameProfile);
    }

    /**
     * 清除指定玩家的皮肤数据
     *
     * @param source 源玩家
     * @throws PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    public static void clearSkinme(String source) throws PlayerNotOnlineException {

        Player player = PlayerManager.fromName(source);

        if(player == null || !player.isOnline()) {

            throw new PlayerNotOnlineException();
        }
        GameProfile sourceGameProfile = PlayerManager.getProfile(player);

        sourceGameProfile.getProperties().get("textures").clear();

        updateSkinme(player, sourceGameProfile);
    }

    /**
     * 更新指定目标玩家的皮肤游戏数据
     *
     * @param player 玩家
     * @param playerGameProfile 玩家游戏信息
     */
    protected static void updateSkinme(Player player, GameProfile playerGameProfile) {

        // MoonLake NMS Packet Util Hyperlink: http://github.com/u2g/MoonLake

        PacketPlayOutPlayerInfo ppopi = PacketPlayOutPlayerInfo.autoMatch(PacketPlayOutPlayerInfo.PlayerInfoAction.REMOVE_PLAYER, player);
        PacketPlayOutEntityDestroy ppoed = new PacketPlayOutEntityDestroy(player);
        PacketPlayOutNamedEntitySpawn ppones = new PacketPlayOutNamedEntitySpawn(player);
        PacketPlayOutPlayerInfo ppopi1 = PacketPlayOutPlayerInfo.autoMatch(PacketPlayOutPlayerInfo.PlayerInfoAction.ADD_PLAYER, player);
        PacketPlayOutRespawn ppor = new PacketPlayOutRespawn(player);
        PacketPlayOutPosition ppop = new PacketPlayOutPosition(player.getLocation());
        PacketPlayOutEntityEquipment ppoee = new PacketPlayOutEntityEquipment(player, PacketPlayOutEntityEquipment.EquipmentSlot.MAINHAND, player.getInventory().getItemInMainHand());
        PacketPlayOutEntityEquipment ppoee1 = new PacketPlayOutEntityEquipment(player, PacketPlayOutEntityEquipment.EquipmentSlot.OFFHAND, player.getInventory().getItemInOffHand());
        PacketPlayOutEntityEquipment ppoee2 = new PacketPlayOutEntityEquipment(player, PacketPlayOutEntityEquipment.EquipmentSlot.HEAD, player.getInventory().getHelmet());
        PacketPlayOutEntityEquipment ppoee3 = new PacketPlayOutEntityEquipment(player, PacketPlayOutEntityEquipment.EquipmentSlot.CHEST, player.getInventory().getChestplate());
        PacketPlayOutEntityEquipment ppoee4 = new PacketPlayOutEntityEquipment(player, PacketPlayOutEntityEquipment.EquipmentSlot.LEGS, player.getInventory().getLeggings());
        PacketPlayOutEntityEquipment ppoee5 = new PacketPlayOutEntityEquipment(player, PacketPlayOutEntityEquipment.EquipmentSlot.FEET, player.getInventory().getBoots());
        PacketPlayOutHeldItemSlot ppohis = new PacketPlayOutHeldItemSlot(player.getInventory().getHeldItemSlot());
        PacketPlayOutAbilities ppoa = new PacketPlayOutAbilities(player);

        // update source player
        ppopi.send(player);
        ppopi1.send(player);
        ppor.send(player);
        ppoa.send(player);
        ppop.send(player);
        ppohis.send(player);

        try {

            Class<?> CraftPlayer = Reflect.PackageType.CRAFTBUKKIT_ENTITY.getClass("CraftPlayer");
            Class<?> EntityPlayer = Reflect.PackageType.MINECRAFT_SERVER.getClass("EntityPlayer");

            Object NMSPlayer = Reflect.getMethod(CraftPlayer, "getHandle").invoke(player);

            Reflect.getMethod(CraftPlayer, "updateScaledHealth").invoke(player);
            Reflect.getMethod(EntityPlayer, "triggerHealthUpdate").invoke(NMSPlayer);

            player.updateInventory();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        // update target player
        Player[] targetOnlines = PlayerManager.getOnlinesExceptTarget(player);

        ppoed.send(targetOnlines);
        ppopi.send(targetOnlines);
        ppopi1.send(targetOnlines);
        ppones.send(targetOnlines);
        ppoee.send(targetOnlines);
        ppoee1.send(targetOnlines);
        ppoee2.send(targetOnlines);
        ppoee3.send(targetOnlines);
        ppoee4.send(targetOnlines);
        ppoee5.send(targetOnlines);
    }
}
