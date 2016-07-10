package com.example.rohan.bvpgo20.NavigationDrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.rohan.bvpgo20.R;

public class SportsActivity extends AppCompatActivity {

    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        setTitle("Sports");

        sliderLayout = (SliderLayout) findViewById(R.id.sportsSlider);

        DefaultSliderView defaultSliderView1 = new DefaultSliderView(SportsActivity.this);
        DefaultSliderView defaultSliderView2 = new DefaultSliderView(SportsActivity.this);
        DefaultSliderView defaultSliderView3 = new DefaultSliderView(SportsActivity.this);
        DefaultSliderView defaultSliderView4 = new DefaultSliderView(SportsActivity.this);
        DefaultSliderView defaultSliderView5 = new DefaultSliderView(SportsActivity.this);
        DefaultSliderView defaultSliderView6 = new DefaultSliderView(SportsActivity.this);

        defaultSliderView1.image("https://scontent.xx.fbcdn.net/v/t1.0-9/13100769_1282020421825860_1384366835614152397_n.jpg?oh=23210c137df3eb573fc0ac70c303bf31&oe=57B8FABA");
        defaultSliderView2.image("https://scontent.xx.fbcdn.net/v/t1.0-9/13096342_1282020711825831_1130473242951707053_n.jpg?oh=cc32be1e348c6be5cab49c52950b2178&oe=57E5C968");
        defaultSliderView3.image("https://scontent.xx.fbcdn.net/v/t1.0-9/13124581_1282021425159093_8899970118717992905_n.jpg?oh=5db72eef58d604c16458021dc5c414b9&oe=57A0DFD3");
        defaultSliderView4.image("https://scontent.xx.fbcdn.net/v/t1.0-9/13124744_1282024945158741_7818939809051807974_n.jpg?oh=e6781cc7c71a5281104aba3603cee1c4&oe=57A061B9");
        defaultSliderView5.image("https://scontent.xx.fbcdn.net/v/t1.0-9/13091999_1282030755158160_8922215487822118593_n.jpg?oh=c7a45a57b3599b334aa99834d8523551&oe=57A06C5E");
        defaultSliderView6.image("https://scontent.xx.fbcdn.net/hphotos-xlf1/v/t1.0-9/13139088_1282031025158133_8999593413208711502_n.jpg?oh=096e77883af6223eddb5f691ae20a967&oe=57AEE08F");

        sliderLayout.addSlider(defaultSliderView1);
        sliderLayout.addSlider(defaultSliderView2);
        sliderLayout.addSlider(defaultSliderView3);
        sliderLayout.addSlider(defaultSliderView4);
        sliderLayout.addSlider(defaultSliderView5);
        sliderLayout.addSlider(defaultSliderView6);

        sliderLayout.setDuration(3000);
        sliderLayout.setPresetTransformer(6);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

    }
}
