package com.example.learningandroid;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import android.util.Log;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationClient;

public class MainActivity extends AppCompatActivity {
//    public static final String CLIENT_ID = "cc57ce3f4df445198f7f85f8d60c6d07";
    public static final String CLIENT_ID = "8ac47bfb990b40afaa68081fd6555ddd";
    public static final String AUTH_TOKEN = "AUTH_TOKEN";
    private static final String REDIRECT_URI = "https://github.com/GenevieveAriella/AndroidAppFall2021";

    private static final String TAG = "Spotify " + MainActivity.class.getSimpleName();
    /**
     * Request code that will be passed together with authentication result to the onAuthenticationResult
     */
    private static final int REQUEST_CODE = 1337;

    View.OnClickListener mListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.signInButton:
                    openLoginWindow();
                    break;
            }
        }
    };

    private void openLoginWindow() {

        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI);

        builder.setScopes(new String[]{ "streaming"});

        AuthorizationRequest request = builder.build();

        AuthorizationClient.openLoginActivity(this,REQUEST_CODE,request);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(MainActivity.this, MainActivity.class);
//        startActivity(intent);

        Button mLoginButton = (Button)findViewById(R.id.signInButton);

        mLoginButton.setOnClickListener(mListener);

    }

    /**
    The purpose of this public method is to link the landing page to the menu page together
     **/
    public void signInButtonClick(View view){
        // Intent takes in 2 arguments, the context and the page you want to link to. In this case,
        // I want to link to menuPage. Next step is to go to the sign in button and loads this method
        // into the onCLick attribute
        Intent intent = new Intent(this, menuPage.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            final AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);

            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:

                    Intent intent = new Intent(this,
                            menuPage.class);

                    intent.putExtra(AUTH_TOKEN, response.getAccessToken());

                    startActivity(intent);

                    destroy();

                    break;

                // Auth flow returned an error
                case ERROR:
                    Log.e(TAG, "Auth error: " + response.getError());
                    break;

                // Most likely auth flow was cancelled
                default:
                    Log.d(TAG, "Auth result: " + response.getType());
            }
        }
    }

    public void destroy() {
        this.finish();
    }
}
