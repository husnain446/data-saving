package byteshaft.com.sharedpeferencedatasaving;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity  implements View.OnClickListener{
     EditText EditData;
     TextView view;
     Button save,load;
     public static String keyName = "key";
     SharedPreferences getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData = getSharedPreferences(keyName, 0);
        helloData();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSave:
               savingData();
                break;

            case R.id.bLoad:
            receivingData();
                break;
        }
    }
    private void helloData() {
        EditData = (EditText) findViewById(R.id.eText);
        view = (TextView) findViewById(R.id.tView);
        save = (Button) findViewById(R.id.bSave);
        load = (Button) findViewById(R.id.bLoad);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    private void savingData() {
        String SharedEditData = EditData.getText().toString();
        SharedPreferences.Editor editor = getData.edit();
        editor.putString("myString", SharedEditData);
        editor.apply();
    }

    private void receivingData() {
        getData = getSharedPreferences(keyName, 0);
        String Result = getData.getString("myString", "Nothing");
        view.setText(Result);
    }
}
