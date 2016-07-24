package com.minecraft.moonlake.skinme;

import com.minecraft.moonlake.exception.player.PlayerNotOnlineException;
import com.minecraft.moonlake.skinme.api.Skinme;
import com.minecraft.moonlake.skinme.commands.Commandmlskinme;
import com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException;
import com.minecraft.moonlake.skinme.exception.IllegalMojangUserException;
import com.minecraft.moonlake.skinme.manager.SkinmeManager;
import com.minecraft.moonlake.util.Util;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by MoonLake on 2016/7/22.
 */
public class SkinmePlugin extends JavaPlugin implements Skinme {

    private final ConsoleCommandSender console;
    private static Skinme MAIN;

    public SkinmePlugin() {

        this.console = this.getServer().getConsoleSender();
    }

    @Override
    public void onEnable() {

        MAIN = this;

        this.getCommand("mlskinme").setExecutor(new Commandmlskinme(this));

        this.log("月色之湖皮肤 MoonLakeSkinme 插件 v" + getDescription().getVersion() + " 成功加载.");
    }

    @Override
    public void onDisable() {

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
     * 给控制台输出日志信息
     *
     * @param message 日志
     */
    @Override
    public void log(String message) {

        this.console.sendMessage("[MoonLakeSkinme] " + Util.color(message));
    }

    /**
     * 设置指定玩家的皮肤为目标玩家
     *
     * @param source 源玩家
     * @param target 目标玩家
     * @throws com.minecraft.moonlake.exception.player.PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangUserException 如果目标玩家不是正版用户则抛出异常
     * @throws com.minecraft.moonlake.skinme.exception.IllegalMojangSkinmeException 如果目标玩家没有皮肤数据则抛出异常
     */
    public void setSkinme(String source, String target) throws PlayerNotOnlineException, IllegalMojangUserException, IllegalMojangSkinmeException {

        SkinmeManager.setSkinme(source, target);
    }

    /**
     * 清除指定玩家的皮肤数据
     *
     * @param source 源玩家
     * @throws PlayerNotOnlineException 如果源玩家没有在线则抛出异常
     */
    @Override
    public void clearSkinme(String source) throws PlayerNotOnlineException {

        SkinmeManager.clearSkinme(source);
    }
}
