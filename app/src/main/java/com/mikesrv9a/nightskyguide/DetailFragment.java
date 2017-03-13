// Fragment subclass that displays one dsObject's details

package com.mikesrv9a.nightskyguide;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikesrv9a.nightskyguide.DatabaseDescription.DSObjectDB;

public class DetailFragment extends Fragment {
    //implements LoaderManager.LoaderCallbacks<Cursor> {

    //private static final int DSOBJECTDB_LOADER = 0;  // identifies the Loader

    private int position;  // array list item

    private TextView objectIdTextView;  // displays dsObject's ID
    private TextView typeTextView; // displays dsObject's type
    private TextView magTextView; // displays dsObject's mag
    private TextView sizeTextView; // displays dsObject's size
    private TextView distTextView; // displays dsObject's distance
    private TextView raTextView; // displays dsObject's RA
    private TextView decTextView; // displays dsObject's Dec
    private TextView constTextView; // displays dsObject's Constellation
    private TextView nameTextView; // displays dsObject's Common Name
    private TextView psaTextView; // displays dsObject's PSA pages
    private TextView oithTextView; // displays dsObject's OITH pages
    private TextView observedTextView; // displays dsObject's Observed status

    // called when DetailFragmentListener's view needs to be created
    @Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);  // this fragment has menu items to display

        // get Bundle of arguments then extract the dsObject's Uri
        Bundle arguments = getArguments();

        if (arguments != null)
            position = arguments.getInt("dsObjectArrayListItem");


        // inflate DetailFragment's layout
        View view =
                inflater.inflate(R.layout.fragment_details, container, false);

        // get the EditTexts
        objectIdTextView = (TextView) view.findViewById(R.id.objectIdTextView);
        typeTextView = (TextView) view.findViewById(R.id.typeTextView);
        magTextView = (TextView) view.findViewById(R.id.magTextView);
        sizeTextView = (TextView) view.findViewById(R.id.sizeTextView);
        distTextView = (TextView) view.findViewById(R.id.distTextView);
        raTextView = (TextView) view.findViewById(R.id.raTextView);
        decTextView = (TextView) view.findViewById(R.id.decTextView);
        constTextView = (TextView) view.findViewById(R.id.constTextView);
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        psaTextView = (TextView) view.findViewById(R.id.psaTextView);
        oithTextView = (TextView) view.findViewById(R.id.oithTextView);
        observedTextView = (TextView) view.findViewById(R.id.observedTextView);

        String positionString = Integer.toString(position);   // test
        objectIdTextView.setText(positionString);             // test
        //DSObject object = DSObjectsFragment.dsObjectsArrayList.get(position);
        /*
        String r1c1Text = object.getDsoObjectID();
        String r1c2Text = object.getDsoConst();
        String r1c3Text = Double.toString(object.getDsoMag());
        String r1c4Text = Integer.toString((int)Math.round(object.getDsoRA()))+"°";
        String r2c1Text = object.getDsoName();
        String r2c2Text = object.getDsoType();
        String r2c3Text = object.getDsoSize();
        String r2c4Text = Integer.toString((int)Math.round(object.getDsoDec()))+"°";
        */
        return view;
    }

    // display this fragment's menu items
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_details_menu, menu);
    }
}