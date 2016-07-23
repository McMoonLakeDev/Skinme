package com.minecraft.moonlake.skinme;

import com.minecraft.moonlake.skinme.api.Skinme;
import com.minecraft.moonlake.skinme.data.UserProfile;
import com.minecraft.moonlake.skinme.data.UserSkinProfile;
import com.minecraft.moonlake.skinme.data.skin.SkinProperty;
import com.minecraft.moonlake.skinme.manager.NetManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by MoonLake on 2016/7/22.
 */
public class SkinmePlugin extends JavaPlugin implements Skinme {

    @Override
    public void onEnable() {

        String target = "jeb_";

        UserProfile profile = NetManager.getUserProfile(target);

        if(profile != null) {

            System.out.println("[MoonLakeSkinme] 玩家 " + target + " 为正版玩家，其 UUID 为: " + profile.getId());
            System.out.println("[MoonLakeSkinme] 正在尝试获取此玩家的皮肤信息数据...");

            UserSkinProfile skinProfile = NetManager.getUserSkinProfile(profile);

            if(skinProfile != null) {

                System.out.println("[MoonLakeSkinme] 成功获取到此玩家的正版皮肤信息数据.");

                SkinProperty property = skinProfile.getFirstSkinProfile().getValueToSkinProperty();

                if(property != null) {

                    System.out.println("[MoonLakeSkinme] 其皮肤模型类型为: " + property.getModel());
                    System.out.println("[MoonLakeSkinme] 其皮肤模型类型是否为 Alex: " + property.isAlexModel());
                    System.out.println("[MoonLakeSkinme] 其皮肤材质指向的链接 URL 为: " + property.getSkinUrl());

                    boolean hasCape = property.hasCape();

                    System.out.println("[MoonLakeSkinme] 其皮肤属性是否拥有披风材质: " + hasCape);

                    if(hasCape) {

                        System.out.println("[MoonLakeSkinme] 其皮肤的披风材质指向的链接 URL 为: " + property.getCapeUrl());
                    }
                }
            }
        }
    }

    @Override
    public void onDisable() {

    }
}
