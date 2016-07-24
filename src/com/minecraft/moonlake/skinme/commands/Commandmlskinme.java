package com.minecraft.moonlake.skinme.commands;

import com.minecraft.moonlake.skinme.api.Skinme;
import com.minecraft.moonlake.skinme.manager.SkinmeManager;
import com.minecraft.moonlake.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by MoonLake on 2016/7/24.
 */
public class Commandmlskinme implements CommandExecutor {

    private final Skinme main;

    public Commandmlskinme(Skinme main) {

        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {

        }
        else if(args.length == 1) {

        }
        else if(args.length == 2) {

        }
        else if(args.length == 3) {

            if(args[0].equalsIgnoreCase("set")) {

                SkinmeManager.setSkinme(args[1], args[2]);

                sender.sendMessage(Util.color("Skinme set to " + args[2] + " debug test."));
            }
        }
        return true;
    }

    private void mlskinmeHelp(CommandSender sender) {

        String[] helps = {

                "/mlskinme help - 查看皮肤插件命令帮助.",
                "/mlskinme set <S> <T> - 设置指定玩家的皮肤为目标皮肤."
        };
        sender.sendMessage(Util.color(helps));
    }
}
