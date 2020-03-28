package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setting the layout for the additon to the large screen.
        setContentView(R.layout.activity_detail);

        // Receive information for the positon
        Intent intent = getIntent();
        int position = intent.getIntExtra("EXTRA_MESSAGE", 0);

        // Add the fragment to its position
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new DetailFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.detailContainerScroll, fragment).commit();
    }
}
