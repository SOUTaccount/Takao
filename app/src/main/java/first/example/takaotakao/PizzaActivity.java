package first.example.takaotakao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PizzaActivity extends AppCompatActivity {
    RecyclerView pizzaRec;
    String [] str1;
    String [] str2;
    int pizzaImg []={R.drawable.restaurant,R.drawable.restaurant,R.drawable.funghi,R.drawable.diavolo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        pizzaRec=findViewById(R.id.pizzaRec);
        str1=getResources().getStringArray(R.array.Pizza);
        str2=getResources().getStringArray(R.array.PricePizza);
        PizzaAdapter pizzaAdapter=new PizzaAdapter(this,str1,str2,pizzaImg);
        pizzaRec.setAdapter(pizzaAdapter);
        pizzaRec.setLayoutManager(new LinearLayoutManager(this));

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_new_task) {
            Intent intent = new Intent(this, TestOrderActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}