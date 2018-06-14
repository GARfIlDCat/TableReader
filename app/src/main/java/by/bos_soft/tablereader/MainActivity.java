package by.bos_soft.tablereader;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFileBrowser;
    FileBrowserFragment frFileBrowser;
    FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnFileBrowser = (Button) findViewById(R.id.btnFileBrowser);
        frFileBrowser = new FileBrowserFragment();
    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnFileBrowser:
                fTrans.add(R.id.frCont, frFileBrowser);
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
    }

}
