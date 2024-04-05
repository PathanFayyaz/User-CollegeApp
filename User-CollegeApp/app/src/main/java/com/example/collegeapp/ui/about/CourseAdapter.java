package com.example.collegeapp.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.collegeapp.R;

import java.util.List;

public class CourseAdapter extends PagerAdapter {
    private Context context;
    private List<CourseModel> list;

    public CourseAdapter(Context context, List<CourseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_item_layout, container, false);

        ImageView mcaIcon;
        TextView  mcaTitle, mcaDesc;

        mcaIcon = view.findViewById(R.id.mca_icon);
        mcaTitle = view.findViewById(R.id.mca_title);
        mcaDesc = view.findViewById(R.id.mca_desc);

        mcaIcon.setImageResource(list.get(position).getImg());

        mcaTitle.setText(list.get(position).getTitle());
        mcaDesc.setText(list.get(position).getDescription());

        container.addView(view, 0);

        return view;

    }
}
