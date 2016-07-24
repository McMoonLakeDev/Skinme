package com.minecraft.moonlake.skinme.exception;

/**
 * Created by MoonLake on 2016/7/24.
 */
public class IllegalSkinmeException extends RuntimeException {

    public IllegalSkinmeException() {

        super("The MoonLake Skinme Exception.");
    }

    public IllegalSkinmeException(String message) {

        super(message);
    }

    public IllegalSkinmeException(Throwable throwable) {

        super(throwable);
    }

    public IllegalSkinmeException(String message, Throwable throwable) {

        super(message, throwable);
    }
}
