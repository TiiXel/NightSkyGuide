package com.mikesrv9a.nightskyguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AppInfoActivity extends AppCompatActivity {

    String infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        Integer appInfoKey = intent.getIntExtra("appInfoKey",1);

        TextView appInfo = (TextView)findViewById(R.id.app_info_text);

        switch (appInfoKey) {
            case 1:
                infoText = "Messier Field Guide v0.1.11.0 (beta)\n" +
                        "Copyright Shiny Objects LLC 2017\n\n" +
                        "The main page displays each of the 110 Messier Object's, including:\n" +
                        "∙ DSO ID (with √ if previously observed)\n∙ Common Name\n" +
                        "∙ Constellation\n∙ DSO Type\n" +
                        "∙ Magnitude (with ● if Mag 7.0 or brighter)\n∙ Apparent Size (arc-mins)\n" +
                        "∙ Current Altitude (with ▲ or ▼ for rising/setting)\n∙ Current Azimuth.\n\n" +
                        "The list of objects is sorted based on altitude, with setting " +
                        "objects listed first.  A negative altitude indicates the object " +
                        "is below the horizon.\n\n" +
                        "The altitude for circumpolar objects are preceeded by a ○ symbol and " +
                        "objects that do not rise above the horizon are preceeded by a ◙ symbol. " +
                        "Some objects without either symbol may only be above the horizon during " +
                        "daylight hours, and thus may not be observable at this time of year.\n\n" +
                        "Clicking on any object in the list will open a detail page " +
                        "providing more information about the object, including rise and set times " +
                        "and an associated constellation chart.";
                break;
            case 2:
                infoText = "Rise and set times are shown for the current time zone of your phone or tablet, " +
                        "and are based on the latitude and longitude designated on the Settings page. " +
                        "Atmospheric refraction and other small factors are not taken into account and may " +
                        "vary from other published sources by a few minutes.\n\n" +
                        "The constellation charts will provide a general location of the DSO, however " +
                        "it is likely that you will need a sky atlas to find many of these objects.  The page numbers " +
                        "for two common atlases are listed on the detail pages.\n\n" +
                        "PSA refers to Sky & Telescope's Pocket Sky Atlas\n\n" +
                        "OITH refers to Objects in the Heavens ed.5.2 by Peter Birren\n\n" +
                        "Clicking on the + icon will allow you to create a record of your observations, including " +
                        "information generally required for various observing programs, such as those sponsored " +
                        "by the Astronomical League.\n\n" +
                        "The constellation charts are from the International Astronomical " +
                        "Union and Sky & Telescope Magazine and are released under the Creative" +
                        "Commons Attribution 3.0 Unported License and have been modified to have " +
                        "a dark background and to include all 110 Messier objects.";
                break;
            case 3:
                infoText = "Entering observation information is at your discretion, however if you using this " +
                        "as a record for an observing program, please make sure that you record all information " +
                        "required by the sponsors.\n\n  If you are only interested in tracking what objects you have " +
                        "observed, you can save a record without entering any information. "+
                        "All DSO's that have an observation records will be indicated with a check mark on the main " +"" +
                        "screen and there is a settings option to show only DSO's that you haven't previously observed.\n\n" +
                        "The date, time and observing location will automatically be filled out.\n\n" +
                        "Aside from the observation notes field at the bottom, all other fields will automatically be filled out " +
                        "to match the entries from your last saved record.";
        }

        appInfo.setText(infoText);
    }

}
