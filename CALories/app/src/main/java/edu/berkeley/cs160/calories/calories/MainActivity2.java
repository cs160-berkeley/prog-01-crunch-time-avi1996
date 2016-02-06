package edu.berkeley.cs160.calories.calories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Avi on 2/5/16.
 */
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView mConvertButton;
    Spinner mChooseWorkout;
    EditText mRepsCount;
    EditText mCalorieCount;

    public static final String WORKOUT_KEY = "workout";
    public static final String REPS_COUNT_KEY = "reps";
    public static final String CALORIE_COUNT_KEY = "calorie_count";
    public static final String TYPE = "type";
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mChooseWorkout = (Spinner) findViewById(R.id.choose_workout_spinner);
        ArrayList<String> choices = new ArrayList<>();
        choices.add(Exercises.PUSHUP_TEXT);
        choices.add(Exercises.SITUP_TEXT);
        choices.add(Exercises.SQUATS_TEXT);
        choices.add(Exercises.LEG_LIFT_TEXT);
        choices.add(Exercises.PLANK_TEXT);
        choices.add(Exercises.JUMPING_JACKS_TEXT);
        choices.add(Exercises.PULLUP_TEXT);
        choices.add(Exercises.CYCLING_TEXT);
        choices.add(Exercises.WALKING_TEXT);
        choices.add(Exercises.JOGGING_TEXT);
        choices.add(Exercises.SWIMMING_TEXT);
        choices.add(Exercises.STAIR_CLIMBING_TEXT);
        ArrayAdapter<String> a =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mChooseWorkout.setAdapter(a);
        mRepsCount = (EditText) findViewById(R.id.reps_minutes_field);
        mCalorieCount = (EditText) findViewById(R.id.calorie_count_field);

        mConvertButton = (TextView) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(this);
        mConvertButton.setTypeface(FontUtils.getYorkTenNormBold(this));

        type = "workout";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.convert_button:
                Intent i = new Intent(this, WorkoutActivity.class);
                i.putExtra(TYPE, type);
                if (type.equals("workout")) {
                    i.putExtra(WORKOUT_KEY, mChooseWorkout.getSelectedItemPosition());
                    i.putExtra(REPS_COUNT_KEY, Double.parseDouble(mRepsCount.getText().toString()));
                } else {

                }

                startActivity(i);
                break;
        }
    }
}
