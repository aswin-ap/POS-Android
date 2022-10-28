package com.example.pos_android.view.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pos_android.R;
import com.example.pos_android.adapters.PopularAdapter;
import com.example.pos_android.data.model.PopularModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    List<SlideModel> slideModels = new ArrayList<>();
    ArrayList<PopularModel> popularArrayList = new ArrayList<>();
    ArrayList<PopularModel> recentArray = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageSlider imgSlider = view.findViewById(R.id.image_slider);
        RecyclerView popularRecyclerView = view.findViewById(R.id.popular_recyclerview);
        RecyclerView recentRecyclerview = view.findViewById(R.id.recent_recyclerview);

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
        slideModels.add(new SlideModel("https://images.app.goo.gl/iwRjbCkMhjRqU3QKA", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/id/237/200/300", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/seed/picsum/200/300", ScaleTypes.FIT));



        popularArrayList.add(new PopularModel("Biriyani", R.drawable.dm1, "biriyaniii"));
        popularArrayList.add(new PopularModel("Mandhi", R.drawable.dm2, "delicious food"));
        popularArrayList.add(new PopularModel("Curry", R.drawable.dm3, "Fish curry"));
        popularArrayList.add(new PopularModel("Breakfast", R.drawable.dm4, "Break fast combo"));
        popularArrayList.add(new PopularModel("Meals", R.drawable.dm1, "Good meals"));

        recentArray.add(new PopularModel("Cake", R.drawable.dm3, "Fish curry"));
        recentArray.add(new PopularModel("Brosted", R.drawable.dm1, "biriyaniii"));
        recentArray.add(new PopularModel("Mandhi", R.drawable.dm2, "delicious food"));
    }
}