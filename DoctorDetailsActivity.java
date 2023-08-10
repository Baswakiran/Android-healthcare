package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name : Ajit kumar","Hospital Address : Delhi", "Exp: 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name : Prasad kumar","Hospital Address : Nagpur", "Exp: 15yrs","Mobile No:7898989898","900"},
                    {"Doctor Name : Swapnil Kale","Hospital Address : Pune", "Exp: 8yrs","Mobile No:8898989898","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Bangalore", "Exp: 6yrs","Mobile No:9898000000","500"},
                    {"Doctor Name : Ashok Panda","Hospital Address : Chennai", "Exp: 7yrs","Mobile No:7798989898","800"},
            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name : Nilesh Patel","Hospital Address : Delhi", "Exp: 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name : Swathi Paar","Hospital Address : Nagpur", "Exp: 15yrs","Mobile No:7898989898","900"},
                    {"Doctor Name : Neeraja Kale","Hospital Address : Pune", "Exp: 8yrs","Mobile No:8898989898","300"},
                    {"Doctor Name : Mayuri Deshmukh","Hospital Address : Bangalore", "Exp: 6yrs","Mobile No:9898000000","500"},
                    {"Doctor Name : Meenakshi Panda","Hospital Address : Chennai", "Exp: 7yrs","Mobile No:7798989898","800"},
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Seema Patel","Hospital Address : Delhi", "Exp: 4yrs","Mobile No:9898989898","200"},
                    {"Doctor Name : Pankaj Parab","Hospital Address : Nagpur", "Exp: 5yrs","Mobile No:7898989898","300"},
                    {"Doctor Name : Monish Jain","Hospital Address : Pune", "Exp: 7yrs","Mobile No:8898989898","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Bangalore", "Exp: 6yrs","Mobile No:9898000000","500"},
                    {"Doctor Name : Ashok Panda","Hospital Address : Chennai", "Exp: 7yrs","Mobile No:7798989898","600"},
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Amol Gawade","Hospital Address : Delhi", "Exp: 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Nagpur", "Exp: 15yrs","Mobile No:7898989898","900"},
                    {"Doctor Name : Nilesh Kale","Hospital Address : Pune", "Exp: 8yrs","Mobile No:8898989898","300"},
                    {"Doctor Name : Deepak Deshpanada","Hospital Address : Bangalore", "Exp: 6yrs","Mobile No:9898000000","500"},
                    {"Doctor Name : Ashok singh","Hospital Address : Chennai", "Exp: 7yrs","Mobile No:7798989898","800"},
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Nilesh Borate","Hospital Address : Delhi", "Exp: 5yrs","Mobile No:9898989898","1600"},
                    {"Doctor Name : Pankaj kumar","Hospital Address : Nagpur", "Exp: 15yrs","Mobile No:7898989898","1900"},
                    {"Doctor Name : Swapnil lale","Hospital Address : Pune", "Exp: 8yrs","Mobile No:8898989898","1300"},
                    {"Doctor Name : Deepak kumar","Hospital Address : Bangalore", "Exp: 6yrs","Mobile No:9898000000","1500"},
                    {"Doctor Name : Ankul Panda","Hospital Address : Chennai", "Exp: 7yrs","Mobile No:7798989898","1800"},
            };
    TextView tv;
    Button btn;
    String [][] doctor_details ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewLTmTitle);
        btn = findViewById(R.id.buttonBMCartBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physician")==0)
        {
            doctor_details= doctor_details1;
        }
        else
        if(title.compareTo("Dietician")==0)
        {
            doctor_details= doctor_details2;
        }
        else
        if(title.compareTo("Dentist")==0)
        {
            doctor_details= doctor_details3;
        }
        else
        if(title.compareTo("Surgeon")==0)
        {
            doctor_details= doctor_details4;
        }
        else
        {
            doctor_details= doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("Line1",doctor_details[i][0]);
            item.put("Line2",doctor_details[i][1]);
            item.put("Line3",doctor_details[i][2]);
            item.put("Line4",doctor_details[i][3]);
            item.put("Line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item);
        }
        sa= new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}