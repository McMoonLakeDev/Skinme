package com.minecraft.moonlake.skinme.data.skin;

/**
 * Created by MoonLake on 2016/7/23.
 */
public class SkinMetadata {

    private String model;

    public SkinMetadata(String model) {

        this.model = model;
    }

    /**
     * 获取此皮肤元数据的模型类型
     *
     * @return 模型类型
     */
    public String getModel() {

        return model;
    }

    /**
     * 获取此皮肤元数据的模型类型是否为 Alex
     *
     * @return true 则为 Alex 否则不是
     */
    public boolean isAlexModel() {

        return model != null && model.equals("slim");
    }
}
