package first.example.takaotakao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter {
    SQLBaseHelper dbHelper;
    Context cont;
    int res;
    int tvName;
    int tvPrice;
    ArrayList<String> listName;
    ArrayList<String> listPrice;
    public MyArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects,int textViewResourceId2,@NonNull List objects2) {
        super(context,resource,textViewResourceId,objects);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        dbHelper=new SQLBaseHelper(getContext());
        View view=super.getView(position,convertView,parent);
        View button=view.findViewById(R.id.delete_but);
        final TextView text=view.findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=String.valueOf(text.getText());
                dbHelper.deleteData(str);

            }
        });
        return super.getView(position, convertView, parent);
    }
}
