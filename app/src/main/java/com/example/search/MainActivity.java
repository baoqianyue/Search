package com.example.search;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String[] searchWeb;
    public String content;
    public String content1;
    public String content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGo = (Button) findViewById(R.id.btn_go);
        final EditText etSearch = (EditText) findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                content1 = etSearch.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.sp_menu);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                searchWeb = getResources().getStringArray(R.array.searchWeb);
                if (searchWeb[position].equals("百度")) {
                    content = "http://www.baidu.com/s?wd=";
                } else if (searchWeb[position].equals("知乎")) {
                    content = "http://www.zhihu.com";
                } else if (searchWeb[position].equals("CSDN")) {
                    content = "http://so.csdn.net/so/search/s.do?q=";
                } else if (searchWeb[position].equals("Google")) {
                    content = "https://www.google.com.hk/?gws_rd=ssl";
                } else if (searchWeb[position].equals("Github")) {
                    content = "https://github.com/search?utf8=✓&q=";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        content1 = etSearch.getText().toString();

        Log.i(TAG, content1);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                content2 = content + content1;

                Intent intent = new Intent(MainActivity.this, Content_activity.class);
                intent.putExtra("searchContent", content2);
                Toast.makeText(MainActivity.this, content2, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
