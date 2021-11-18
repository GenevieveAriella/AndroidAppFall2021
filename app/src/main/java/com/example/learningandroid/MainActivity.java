package com.example.learningandroid;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import android.content.Intent;
import android.net.Uri;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.spotify.sdk.android.auth.BuildConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Spotify " + MainActivity.class.getSimpleName();

    private static final String CLIENT_ID = "cc57ce3f4df445198f7f85f8d60c6d07";

    private static final String REDIRECT_URL = "https://github.com/qle2";

    private static final int REQUEST_CODE = 1337;

    public static final String AUTH_TOKEN = "AUTH_TOKEN";

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

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

                    Intent intent = new Intent(MainActivity.this,

                            MainActivity.class);

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