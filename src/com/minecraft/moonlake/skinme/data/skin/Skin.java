package com.minecraft.moonlake.skinme.data.skin;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class Skin {

    private SkinMetadata metadata;
    private String url;

    public Skin(SkinMetadata metadata, String url) {

        this.metadata = metadata;
        this.url = url;
    }

    /**
     * 获取此皮肤属性的元数据对象
     *
     * @return 元数据对象
     */
    public SkinMetadata getMetadata() {

        return metadata;
    }

    /**
     * 获取此皮肤属性的 URL 值
     *
     * @return URL 值
     */
    public String getUrl() {

        return url;
    }
}
