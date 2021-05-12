package com.gjm.amp_photo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User item = User.builder()
                .name("Build Android application")
                .build();

        Amplify.DataStore.save(item,
                success -> Log.i("Tutorial", "Saved item: " + success.item().getName()),
                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
        );
    }
}