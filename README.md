# 안드로이드 애니메이션

## 애니메이션 효과란
 - 뷰나 속성에 간단한 변형을 줄 수 있는 효과
 - 기존 레이아웃 애니메이션과 안드로이드 3.0 에서 추가된 구성요소(Property) 애니메이션으로 나눌 수 있음
 - 구글의 디자인 기조인 'Material Design'을 구현하기 위한 필수


 ## 애니메이션 효과의 종류 및 대표 속성
  - AlphaAnimation : 투명도
    > fromAlpha
    > toAlpha
  - RotateAnimation : 회전
    > fromDegrees
    > toDegrees
    > toYScale
    > pivotX
    > pivotY
    > startOffset
  - ScaleAnimation : 크기 변환
    > fromXScale
    > fromYScale
    > toXScale
    > toYScale
    > pivotX
    > pivotY
    > fillAfter
    > fillBefore
  - TranslateAnimation : 위치 이동
    > toXDelta
    > toYDelta

## 뷰 애니메이터
  - View에 대해서 애니메이션을 적용할 수 있음.
  - 커스텀 적용 하려면 res>anim 폴더에 anim 속성을 가진 xml 파일에 정의해야 함.
  - 구현시에는 Animation 클래스를 객체화한 후 AnimationUtils.loadAnimation함수로 불러옴.
  - 구현 예시(ScaleAnimation Custom)
     1. scale.xml (res/anim 폴더 내에 저장)
     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <scale
       xmlns:android="http://schemas.android.com/apk/res/android"


       android:fromXScale="1.0"
       android:fromYScale="1.0"

       android:toXScale="5.0"
       android:toYScale="5.0"
       android:fillAfter="true"
       android:duration="3000"
       >

     </scale>

     <!--fillAfter = 종료 후에 마지막 형태로 고정-->
     ```


  2. MainActivity.java (자바코드 구현)
    ```java
    //버튼을 누르면 애니메이션이 동작하도록 구현
    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
      private Button btnScale;

      @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

        Animation animation = null;
        switch(v.getId()){
          case R.id.btnScale:
          //미리 작성해놓은 애니메이션 설정파일을 AnimationUtils.loadAnimation으로드
               animation = AnimationUtils.loadAnimation(this, R.anim.scale);
               break;
             }
             if(animation != null){
               startAnimation(animation);
             }
          }  
    }


## 프로퍼티 애니메이션(Property Animation)
  - Object 등 거의 모든 것에 적용 가능한 애니메이션
  - 안드로이드 3.0 버전 이후 등장한 개념

### ObjectAnimator
  - 정의 :  ValueAnimator의 하위클래스. ValueAnimator보다는 사용하기가 편리하지만, 그만큼 제약사항도 많다.


  - 구현 예시 (특정 Object(버튼)를 Y축을 기준으로 원하는 값(-500)만큼 움직임)
    ```java
    //입력시 propertyName은 이미 지정된 값을 입력해야 함.
    ObjectAnimator transY = ObjectAnimator.ofFloat(button, "translationY", -500);
    //ofFLoat(버튼id, "속성 이름","원하는 값")
    ```

### AnimatiorSet
 - 정의 : 한 개의 오브젝트에 여러개의 프로퍼티 애니메이션을 동시에 주고 싶을 때 사용하는 세트.


  - 구현 예시
  ```java
  AnimatorSet aniSet = new AnimatorSet();

  ObjectAnimator transX = ObjectAnimator.ofFloat(button, "translationX", 500);

  ObjectAnimator transY = ObjectAnimator.ofFloat(button, "translationY", 300);

  //여러가지 애니메이션 합치기
  aniSet.playTogether(transX, transY);
  //합친 애니메이션의 재생시간(3초) 부여
  aniSet.setDuration(3000);    
  ```

## Interpolator
  - 정의 : 기본적인 애니메이션이 변화하는 속도를 정의해둔 인터페이스.


  - 사용 가능한 애니메이션
  
    > AlphaAnimation, ScaleAnimation, TranslateAnimation, RotateAnimation


## 참고사이트
  
  - 안드로이드 디자인 가이드
    > (영문) https://material.io/guidelines/
    > (한글) http://davidlab.net/google-design-ko/material-design/introduction.html
