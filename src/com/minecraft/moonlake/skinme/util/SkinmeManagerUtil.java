package com.minecraft.moonlake.skinme.util;

import com.minecraft.moonlake.exception.player.PlayerNotOnlineException;
import com.minecraft.moonlake.skinme.api.Skinme;
import com.minecraft.moonlake.skinme.api.SkinmeManager;
import com.minecraft.moonlake.skinme.data.UserSkinProfile;
import com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException;
import com.minecraft.moonlake.skinme.exception.IllegalMojangUserException;
import com.minecraft.moonlake.skinme.manager.SkinManager;
import org.bukkit.entity.Player;

/**
 * Created by MoonLake on 2016/7/25.
 */
public class SkinmeManagerUtil implements SkinmeManager {

    private final Skinme main;

    public SkinmeManagerUtil(Skinme main) {

        this.main = main;
    }

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws PlayerNotOnlineException     如果源玩家没有在线则抛出异常
     * @throws IllegalMojangUserException   如果目标玩家不是正版用户则抛出异常
     * @throws IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    @Override
    public void setSkinme(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException {

        SkinManager.setSkinme(source, target);
    }

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source            源玩家
     * @param targetSkinProfile 目标用户皮肤信息对象
     * @throws PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    @Override
    public void setSkinme(Player source, UserSkinProfile targetSkinProfile) throws PlayerNotOnlineException {

        SkinManager.setSkinme(source, targetSkinProfile);
    }

    /**
     * 设置指定玩家的皮肤为目标玩家 (异步不影响主线程)
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws PlayerNotOnlineException     如果源玩家没有在线则抛出异常
     * @throws IllegalMojangUserException   如果目标玩家不是正版用户则抛出异常
     * @throws IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    @Override
    public void setSkinmeAsync(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException {

        SkinManager.setSkinmeAsync(source, target);
    }

    /**
     * 设置指定玩家的皮肤为目标玩家 (异步不影响主线程)
     *
     * @param source            源玩家
     * @param targetSkinProfile 目标用户皮肤信息对象
     * @throws PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    @Override
    public void setSkinmeAsync(Player source, UserSkinProfile targetSkinProfile) throws PlayerNotOnlineException {

        SkinManager.setSkinmeAsync(source, targetSkinProfile);
    }

    /**
     * 清除指定玩家的皮肤数据
     *
     * @param source 源玩家
     * @throws PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    @Override
    public void clearSkinme(String source) throws PlayerNotOnlineException {

        SkinManager.clearSkinme(source);
    }
}
