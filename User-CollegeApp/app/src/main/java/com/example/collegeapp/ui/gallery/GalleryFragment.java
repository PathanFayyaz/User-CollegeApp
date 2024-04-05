package com.example.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView indRecycler, fresherRecycler, happeningRecycler, tripRecycler, farewellRecycler, otherRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        indRecycler = view.findViewById(R.id.indRecycler);
        fresherRecycler = view.findViewById(R.id.fresherRecycler);
        happeningRecycler = view.findViewById(R.id.happeningRecycler);
        tripRecycler = view.findViewById(R.id.tripRecycler);
        farewellRecycler = view.findViewById(R.id.farewellRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getindRecycler();

        //getfresherRecycler();

        gethappeningRecycler();

        gettripRecycler();

        getfarewellRecycler();

        getotherRecycler();

        return view;
    }

    private void getindRecycler() {
        reference.child("INDUCTION").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                indRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                indRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getfresherRecycler() {
        reference.child("FRESHER'S").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                fresherRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                fresherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void gethappeningRecycler() {
        reference.child("HAPPENINGS").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                happeningRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                happeningRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void gettripRecycler() {
        reference.child("TRIP").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                tripRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                tripRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getfarewellRecycler() {
        reference.child("FAREWELL").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                farewellRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                farewellRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getotherRecycler() {
        reference.child("OTHER").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot1: dataSnapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}