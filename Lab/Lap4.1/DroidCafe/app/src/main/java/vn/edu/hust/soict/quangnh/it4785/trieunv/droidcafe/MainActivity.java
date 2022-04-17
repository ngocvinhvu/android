package vn.edu.hust.soict.quangnh.it4785.trieunv.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage = "";
    public static final String EXTRA_MESSAGE = "GIO_HANG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDonutOrder(View view) {
        Toast.makeText(this, getString(R.string.donut_order_message),
                Toast.LENGTH_LONG).show();
        mOrderMessage = getString(R.string.donut_order_message);
    }

    public void showIce_creamOrder(View view) {
        Toast.makeText(this, getString(R.string.ice_cream_order_message),
                Toast.LENGTH_LONG).show();
        mOrderMessage = getString(R.string.ice_cream_order_message);
    }

    public void showFroyoOrder(View view) {
        Toast.makeText(this, getString(R.string.froyo_order_message),
                Toast.LENGTH_SHORT).show();
        mOrderMessage = getString(R.string.froyo_order_message);
    }

    public void showOrderActivity(View view) {
        if(mOrderMessage == ""){
            Toast.makeText(this, "Please choose a droid desert", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,mOrderMessage, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE,mOrderMessage); // gửi dữ liệu
        startActivity(intent);
    }
}