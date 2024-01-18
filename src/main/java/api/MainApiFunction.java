package api;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class MainApiFunction {

    public static String respBody;
    public static OkHttpClient client = new OkHttpClient();
    public static Request request;
    public static Root rootJSON;


    public static Response getResponse(String address) throws IOException {
        request = new Request.Builder().url(address).build();
        return client.newCall(request).execute();
    }

    public static Root getRootJSON(String address) throws IOException {
        respBody = getResponse(address).body().string();
        rootJSON = new Gson().fromJson(respBody, Root.class);
        return rootJSON;
    }

}
