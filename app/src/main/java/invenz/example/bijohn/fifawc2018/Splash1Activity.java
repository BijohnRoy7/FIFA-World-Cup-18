package invenz.example.bijohn.fifawc2018;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bijohn.fifawc2018.R;

import invenz.example.bijohn.fifawc2018.activity.Main2Activity;

public class Splash1Activity extends AppCompatActivity {
    private ImageView imageView;
    private Dialog selectLanguageDialog;
    private TextView btSelect;
    private RadioButton rbEnglishLang, rbBanglaLang;
    private String langShared;
    private MySharedPreference mySharedPreference;
    private static boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        imageView = findViewById(R.id.isSplashS);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        imageView.startAnimation(animation);
        selectLanguageDialog = new Dialog(Splash1Activity.this);
        mySharedPreference = new MySharedPreference();


        SharedPreferences sharedPref = getSharedPreferences("languageSharedPref", Context.MODE_PRIVATE);
        final String langShared = sharedPref.getString("languageSP", "");

        /*###################### Is Internet Connected ? ##########################*/
        IsInternetConnected isInternetConnected = new IsInternetConnected();

        SharedPreferences sharedPreferences1 = getSharedPreferences("languageSharedPref",MODE_PRIVATE);
        isFirstTime = sharedPreferences1.getBoolean("isFirst",true);

        if(!isInternetConnected.isConnected(Splash1Activity.this) && isFirstTime == true)
        {
            buildDialog(Splash1Activity.this).show();
            //Toast.makeText(this, ""+isFirstTime, Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences.Editor editor = sharedPreferences1.edit();
            editor.putBoolean("isFirst", false);
            editor.commit();

            //Toast.makeText(this, ""+isFirstTime, Toast.LENGTH_SHORT).show();



            //Toast.makeText(this,"Welcome", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_splash1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {


                    if (langShared.equals("english") || langShared.equals("bangla")){
                        SelectedLanguage.lang = langShared;
                        startActivity(new Intent(Splash1Activity.this, Main2Activity.class));
                        finish();

                    }
                    else
                    {

                        /*################### Dialog for choosing language #####################*/
                        selectLanguageDialog.setContentView(R.layout.select_language_dialog);
                        Window window = selectLanguageDialog.getWindow();
                        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        //window.setLayout(800, 900);
                        selectLanguageDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        selectLanguageDialog.setCancelable(false);

                        rbEnglishLang = selectLanguageDialog.findViewById(R.id.idEnglish_selectLang);
                        rbBanglaLang = selectLanguageDialog.findViewById(R.id.idBangla_selectLang);
                        btSelect = selectLanguageDialog.findViewById(R.id.idSelectButton_select_Lang);


                        /*#######################################*/
                        selectLanguageDialog.show();

                        btSelect.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (rbEnglishLang.isChecked()){

                                    //If English Language is selected
                                    SelectedLanguage.lang = "english";

                                    //setting shared preference
                                    mySharedPreference.getMySharedPref("english", Splash1Activity.this);
                                    selectLanguageDialog.dismiss();
                                    //Toast.makeText(Splash1Activity.this, ""+SelectedLanguage.lang, Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(Splash1Activity.this, Main2Activity.class));
                                    finish();

                                }else if (rbBanglaLang.isChecked()){

                                    //If Bangla Language is selected
                                    SelectedLanguage.lang = "bangla";

                                    //setting shared preference
                                    mySharedPreference.getMySharedPref("bangla", Splash1Activity.this);
                                    selectLanguageDialog.dismiss();
                                    //Toast.makeText(Splash1Activity.this, ""+SelectedLanguage.lang, Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(Splash1Activity.this, Main2Activity.class));
                                    finish();

                                }else {
                                    Toast.makeText(Splash1Activity.this, "Please select a language", Toast.LENGTH_SHORT).show();
                                }


                            }
                        });
                    }



                }
            },1500);
        }
    }



    /*################### METHOD FOR SHOWING DIALOG WHEN INTERNET IS NOT CONNECTED ###############################*/
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi atleast once to access this.\nPress ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}
