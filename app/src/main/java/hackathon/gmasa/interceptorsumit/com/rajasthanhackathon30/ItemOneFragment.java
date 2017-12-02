package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ItemOneFragment extends Fragment {

    TextView t;
    String areaString = "";
    int cityString=0 ;

    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_one, container, false);
        t = (TextView)v.findViewById(R.id.text1);
//        final String url = "https://data.bureaucrat75.hasura-app.io/v1/query";
//
//        try {
//            final OkHttpClient client = new OkHttpClient();
//            MediaType mediaType = MediaType.parse("application/json");
//            JSONObject jsonObject = new JSONObject()
//                    .put("type", "select")
//                    .put("args", new JSONObject()
//                            .put("table", "author")
//                            .put("columns", new JSONArray()
//                                    .put("*")
//                            )
//                            .put("where", new JSONObject()
//                                    .put("name", new JSONObject()
//                                            .put("$eq", MainActivity.username)      //todo getting v=required person
//                                    )
//                            )
//                    );
//
//            RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
//            final Request request = new Request.Builder()
//                    .url(url)
//                    .post(body)
//                    .build();
//
//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(okhttp3.Call call, IOException e) {
//                    //Handle failure
//                }
//
//                @Override
//                public void onResponse(okhttp3.Call call, Response response) throws IOException {
//
//                }
//            });
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        //todo Getting data in variables here



//        t = (TextView)inflater.inflate(R.layout.fragment_item_one.findViewbyId(R.id.text1);
//        return inflater.inflate(R.layout.fragment_item_one, container, false);
        return v;
    }

}
