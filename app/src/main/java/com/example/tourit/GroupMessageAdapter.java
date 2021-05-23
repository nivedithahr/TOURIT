package com.example.tourit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GroupMessageAdapter extends RecyclerView.Adapter{

    Context contexts;
    ArrayList<MessageSt> messages;

    final int ITEM_SENT = 1;
    final int ITEM_RECEIVE = 2;

    public GroupMessageAdapter(Context contexts, ArrayList<MessageSt> messages){
        this.contexts = contexts;
        this.messages = messages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_SENT){
            View view = LayoutInflater.from(contexts).inflate(R.layout.senditem, parent, false);
            return new SentViewHolderS(view);
        }else {
            View view = LayoutInflater.from(contexts).inflate(R.layout.receiveitem, parent, false);
            return new ReceiveViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        MessageSt messageSt = messages.get(position);
        if (FirebaseAuth.getInstance().getUid().equals(messageSt.getSenderId())){
            return ITEM_SENT;
        }
        else {
            return ITEM_RECEIVE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageSt messageSt = messages.get(position);

        if (holder.getClass() == SentViewHolderS.class){
            SentViewHolderS viewHolderS = (SentViewHolderS)holder;

            FirebaseDatabase.getInstance()
                    .getReference().child("Users")
                    .child(messageSt.getSenderId())
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                UserObject userTeacher = snapshot.getValue(UserObject.class);
                                viewHolderS.nameGrpSent.setText(userTeacher.getUserName());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

            viewHolderS.grpSentChat.setText(messageSt.getMessageS());
        }else {
            ReceiveViewHolder viewHolderS = (ReceiveViewHolder) holder;

            FirebaseDatabase.getInstance()
                    .getReference().child("Users")
                    .child(messageSt.getSenderId())
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                UserObject userTeacher = snapshot.getValue(UserObject.class);
                                viewHolderS.nameGrpRec.setText(userTeacher.getUserName());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

            viewHolderS.recGrp.setText(messageSt.getMessageS());
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class SentViewHolderS extends RecyclerView.ViewHolder{

        private TextView grpSentChat, nameGrpSent;

        public SentViewHolderS(@NonNull View itemView) {
            super(itemView);

            grpSentChat = itemView.findViewById(R.id.sentGrp);
            nameGrpSent = itemView.findViewById(R.id.grpNameSent);
        }
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder{

        private TextView recGrp,nameGrpRec;

        public ReceiveViewHolder(@NonNull View itemView) {
            super(itemView);

            recGrp = itemView.findViewById(R.id.recieveGrpChat);
            nameGrpRec = itemView.findViewById(R.id.grpNameRec);
        }
    }
}
