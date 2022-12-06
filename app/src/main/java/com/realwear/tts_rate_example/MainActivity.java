package com.realwear.tts_rate_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }

    public void testSpeak(View view) {
        String testSpeech = "test test test test test test test";

        t1.speak(testSpeech, TextToSpeech.QUEUE_ADD, null, "test");
    }

    /**
     * Sets the speech rate to normal (1.0)
     * @param view
     */
    public void rateNormal(View view) {
        t1.setSpeechRate(1.0f);
    }

    /**
     * Sets the speech rate to twice the normal rate (2.0)
     * @param view
     */
    public void rateFast(View view) {
        t1.setSpeechRate(2.0f);
    }

    /**
     * Sets the speech rate to half the normal rate (0.5)
     * @param view
     */
    public void rateSlow(View view) {
        t1.setSpeechRate(.5f);
    }
}