package invenz.example.bijohn.fifawc2018;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    //Shrared preference to know is languale already selected
    public void getMySharedPref(String lang, Context context){

        SharedPreferences sharedPref = context.getSharedPreferences("languageSharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("languageSP", lang);
        editor.apply();
    }


}
