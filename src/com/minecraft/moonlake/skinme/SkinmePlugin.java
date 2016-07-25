package com.minecraft.moonlake.skinme;

import com.minecraft.moonlake.MoonLakePlugin;
import com.minecraft.moonlake.skinme.api.Skinme;
import com.minecraft.moonlake.skinme.api.SkinmeManager;
import com.minecraft.moonlake.skinme.commands.Commandmlskinme;
import com.minecraft.moonlake.skinme.util.SkinmeManagerUtil;
import com.minecraft.moonlake.util.Util;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by MoonLake on 2016/7/22.
 */
public class SkinmePlugin extends JavaPlugin implements Skinme {

    private SkinmeManager manager;
    private final ConsoleCommandSender console;
    private static Skinme MAIN;

    public SkinmePlugin() {

        this.console = this.getServer().getConsoleSender();
    }

    @Override
    public void onEnable() {

        MAIN = this;

        if(!setupMoonLake()) {

            this.log("前置月色之湖核心 API 插件加载失败.");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        manager = new SkinmeManagerUtil(getInstance());

        this.getCommand("mlskinme").setExecutor(new Commandmlskinme(this));
        this.log("月色之湖皮肤 MoonLakeSkinme 插件 v" + getDescription().getVersion() + " 成功加载.");
    }

    @Override
    public void onDisable() {

    }

    /**
     * 加载前置月色之湖核心 API 插件
     *
     * @return 是否成功
     */
    private boolean setupMoonLake() {

        Plugin plugin = this.getServer().getPluginManager().getPlugin("MoonLake");
        return plugin != null && plugin instanceof MoonLakePlugin;
    }

    /**
     * 获取月色之湖皮肤实例对象
     *
     * @return 实例对象
     */
    public static Skinme getInstances() {

        return MAIN;
    }

    /**
     * 获取插件的主类对象
     *
     * @return 主类
     */
    @Override
    public SkinmePlugin getMain() {

        return this;
    }

    /**
     * 获取月色之湖皮肤实例对象
     *
     * @return 实例对象
     */
    @Override
    public Skinme getInstance() {

        return MAIN;
    }

    /**
     * 给控制台输出日志信息
     *
     * @param message 日志
     */
    @Override
    public void log(String message) {

        this.console.sendMessage("[MoonLakeSkinme] " + Util.color(message));
    }

    /**
     * 获取月色之湖皮肤管理实例对象
     *
     * @return 管理实例对象
     */
    @Override
    public SkinmeManager getManager() {

        return manager;
    }
}
