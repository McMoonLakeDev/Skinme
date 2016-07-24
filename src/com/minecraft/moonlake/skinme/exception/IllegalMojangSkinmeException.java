package com.minecraft.moonlake.skinme.exception;

/**
 * Created by MoonLake on 2016/7/24.
 */
public class IllegalMojangSkinmeException extends IllegalSkinmeException {

    public IllegalMojangSkinmeException() {

        super("The Player Not Mojang Skinme Exception.");
    }

    public IllegalMojangSkinmeException(String message) {

        super(message);
    }

    public IllegalMojangSkinmeException(Throwable throwable) {

        super(throwable);
    }

    public IllegalMojangSkinmeException(String message, Throwable throwable) {

        super(message, throwable);
    }
}
