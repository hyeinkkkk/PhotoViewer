package com.hyein.photoviewer;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by nolgong-hyein on 2018. 1. 14..
 */

public class BasicAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private int layout;
    private static Context context;
    ArrayList<Photo> data = new ArrayList<>();

    public BasicAdapter(Context context, int layout, ArrayList<Photo> data){
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Photo getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflater.inflate(layout,viewGroup,false);
        }

        Photo photo = data.get(i);

        LinearLayout linearLayout = convertView.findViewById(R.id.basicLinearLayout);
        LinearLayout contentLinearLayout = convertView.findViewById(R.id.basicContentLinearLayout);
        TextView title = convertView.findViewById(R.id.basicTitleTextView);
        ImageView imageView = convertView.findViewById(R.id.basicImageView);
        TextView url = convertView.findViewById(R.id.basicUrlTextView);
        TextView size = convertView.findViewById(R.id.basicSizeTextView);
        TextView date = convertView.findViewById(R.id.basicDateTextView);

        title.setText(photo.getTitle());
        date.setText(data.get(i).getDate());


        if(photo.getUrl() != null){
            Glide.with(context).load(photo.getUrl()).into(imageView);
            url.setText(data.get(i).getUrl());
            size.setText(photo.getWidth()+ "x" +  photo.getHeight());

            //원래 속성으로 변경한다.
            imageView.setVisibility(View.VISIBLE);
            url.setVisibility(View.VISIBLE);
            size.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight=0.6f;
            contentLinearLayout.setLayoutParams(layoutParams);
            contentLinearLayout.setWeightSum(1.0f);

            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(100)));
        }else{
            //불필요한 공백을 지운다. 컨텐츠를 감싼 부모 레이아웃의 weightSum을 변경해 꽉 채울 수 있게 변경한다.
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight=0.9f;
            contentLinearLayout.setWeightSum(0.5f);
            contentLinearLayout.setLayoutParams(layoutParams);
            //정보가 없으므로, 필요없는 요소를 삭제한다.
            imageView.setVisibility(View.GONE);
            url.setVisibility(View.GONE);
            size.setVisibility(View.GONE);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(50)));
        }

        return convertView;
    }

    public static int dpToPx(int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }

}
