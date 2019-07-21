package com.example.guessgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import io.realm.Realm;


public class FlowerQuizActivity extends AppCompatActivity {

    ImageButton flower_pic;Button next;Button btn[]=new Button[4];
    TextView p_name;
    String foption[]={"rose", "lily", "begonia", "jasmine", "orchid"};
    Random rand=new Random();
    Realm realm;
    int id,correct_pos,pic_pick,incorrect_pos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_display);
        flower_pic=findViewById(R.id.pic);
        next=findViewById(R.id.next);
        p_name=findViewById(R.id.tv_user_name);
        btn[0]=findViewById(R.id.button1);btn[1]=findViewById(R.id.button2);btn[2]=findViewById(R.id.button3);btn[3]=findViewById(R.id.button4);
        realm.init(this);
        realm=Realm.getDefaultInstance();
        p_name.setText(getIntent().getStringExtra("playerName"));
        //Picture selection and option part
        correct_pos=rand.nextInt(4);
        pic_pick=rand.nextInt(5);
        id=getResources().getIdentifier(foption[pic_pick],"drawable",getPackageName());
        flower_pic.setImageResource(id);
        flower_pic.setScaleType(ImageView.ScaleType.FIT_CENTER);
        for(int i=0;i<4;i++){
            if( i == correct_pos ) btn[i].setText(foption[pic_pick]);
            else{
                  incorrect_pos=(int)(rand.nextInt(15)%5);
                  while(incorrect_pos == pic_pick){incorrect_pos=rand.nextInt(5);}
                  btn[i].setText(foption[incorrect_pos]);
                }
        }

    }

    protected void onSubmit(View view){}
}
