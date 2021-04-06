package first.example.takaotakao;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {
    String data1 [];
    String data2 [];
    int images[];
    Context context;
    SQLBaseHelper dbHelper;

    public PizzaAdapter(Context ct, String s1[],String s2[], int img []){
        context=ct;
        data1=s1;
        data2=s2;
        images=img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.pizza_adapter,parent,false);
        dbHelper=new SQLBaseHelper(context);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.image1.setImageResource(images[position]);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String str=String.valueOf(holder.text1.getText());
                        String price=String.valueOf(holder.text2.getText());
                        dbHelper.insertData(str,price);
                        //dbHelper.insertPrice(price);
                        Toast toast1=Toast.makeText(context,"PRODUCT ADDED " + str,Toast.LENGTH_SHORT);
                        toast1.show();

            }
        });
        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast2=Toast.makeText(context,"IMAGE PICKED",Toast.LENGTH_SHORT);
                toast2.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1;
        TextView text2;
        ImageView image1;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.pizzaText);
            text2=itemView.findViewById(R.id.textView4);
            image1=itemView.findViewById(R.id.pizzaView);
            button=itemView.findViewById(R.id.pizza_button);

        }

    }
}