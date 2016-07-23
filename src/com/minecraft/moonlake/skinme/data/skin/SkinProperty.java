package com.minecraft.moonlake.skinme.data.skin;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class SkinProperty {

    private long timestamp;
    private String profileId;
    private String profileName;
    private SkinTexture textures;

    public SkinProperty(long timestamp, String profileId, String profileName, SkinTexture textures) {

        this.timestamp = timestamp;
        this.profileId = profileId;
        this.profileName = profileName;
        this.textures = textures;
    }

    /**
     * 获取此皮肤属性对象的时间戳值
     *
     * @return 时间戳
     */
    public long getTimestamp() {

        return timestamp;
    }

    /**
     * 获取此皮肤属性对象的信息 UUID 值
     *
     * @return UUID 值
     */
    public String getProfileId() {

        return profileId;
    }

    /**
     * 获取此皮肤属性对象的信息名称值
     *
     * @return 名称值
     */
    public String getProfileName() {

        return profileName;
    }

    /**
     * 获取此皮肤属性对象的材质对象
     *
     * @return 材质对象
     */
    public SkinTexture getTextures() {

        return textures;
    }

    /**
     * 获取此皮肤属性对象的皮肤元数据的模型类型
     *
     * @return 模型类型
     */
    public String getModel() {

        return textures != null && textures.getSkin() != null && textures.getSkin().getMetadata() != null ? textures.getSkin().getMetadata().getModel() : null;
    }

    /**
     * 获取此皮肤属性对象的皮肤元数据的模型类型是否为 Alex
     *
     * @return true 则为 Alex 否则不是
     */
    public boolean isAlexModel() {

        return textures != null && textures.getSkin() != null && textures.getSkin().getMetadata() != null && textures.getSkin().getMetadata().isAlexModel();
    }

    /**
     * 获取此皮肤属性对象的皮肤 URL 值
     *
     * @return 披风 URL 值
     */
    public String getSkinUrl() {

        return textures != null && textures.getSkin() != null ? textures.getSkin().getUrl() : null;
    }

    /**
     * 获取此皮肤属性对象的披风 URL 值
     *
     * @return 披风 URL 值
     */
    public String getCapeUrl() {

        return hasCape() ? textures.getCape().getUrl() : null;
    }

    /**
     * 获取此皮肤属性对象是否拥有披风属性
     *
     * @return true 则拥有披风属性 else 没有
     */
    public boolean hasCape() {

        return textures != null && textures.hasCape();
    }

    /**
     * 复制此皮肤属性的对象
     *
     * @return 皮肤属性对象
     */
    @Override
    public SkinProperty clone() {

        return new SkinProperty(timestamp, profileId, profileName, textures);
    }
}
