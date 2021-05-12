package com.gjm.amp_photo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Photos;
import com.amplifyframework.datastore.generated.model.User;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        User item = User.builder()
//                .name("Build Android application")
////                .priority(Priority.HIGH)
//                .build();
//
//        Amplify.DataStore.save(item,
//                success -> Log.i("Tutorial", "Saved item: " + success.item().getName()),
//                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
//        );

        Amplify.DataStore.query(Photos.class,
                (Iterator<Photos> photos) -> {
                    while (photos.hasNext()) {
                        Photos photo = photos.next();

                        Log.i("Tutorial", "==== Todo ====");
                        if (photo.getPriority() != null) {
                            Log.i("Tutorial", "Priority: " + photo.getPriority().toString());
                        }

                    }
                },
                failure -> Log.e("Tutorial", "Could not query DataStore", failure)
        );
    }
}