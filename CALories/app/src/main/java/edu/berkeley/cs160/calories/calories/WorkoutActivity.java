package edu.berkeley.cs160.calories.calories;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.HashMap;

public class WorkoutActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static HashMap<Integer, Integer> exercises;

    GridView mExerciseGrid;

    private static final int column = 4;
    static  String[] str_arr ;
    int displayWidth,displayHeight,statusbar_height ,required_height;

    private TextView mPushUpField;
    private TextView mSitUpField;
    private TextView mSquatsField;
    private TextView mLegLiftField;

    private TextView mPlankField;
    private TextView mJumpingJacksField;
    private TextView mPullUpField;
    private TextView mCyclingField;

    private TextView mWalkingField;
    private TextView mJoggingField;
    private TextView mSwimmingField;
    private TextView mStairClimbingField;

    private TextView mPushUpCaloriesField;
    private TextView mSitUpCaloriesField;
    private TextView mSquatsCaloriesField;
    private TextView mLegLiftCaloriesField;

    private TextView mPlankCaloriesField;
    private TextView mJumpingJacksCaloriesField;
    private TextView mPullUpCaloriesField;
    private TextView mCyclingCaloriesField;

    private TextView mWalkingCaloriesField;
    private TextView mJoggingCaloriesField;
    private TextView mSwimmingCaloriesField;
    private TextView mStairClimbingCaloriesField;

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        displayWidth = metrics.widthPixels ;
        displayHeight = metrics.heightPixels;

        required_height = displayHeight - statusbar_height ;

        Exercises.instantiate();

        exercises = Exercises.getExerciseConversion();

        mPushUpField = (TextView) findViewById(R.id.pushup_field);
        mSitUpField = (TextView) findViewById(R.id.situp_field);
        mSquatsField = (TextView) findViewById(R.id.squats_field);
        mLegLiftField = (TextView) findViewById(R.id.leg_lift_field);

        mPlankField = (TextView) findViewById(R.id.planks_field);
        mJumpingJacksField = (TextView) findViewById(R.id.jumping_jacks_field);
        mPullUpField = (TextView) findViewById(R.id.pullup_field);
        mCyclingField = (TextView) findViewById(R.id.cycling_field);

        mWalkingField = (TextView) findViewById(R.id.walking_field);
        mJoggingField = (TextView) findViewById(R.id.jogging_field);
        mSwimmingField = (TextView) findViewById(R.id.swimming_field);
        mStairClimbingField = (TextView) findViewById(R.id.stair_climbing_field);

        mPushUpCaloriesField = (TextView) findViewById(R.id.pushup_field);
        mSitUpCaloriesField = (TextView) findViewById(R.id.situp_calories);
        mSquatsCaloriesField = (TextView) findViewById(R.id.squats_calories);
        mLegLiftCaloriesField = (TextView) findViewById(R.id.leg_lift_calories);

        mPlankCaloriesField = (TextView) findViewById(R.id.planks_calories);
        mJumpingJacksCaloriesField = (TextView) findViewById(R.id.jumping_jacks_calories);
        mPullUpCaloriesField = (TextView) findViewById(R.id.pullup_calories);
        mCyclingCaloriesField = (TextView) findViewById(R.id.cycling_calories);

        mWalkingCaloriesField = (TextView) findViewById(R.id.walking_calories);
        mJoggingCaloriesField = (TextView) findViewById(R.id.jogging_calories);
        mSwimmingCaloriesField = (TextView) findViewById(R.id.swimming_calories);
        mStairClimbingCaloriesField = (TextView) findViewById(R.id.stair_climbing_calories);

        Bundle i = getIntent().getExtras();

        type = i.getString(MainActivity2.TYPE);
        if (type.equals("workout")) {
            Integer workout = i.getInt(MainActivity2.WORKOUT_KEY);
            Double reps = i.getDouble(MainActivity2.REPS_COUNT_KEY);
            Double calories = Exercises.getCaloriesBurned(workout, reps);

            mPushUpField.setText(((Double) Exercises.convertExercise(workout, Exercises.PUSHUP, reps)).toString() + "\n" + " reps");
            mSitUpField.setText(((Double) Exercises.convertExercise(workout, Exercises.SITUP, reps)).toString() + "\n" + " reps");
            mSquatsField.setText(((Double) Exercises.convertExercise(workout, Exercises.SQUATS, reps)).toString() + "\n" + " reps");
            mLegLiftField.setText(((Double) Exercises.convertExercise(workout, Exercises.LEG_LIFT, reps)).toString() + "\n" + " minutes");

            mPlankField.setText(((Double) Exercises.convertExercise(workout, Exercises.PLANK, reps)).toString() + "\n" + " minutes");
            mJumpingJacksField.setText(((Double) Exercises.convertExercise(workout, Exercises.JUMPING_JACKS, reps)).toString() + "\n" + " minutes");
            mPullUpField.setText(((Double) Exercises.convertExercise(workout, Exercises.PULLUP, reps)).toString() + "\n" + " reps");
            mCyclingField.setText(((Double) Exercises.convertExercise(workout, Exercises.CYCLING, reps)).toString() + "\n" + " minutes");

            mWalkingField.setText(((Double) Exercises.convertExercise(workout, Exercises.WALKING, reps)).toString() + "\n" + " minutes");
            mJoggingField.setText(((Double) Exercises.convertExercise(workout, Exercises.JOGGING, reps)).toString() + "\n" + " minutes");
            mSwimmingField.setText(((Double) Exercises.convertExercise(workout, Exercises.SWIMMING, reps)).toString() + "\n" + " minutes");
            mStairClimbingField.setText(((Double) Exercises.convertExercise(workout, Exercises.STAIR_CLIMBING, reps)).toString() + "\n" + " minutes");

            mPushUpCaloriesField.setText(calories.toString() + " calories");
            mSitUpCaloriesField.setText(calories.toString() + " calories");
            mSquatsCaloriesField.setText(calories.toString() + " calories");
            mLegLiftCaloriesField.setText(calories.toString() + " calories");

            mPlankCaloriesField.setText(calories.toString() + " calories");
            mJumpingJacksCaloriesField.setText(calories.toString() + " calories");
            mPullUpCaloriesField.setText(calories.toString() + " calories");
            mCyclingCaloriesField.setText(calories.toString() + " calories");

            mWalkingCaloriesField.setText(calories.toString() + " calories");
            mJoggingCaloriesField.setText(calories.toString() + " calories");
            mSwimmingCaloriesField.setText(calories.toString() + " calories");
            mStairClimbingCaloriesField.setText(calories.toString() + " calories");
        }

