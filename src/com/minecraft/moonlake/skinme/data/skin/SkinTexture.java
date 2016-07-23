package com.minecraft.moonlake.skinme.data.skin;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class SkinTexture {

    private Skin SKIN;
    private Cape CAPE;

    public SkinTexture(Skin skin, Cape cape) {

        this.SKIN = skin;
        this.CAPE = cape;
    }

    /**
     * 获取此皮肤材质的皮肤属性对象
     *
     * @return 皮肤属性对象
     */
    public Skin getSkin() {

        return SKIN;
    }

    /**
     * 获取此皮肤材质的披风属性对象
     *
     * @return 披风属性对象
     */
    public Cape getCape() {

        return CAPE;
    }

    /**
     * 获取此皮肤材质是否拥有披风属性
     *
     * @return true 则拥有披风属性 else 没有
     */
    public boolean hasCape() {

        return CAPE != null;
    }

    /**
     * 复制此皮肤材质的皮肤属性对象
     *
     * @return 皮肤属性对象
     */
    @Override
    public SkinTexture clone() {

        return new SkinTexture(SKIN, CAPE);
    }
}
