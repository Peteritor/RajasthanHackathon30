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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ItemTwoFragment extends Fragment {
    public String dept_name,Details;
    private EditText dept,detail;
    private Button btnpres;
    Spinner spinner;
    int cityString;
    public static ItemTwoFragment newInstance() {
        ItemTwoFragment fragment = new ItemTwoFragment();
        return fragment;
    }
//todo -----*****----- COMPLAINTS ARE TO BE PUT FROM HERE
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_two, container, false);
        dept=(EditText)v.findViewById(R.id.dept);
        detail=(EditText)v.findViewById(R.id.detail);
        btnpres=(Button) v.findViewById(R.id.raise_button);
        spinner = (Spinner)v.findViewById(R.id.spinninghere);
        List<String> categories = new ArrayList<String>();

        categories.add("PWD");
        categories.add("Electricity Board");
        categories.add("Municipalty");
//        categories.add("");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                dept_name=item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            dept_name="PWD";
            }
        });


        btnpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {        //TODO onclick button

//                dept_name=dept.getText().toString();
                Details=detail.getText().toString();

                String url = "https://data.bureaucrat75.hasura-app.io/v1/query";

                try {
                    OkHttpClient client = new OkHttpClient();

                    MediaType mediaType = MediaType.parse("application/json");
                    JSONObject jsonObject = new JSONObject()
                            .put("type", "insert")
                            .put("args", new JSONObject()
                                            .put("table", "Issue_tab")
                                            .put("objects", new JSONArray()
                                                            .put(new JSONObject()
                                                                            .put("dept_name", dept_name)
                                                                            .put("current_personel", "MR. First personel")
//                                            .put("previous_personel", "")
//                                            .put("Image_link", "")
//                                            .put("rating_1to5", "")
                                                                            .put("Level", 1)
//                                            .put("Id", "")
                                                                            .put("resolved", false)
                                                                            .put("days_to_go", "10")            // SETTING as DEFAULT 10 DAYS
                                                                            .put("author_username", MainActivity.username)
                                                                            .put("details",Details)
                                                            )
                                            )
                            );

                    RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
                    Request request = new Request.Builder()
                            .url(url)
                            .post(body)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(okhttp3.Call call, IOException e) {
                            Toast.makeText(getContext(), " Kindly check your internet connection \n      and try again !", Toast.LENGTH_LONG).show();
                            //Handle failure
                        }

                        @Override
                        public void onResponse(okhttp3.Call call, Response response) throws IOException {
                            //TODO clear all text fields and GoTO congtats Activity.
                            //GOTO NEXT ACTIVITY FOR INFORMATION AND RESTART
                            try {
                                dept.setText("");
                                detail.setText("");
                            }
                            catch (Exception e){

                            }
                            // Handle success
                            Intent i = new Intent(getContext(), complain_sucess.class);
                            startActivity(i);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });



        //        return inflater.inflate(R.layout.fragment_item_two, container, false);

        return v;
    }
}
