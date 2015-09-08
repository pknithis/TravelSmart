package com.example.nithishkp.travelsmart;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.Logger;


public class ListPlaces extends ActionBarActivity {

    ArrayList<EditText> placeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_places);
        placeList = new ArrayList<EditText>();
        placeList.add((EditText)findViewById(R.id.place1));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_places, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addPlace(View v)
    {
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);
        int index = layout.indexOfChild(placeList.get(placeList.size()-1));
        EditText newPlace = new EditText(this);
        EditText tempText = placeList.get(placeList.size()-1);
        newPlace.setLayoutParams(tempText.getLayoutParams());
        layout.addView(newPlace,index+1);
        placeList.add(newPlace);
    }
    public void launchActivity(View v)
    {
        Intent it = new Intent(getBaseContext(),AddPlcaces.class);

        ArrayList <String>places = new ArrayList<String>();

        for(EditText e : placeList)
        {
            if(e.getText().length() > 0)
            {
                places.add(e.getText()+"");
            }
        }
        String placeList[]= new String[places.size()];
        places.toArray(placeList);
        it.putExtra("LOCATIONS",placeList);

        Log.v("Nithish", "Launching activity");
        //System.out.print("Nithish Launching activity");
        startActivity(it);
        this.setVisible(false);
    }
}
