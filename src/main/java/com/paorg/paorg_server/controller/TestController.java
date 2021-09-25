package com.paorg.paorg_server.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

  @GetMapping
  @CrossOrigin("http://localhost:3000")
  public String get(HttpServletRequest request) {
    String idToken = request.getHeader("Authorization");

    try {
      FirebaseToken decodedToken =
        FirebaseAuth.getInstance().verifyIdToken(idToken);
      return "サーバー認証成功：java_firebase";
    } catch (FirebaseAuthException e) {
      e.printStackTrace();
      return "サーバー認証失敗";
    }
  }
}
