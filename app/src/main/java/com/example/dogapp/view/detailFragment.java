package com.example.dogapp.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapp.R;
import com.example.dogapp.databinding.FragmentDetailBinding;
import com.example.dogapp.model.DogBreed;

public class detailFragment extends Fragment {

    private DogBreed dogBreed;
    private FragmentDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dogBreed = (DogBreed) getArguments().getSerializable("dogBreed");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.fragment_detail, null, false);
        View viewRoot = binding.getRoot();
        binding.setDog(dogBreed);
        return viewRoot;


    }
}