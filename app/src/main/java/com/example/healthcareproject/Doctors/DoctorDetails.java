package com.example.healthcareproject.Doctors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    private final String[][] doctor_details1 = {
            {
                    "Doctor Name: Dr. Adwani Satish",
                    "Hospital Address: Sant Hirdaram Nagar, Bhopal",
                    "Experience: 10 years",
                    "Mobile Number: 0755-264 1690",
                    "500"
            },
            {
                    "Doctor Name: Dr. Agrawal Pankaj",
                    "Hospital Address: Shivaji Nagar, Bhopal",
                    "Experience: 13 years",
                    "Mobile Number: 755-6454669",
                    "600"
            },
            {
                    "Doctor Name: Dr. Achwal Suvarna",
                    "Hospital Address: Sagar",
                    "Experience: 10 years",
                    "Mobile Number: 0775-2342445",
                    "450"
            },
            {
                    "Doctor Name: Dr. Ahiwar Dilip",
                    "Hospital Address: New market, Narsinghpur",
                    "Experience: 14 years",
                    "Mobile Number: 0755-264 1234",
                    "550"
            },
            {
                    "Doctor Name: Dr. Chandorkar Sanjeev",
                    "Hospital Address: Narsinghpur",
                    "Experience: 11 years",
                    "Mobile Number: 0755-231 1624",
                    "480"
            },
            {
                    "Doctor Name: Dr. Chandorkar Sanjeev",
                    "Hospital Address: Narsinghpur",
                    "Experience: 11 years",
                    "Mobile Number: 0755-231 1624",
                    "480"
            },
            {
                    "Doctor Name: Dr. Achwal Suvarna",
                    "Hospital Address: Sagar",
                    "Experience: 10 years",
                    "Mobile Number: 0775-2342445",
                    "450"
            }
    };

    private final String[][] doctor_details2 = {
            {
                    "Doctor Name: Dr. Emily Davis",
                    "Hospital Address: 321 Health Lane, Medical City",
                    "Experience: 10 years",
                    "Mobile Number: 111-222-3333",
                    "400"
            },
            {
                    "Doctor Name: Dr. Robert Miller",
                    "Hospital Address: 456 Care Blvd, Wellnesstown",
                    "Experience: 18 years",
                    "Mobile Number: 444-555-6666",
                    "600"
            },
            {
                    "Doctor Name: Dr. Sarah Wilson",
                    "Hospital Address: 789 Healing Ave, Healthville",
                    "Experience: 22 years",
                    "Mobile Number: 777-888-9999",
                    "800"
            },
            {
                    "Doctor Name: Dr. Kevin Anderson",
                    "Hospital Address: 543 Medical Park, Cureville",
                    "Experience: 16 years",
                    "Mobile Number: 888-777-6666",
                    "700"
            },
            {
                    "Doctor Name: Dr. Lisa Adams",
                    "Hospital Address: 876 Medical Center Dr, Remedytown",
                    "Experience: 14 years",
                    "Mobile Number: 222-333-4444",
                    "500"
            },
            {
                    "Doctor Name: Dr. John Doe",
                    "Hospital Address: 123 Medical Ave, Cityville",
                    "Experience: 15 years",
                    "Mobile Number: 123-456-7890",
                    "550"
            },
            {
                    "Doctor Name: Dr. Jane Smith",
                    "Hospital Address: 456 Health St, Townsville",
                    "Experience: 12 years",
                    "Mobile Number: 987-654-3210",
                    "480"
            },
            {
                    "Doctor Name: Dr. Michael Johnson",
                    "Hospital Address: 789 Wellness Rd, Villagetown",
                    "Experience: 20 years",
                    "Mobile Number: 555-123-4567",
                    "900"
            }
    };

    private final String[][] doctor_details3 = {
            {
                    "Doctor Name: Dr. Samantha Brown",
                    "Hospital Address: 432 Health Plaza, Wellness City",
                    "Experience: 8 years",
                    "Mobile Number: 111-222-3333",
                    "450"
            },
            {
                    "Doctor Name: Dr. Jason Davis",
                    "Hospital Address: 555 Care Blvd, Health Haven",
                    "Experience: 14 years",
                    "Mobile Number: 444-555-6666",
                    "600"
            },
            {
                    "Doctor Name: Dr. Olivia Clark",
                    "Hospital Address: 789 Healing Ave, Curetown",
                    "Experience: 20 years",
                    "Mobile Number: 777-888-9999",
                    "700"
            },
            {
                    "Doctor Name: Dr. Benjamin Smith",
                    "Hospital Address: 543 Medical Park, Remedyville",
                    "Experience: 10 years",
                    "Mobile Number: 888-777-6666",
                    "550"
            },
            {
                    "Doctor Name: Dr. Amanda Johnson",
                    "Hospital Address: 876 Medical Center Dr, Healthsville",
                    "Experience: 12 years",
                    "Mobile Number: 222-333-4444",
                    "500"
            }
    };

    private final String[][] doctor_details4 = {
            {
                    "Doctor Name: Dr. Ethan Anderson",
                    "Hospital Address: 111 Health Street, Careville",
                    "Experience: 7 years",
                    "Mobile Number: 111-222-3333",
                    "400"
            },
            {
                    "Doctor Name: Dr. Olivia Roberts",
                    "Hospital Address: 222 Wellness Rd, Remedyland",
                    "Experience: 16 years",
                    "Mobile Number: 444-555-6666",
                    "650"
            },
            {
                    "Doctor Name: Dr. Lucas Johnson",
                    "Hospital Address: 333 Healing Ave, Healthtown",
                    "Experience: 19 years",
                    "Mobile Number: 777-888-9999",
                    "750"
            },
            {
                    "Doctor Name: Dr. Isabella Davis",
                    "Hospital Address: 444 Cure Center, Wellness City",
                    "Experience: 12 years",
                    "Mobile Number: 888-777-6666",
                    "600"
            },
            {
                    "Doctor Name: Dr. Noah Taylor",
                    "Hospital Address: 555 Medical Park, Remedyville",
                    "Experience: 14 years",
                    "Mobile Number: 222-333-4444",
                    "550"
            }
    };


    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    TextView dept;
    ImageView backToFindDoctor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        /*--------------------------------------------------------------Set Title---------------------------------------------------------------------------------------*/
        dept = findViewById(R.id.doctorDepartment);
        Intent i = getIntent();


        String department = i.getStringExtra("dept");
        dept.setText(department);
        assert department != null;
        if (department.compareTo("Family Physicians") == 0) {
            doctor_details = doctor_details1;
        } else if (department.compareTo("Dentists") == 0) {
            doctor_details = doctor_details2;
        } else if (department.compareTo("Dietitian") == 0) {
            doctor_details = doctor_details3;
        } else if (department.compareTo("Surgeon") == 0) {
            doctor_details = doctor_details4;
        } else if (department.compareTo("Cardiologists") == 0) {
            doctor_details = doctor_details1;
        } else if (department.compareTo("Neurologists") == 0) {
            doctor_details = doctor_details2;
        } else if (department.compareTo("Radiologists") == 0) {
            doctor_details = doctor_details3;
        }

        /*--------------------------------------------------------------back to find Doctor---------------------------------------------------------------------------------------*/
        backToFindDoctor = findViewById(R.id.backToFindDoctor);
        backToFindDoctor.setOnClickListener(view -> {
//            Intent intent = new Intent(DoctorDetails.this, FindDoctor.class);
//            startActivity(intent);
            onBackPressed();
        });

        list = new ArrayList();
        for (String[] doctorDetail : doctor_details) {
            item = new HashMap<>();
            item.put("line1", doctorDetail[0]);
            item.put("line2", doctorDetail[1]);
            item.put("line3", doctorDetail[2]);
            item.put("line4", doctorDetail[3]);
            item.put("line5", "Fees :₹" + doctorDetail[4] + "/-");

            list.add(item);

        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listView);
        lst.setAdapter(sa);

        lst.setOnItemClickListener((adapterView, view, i1, l) -> {

            Intent intent = new Intent(DoctorDetails.this, BookAppointment.class);
            intent.putExtra("text1", department);
            intent.putExtra("text2", doctor_details[i1][0]);
            intent.putExtra("text3", doctor_details[i1][1]);
            intent.putExtra("text4", doctor_details[i1][3]);
            intent.putExtra("text5", doctor_details[i1][4]);
            startActivityForResult(intent, 1);
        });
    }
}