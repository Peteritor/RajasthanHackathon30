package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class complain_sucess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_sucess);


    }
    public void done_here(View view){
        finish();
        Intent i = new Intent(getApplicationContext(), Dashboard.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
