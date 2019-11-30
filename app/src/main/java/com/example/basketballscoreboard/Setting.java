package com.example.basketballscoreboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    SettingData gameRule=new SettingData();

    class switch1 implements CompoundButton.OnCheckedChangeListener{
        @Override
        //파울 카운트
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
                gameRule.cntFoul=true;
            else
                gameRule.cntFoul=false;
        }
    }

    class switch2 implements CompoundButton.OnCheckedChangeListener{
        @Override
        //슛 차트
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
                gameRule.shotChart=true;
            else
                gameRule.shotChart=false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        Switch switch1=(Switch)findViewById(R.id.switch1);
        Switch switch2=(Switch)findViewById(R.id.switch2);

        final EditText editText1=(EditText)findViewById((R.id.editText1));
        final EditText editText2=(EditText)findViewById((R.id.editText2));

        Button button1=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                                           if(editText1.getText().toString().equals("") ||
                                                   editText2.getText().toString().equals("")) {
                                               Toast.makeText(Setting.this,
                                                       "값이 없습니다.",
                                                       Toast.LENGTH_LONG).show();
                                           } else { //둘 다 공백이 아닐때
                                               if(editText1.getText().toString().equals("0")) {
                                                   Toast.makeText(Setting.this,
                                                           "1이상의 수를 입력",
                                                           Toast.LENGTH_LONG).show();
                                                   if(editText2.getText().toString().equals("0")) {
                                                       Toast.makeText(Setting.this,
                                                               "1이상의 수를 입력",
                                                               Toast.LENGTH_LONG).show();
                                                   } else {
                                                       String s1 = editText1.getText().toString();//1번 값 가져오기(xml->java)
                                                       String s2 = editText2.getText().toString();//2번 값 가져오기(xml->java)
                                                       gameRule.numQuarter = Integer.parseInt(s1);//문자 -> 숫자(정수형)
                                                       gameRule.timePerQuarter = Integer.parseInt(s2);//문자 -> 숫자(정수형)
                                                       ///화면 전환 추가
                            /*
                            System.out.println("쿼터수");
                            System.out.println(gameRule.numQuarter);
                            System.out.println(gameRule.timePerQuarter);
                            System.out.println(gameRule.cntFoul);
                            System.out.println(gameRule.shotChart);
                            */
                                                   }
                                               }

                                           }
                                       }
                                   }
        );
    }
}
