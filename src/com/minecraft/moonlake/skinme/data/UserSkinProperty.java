package com.minecraft.moonlake.skinme.data;

import com.google.gson.Gson;
import com.minecraft.moonlake.skinme.data.skin.SkinProperty;
import com.mojang.authlib.properties.Property;

import java.util.Base64;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class UserSkinProperty {

    private String name;
    private String value;
    private String signature;

    public UserSkinProperty(String name, String value, String signature) {

        this.name = name;
        this.value = value;
        this.signature = signature;
    }

    /**
     * 获取此用户的皮肤属性的名称值
     *
     * @return 名称
     */
    public String getName() {

        return name;
    }

    /**
     * 获取此用户的皮肤属性值 (未解码)
     *
     * @return 皮肤属性值
     */
    public String getValue() {

        return value;
    }

    /**
     * 获取此用户的皮肤属性是拥有签名
     *
     * @return true 则拥有签名 else 没有
     */
    public boolean hasSignature() {

        return this.signature != null;
    }

    /**
     * 获取此用户的皮肤属性签名
     *
     * @return 皮肤属性签名
     */
    public String getSignature() {

        return signature;
    }

    /**
     * 获取此用户的皮肤属性值 (已解码)
     *
     * @return 皮肤属性值
     */
    public String getValueToDecoder() {

        return value != null ? new String(Base64.getDecoder().decode(value)) : null;
    }

    /**
     * 获取此用户的皮肤属性对象的 (已转换对象)
     *
     * @return 皮肤属性对象
     */
    public SkinProperty getValueToSkinProperty() {

        return value != null ? new Gson().fromJson(getValueToDecoder(), SkinProperty.class) : null;
    }

    @Override
    public UserSkinProperty clone() {

        return new UserSkinProperty(name, value, signature);
    }

    /**
     * 将此用户的皮肤属性对象转换为 Mojang 皮肤属性对象
     *
     * @return Mojang 的皮肤属性对象
     */
    public Property toMojangProperty() {

        return new Property(name, value, signature);
    }
}
