package android.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourthActivity<nameField> extends AppCompatActivity implements View.OnClickListener {
    private Button btnBack;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
            }
    public void submitOrder(View view) {
        // Get user's name

        EditText nameField = findViewById(R.id.input);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();


        // Display the order summary on the screen
        String message = createOrderSummary(name);

        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT,
//                getString(R.string.texts, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(String name) {
        String priceMessage = getString(R.string.order_summary_name, name);
        return priceMessage;
    }

}
