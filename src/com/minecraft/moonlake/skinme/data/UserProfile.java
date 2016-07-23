package com.minecraft.moonlake.skinme.data;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class UserProfile {

    private String id;
    private String name;

    public UserProfile(String id, String name) {

        this.id = id;
        this.name = name;
    }

    /**
     * 获取此用户的 UUID 值
     *
     * @return UUID
     */
    public String getId() {

        return id;
    }

    /**
     * 获取此用户的名称值
     *
     * @return 名称
     */
    public String getName() {

        return name;
    }

    /**
     * 复制此用户的信息对象
     *
     * @return 复制的信息对象
     */
    @Override
    public UserProfile clone() {

        return new UserProfile(id, name);
    }
}
