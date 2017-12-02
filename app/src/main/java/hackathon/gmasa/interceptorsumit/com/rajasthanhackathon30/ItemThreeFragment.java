package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.HTTP;

public class ItemThreeFragment extends Fragment {

    public int c=0;
    private int ID_issue;
    private String issue_details;
    private TextView alltext;

    private int Id;
    private String  author_username;
    private String  dept_name;
    private String current_personel;
    private String  previous_personel;
    private String  Image_link;
    private Boolean resolved;
    private int days_to_go;
    private String rating_1to5;
    private int Level;
    private String details;
    private TextView allIssuesdata,lasttext;
    private ProgressBar progress;


    public static ItemThreeFragment newInstance() {
        ItemThreeFragment fragment = new ItemThreeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_item_three, container, false);
        progress = (ProgressBar)v.findViewById(R.id.progress1);
        allIssuesdata=(TextView)v.findViewById(R.id.allIssuesdata);
        lasttext=(TextView)v.findViewById(R.id.lasttext);



        //TODO FOR GETTING LIST
        String url = "https://data.bureaucrat75.hasura-app.io/v1/query";

        try {
            final OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            JSONObject jsonObject = new JSONObject()
                    .put("type", "select")
                    .put("args", new JSONObject()
                            .put("table", "Issue_tab")
                            .put("columns", new JSONArray()
                                    .put("*")
                            )
                            .put("where", new JSONObject()
                                    .put("author_username", new JSONObject()
                                            .put("$eq", MainActivity.username)
                                    )
                            ).put("limit", "1")
                    );

            RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
            final Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    //Handle failure
                }

                @Override
                public void onResponse(okhttp3.Call call, Response response) throws IOException {
                    // Handle success
                    Response responseq = client.newCall(request).execute();
                    String responseString = responseq.body().string().replace("[","").replace("]","");

//                    getRetrofitObject();
                    Log.v("newyolo",responseString);

                    JSONObject jObj;

                    try
                    {
                        jObj = new JSONObject(responseString);
                        dept_name = jObj.getString("dept_name").toString();
                        days_to_go = jObj.getInt("days_to_go");
                        Id = jObj.getInt("Id");
                        author_username = jObj.getString("author_username").toString();
                        current_personel = jObj.getString("current_personel").toString();
                        previous_personel = jObj.getString("previous_personel").toString();
                        Image_link = jObj.getString("Image_link").toString();
                        resolved = jObj.getBoolean("resolved");
                        Level = jObj.getInt("Level");
                        rating_1to5 = jObj.getString("rating_1to5");
                        details = jObj.getString("details").toString();


                        //------***----
                        new Handler(Looper.getMainLooper()).post(new Runnable(){
                            @Override
                            public void run() {
                                allIssuesdata.setText("Department - "+dept_name
                                +"\nComplaint Id - "+Id+
                                        "\nCurrent personel - "+current_personel+
                                        "\nLevel of department - "+Level+
                                "\nComplaint Details - "+details+"\n\nTimeLine of issue raised"
                                );
                                Log.v("newyolooooooooo",current_personel+"--"+details+"--"+resolved+dept_name+"---->"+days_to_go);
                                lasttext.setText("\nDays left for resolving - "+days_to_go + " days left");
                                progress.setIndeterminate(false);
                                progress.setProgress((100-days_to_go*10));


                            }
                        });
                        //-------****---
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //TODO GETTING LIST


        return v;
    }
}
