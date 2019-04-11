package learncode.nj.com.jaipurbus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Rcadapter  extends RecyclerView.Adapter<Rcadapter.RcViewholder> {
    List<String> dataList;
    Context context;

    Rcadapter(List<String> data, Context con){
        dataList=new ArrayList<>();
        dataList=data;
        context=con;
    }

    @NonNull
    @Override
    public RcViewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclere,parent,false);
        return new RcViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RcViewholder hc, int i) {
       String[] singledata=dataList.get(i).split(":");
       hc.namet.setText(singledata[0]);
       if(singledata[1].equalsIgnoreCase("L")){
           hc.typet.setText("Low floor");
           hc.imt.setText("L");
       }else
       {
           hc.typet.setText("Mini Bus");
           hc.imt.setText("M");
       }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class RcViewholder extends RecyclerView.ViewHolder{
        TextView imt, namet,typet;
        public RcViewholder(@NonNull View itemView) {
            super(itemView);

            imt=itemView.findViewById(R.id.im);
            namet=itemView.findViewById(R.id.name);
            typet=itemView.findViewById(R.id.type);


        }
    }
}
