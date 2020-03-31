package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Defining the thee pillars of recycler view
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // Boolean for whether or not the view is large enough
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting the recyclerView to a view
        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);

        // Connecting recyclerView to layoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // If detailContainer exists, then we are using a widescreen. So, we need to setup the fragment.
        // If not, then we just intent to another screen with the correct information.
        mTwoPane = findViewById((R.id.detailContainer)) != null;
        RestaurantAdapter.RecyclerViewClickListener listener = new RestaurantAdapter.RecyclerViewClickListener() {
            public void onClick(View view, int position) {
                if (mTwoPane) { // Organise fragment
                    final FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    Bundle arguments = new Bundle();
                    arguments.putInt("position", position); // Pass identifier of restaurant
                    DetailFragment fragment = new DetailFragment(); // Send position to the detailFragment
                    fragment.setArguments(arguments);
                    transaction.replace(R.id.detailContainer, fragment);
                    transaction.commit();
                } else {
                    launchDetailActivity(position); // Go to new screen with identifier of restaurant
                }
            }
        };

        // Connect recyclerView to Adapter
        mAdapter = new RestaurantAdapter(Restaurant.getRestaurants(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    // New activity to page with restaurant details
    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("EXTRA_MESSAGE", position);
        startActivity(intent);
    }
}
