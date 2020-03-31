package au.edu.unsw.infs3634.cryptobag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Initialising the restaurant arraylist and clicklistener
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private ArrayList<Restaurant> mRestaurants;
    private RecyclerViewClickListener mListener;

    // Defining the restaurant arraylist (stores restaurants) and clicklistener
    public RestaurantAdapter(ArrayList<Restaurant> restaurants, RecyclerViewClickListener listener) {
        mRestaurants = restaurants;
        mListener = listener;
    }

    // What happens if the clicklistener is clicked
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    // Setting up how the recyclerview looks like
    public static class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, cuisine, location;
        private RecyclerViewClickListener mListener;

        // Initialising and defining UI elements of the recyclerview
        public RestaurantViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.restaurantNameTV1);
            cuisine = v.findViewById(R.id.restaurantCuisineTV1);
            location = v.findViewById(R.id.restaurantLocationTV1);
        }

        // What happens if the user clicks an elements of the recyclerview
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    // Connecting the different restaurant_list_row instances to the recyclerview (there are multiple as there are many restaurants)
    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_row, parent, false);
        return new RestaurantViewHolder(v, mListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurant restaurant = mRestaurants.get(position);
        holder.name.setText(restaurant.getName());
        holder.cuisine.setText(restaurant.getcuisine());
        holder.location.setText(restaurant.getlocation());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }
}