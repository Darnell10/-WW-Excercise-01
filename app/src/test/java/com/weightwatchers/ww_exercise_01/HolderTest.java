package com.weightwatchers.ww_exercise_01;

import com.weightwatchers.ww_exercise_01.networking.ApiUtil;

import org.junit.Test;

public class HolderTest {

    @Test
    public void rightBaseUrl(){
        String url = ApiUtil.BASE_URL;
        assertEquals(url,"https://www.weightwatchers.com/");
    }

    private boolean assertEquals(String given, String received) {
        if (given.equals(received)){
            return true;
        }
        return false;
    }
}
