package first.example.takaotakao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestOrderAdapter extends RecyclerView.Adapter<TestOrderAdapter.MyViewHolder> {
    ArrayList<String> taskList;
    ArrayList<String> taskList2;

   // int images[];
    Context context;
    SQLBaseHelper dbHelper;

    public TestOrderAdapter(Context ct, ArrayList<String> tL,ArrayList<String> tL2){
        context=ct;
        taskList=tL;
        taskList2=tL2;
      //  images=img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.test_order_adapter,parent,false);
        dbHelper=new SQLBaseHelper(context);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TestOrderAdapter.MyViewHolder holder, final int position) {
        if (position!=taskList.size()) {
            holder.text1.setText(String.valueOf(taskList.get(position)));
            holder.text2.setText(String.valueOf(taskList2.get(position)));
        }
        //holder.image1.setImageResource(images[position]);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task=String.valueOf(holder.text1.getText());
                Toast toast=Toast.makeText(context,"name " + task,Toast.LENGTH_SHORT);
                toast.show();
                dbHelper.deleteData(task);
                notifyDataSetChanged();
                taskList.clear();
                taskList=dbHelper.getAllTasks();
            }
        });

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1;
        TextView text2;
        //ImageView image1;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.text_test);
            text2=itemView.findViewById(R.id.text_test2);
           // image1=itemView.findViewById(R.id.img_test);
            button=itemView.findViewById(R.id.button_test);

        }

    }
}