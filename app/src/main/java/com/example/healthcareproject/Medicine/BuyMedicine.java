package com.example.healthcareproject.Medicine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.Cart.MyCartLab;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicine extends AppCompatActivity {

    TextView titleBM;

    private final String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "305"},
                    {"Vitamin B Complex Capsules", "448"},
                    {"Inlife Vitamin E Wheat Germ Oil Capsule", "540"},
                    {"Dolo 650 Tablet", "30"},
                    {"Crocin 650 Advance Tablet", "50"},
                    {"Strepsils Medicated Lozenges for Sore Throat", "40"},
                    {"Tata 1mg Calcium + Vitamin D3", "30"},
                    {"Feronia -XT Tablet", "130"}
            };
    private final String[] package_details = {
            "Building and keeping the bones & teeth strong\n"+
                    "Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increasing resistance against infection",
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulat ",
            "Provides relief from vitaminB deficiencies\n" +
                    "Helps in formation of red blood cells\n"+"Maintains healthy nervous system",
            "It promotes health as well as skin benefit.\n"+
                    "It helps reduce skin blemish and pigmentation.\n"+
                    "It act as safeguard the skin from the harsh UVA and UVB sun rays.",
            "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messe ",
            "Helps relieve fever and bring down a high temperature \n" +
                    "Suitable for people with a heart condition or high blood pressure",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n"+"Provides a warm and comforting feeling during sore throat",
            "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n"+
                    "Promotes mobility and flexibility of joints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
    };


    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    ImageView backToHomeBM,goToCart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        /*--------------------------------------------------------------Set Title---------------------------------------------------------------------------------------*/
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        titleBM = findViewById(R.id.titleBM);
        titleBM.setText(title);

        /*--------------------------------------------------------------Go back to Home---------------------------------------------------------------------------------------*/
        backToHomeBM=findViewById(R.id.backToHomeBM);
        backToHomeBM.setOnClickListener(view -> {
            Intent i = new Intent(BuyMedicine.this, HomePage.class);
            startActivity(i);
        });

        /*--------------------------------------------------------------Go to My Cart ---------------------------------------------------------------------------------------*/
        goToCart=findViewById(R.id.goToCartBtnBM);
        goToCart.setOnClickListener(view -> {
            Intent i = new Intent(BuyMedicine.this, MyCartLab.class);
            startActivity(i);
        });


        /*--------------------------------------Set The data form list View  ----------------------------------------------------------------------------------------*/
        listView = findViewById(R.id.buyMedList);
        list = new ArrayList<>();
        for (String[] aPackage : packages) {
            item = new HashMap<>();
            item.put("line1", aPackage[0]);
            item.put("line2", "Total Cost : " + aPackage[1]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.lab_test_item_list,
                new String[]{"line1", "line2"},
                new int[]{R.id.line_x, R.id.line_y}
        );
        listView.setAdapter(sa);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it1 = new Intent(BuyMedicine.this, BuyMedicineDetails.class);
            it1.putExtra("text1", packages[i][0]);
            it1.putExtra("text2", package_details[i]);
            it1.putExtra("text3", packages[i][1]);
            startActivity(it1);
        });


    }
}