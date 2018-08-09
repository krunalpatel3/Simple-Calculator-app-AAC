package krunal.com.example.calculator;



import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    private MainActivityViewModel mMainActivityViewModel;

    private Button mButtonOne, mButtonTwo, mButtonThree, mButtonFour,
            mButtonFive, mButtonSix, mButtonSeven, mButtonEight,
            mButtonNine, mButtonZero;

    private Button mButtonMultiply, mButtonMinus, mButtonPlus,
            mButtonDivide, mButtonDecimal, mButtonBack, mButtonSmallBracket,
            mButtonEqual, mButtonPercentage;

    private Button mButtonClear;

    private TextView mTextViewCalculate, mTextViewResult;

    private Boolean mIsBracketOpen = false;

    private static final String TAB = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mTextViewResult = findViewById(R.id.textview_result);
        mTextViewCalculate = findViewById(R.id.textview_Calculate);

        mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated);
        mTextViewResult.setText(mMainActivityViewModel.result);

        mButtonOne = findViewById(R.id.button_one);
        mButtonTwo = findViewById(R.id.button_two);
        mButtonThree = findViewById(R.id.button_three);
        mButtonFour = findViewById(R.id.button_four);
        mButtonFive = findViewById(R.id.button_five);
        mButtonSix = findViewById(R.id.button_six);
        mButtonSeven = findViewById(R.id.button_seven);
        mButtonEight = findViewById(R.id.button_eight);
        mButtonNine = findViewById(R.id.button_nine);
        mButtonZero = findViewById(R.id.button_zero);

        mButtonMultiply = findViewById(R.id.button_multiply);
        mButtonMinus = findViewById(R.id.button_minus);
        mButtonPlus = findViewById(R.id.button_plus);
        mButtonDivide = findViewById(R.id.button_divide);

        mButtonDecimal = findViewById(R.id.button_dot);
        mButtonBack = findViewById(R.id.button_back);

        mButtonSmallBracket = findViewById(R.id.button_small_bracket);
        mButtonEqual = findViewById(R.id.button_equal);
        mButtonPercentage = findViewById(R.id.button_percentage);

        mButtonClear = findViewById(R.id.button_delete);


        // Clear.
        mButtonClear.setOnClickListener(v -> {
            mTextViewCalculate.setText("");
            mTextViewResult.setText("");
            mIsBracketOpen = false;
        });


        // Numbers.
        mButtonOne.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "1");
        });

        mButtonTwo.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "2");
        });

        mButtonThree.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "3");
        });

        mButtonFour.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "4");
        });
        mButtonFive.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "5");
        });
        mButtonSix.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "6");
        });

        mButtonSeven.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "7");
        });

        mButtonEight.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "8");
        });

        mButtonNine.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "9");
        });

        mButtonZero.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "0");
        });


        // Symbols.
        mButtonDecimal.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + ".");
        });

        mButtonDivide.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "/");
        });

        mButtonMinus.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "-");
        });

        mButtonMultiply.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "X");
        });

        mButtonPercentage.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "%");
        });

        mButtonPlus.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "+");
        });

        mButtonSmallBracket.setOnClickListener((View v) -> {
            if (mIsBracketOpen) {
                mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
                mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + ")");
                mIsBracketOpen = false;
            } else {
                mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
                mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated + "(");
                mIsBracketOpen = true;
            }
        });


        // Back.
        mButtonBack.setOnClickListener((View v) -> {
            Log.i(TAB,"click back");
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();
            if (mMainActivityViewModel.getLength() > 0) {
                Log.i(TAB, String.valueOf(mMainActivityViewModel.getLength()));
                mMainActivityViewModel.StoreValuesToBeCalculated = mMainActivityViewModel.StoreValuesToBeCalculated.substring(0,mMainActivityViewModel.getLength()-1);
                mTextViewCalculate.setText(mMainActivityViewModel.StoreValuesToBeCalculated);
            } else {
                mTextViewCalculate.setText("");
            }

            if (mMainActivityViewModel.getLength()==0){
                mTextViewResult.setText("");
            }
        });

        // Equal.
        mButtonEqual.setOnClickListener(v -> {
            mMainActivityViewModel.StoreValuesToBeCalculated = mTextViewCalculate.getText().toString();

            mMainActivityViewModel.StoreValuesToBeCalculated = mMainActivityViewModel.StoreValuesToBeCalculated.replaceAll("X", "*");
            mMainActivityViewModel.StoreValuesToBeCalculated = mMainActivityViewModel.StoreValuesToBeCalculated.replaceAll("%", "/100");

            Context context = Context.enter();
            context.setOptimizationLevel(-1);

            try {
                Scriptable scope = context.initStandardObjects();
                mMainActivityViewModel.result = context
                        .evaluateString(scope,
                                mMainActivityViewModel.StoreValuesToBeCalculated,
                                "JavaScript", 1, null).toString();

            } catch (Exception e) {
                mMainActivityViewModel.result = "Error";
            }

            mTextViewResult.setText(mMainActivityViewModel.result);

        });

    }


}
