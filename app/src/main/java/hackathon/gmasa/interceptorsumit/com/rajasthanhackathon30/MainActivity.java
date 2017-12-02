package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public EditText usernameEdit;

    private Button btnNext;
    public static String username;
    public String url1 = "https://data.bureaucrat75.hasura-app.io/";



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext=(Button)findViewById(R.id.nextBtn);
        usernameEdit=(EditText)findViewById(R.id.usernameEdit);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=usernameEdit.getText().toString();
                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
            }
        });


        //-------*****************HASURA------------
//
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
//                                            .put("$eq", "Aubrey")
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
//                    // Handle success
//                    Response responseq = client.newCall(request).execute();
//                    String responseString = responseq.body().string().replace("[","").replace("]","");
//
////                    getRetrofitObject();
//                    Log.v("newyolo",responseString);
//
//                    JSONObject jObj;
//                    String areaString = "";
//                    int cityString=0 ;
//                    try
//                    {
//                        jObj = new JSONObject(responseString);
//                        areaString = jObj.getString("name").toString();
//                        cityString = jObj.getInt("id");
//                        Log.v("newyolo",areaString+"---->"+cityString);
//                    }
//                    catch (JSONException e)
//                    {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        //todo Getting data in variables here



        //-------*****************HASURA------------
    }

}//End of mainActivity
