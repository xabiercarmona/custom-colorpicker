package com.etxazpi.tools.sample;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.etxazpi.tools.colorpicker.ColorPickerDialog;

public class MainActivity extends AppCompatActivity {

    private static int[] getColors(Context context) {
        int[] mColorChoices = null;
        String[] color_array = context.getResources().
                getStringArray(R.array.color_choices);

        if (color_array != null && color_array.length > 0) {
            mColorChoices = new int[color_array.length];
            for (int i = 0; i < color_array.length; i++) {
                mColorChoices[i] = Color.parseColor(color_array[i]);
            }
        }
        return mColorChoices;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorPickerDialog colorcalendar = ColorPickerDialog.newInstance(
                R.string.color_picker_default_title,
                getColors(getApplicationContext()),
                0,
                5,
                ColorPickerDialog.SIZE_SMALL);
        colorcalendar.show(getFragmentManager(), "cal");
    }
}
