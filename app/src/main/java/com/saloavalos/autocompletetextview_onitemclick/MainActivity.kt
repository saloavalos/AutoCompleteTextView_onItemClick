package com.saloavalos.autocompletetextview_onitemclick

import androidx.appcompat.app.AppCompatActivity
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.ArrayAdapter
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener

class MainActivity : AppCompatActivity() {
    private lateinit var actvMain: AutoCompleteTextView
    private lateinit var tvMain: TextView
    var strings = arrayOf("One", "Two", "Three", "Four")
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hooks
        actvMain = findViewById(R.id.actv_main)
        tvMain = findViewById(R.id.tv_main)

        // Initialize adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strings)

        // Set the minimum of words needed to show suggestions
        actvMain.threshold = 1

        // Set adapter
        actvMain.setAdapter(adapter)
        actvMain.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            // Set selected text on textView
            tvMain.text = adapter!!.getItem(position)
        }
    }
}

/* Java version
package com.saloavalos.autocompletetextview_onitemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView actvMain;
    TextView tvMain;
    String[] strings = {"One", "Two", "Three", "Four"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hooks
        actvMain = findViewById(R.id.actv_main);
        tvMain = findViewById(R.id.tv_main);

        // Initialize adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, strings);

        // Set the minimum of words needed to show suggestions
        actvMain.setThreshold(1);

        // Set adapter
        actvMain.setAdapter(adapter);

        actvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Set selected text on textView
                tvMain.setText(adapter.getItem(position));
            }
        });
    }
}
 */