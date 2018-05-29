package by.bos_soft.tablereader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnFileBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFileBrowser = (Button) findViewById(R.id.btnFileBrowser);
        btnFileBrowser.callOnClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFileBrowser:
                startActivity(new Intent(this, FileBrowser.class));
                break;
            default:
                break;
        }
    }

}
