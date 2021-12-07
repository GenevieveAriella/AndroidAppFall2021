package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Spotify " + MainActivity.class.getSimpleName();

    private static final String CLIENT_ID = "8ac47bfb990b40afaa68081fd6555ddd";

    private static final String REDIRECT_URL = "https://github.com/GenevieveAriella/AndroidAppFall2021";

    private static final int REQUEST_CODE = 1337;

    public static final String AUTH_TOKEN = "AUTH_TOKEN";

    public static final String RESPONSE_KEY = "response";

    static final String EXTRA_AUTH_REQUEST = "EXTRA_AUTH_REQUEST";

    static final String EXTRA_AUTH_RESPONSE = "EXTRA_AUTH_RESPONSE";

    public static final String REQUEST_KEY = "request";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);

        Button mLoginButton = (Button)findViewById(R.id.signInButton);

        mLoginButton.setOnClickListener(mListener);
    }

    private void openLoginWindow() {

        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URL);

        builder.setScopes(new String[]{ "streaming"});

        AuthorizationRequest request = builder.build();

        AuthorizationClient.openLoginActivity(this,REQUEST_CODE,request);
    }


    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE)

        {
            final AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);
            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:
                    Log.e(TAG,"Auth token: " + response.getAccessToken());

                    Intent intent = new Intent(MainActivity.this, menuPage.class);

                    intent.putExtra(AUTH_TOKEN, response.getAccessToken());

                    startActivity(intent);

                    destroy();

                    break;

                // Auth flow returned an error
                case ERROR:
                    Log.e(TAG,"Auth error: " + response.getError());
                    break;
                // Most likely auth flow was cancelled
                default:
                    Log.d(TAG,"Auth result: " + response.getType());

            }

        }

    }


    View.OnClickListener mListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.signInButton:
                    openLoginWindow();
                    break;
            }
        }

    };

    public void destroy(){

        MainActivity.this.finish();

    }

}