package com.kimjinhwan.android.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnScale;
    private Button btnTranslate;
    private Button btnAlpha;
    private Button btnRotate;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnScale = (Button) findViewById(R.id.btnScale);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        imageView = (ImageView) findViewById(R.id.imageView);

        btnScale.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //미리 작성해놓은 애니메이션 설정파일을 로드
        Animation animation = null;
        switch(v.getId()){
            case R.id.btnTranslate:
                animation = AnimationUtils.loadAnimation(this, R.anim.trans);
                break;
            case R.id.btnRotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.btnAlpha:
                break;
            case R.id.btnScale:
                animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;
            case R.id.imageView:
                Intent intent = new Intent(this, WindmillActivity.class);
                startActivity(intent);

        }
        if(animation != null){
            imageView.startAnimation(animation);
        }

    }
}
