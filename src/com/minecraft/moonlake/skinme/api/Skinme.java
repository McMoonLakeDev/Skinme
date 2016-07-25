package com.minecraft.moonlake.skinme.api;

import com.minecraft.moonlake.skinme.SkinmePlugin;

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
     * 获取月色之湖皮肤实例对象
     *
     * @return 实例对象
     */
    Skinme getInstance();

    /**
     * 给控制台输出日志信息
     *
     * @param message 日志
     */
    void log(String message);

    /**
     * 获取月色之湖皮肤管理实例对象
     *
     * @return 管理实例对象
     */
    SkinmeManager getManager();
}
