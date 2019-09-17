package com.example.casper.debugapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewMainActivity extends AppCompatActivity {

    private Button buttonPrevious, buttonNext;
    private ImageView imageViewFunny ;
    private int[] imageIDArray = {R.drawable.funny_1, R.drawable.funny_2
            , R.drawable.funny_3, R.drawable.funny_4, R.drawable.funny_5
            , R.drawable.funny_6
    };
    private int imageIDArrayCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_main);
        buttonPrevious = (Button)findViewById(R.id.button_previous);
        buttonNext =(Button) findViewById(R.id.button_next);
        imageViewFunny = (ImageView)findViewById(R.id.image_view_funny);
        buttonPrevious.setOnClickListener(new MyButtonClickListener());
        buttonNext.setOnClickListener(new MyButtonClickListener());

    }

    private class MyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (((Button) view).getText() == buttonNext.getText()) {
                imageIDArrayCurrentIndex ++;
            } else {
                imageIDArrayCurrentIndex --;
            }
           imageIDArrayCurrentIndex=(imageIDArrayCurrentIndex+imageIDArray.length)%imageIDArray.length;
            Log.i("mymess", "onClick: "+imageIDArrayCurrentIndex);
            imageViewFunny.setImageResource(imageIDArray[imageIDArrayCurrentIndex]);
        }
    }
}
