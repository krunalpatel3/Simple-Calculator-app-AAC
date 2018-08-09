package krunal.com.example.calculator;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

public class MainActivityViewModel extends AndroidViewModel {

    String result="";

    String StoreValuesToBeCalculated;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public int getLength(){
        return StoreValuesToBeCalculated.length();
    }


}
