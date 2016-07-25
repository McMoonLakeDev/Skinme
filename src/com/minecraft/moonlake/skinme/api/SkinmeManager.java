package com.minecraft.moonlake.skinme.api;

import com.minecraft.moonlake.exception.player.PlayerNotOnlineException;
import com.minecraft.moonlake.skinme.data.UserSkinProfile;
import com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException;
import com.minecraft.moonlake.skinme.exception.IllegalMojangUserException;
import org.bukkit.entity.Player;

/**
 * Created by MoonLake on 2016/7/25.
 */
public interface SkinmeManager {

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangUserException 如果目标玩家不是正版用户则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    @Deprecated
    void setSkinme(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException;

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source 源玩家
     * @param targetSkinProfile 目标用户皮肤信息对象
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    @Deprecated
    void setSkinme(Player source, UserSkinProfile targetSkinProfile) throws PlayerNotOnlineException;

    /**
     * 设置指定玩家的皮肤为目标玩家 (异步不影响主线程)
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangUserException 如果目标玩家不是正版用户则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    void setSkinmeAsync(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException;

    /**
     * 设置指定玩家的皮肤为目标玩家 (异步不影响主线程)
     *
     * @param source 源玩家
     * @param targetSkinProfile 目标用户皮肤信息对象
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    void setSkinmeAsync(Player source, UserSkinProfile targetSkinProfile) throws PlayerNotOnlineException;

    /**
     * 清除指定玩家的皮肤数据
     *
     * @param source 源玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    void clearSkinme(String source) throws PlayerNotOnlineException;
}
