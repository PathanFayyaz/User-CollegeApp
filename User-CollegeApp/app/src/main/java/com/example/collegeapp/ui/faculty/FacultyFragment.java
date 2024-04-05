package com.example.collegeapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment,mechanicalDepartment,trainingDepartment,nonTeachingDepartment,supportingStaff,director;
    private LinearLayout csNoData,mechNoData,tpData,nonTeachData,sStaffData,directorData;
    private List<TeacherData> list1, list2,list3,list4,list5,list6;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        csDepartment = view.findViewById(R.id.csDepartment);
        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
        trainingDepartment = view.findViewById(R.id.trainingDepartment);
        nonTeachingDepartment = view.findViewById(R.id.nonTeachingDepartment);
        supportingStaff = view.findViewById(R.id.supportingStaff);
        director = view.findViewById(R.id.director);

        csNoData = view.findViewById(R.id.csNoData);
        mechNoData = view.findViewById(R.id.mechNoData);
        tpData = view.findViewById(R.id.tpData);
        nonTeachData = view.findViewById(R.id.nonTeachData);
        sStaffData = view.findViewById(R.id.sStaffData);
        directorData = view.findViewById(R.id.directorData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");



        csDepartment();
        mechanicalDepartment();
        trainingDepartment();
        nonTeachingDepartment();
        supportingStaff();
        director();


        return view;
    }

    private void director() {
        dbRef = reference.child("DIRECTOR");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    directorData.setVisibility(View.VISIBLE);
                    director.setVisibility(View.GONE);
                }else {
                    directorData.setVisibility(View.GONE);
                    director.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(0,data);
                    }
                    director.setHasFixedSize(true);
                    director.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6,getContext());
                    director.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("MCA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(0,data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void mechanicalDepartment() {
        dbRef = reference.child("MBA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else {
                    mechNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(0,data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void trainingDepartment() {
        dbRef = reference.child("Training and Placement");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    tpData.setVisibility(View.VISIBLE);
                    trainingDepartment.setVisibility(View.GONE);
                }else {
                    tpData.setVisibility(View.GONE);
                    trainingDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(0,data);
                    }
                    trainingDepartment.setHasFixedSize(true);
                    trainingDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    trainingDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void nonTeachingDepartment() {
        dbRef = reference.child("Non Teaching");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    nonTeachData.setVisibility(View.VISIBLE);
                    nonTeachingDepartment.setVisibility(View.GONE);
                }else {
                    nonTeachData.setVisibility(View.GONE);
                    nonTeachingDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(0,data);
                    }
                    nonTeachingDepartment.setHasFixedSize(true);
                    nonTeachingDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    nonTeachingDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void supportingStaff() {
        dbRef = reference.child("Supporting Staff");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    sStaffData.setVisibility(View.VISIBLE);
                    supportingStaff.setVisibility(View.GONE);
                }else {
                    sStaffData.setVisibility(View.GONE);
                    supportingStaff.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(0,data);
                    }
                    supportingStaff.setHasFixedSize(true);
                    supportingStaff.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    supportingStaff.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}