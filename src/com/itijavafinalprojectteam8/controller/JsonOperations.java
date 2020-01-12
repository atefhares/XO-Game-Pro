package com.itijavafinalprojectteam8.controller;

import com.itijavafinalprojectteam8.Constants;
import com.itijavafinalprojectteam8.controller.sec.PasswordHelper;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;

/**
 * @author ahares
 */
public class JsonOperations {

    public static String getResponseType(String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        return jsonObject.optString(Constants.JsonKeys.KEY_RESPONSE_TYPE);
    }

    public static String getSignInJson(String email, String plainPass) throws NoSuchAlgorithmException {
        JSONObject object = new JSONObject();
        object.put(Constants.JsonKeys.KEY_REQUEST_TYPE, Constants.ConnectionTypes.TYPE_SIGN_IN);
        object.put(Constants.JsonKeys.KEY_USER_EMAIL, email);
        object.put(Constants.JsonKeys.KEY_USER_PASSWORD, PasswordHelper.getEncryptedPassword(plainPass));
        return object.toString();
    }


    public static String getSignUpJson(String name, String email, String plainPass) throws NoSuchAlgorithmException {
        JSONObject object = new JSONObject();
        object.put(Constants.JsonKeys.KEY_REQUEST_TYPE, Constants.ConnectionTypes.TYPE_SIGN_UP);
        object.put(Constants.JsonKeys.KEY_USER_NAME, name);
        object.put(Constants.JsonKeys.KEY_USER_EMAIL, email);
        object.put(Constants.JsonKeys.KEY_USER_PASSWORD, PasswordHelper.getEncryptedPassword(plainPass));
        return object.toString();
    }

    public static int getResponseCode(String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        return jsonObject.getInt(Constants.JsonKeys.KEY_RESPONSE_CODE);
    }

    public static String getResponseMessage(String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        return jsonObject.optString(Constants.JsonKeys.KEY_RESPONSE_MSG);
    }

    public static String getAllPlayersJson() {
        JSONObject object = new JSONObject();
        object.put(Constants.JsonKeys.KEY_REQUEST_TYPE, Constants.ConnectionTypes.TYPE_GET_ALL_PLAYERS);
        return object.toString();
    }
}
