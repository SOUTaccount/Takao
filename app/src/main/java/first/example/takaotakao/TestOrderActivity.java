package first.example.takaotakao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class TestOrderActivity extends AppCompatActivity {
    RecyclerView testRec;
    ArrayList<String> taskList;
    ArrayList<String> taskList2;

    SQLBaseHelper dbHelper;
    //int pizzaImg []={R.drawable.restaurant,R.drawable.restaurant,R.drawable.funghi,R.drawable.diavolo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_order);
        testRec = findViewById(R.id.testRec);
        dbHelper = new SQLBaseHelper(this);
        taskList = dbHelper.getAllTasks();
        taskList2 = dbHelper.getAllPrice();

        TestOrderAdapter testAdapter = new TestOrderAdapter(this, taskList,taskList2);
        testRec.setAdapter(testAdapter);
        testRec.setLayoutManager(new LinearLayoutManager(this));

    }


    }