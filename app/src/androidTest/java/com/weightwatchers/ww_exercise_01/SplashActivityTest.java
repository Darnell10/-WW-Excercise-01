package com.weightwatchers.ww_exercise_01;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.weightwatchers.ww_exercise_01.ui.MainActivity;
import com.weightwatchers.ww_exercise_01.ui.WW_Splash;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<WW_Splash> activityTestRule = new ActivityTestRule<>(WW_Splash.class);

    @Test
    public void testIntent() {
        Intent intent = new Intent(activityTestRule.getActivity(), MainActivity.class);
        activityTestRule.launchActivity(intent);
    }


}