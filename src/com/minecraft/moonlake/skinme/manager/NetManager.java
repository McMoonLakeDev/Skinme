package com.minecraft.moonlake.skinme.manager;

import com.google.gson.Gson;
import com.minecraft.moonlake.skinme.data.UserProfile;
import com.minecraft.moonlake.skinme.data.UserSkinProfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MoonLake on 2016/7/23.
 */
public final class NetManager {

    private final static String USER_PROFILE_URL;
    private final static String USER_PROFILE_SKIN_URL;

    static {

        USER_PROFILE_URL = "https://api.mojang.com/users/profiles/minecraft/";
        USER_PROFILE_SKIN_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";
    }

    /**
     * 获取指定玩家名的 Mojang 账户 Profile 信息对象
     *
     * @param name 玩家名
     * @return 用户信息对象 异常或没有返回 null
     */
    public static UserProfile getUserProfile(String name) {

        HttpURLConnection httpURLConnection = null;

        try {

            httpURLConnection = getConnection(USER_PROFILE_URL + name);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", "Premium-Checker");
            httpURLConnection.connect();

            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            String content = "";

            while((content = br.readLine()) != null) {

                stringBuffer.append(content);
            }
            br.close();

            content = stringBuffer.toString();

            if(content == null || content.isEmpty() || content.equals("null")) {

                return null;
            }
            return new Gson().fromJson(content, UserProfile.class);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {

            if(httpURLConnection != null) {

                httpURLConnection.disconnect();
            }
        }
        return null;
    }

    /**
     * 获取指定玩家名的 Mojang 账户 Skin Profile 信息对象
     *
     * @param profile 用户信息对象
     * @return 用户皮肤信息对象 异常或没有返回 null
     */
    public static UserSkinProfile getUserSkinProfile(UserProfile profile) {

        return profile != null ? getUserSkinProfile(profile.getId()) : null;
    }

    /**
     * 获取指定玩家的 Mojang 账户 Skin Profile 信息对象
     *
     * @param uuid 玩家 UUID
     * @return 用户皮肤信息对象 异常或没有返回 null
     */
    public static UserSkinProfile getUserSkinProfile(String uuid) {

        HttpURLConnection httpURLConnection = null;

        try {

            httpURLConnection = getConnection(USER_PROFILE_SKIN_URL + uuid.replace("-", "") + "?unsigned=false");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", "Premium-Checker");
            httpURLConnection.connect();

            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            String content = "";

            while((content = br.readLine()) != null) {

                stringBuffer.append(content);
            }
            br.close();

            content = stringBuffer.toString();

            if(content == null || content.isEmpty() || content.equals("null")) {

                return null;
            }
            return new Gson().fromJson(content, UserSkinProfile.class);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {

            if(httpURLConnection != null) {

                httpURLConnection.disconnect();
            }
        }
        return null;
    }

    /**
     * 获取指定网络连接地址的连接对象
     *
     * @param url 网址
     * @return 连接对象
     * @throws IOException if an I/O exception occurs.
     */
    protected static HttpURLConnection getConnection(String url) throws IOException {

        return getConnection(url, 5000);
    }

    /**
     * 获取指定网络连接地址的连接对象
     *
     * @param url 网址
     * @param timeout 超时时间
     * @return 连接对象
     * @throws IOException if an I/O exception occurs.
     */
    protected static HttpURLConnection getConnection(String url, int timeout) throws IOException {

        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        httpURLConnection.setConnectTimeout(timeout);
        httpURLConnection.setReadTimeout(timeout);
        return httpURLConnection;
    }
}
