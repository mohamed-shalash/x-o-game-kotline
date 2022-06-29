package com.example.x_o

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun clicked(view: View) {
        var clickedbtn=0;
        var button =view as Button
        when(button.id){
            R.id.b1 -> clickedbtn=1;
            R.id.b2 -> clickedbtn=2;
            R.id.b3 -> clickedbtn=3;
            R.id.b4 -> clickedbtn=4;
            R.id.b5 -> clickedbtn=5;
            R.id.b6 -> clickedbtn=6;
            R.id.b7 -> clickedbtn=7;
            R.id.b8 -> clickedbtn=8;
            R.id.b9 -> clickedbtn=9;
        }
        playGame(clickedbtn,button)
    }
    var  pl1= ArrayList<Int>();
    var  pl2= ArrayList<Int>();
    var player=1

    fun playGame(cellID:Int,bu:Button){
        if (player==1){
            player=2;
            bu.text="X";
            bu.setBackgroundColor(Color.GREEN)
            pl1.add(cellID)
            AutoPlay()
        }else{
            player=1;
            bu.text="O";
            bu.setBackgroundColor(Color.BLUE)
            pl2.add(cellID)
        }
        bu.isEnabled=false
        CheckWinner()
    }


    fun AutoPlay(){
        var  autoplay= ArrayList<Int>();
        for (cellid in 1..9){
            if (!(pl1.contains(cellid) || pl2.contains(cellid))){
                autoplay.add(cellid)
            }
        }

        val r = java.util.Random()
        if (autoplay.size==0)return;
        val randomindex=r.nextInt(autoplay.size-0)+0
        val cellid=autoplay[randomindex]

        var buselect:Button ?
        when(cellid){
            1->buselect=findViewById(R.id.b1)
            2->buselect=findViewById(R.id.b2)
            3->buselect=findViewById(R.id.b3)
            4->buselect=findViewById(R.id.b4)
            5->buselect=findViewById(R.id.b5)
            6->buselect=findViewById(R.id.b6)
            7->buselect=findViewById(R.id.b7)
            8->buselect=findViewById(R.id.b8)
            9->buselect=findViewById(R.id.b9)
            else->{
                buselect=findViewById(R.id.b1)
            }
        }
        playGame(cellid,buselect)
    }

    fun CheckWinner(){
        var win=5

        if (pl1.contains(1)&&pl1.contains(2)&&pl1.contains(3)) win=1
        if (pl2.contains(1)&&pl2.contains(2)&&pl2.contains(3)) win=2


        if (pl1.contains(4)&&pl1.contains(5)&&pl1.contains(6)) win=1
        if (pl2.contains(4)&&pl2.contains(5)&&pl2.contains(6)) win=2

        if (pl1.contains(7)&&pl1.contains(8)&&pl1.contains(9)) win=1
        if (pl2.contains(7)&&pl2.contains(8)&&pl2.contains(9)) win=2

        if (pl1.contains(1)&&pl1.contains(4)&&pl1.contains(7)) win=1
        if (pl2.contains(1)&&pl2.contains(4)&&pl2.contains(7)) win=2


        if (pl1.contains(2)&&pl1.contains(5)&&pl1.contains(8)) win=1
        if (pl2.contains(2)&&pl2.contains(5)&&pl2.contains(8)) win=2

        if (pl1.contains(3)&&pl1.contains(6)&&pl1.contains(9)) win=1
        if (pl2.contains(3)&&pl2.contains(6)&&pl2.contains(9)) win=2

        if(win==1||win==2)
        Toast.makeText(baseContext,"winner is player num "+win,Toast.LENGTH_LONG).show()

    }
}