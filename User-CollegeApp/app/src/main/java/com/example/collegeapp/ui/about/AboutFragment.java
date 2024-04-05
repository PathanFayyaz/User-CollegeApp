package com.example.collegeapp.ui.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;
    private ImageView map;

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        map = view.findViewById(R.id.map);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_mca, "Master of Computer Science", "Master of Computer Applications (MCA) is a two year professional post-graduate programme for candidates wanting to delve deeper into the world of computer application development with the help of learning modern programming language. The programme is a blend of both theoretical and practical knowledge."));
        list.add(new CourseModel(R.drawable.ic_mba, "Masters of Business Administration", "MBA stands for Masters of Business Administration. An MBA is an advanced degree that provides theoretical and practical training in business principles and leadership skills. MBA recipients obtain this postgraduate degree to further enhance their marketability as a professional."));

        adapter = new CourseAdapter(getContext(), list);


        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-bd964.appspot.com/o/userpic%2Fclg.jpg?alt=media&token=7af27b70-e9a0-4507-b9a4-71fcd3010165")
                .into(imageView);
        return  view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Allana Institute of Management Sciences");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}