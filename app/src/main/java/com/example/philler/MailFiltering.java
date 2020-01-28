package com.example.philler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.StringTokenizer;

public class MailFiltering extends AppCompatActivity implements View.OnClickListener {
    EditText emailView;
    Button startBtn;
    Button restartBtn;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_filtering);

        emailView = findViewById(R.id.add_mail);
        emailView.setInputType(0);
        emailView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText emailView = findViewById(R.id.add_mail);
                emailView.setInputType(1);
            }
        });
        startBtn = findViewById(R.id.start);
        startBtn.setOnClickListener(this);
        restartBtn = findViewById(R.id.restart);
        restartBtn.setOnClickListener(this);

        Intent tnt = getIntent();
        String action = tnt.getAction();
        String type = tnt.getType();
        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)){
                String sharedText = tnt.getStringExtra(Intent.EXTRA_TEXT);
                emailView.setText(sharedText);
            }
        } //다른 앱에서 공유하면 emailView에 뿌려진다
    }

    @Override
    public void onClick(View view) {
        final InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(emailView.getWindowToken(), 0);
        //start든 restart든 누르면 키보드 창 내려간다

        if(view.getId() == R.id.start) {
            str = emailView.getText().toString();

            if(str == null || str.equals("")){
                Toast t = Toast.makeText(this, R.string.main_mail_error, Toast.LENGTH_SHORT);
                t.show();
            } else {
                StringTokenizer st = new StringTokenizer(str, " ,:;◈//☜@★$￥♚＃＊은는가을를\n");
                int strLen = st.countTokens(); //st에 들어가 있는 단어의 수를 센다
                String strArray[] = new String[strLen]; //strArray 하나하나가 단어다
                for(int i=0; i<strLen; i++){
                    String token = st.nextToken();
                    strArray[i] = token;
                } //특문을 기준으로 단어를 잘라서 넣는다 strArray[0], strArray[1] 이렇게 들어간다

                int num1 = 1;
                int num2 = 2;
                int spamLen = 0;
                int spamExLen = 5;
                int spamDoLen;
                int count = 0;
                int count_ex = 0;
                int count_domain = 0;
                int count_add = 0;

                //db에서 단어받아오기
                //
                //

                //액티비티 구분 시작
                if (count_domain != 0 || count_add == 0) {
                    if (count_ex == 0) {
                        if (count >  7 ) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage1.class);
                            startActivity(intent);
                        } else if (count > 3) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage2.class);
                            startActivity(intent);
                        } else {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage3.class);
                            startActivity(intent);
                        }
                    } //단계별
                    else {
                        if (count > 7) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage4.class);
                            startActivity(intent);
                        } else if (count > 3) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage5.class);
                            startActivity(intent);
                        } else {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage6.class);
                            startActivity(intent);
                        }
                    } //단계별 + 확장자

                } else {
                    if (count_ex == 0) {
                        if (count > 7) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage7.class);
                            startActivity(intent);
                        } else if (count > 3) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage8.class);
                            startActivity(intent);
                        } else {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage9.class);
                            startActivity(intent);
                        }
                    } //단계별 + 도메인
                    else {
                        if (count > 7) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage10.class);
                            startActivity(intent);
                        } else if (count > 3) {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage11.class);
                            startActivity(intent);
                        } else {
                            this.finish();
                            Intent intent=new Intent(this, ResultPage12.class);
                            startActivity(intent);
                        }
                    } //단계별 + 도메인 + 확장자
                }
            }
        }

        if(view.getId() == R.id.restart) {
            this.finish();
            Intent intent = new Intent(this, MailFiltering.class);
            startActivity(intent);
            overridePendingTransition(0, 0); //액티비티 전환을 위해서 필요, 검색 요망
        }
    }
}
