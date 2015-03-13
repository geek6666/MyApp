package com.zy.myapp;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/3/10.
 */
public class PopActivity extends Activity implements View.OnClickListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_activity);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
//                buttonClick();
                buttonClick3();
                break;
        }
    }

    private void buttonClick3() {
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        final PopupWindow popupWindow = new PopupWindow(width, height);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(R.drawable.icon_zan);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        imageView.setLayoutParams(params);
        View rootView = View.inflate(this, R.layout.pop_item, null);
//        ImageView popImageView = (ImageView) rootView.findViewById(R.id.pop_item_image);
        View popImageView = rootView.findViewById(R.id.pop_item_view);

        PropertyValuesHolder aValuesHolder1 = PropertyValuesHolder.ofFloat(View.ALPHA, 0, 0.8f);
        PropertyValuesHolder scaleXValuesHolder1 = PropertyValuesHolder.ofFloat(View.SCALE_X, 0, 1.5f);
        PropertyValuesHolder scaleYValuesHolder1 = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0, 1.5f);
        PropertyValuesHolder translationValuesHolder1 = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0, -(height / 2 + 200));
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(popImageView, aValuesHolder1, translationValuesHolder1, scaleXValuesHolder1, scaleYValuesHolder1);
        objectAnimator1.setDuration(1000);


        PropertyValuesHolder aValuesHolder2 = PropertyValuesHolder.ofFloat(View.ALPHA, 0.8f, 0);
        PropertyValuesHolder scaleXValuesHolder2 = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.5f, 1f);
        PropertyValuesHolder scaleYValuesHolder2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.5f, 1f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(popImageView, aValuesHolder2, scaleXValuesHolder2, scaleYValuesHolder2);
        objectAnimator2.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator1).before(objectAnimator2);
        animatorSet.start();

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                popupWindow.dismiss();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        popupWindow.setContentView(rootView);
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
    }

    private void buttonClick2() {
//        Path path = new Path();
////        path.addCircle(100f, 100f, 50f, Path.Direction.CCW);
//        path.lineTo(100, 0);
//        path.lineTo(100, 50);
//        path.lineTo(40, 100);
//        path.lineTo(0, 0);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(button, "translationX", "translationY", path);
//
//        objectAnimator.setDuration(3000);
//        objectAnimator.start();

    }

    private void buttonClick() {
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.RED));
        popupWindow.setWidth(300);
        popupWindow.setHeight(300);
        popupWindow.setAnimationStyle(R.style.PopWindowAnimation);
        popupWindow.setOutsideTouchable(true);
        TextView textView = new TextView(this);
        textView.setText("测试");
        popupWindow.setContentView(textView);
        popupWindow.showAsDropDown(button, 0, 0);
        popupWindow.update();
    }
}
