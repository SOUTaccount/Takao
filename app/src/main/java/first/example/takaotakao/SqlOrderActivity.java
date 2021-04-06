package first.example.takaotakao;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SqlOrderActivity extends AppCompatActivity {
    private ListView allTasks;
    private ArrayAdapter<String> myAdapter;
    SQLBaseHelper dbHelper;
    ArrayList<String>  taskList;
    ArrayList<String>  priceList;
    MyArrayAdapter myArrayAdapter;
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_order);
        dbHelper=new SQLBaseHelper(this);
        allTasks=findViewById(R.id.list_task);
        loadAllTasks();
        allTasks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemSelect: position = " + position + ", id = "
                        + id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(LOG_TAG, "itemSelect: nothing");

            }
        });
    }

    public void loadAllTasks() {
        taskList=dbHelper.getAllTasks();
        if (myAdapter==null){
            myAdapter=new ArrayAdapter<String>(this,R.layout.raw,R.id.textView3,taskList);
            allTasks.setAdapter(myAdapter);

        }else{
            myAdapter.clear();
            myAdapter.addAll(taskList);
            myAdapter.notifyDataSetChanged();
        }
    }

   public void deleteTask(View view){
       TextView tv=(TextView)findViewById(R.id.textView3);
       String task=String.valueOf(tv.getText());
       dbHelper.deleteData(task);
       loadAllTasks();
   }
}

