package android.example.uas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMoveIntent;
    private Button btnMoveIntent2;
    private Button btnMoveIntent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveIntent = findViewById(R.id.btn_move_intent);
        btnMoveIntent.setOnClickListener(this);
        btnMoveIntent2 = findViewById(R.id.btn_move_intent2);
        btnMoveIntent2.setOnClickListener(this);
        btnMoveIntent3 = findViewById(R.id.btn_move_intent3);
        btnMoveIntent3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_intent:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn_move_intent2:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
            case R.id.btn_move_intent3:
                startActivity(new Intent(this, FourthActivity.class));
                break;
        }
    }

}
