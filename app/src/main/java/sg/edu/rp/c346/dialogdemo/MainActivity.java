package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnDemo4;
    Button btnDemo5;
    Button btnDemo6;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvDemo4;
    TextView tvDemo5;
    TextView tvDemo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDemo1 = (Button) findViewById(R.id.buttonDemo1);
        btnDemo2 = (Button) findViewById(R.id.buttonDemo2);
        btnDemo3 = (Button) findViewById(R.id.buttonDemo3);
        btnDemo4= (Button) findViewById(R.id.buttonDemo4);
        btnDemo5 = (Button) findViewById(R.id.buttonDemo5);
        btnDemo6 = (Button) findViewById(R.id.buttonDemo6);
        tvDemo2 = (TextView) findViewById(R.id.textViewDemo2);
        tvDemo3 = (TextView) findViewById(R.id.textViewDemo3);
        tvDemo4 = (TextView) findViewById(R.id.textViewDemo4);
        tvDemo5 = (TextView) findViewById(R.id.textViewDemo5);
        tvDemo6 = (TextView) findViewById(R.id.textViewDemo6);

        //*************************** DEMO 1****************************//

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create the dialog Builider
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                /*
                //set The dialog details
                myBuilder.setTitle("Demo - 1 Simple Dialog");
                myBuilder.setMessage("I can develop Android App");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);

                //Create and display the dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
                */
                //set The dialog details
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have complited a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss",null);

                //Create and display the dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        //*************************** DEMO 2****************************//

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement your Button Dialog box
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below.");
                myBuilder.setCancelable(false);

// Configure the 'positive' button
                myBuilder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvDemo2.setText("You have selected Positive.");
                    }
                });
                myBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvDemo2.setText("You have selected Negative.");
                    }
                });


// Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }


        });

        //*************************** DEMO 3****************************//

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                final EditText etInput = (EditText)viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Extract the Text entered by the user
                        String message = etInput.getText().toString();
                        // Update the Text to TextView
                        tvDemo3.setText(message);
                    }
                });


                myBuilder.setNegativeButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //*************************** DEMO 4****************************//
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                // Obtain the UI component in the input.xml layout
                final EditText etInputNum1 = (EditText)viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInputNum2 = (EditText)viewDialog.findViewById(R.id.editTextNum2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Extract the Text entered by the user
                       String num1 = etInputNum1.getText().toString();
                        int intNum1 = Integer.parseInt(num1);

                        String num2 = etInputNum2.getText().toString();
                        int intNum2 = Integer.parseInt(num2);

                        int result = intNum1 + intNum2;
                        String strResult = String.valueOf(result);

                        // Update the Text to TextView
                        tvDemo4.setText(strResult);
                    }
                });


                myBuilder.setNegativeButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });




        //*************************** DEMO 5****************************//
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the date
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };
                // Create the Date Picker Dialog
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,hour,minute,true);

                myTimeDialog.show();
            }
        });

        //*************************** DEMO 6****************************//
        btnDemo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        tvDemo6.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, 2014, 11, 31);

                myDateDialog.show();
            }
        });





    }
}
