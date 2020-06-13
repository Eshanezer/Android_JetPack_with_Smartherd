package com.ezer.jetpack.room;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ezer.jetpack.R;
import com.ezer.jetpack.room.model.Note;

import org.w3c.dom.Text;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private Context context;
    private  LayoutInflater inflater;
    private List<Note> list;

    public NoteAdapter(Context applicationContext) {
        this.context = applicationContext;
        inflater =LayoutInflater.from(context);
    }

    public void setNotes(List<Note> notes){
        list =notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view =inflater.inflate(R.layout.layout_item,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if(list!=null){
            Note note = list.get(position);
            holder.setData(note.getNote(),position);
        }else {
            holder.tv.setText("No Items Found");
        }
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }else{
            return 0;
        }
    }
}
class NoteViewHolder extends RecyclerView.ViewHolder{
TextView tv;
int position;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        tv =itemView.findViewById(R.id.text);
    }
    public void setData(String s,int position){
        tv.setText(s);
        this.position =position;
    }
}
