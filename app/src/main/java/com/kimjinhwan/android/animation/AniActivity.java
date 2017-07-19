package com.kimjinhwan.android.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

public class AniActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRed;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        initView();
    }

    private void initView() {
        btnRed = (Button) findViewById(R.id.btnRed);
        button6 = (Button) findViewById(R.id.button6);

        btnRed.setOnClickListener(this);
        button6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.button6:
                ObjectAnimator transY = ObjectAnimator.ofFloat(btnRed, "translationY", -500);
                ObjectAnimator transX = ObjectAnimator.ofFloat(btnRed, "translationX", 300);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(btnRed, "rotation", 1440);

                //오브젝트 애니메이터 여러개를 동시에 실행시킬 '세트' 꾸미기
                AnimatorSet aniSet = new AnimatorSet();
                aniSet.playTogether(transX, transY, rotate); //개수의 제한이 없음.
                aniSet.setDuration(3000);
                aniSet.setInterpolator(new AccelerateDecelerateInterpolator()); //
                aniSet.start();
                break;
            case R.id.btnRed:
                
                break;
        }
    }
}
