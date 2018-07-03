package vin.kell.pay;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import co.chatsdk.ui.R;

public class PickPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                EditText etAmount = (EditText) findViewById(R.id.et_payment_amount);
                double amount = Double.parseDouble(etAmount.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("Amount",amount);
                //intent.putExtra("Bill",getNotePicture(amount));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private Bitmap getNotePicture(double amount) {
        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        Bitmap bmp = Bitmap.createBitmap(100, 50, conf); // this creates a MUTABLE bitmap
        Canvas canvas = new Canvas(bmp);
        Paint bgPaint = new Paint();
        bgPaint.setARGB(255,133,187,101);
        bgPaint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(bgPaint);

        Paint textPaint = new Paint();
        int xPos = (canvas.getWidth() / 2);

        int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)) ;

        textPaint.setARGB(255,255,255,255);
        canvas.drawText(String.format("$%.2f", amount), xPos, yPos, textPaint);

        return bmp;
    }

}
