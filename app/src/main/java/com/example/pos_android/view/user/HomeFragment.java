package com.example.pos_android.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pos_android.R;
import com.example.pos_android.adapter.PopularAdapter;
import com.example.pos_android.data.model.PopularModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    View view;
    CardView bookingImage;
    List<SlideModel> slideModels = new ArrayList<>();
    ArrayList<PopularModel> popularArrayList = new ArrayList<>();
    ArrayList<PopularModel> recentArray = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imgSlider = view.findViewById(R.id.image_slider);
        RecyclerView popularRecyclerView = view.findViewById(R.id.popular_recyclerview);
        RecyclerView recentRecyclerview = view.findViewById(R.id.recent_recyclerview);
        bookingImage = view.findViewById(R.id.iv_booking);

        initData();


        imgSlider.setImageList(slideModels);

        PopularAdapter popularAdapter = new PopularAdapter(popularArrayList);
        popularRecyclerView.setAdapter(popularAdapter);
        popularRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));

        popularAdapter = new PopularAdapter(recentArray);
        recentRecyclerview.setAdapter(popularAdapter);
        recentRecyclerview.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));

        return view;
    }

    private void initData() {
        slideModels.add(new SlideModel(R.drawable.poster, ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://c8.alamy.com/comp/2AAMYCB/set-of-poster-offer-delicious-fast-food-2AAMYCB.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://thumbs.dreamstime.com/z/fast-food-best-offer-banner-template-restaurant-cafe-design-element-poster-invitation-voucher-flyer-coupon-brochure-vector-153266434.jpg", ScaleTypes.FIT));


        popularArrayList.add(new PopularModel("Biriyani", R.drawable.dm1, "biriyaniii"));
        popularArrayList.add(new PopularModel("Mandhi", R.drawable.dm2, "delicious food"));
        popularArrayList.add(new PopularModel("Curry", R.drawable.dm3, "Fish curry"));
        popularArrayList.add(new PopularModel("Breakfast", R.drawable.dm4, "Break fast combo"));
        popularArrayList.add(new PopularModel("Meals", R.drawable.dm1, "Good meals"));

        recentArray.add(new PopularModel("Cake", R.drawable.dm3, "Fish curry"));
        recentArray.add(new PopularModel("Brosted", R.drawable.dm1, "biriyaniii"));
        recentArray.add(new PopularModel("Mandhi", R.drawable.dm2, "delicious food"));

        bookingImage.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_tableReservationFragment);
        });
    }
}