package com.snxun.xm.zhgl.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.snxun.xm.zhgl.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * 普通
 * Created by liancl on 2019/4/11.
 */
public class ExpandView extends LinearLayout {
    TextView tvTitle;
    ImageView img;
    LinearLayout linTitle;
    boolean click;

    public ExpandView(@NonNull Context context) {
        super(context);
    }


    public ExpandView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ExpandView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ExpandView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandView);
        String title = typedArray.getString(R.styleable.ExpandView_ev_title);
        setOrientation(LinearLayout.VERTICAL);
        View inflate = LayoutInflater.from(context).inflate(R.layout.it_head_expand, this);
        tvTitle = inflate.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        img = inflate.findViewById(R.id.img);
        linTitle = inflate.findViewById(R.id.lin_title);
        linTitle.setOnClickListener(v -> {
            click=!click;
            hideView(click);
        });
        typedArray.recycle();
    }

    private void hideView(boolean click) {
        img.setImageResource(click?R.drawable.ic_down:R.drawable.ic_up);
        int childCount = getChildCount();
        if(childCount>0){
            for (int i = 0; i < childCount; i++) {
                if(i>0){
                    getChildAt(i).setVisibility(click?GONE:VISIBLE);
                }
            }
        }
    }

    public void setHide(boolean hide){
        hideView(hide);
    }
}
