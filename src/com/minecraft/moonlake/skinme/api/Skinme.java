package com.minecraft.moonlake.skinme.api;

import com.minecraft.moonlake.exception.player.PlayerNotOnlineException;
import com.minecraft.moonlake.skinme.SkinmePlugin;
import com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException;
import com.minecraft.moonlake.skinme.exception.IllegalMojangUserException;

/**
 * Created by MoonLake on 2016/7/22.
 */
public interface Skinme {

    /**
     * 获取插件的主类对象
     *
     * @return 主类
     */
    SkinmePlugin getMain();

    /**
     * 给控制台输出日志信息
     *
     * @param message 日志
     */
    void log(String message);

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangUserException 如果目标玩家不是正版用户则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    void setSkinme(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException;

    /**
     * 清除指定玩家的皮肤数据
     *
     * @param source 源玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    void clearSkinme(String source) throws PlayerNotOnlineException;
}
