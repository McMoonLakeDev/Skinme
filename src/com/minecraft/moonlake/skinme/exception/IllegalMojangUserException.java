package com.minecraft.moonlake.skinme.exception;

/**
 * Created by MoonLake on 2016/7/24.
 */
public class IllegalMojangUserException extends IllegalSkinmeException {

    public IllegalMojangUserException() {

        super("The Player Not Mojang User Exception.");
    }

    public IllegalMojangUserException(String message) {

        super(message);
    }

    public IllegalMojangUserException(Throwable throwable) {

        super(throwable);
    }

    public IllegalMojangUserException(String message, Throwable throwable) {

        super(message, throwable);
    }
}
