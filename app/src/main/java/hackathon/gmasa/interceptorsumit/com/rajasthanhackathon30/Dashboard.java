package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    selectedFragment = ItemOneFragment.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
//                    transaction.addToBackStack(null);
                    transaction.disallowAddToBackStack();
                    transaction.commit();
                    return true;
                case R.id.navigation_groups:
                    selectedFragment = ItemTwoFragment.newInstance();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.replace(R.id.frame_layout, selectedFragment);
//                    transaction1.addToBackStack(null);
                    transaction1.disallowAddToBackStack();
                    transaction1.commit();
                    return true;
                case R.id.navigation_post:
                    selectedFragment = ItemThreeFragment.newInstance();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.frame_layout, selectedFragment);
                    transaction2.disallowAddToBackStack();
                    transaction2.commit();
                    return true;

            }
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frame_layout, selectedFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
            return true;

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ItemOneFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
