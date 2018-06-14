package by.bos_soft.tablereader;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FileBrowserFragment extends Fragment {

    // имена атрибутов для Map
    final String ATTRIBUTE_FILENAME = "filename";
    final String ATTRIBUTE_CHECKED = "checked";
    final String ATTRIBUTE_IMAGE = "image";
    final String ATTRIBUTE_FILEINFO = "fileinfo";

    private Unbinder unbinder;

    @BindView(R.id.lvFiles) ListView lvFile;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_file_browser, null);
        unbinder = ButterKnife.bind(this, v);

        // массивы данных
        String[] files = { "file 1", "file 2", "file 3", "file 4", "file 5", "file 6", "file 7",
                "file 8", "file 9", "file 10", "file 11", "file 12" };
        String[] infos = { "info 1", "info 2", "info 3", "info 4", "info 5", "info 6", "info 7",
                "info 8", "info 9", "info 10", "info 11", "info 12" };
        boolean[] checked = { true, false, false, true, false, false, true,
                false, false, true, false, false };
        int img = R.mipmap.ic_launcher;

        // упаковываем данные в понятную для адаптера структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                files.length);

        Map<String, Object> m;

        for (int i = 0; i < files.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_FILENAME, files[i]);
            m.put(ATTRIBUTE_FILEINFO, infos[i]);
            m.put(ATTRIBUTE_CHECKED, checked[i]);
            m.put(ATTRIBUTE_IMAGE, img);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = {ATTRIBUTE_FILENAME, ATTRIBUTE_CHECKED,
                ATTRIBUTE_IMAGE, ATTRIBUTE_FILEINFO};
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.cbFileName, R.id.cbFileName, R.id.ivFile, R.id.tvFileInfo };

        // создаем адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(getActivity(), data, R.layout.item_file_browser,
                from, to);

        // присваиваем списку адаптер
        lvFile.setAdapter(sAdapter);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
