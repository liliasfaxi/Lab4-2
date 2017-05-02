package tn.medtech.lab4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eName, eSurname, eGrade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.e_name);
        eSurname = (EditText) findViewById(R.id.e_surname);
        eGrade = (EditText) findViewById(R.id.e_grade);


    }

    public void insertStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int grade = Integer.parseInt(eGrade.getText().toString());
        Student student = new Student(eName.getText().toString(), eSurname.getText().toString(),grade);
        dbHandler.addStudent(student);
        Toast.makeText(this, "Inserted Student: "+dbHandler.findStudent(eName.getText().toString()).toString(), Toast.LENGTH_SHORT).show();

        emptyFields();
    }

    public void deleteStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,null, 1);
        boolean result = dbHandler.deleteStudent(eName.getText().toString());
        if (result)
        {
            Toast.makeText(this, "Record Deleted!", Toast.LENGTH_SHORT).show();
            emptyFields();
        }
        else
            Toast.makeText(this, "No Match Found!", Toast.LENGTH_SHORT).show();
    }

    public void getStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Student student = dbHandler.findStudent(eName.getText().toString());
        if (student != null) {
            eSurname.setText(student.getSurname());
            eGrade.setText(String.valueOf(student.getGrade()));
        } else {
            Toast.makeText(this, "No Match Found!", Toast.LENGTH_SHORT).show();
        }
    }

    private void emptyFields(){
        eName.setText("");
        eSurname.setText("");
        eGrade.setText("");
    }
}
