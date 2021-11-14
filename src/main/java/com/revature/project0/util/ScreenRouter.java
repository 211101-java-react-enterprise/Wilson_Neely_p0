package com.revature.project0.util;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.Collections.LinkedList;

public class ScreenRouter {

    private final LinkedList<View> screens;

    public ScreenRouter(){
        screens = new LinkedList<>();
    }

    public void addScreen(View screen){
        screens.add(screen);
    }

    public void navigate(String route) throws Exception{

        View thisScreen;
        for (int i = 0; i < screens.size(); i++){
            thisScreen = screens.get(i);
            if (thisScreen.getRoute().equals(route)){
                thisScreen.render();
            }
        }
    }
}
