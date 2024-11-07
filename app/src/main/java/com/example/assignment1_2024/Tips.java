package com.example.assignment1_2024;

import java.util.ArrayList;
import java.util.List;

public class Tips {
    private String wightType;
    private String tip1;
    private String tip2;
    private String tip3;
    private int imageID;

    public Tips(String wightType, String tip1, String tip2, String tip3, int imageID) {
        this.wightType= wightType;
        this.tip1 = tip1;
        this.tip2 = tip2;
        this.tip3 = tip3;
        this.imageID = imageID;
    }

    public static final Tips[] tips= {
       new Tips("Over Weight", "Drink More Water", "Do Not Drink Soda", "Do Exercise Daily", R.drawable.mobile_ass1_overweight1),
       new Tips("Over Weight", "Eat Fruits and Vegetables", "Get Enough Sleep", "Eat Only When Hungry", R.drawable.mobile_ass1_overweight2),
       new Tips("Over Weight", "Control Food Portions", "Keep Food Diary", "Do Not Eat and Watch TV", R.drawable.mobile_ass1_overweight3),
       new Tips("Over Weight", "Build Muscles", "Eat Breakfast", "Eat Less Fast Food", R.drawable.mobile_ass1_overweight4),
       new Tips("Normal", "Focus on Balanced Nutrition", "Eat Mindfully", "Stay Hydrated", R.drawable.mobile_ass1_gainweight1),
       new Tips("Normal", "Exercise Regularly", "Limit Processed Foods and Added Sugars", "Get Quality Sleep", R.drawable.mobile_ass1_gainweight2),
       new Tips("Normal", "Manage Stress", "Include Fiber-Rich Foods", "Listen to Your Body’s Nutritional Needs", R.drawable.mobile_ass1_gainweight3),
       new Tips("Normal", "Monitor Portion Sizes", "Stay Consistent with Health Goals", "Include Lean Protein in Every Meal", R.drawable.mobile_ass1_gainweight4),
       new Tips("Under Weight", "Eat More Frequently", "Choose Nutrient-Dense Foods", "Increase Protein Intake", R.drawable.mobile_ass1_underweight1),
       new Tips("Under Weight", "Add Healthy Fats", "Include Calorie-Dense Snacks", "Drink Smoothies and Shakes", R.drawable.mobile_ass1_underweight2),
       new Tips("Under Weight", "Avoid Drinking Water Before Meals", "Strength Training", "Gradually Increase Portion Sizes", R.drawable.mobile_ass1_underweight3)
    };

    public static String[] getWeightTypes() {
        return new String[] {"Over Weight", "Normal", "Under Weight"};
    }

    public static List<Tips> getTipsByType(String weightType) {
        List<Tips> result = new ArrayList<>();
        for (Tips d : tips) {
            if (d.getWightType().equals(weightType)) {
                result.add(d);
            }
        }
        return result;
    }

    public String getWightType() { return wightType; }
    public void setWightType(String wightType) { this.wightType = wightType; }
    public String getTip1() { return tip1; }
    public void setTip1(String tip1) { this.tip1 = tip1; }
    public String getTip2() { return tip2; }
    public void setTip2(String tip2) { this.tip2 = tip2; }
    public String getTip3() { return tip3; }
    public void setTip3(String tip3) { this.tip3 = tip3; }
    public int getImageID() { return imageID; }
    public void setImageID(int imageID) { this.imageID = imageID; }

    @Override
    public String toString() {
        return "\nTip1: " + tip1 + "\n\nTip2: " + tip2 + "\n\nTip3: " + tip3 + "\n";
    }
}