//        mExerciseGrid = (GridView) findViewById(R.id.exercise_grid);
//
//        mExerciseGrid.setHorizontalSpacing(10);
////        mExerciseGrid.setVerticalSpacing(10);
//
//        mExerciseGrid.setNumColumns(column);// set your  column number what you want
//        int column_width = displayWidth / column;
//        int column_height = required_height / column ;
//        mExerciseGrid.setAdapter(new ExerciseGridAdapter(this, column_width,column_height));

        mPushUpField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    mSitUpField.setText("");
                    mSquatsField.setText("");
                    mLegLiftField.setText("");

                    mPlankField.setText("");
                    mJumpingJacksField.setText("");
                    mPullUpField.setText("");
                    mCyclingField.setText("");

                    mWalkingField.setText("");
                    mJoggingField.setText("");
                    mSwimmingField.setText("");
                    mStairClimbingField.setText("");
                } else {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private class ExerciseGridAdapter extends BaseAdapter {
        private Context context;
        int column_width , column_height ;

        public ExerciseGridAdapter(Context context, int column_width ,int column_height) {
            this.context = context;
            this.column_width = column_width ;
            this.column_height = column_height ;
        }

        @Override
        public int getCount() {
            return exercises.size();
        }

        @Override
        public Integer getItem(int position) {
            return exercises.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            if (item == null) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                item = inflater.inflate(R.layout.exercise_item, parent, false);
            }
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            item.setLayoutParams(new GridView.LayoutParams(params));

            android.widget.AbsListView.LayoutParams parms = new android.widget.AbsListView.LayoutParams(column_width, column_height);
            item.setLayoutParams(parms);

            Log.d(TAG, ((Integer) column_width).toString());
            Log.d(TAG, ((Integer) column_height).toString());

            ImageView image = (ImageView) item.findViewById(R.id.item_image);
            ImageUtils.loadImageFromUrl(getApplicationContext(), "http://www.gospelherald.com/data/images/full/8263/kyrie-irving.jpg", image);

            return item;
        }
    }
}
