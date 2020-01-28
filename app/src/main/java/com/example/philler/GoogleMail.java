package com.example.philler;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.StringTokenizer;

public class GoogleMail extends AppCompatActivity implements View.OnClickListener{
    WebView googleView;
    EditText emailView;
    String str;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_mail);

        googleView = findViewById(R.id.googleView);
        emailView = findViewById(R.id.editText);
        startBtn = findViewById(R.id.button);
        startBtn.setOnClickListener(this);

        googleView.getSettings().setJavaScriptEnabled(true);
        googleView.getSettings().setBuiltInZoomControls(true);
        googleView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        googleView.getSettings().setLightTouchEnabled(true);
        googleView.getSettings().setSaveFormData(true);

        googleView.setWebViewClient(new MyWebViewClient());
        googleView.loadUrl("http://mail.google.com");
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onClick(View view) {
        str = emailView.getText().toString();

        if(str == null || str.equals("")){
            Toast t = Toast.makeText(this, R.string.main_mail_error, Toast.LENGTH_SHORT);
            t.show();
        } else {
            StringTokenizer st = new StringTokenizer(str, " ,:;◈//☜@★$￥♚＃＊은는가을를\n");
            int strLen = st.countTokens(); //st에 들어가 있는 단어의 수를 센다
            String strArray[] = new String[strLen]; //strArray 하나하나가 단어다
            for (int i = 0; i < strLen; i++) {
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
                    if (count > 7) {
                        ResultPopup1 dialog = new ResultPopup1(this);
                        dialog.show();
                    } else if (count > 3) {
                        ResultPopup2 dialog = new ResultPopup2(this);
                        dialog.show();
                    } else {
                        ResultPopup3 dialog = new ResultPopup3(this);
                        dialog.show();
                    }
                } //단계별
                else {
                    if (count > 7) {
                        ResultPopup4 dialog = new ResultPopup4(this);
                        dialog.show();
                    } else if (count > 3) {
                        ResultPopup5 dialog = new ResultPopup5(this);
                        dialog.show();
                    } else {
                        ResultPopup6 dialog = new ResultPopup6(this);
                        dialog.show();
                    }
                } //단계별 + 확장자

            } else {
                if (count_ex == 0) {
                    if (count > 7) {
                        ResultPopup7 dialog = new ResultPopup7(this);
                        dialog.show();
                    } else if (count > 3) {
                        ResultPopup8 dialog = new ResultPopup8(this);
                        dialog.show();
                    } else {
                        ResultPopup9 dialog = new ResultPopup9(this);
                        dialog.show();
                    }
                } //단계별 + 도메인
                else {
                    if (count > 7) {
                        ResultPopup10 dialog = new ResultPopup10(this);
                        dialog.show();
                    } else if (count > 3) {
                        ResultPopup11 dialog = new ResultPopup11(this);
                        dialog.show();
                    } else {
                        ResultPopup12 dialog = new ResultPopup12(this);
                        dialog.show();
                    }
                } //단계별 + 도메인 + 확장자
            }
        }
    }
}
