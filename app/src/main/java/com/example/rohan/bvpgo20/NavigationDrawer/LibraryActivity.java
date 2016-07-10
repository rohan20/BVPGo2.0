package com.example.rohan.bvpgo20.NavigationDrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.rohan.bvpgo20.R;

public class LibraryActivity extends AppCompatActivity {

    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        setTitle("Library");

        sliderLayout = (SliderLayout) findViewById(R.id.librarySlider);

        DefaultSliderView defaultSliderView1 = new DefaultSliderView(LibraryActivity.this);
        defaultSliderView1.image("http://bvcoend.ac.in/images/upload/BVPFILE80184094475175FILE91801UPLOAD647133.jpg");
        DefaultSliderView defaultSliderView2 = new DefaultSliderView(LibraryActivity.this);
        defaultSliderView2.image("http://bvcoend.ac.in/images/upload/BVPFILE24699439740316FILE23684UPLOAD9410882.jpg");
        DefaultSliderView defaultSliderView3 = new DefaultSliderView(LibraryActivity.this);
        defaultSliderView3.image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/BVCOE_Library.JPG/220px-BVCOE_Library.JPG");

        sliderLayout.addSlider(defaultSliderView1);
        sliderLayout.addSlider(defaultSliderView2);
        sliderLayout.addSlider(defaultSliderView3);

        sliderLayout.setDuration(3000);
        sliderLayout.setPresetTransformer(4);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

    }
}
