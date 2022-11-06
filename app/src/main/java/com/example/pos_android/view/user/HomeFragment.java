package com.example.pos_android.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pos_android.R;
import com.example.pos_android.adapter.PopularAdapter;
import com.example.pos_android.contracts.UserHomeContract;
import com.example.pos_android.data.model.PopularModel;
import com.example.pos_android.data.model.UserHomeResponse;
import com.example.pos_android.databinding.FragmentHomeBinding;
import com.example.pos_android.presenter.UserHomePresenter;
import com.example.pos_android.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment implements UserHomeContract.View {
    PopularAdapter popularAdapter;
    PopularAdapter recentAdapter;
    UserHomePresenter presenter;
    List<SlideModel> slideModels = new ArrayList<>();
    ArrayList<PopularModel> popularArrayList = new ArrayList<>();
    ArrayList<PopularModel> recentArray = new ArrayList<>();
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();

        binding.imageSlider.setImageList(slideModels);

        binding.recentRecyclerview.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));
        recentAdapter = new PopularAdapter(recentArray,false,requireContext());
        binding.recentRecyclerview.setAdapter(recentAdapter);
    }

    private void initData() {

        presenter = new UserHomePresenter(HomeFragment.this, requireContext());
        presenter.getHomeDetails();

        slideModels.clear();
        slideModels.add(new SlideModel(R.drawable.poster, ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://c8.alamy.com/comp/2AAMYCB/set-of-poster-offer-delicious-fast-food-2AAMYCB.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://thumbs.dreamstime.com/z/fast-food-best-offer-banner-template-restaurant-cafe-design-element-poster-invitation-voucher-flyer-coupon-brochure-vector-153266434.jpg", ScaleTypes.FIT));

        recentArray.clear();
        recentArray.add(new PopularModel("Biriyani", R.drawable.dm1, "biriyaniii"));
        recentArray.add(new PopularModel("Mandhi", R.drawable.dm2, "delicious food"));
        recentArray.add(new PopularModel("Curry", R.drawable.dm3, "Fish curry"));
        recentArray.add(new PopularModel("Breakfast", R.drawable.dm4, "Break fast combo"));
        recentArray.add(new PopularModel("Meals", R.drawable.dm1, "Good meals"));

        binding.ivBooking.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_homeFragment_to_tableReservationFragment);
        });
    }

    @Override
    public void showProgressBar() {
        showLoadingDialog(requireContext());
    }

    @Override
    public void hideProgressBar() {
        hideLoadingDialog();
    }

    @Override
    public void showApiErrorWarning(String string) {
        hideLoadingDialog();
        showToast(requireContext(), string);
    }

    @Override
    public void showWarningMessage(String message) {
        showToast(requireContext(), message);
    }


    @Override
    public void showUserResponse(UserHomeResponse response) {
       // showToast(requireContext(), response.getMessage());
        popularArrayList.clear();
        for (UserHomeResponse.PopularFood food : response.getData().getPopularFoods()) {
            popularArrayList.add(new PopularModel(
                    food.getName(), food.getImage(), food.getPrice()
            ));
        }
        popularAdapter = new PopularAdapter(popularArrayList,requireContext());
        binding.popularRecyclerview.setAdapter(popularAdapter);
        binding.popularRecyclerview.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));

    }
}