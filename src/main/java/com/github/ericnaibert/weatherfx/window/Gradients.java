package com.github.ericnaibert.weatherfx.window;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Gradients {

    private static LinearGradient gradient1;
    private static LinearGradient gradient2;

    private static Stop[] gradientStop() {

        return new Stop[]{
                new Stop(0, Color.rgb(255,255,255,1)),
                new Stop(1,Color.rgb(255,255,255,0.5))
        };
    }

    public static LinearGradient getGradient1() {
        setGradient1();
        return gradient1;
    }

    private static void setGradient1() {
        Gradients.gradient1 = new LinearGradient(0.45, 0, 0.5, 0, true,
                CycleMethod.NO_CYCLE, gradientStop());
    }

    public static LinearGradient getGradient2() {
        setGradient2();
        return gradient2;
    }

    private static void setGradient2() {
        Gradients.gradient2 = new LinearGradient(0.65, 0, 0.7, 0, true,
                CycleMethod.NO_CYCLE, gradientStop());
    }
}
