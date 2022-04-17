package vn.edu.hust.soict.quangnh.it4785.trieunv.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    public static final String REPLY_MESSAGE = "Order";
    RadioGroup grDelivery;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Order");

        grDelivery = findViewById(R.id.grDelivery);
        spinner = findViewById(R.id.spinner_phone);

        Intent intent = getIntent();
        String message = "Order: "+ intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textview = findViewById(R.id.order_textview);
        textview.setText(message);

        grDelivery.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int id) {
                        switch (id){
                            case R.id.sameday:
                                showMessage(R.string.same_day);
                                break;
                            case R.id.nextday:
                                showMessage(R.string.next_day);
                                break;
                            case R.id.pickup:
                                showMessage(R.string.pick_up);
                                break;
                        }
                    }
                }
        );

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        List<String> listPhoneStyles =
                                Arrays.asList(getResources().getStringArray(R.array.labels_array));
                        Toast.makeText(OrderActivity.this,listPhoneStyles.get(i),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
    }
    public void showMessage(int idMessage){
        Toast.makeText(this,getString(idMessage),
                Toast.LENGTH_SHORT).show();
    }

}