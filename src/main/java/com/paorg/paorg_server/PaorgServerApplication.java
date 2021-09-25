package com.paorg.paorg_server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PaorgServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaorgServerApplication.class, args);
    initializeFirebaseApp();
  }

  private static void initializeFirebaseApp() {
    FirebaseOptions options = null;
    try {
      options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.getApplicationDefault())
        .build();
    } catch (IOException e) {
      e.printStackTrace();
    }
    FirebaseApp.initializeApp(options);
  }

}
