package com.paorg.paorg_server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

  /**
   * CORS対策
   * @return CORS対策追加後の設定
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        // TODO 環境別の指定追加
        // registry.addMapping("/*").allowedOrigins("http://localhost:3000");
        registry.addMapping("/*").allowedOrigins("http://192.168.1.5:3000");
      }
    };
  }

}
