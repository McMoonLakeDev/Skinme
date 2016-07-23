package com.minecraft.moonlake.skinme.data;

import java.util.List;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class UserSkinProfile {

    private UserProfile profile;
    private List<UserSkinProperty> properties;

    public UserSkinProfile(UserProfile profile, List<UserSkinProperty> properties) {

        this.profile = profile;
        this.properties = properties;
    }

    public UserSkinProfile(String id, String name, List<UserSkinProperty> properties) {

        this(new UserProfile(id, name), properties);
    }

    /**
     * 获取此用户的信息对象
     *
     * @return 信息对象
     */
    public UserProfile getProfile() {

        return profile;
    }

    /**
     * 获取此用户的皮肤属性对象集合
     *
     * @return 皮肤属性对象集合
     */
    public List<UserSkinProperty> getProperties() {

        return properties;
    }

    /**
     * 获取此用户是否拥有皮肤属性
     *
     * @return true 则拥有皮肤属性 else 没有
     */
    public boolean hasSkinProfile() {

        return properties != null && properties.size() > 0;
    }

    /**
     * 获取此用户的首皮肤属性对象
     *
     * @return 首皮肤属性对象 没有则返回 null
     */
    public UserSkinProperty getFirstSkinProfile() {

        return hasSkinProfile() ? properties.get(0) : null;
    }

    /**
     * 复制此用户的皮肤属性对象
     *
     * @return 皮肤属性对象
     */
    @Override
    public UserSkinProfile clone() {

        return new UserSkinProfile(profile, properties);
    }
}
