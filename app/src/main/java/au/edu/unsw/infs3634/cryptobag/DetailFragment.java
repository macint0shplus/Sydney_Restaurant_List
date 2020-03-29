package au.edu.unsw.infs3634.cryptobag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView restaurantName;
    private TextView restaurantCuisine;
    private TextView restaurantLocation;
    private RatingBar restaurantRating;
    private TextView restaurantPhone;
    private ImageView restaurantSearch;
    private Restaurant myRestaurant;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        boolean mTwoPane = false;
        int position = 0;
        int dd = 0;

        restaurantName = v.findViewById(R.id.restaurantNameTV2);
        restaurantCuisine = v.findViewById(R.id.restaurantCuisineTV2);
        restaurantLocation = v.findViewById(R.id.restaurantLocationTV2);
        restaurantRating = v.findViewById(R.id.restaurantRatingTV2);
        restaurantPhone = v.findViewById(R.id.restaurantPhoneTV2);
        restaurantSearch = v.findViewById(R.id.restaurantSearchTV2);

        if (this.getArguments() != null) {
            mTwoPane = getArguments().getBoolean("position", true);
        }

        if (mTwoPane) {
            myRestaurant = Restaurant.getRestaurants().get(getArguments().getInt("position"));
        } else {
            Intent intent = getActivity().getIntent();
            position = intent.getIntExtra("EXTRA_MESSAGE", 0);
            myRestaurant = myRestaurant.getRestaurants().get(position);
        }
        restaurantName.setText(String.valueOf(myRestaurant.getName()));
        restaurantCuisine.setText(String.valueOf(myRestaurant.getcuisine()));
        restaurantLocation.setText(String.valueOf(myRestaurant.getlocation()));
        restaurantRating.setRating((float)myRestaurant.getrating());
        restaurantPhone.setText(String.valueOf(myRestaurant.getphone()));
        restaurantSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchRestaurant(myRestaurant.getName());
            }
        });

        return v;
    }

    private void searchRestaurant(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }
}