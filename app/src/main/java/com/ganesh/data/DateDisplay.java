package com.ganesh.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DateDisplay extends AppCompatActivity {
    TextView nalatime1,nalatime2,day,date,raguText,yemaText,disp;
    Button left,right;
    String d,kil;
    String nala,ragu,yama,marri,spl;
    int m,tempkila,temp; String month;
    String[] raghu={"16.30-18.00","07.30-09.00","15.00-16.30","12.00-13.30","13.30-15.00","10.30-12.00","09.00-10.30"};
    String[] yema={"12.00-01.30","10.30-12.00","09.00-10.30","07.30-09.00","06.00-07.30","03.00-04.30","01.30-03.00"};
    String[] kilamai={"ஞாயிறு","திங்கள்","செவ்வாய்","புதன்","வியாழன்","வெள்ளி","சனி"};
    String[] months={"சித்திரை","வைகாசி","ஆனி","ஆடி","ஆவணி","புரட்டாசி","ஐப்பசி","கார்த்திகை","மார்கழி","தை","மாசி","பங்குனி"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_date_display);
        nalatime1=(TextView)findViewById(R.id.morningtime);
        nalatime2=(TextView)findViewById(R.id.eveningtime);
        raguText=(TextView) findViewById(R.id.raguTime);
        disp=(TextView) findViewById(R.id.dispdate);
        yemaText=(TextView)findViewById(R.id.yamatime);
        day=(TextView)findViewById(R.id.day);
        date=(TextView)findViewById(R.id.date);
        d=getIntent().getExtras().getString("date");
        kil=getIntent().getExtras().getString("kilamai");
        nala=getIntent().getExtras().getString("nala");
        int kilamai1= Integer.parseInt(kil);
        tempkila=kilamai1;
        temp=Integer.parseInt(d);
        ragu=raghu[kilamai1];
        yama=yema[kilamai1];
        marri=getIntent().getExtras().getString("marri");
        month=getIntent().getExtras().getString("month");
        left=(Button)findViewById(R.id.left);
       right=(Button)findViewById(R.id.right);
       call();
       left.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tempkila=Math.abs((tempkila-1)%7);
               temp--;
               call();
           }
       });
       right.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                  tempkila=(tempkila+1)%7;
                  temp++;
                  call();
           }
       });
       }
    public void call(){
        String[] datenala=nala.split(",");
        m=Integer.parseInt(month);
        String[] nal=datenala[temp-1].split(" ");
        ragu=raghu[tempkila];
        yama=yema[tempkila];
        nalatime1.setText(nal[0]);
        nalatime2.setText(nal[1]);
        String fr=months[m]+", ஹேவிளம்பி";
        disp.setText(fr);
        date.setText(String.valueOf(temp));
        raguText.setText(ragu);
        yemaText.setText(yama);
        day.setText(kilamai[tempkila]);
    }
}
