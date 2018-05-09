package com.example.yyh.canvesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.Toast;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;

public class MainActivity extends AppCompatActivity {

    private BridgeWebView wvBridge;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button3);
        wvBridge = (BridgeWebView) findViewById(R.id.JsBridgeWebView);
        wvBridge.setDefaultHandler(new DefaultHandler());
        wvBridge.setWebChromeClient(new WebChromeClient());
        wvBridge.setWebViewClient(new MyWebViewClient(wvBridge));
        wvBridge.loadUrl("file:///android_asset/test.html");


        wvBridge.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data,CallBackFunction function) {
                //显示接受到的消息
                showToast(data);
                //返回给js的消息
                function.onCallBack("返回给toast的alert");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("bridge","native click");
                /**
                 * 给Html发消息   js接收并返回data
                 */
                wvBridge.callHandler("functionInJs", "调用js的方法", new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        showToast("==="+data);
                    }
                });
            }
        });
    }

    public void showToast (String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
