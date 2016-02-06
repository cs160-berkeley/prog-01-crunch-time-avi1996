package edu.berkeley.cs160.calories.calories;

import java.util.HashMap;

/**
 * Created by Avi on 2/1/16.
 */
public class Exercises {

    public static final int PUSHUP = 0;
    public static final int SITUP = 1;
    public static final int SQUATS = 2;
    public static final int LEG_LIFT = 3;
    public static final int PLANK = 4;
    public static final int JUMPING_JACKS = 5;
    public static final int PULLUP = 6;
    public static final int CYCLING = 7;
    public static final int WALKING = 8;
    public static final int JOGGING = 9;
    public static final int SWIMMING = 10;
    public static final int STAIR_CLIMBING = 11;

    public static final String PUSHUP_TEXT = "Pushups";
    public static final String SITUP_TEXT = "Situps";
    public static final String SQUATS_TEXT = "Squats";
    public static final String LEG_LIFT_TEXT = "Leg-lifts";
    public static final String PLANK_TEXT = "Plank";
    public static final String JUMPING_JACKS_TEXT = "Jumping Jacks";
    public static final String PULLUP_TEXT = "Pullups";
    public static final String CYCLING_TEXT = "Cycling";
    public static final String WALKING_TEXT = "Walking";
    public static final String JOGGING_TEXT = "Jogging";
    public static final String SWIMMING_TEXT = "Swimming";
    public static final String STAIR_CLIMBING_TEXT = "Stair Climbing";


    //All Conversion factors are the amount to burn 100 Calories (for 150 lb person)
    public static final int PUSHUP_CONVERSION_REPS = 350;
    public static final int SITUP_CONVERSION_REPS = 200;
    public static final int SQUATS_CONVERSION_REPS = 225;
    public static final int LEG_LIFT_CONVERSION_MINS = 25;
    public static final int PLANK_CONVERSION_MINS = 25;
    public static final int JUMPING_JACK_CONVERSION_MINS = 10;
    public static final int PULLUP_CONVERSION_REPS = 100;
    public static final int CYCLING_CONVERSION_MINS = 12;
    public static final int WALKING_CONVERSION_MINS = 20;
    public static final int JOGGING_CONVERSION_MINS = 12;
    public static final int SWIMMING_CONVERSION_MINS = 13;
    public static final int STAIR_CLIMBING_CONVERSION_MINS = 15;

    public static final int BASE_CALORIES = 100;
    private static final HashMap<Integer, Integer> exerciseConversion = new HashMap<>();
    // HashMap to determine if the count is of reps or minutes. True if reps, False if minutes
    private static final HashMap<Integer, Boolean> countIsTypeReps = new HashMap<>();

    public static HashMap<Integer, Integer> getExerciseConversion() {
        return exerciseConversion;
    }

    public static HashMap<Integer, Boolean> getCountIsTypeReps() {
        return countIsTypeReps;
    }

    public static void instantiate() {
        exerciseConversion.put(PUSHUP, PUSHUP_CONVERSION_REPS);
        exerciseConversion.put(SITUP, SITUP_CONVERSION_REPS);
        exerciseConversion.put(SQUATS, SQUATS_CONVERSION_REPS);
        exerciseConversion.put(LEG_LIFT, LEG_LIFT_CONVERSION_MINS);
        exerciseConversion.put(PLANK, PLANK_CONVERSION_MINS);
        exerciseConversion.put(JUMPING_JACKS, JUMPING_JACK_CONVERSION_MINS);
        exerciseConversion.put(PULLUP, PULLUP_CONVERSION_REPS);
        exerciseConversion.put(CYCLING, CYCLING_CONVERSION_MINS);
        exerciseConversion.put(WALKING, WALKING_CONVERSION_MINS);
        exerciseConversion.put(JOGGING, JOGGING_CONVERSION_MINS);
        exerciseConversion.put(SWIMMING, SWIMMING_CONVERSION_MINS);
        exerciseConversion.put(STAIR_CLIMBING, STAIR_CLIMBING_CONVERSION_MINS);

        countIsTypeReps.put(PUSHUP, true);
        countIsTypeReps.put(SITUP, true);
        countIsTypeReps.put(SQUATS, true);
        countIsTypeReps.put(LEG_LIFT, false);
        countIsTypeReps.put(PLANK, false);
        countIsTypeReps.put(JUMPING_JACKS, false);
        countIsTypeReps.put(PULLUP, true);
        countIsTypeReps.put(CYCLING, false);
        countIsTypeReps.put(WALKING, false);
        countIsTypeReps.put(JOGGING, false);
        countIsTypeReps.put(SWIMMING, false);
        countIsTypeReps.put(STAIR_CLIMBING, false);

    }

    //FUNCTIONALITY #2
    public static double convertExercise(int sourceExercise, int targetExercise, double amount) {
        if (amount == 0) {
            return 0;
        }
        if (sourceExercise == targetExercise) {
            return amount;
        }
        double calories = getCaloriesBurned(sourceExercise, amount);
        int targetConversion = exerciseConversion.get(targetExercise);

        return (calories / BASE_CALORIES) * targetConversion;

    }

    //FUNCTIONALITY #1
    public static double getCaloriesBurned(int sourceExercise, double amount) {
        if (amount == 0) {
            return 0;
        }
        double conversionFactor = exerciseConversion.get(sourceExercise);
        return BASE_CALORIES / (conversionFactor/amount);
    }




}
