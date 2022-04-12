package com.paorg.paorg_server.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.paorg.paorg_server.bean.TestBean;
import com.paorg.paorg_server.domain.TestDomain;
import com.paorg.paorg_server.entity.Test;
import com.paorg.paorg_server.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

  private final TestService testService;
  // private final TestDomain testDomain;

  @GetMapping
  @CrossOrigin("http://localhost:3000")
  public String get(HttpServletRequest request) {
    String idToken = request.getHeader("Authorization");

    try {
      FirebaseToken decodedToken =
        FirebaseAuth.getInstance().verifyIdToken(idToken);
      return "サーバー認証成功：paorg_server";
    } catch (FirebaseAuthException e) {
      e.printStackTrace();
      return "サーバー認証失敗";
    }
  }

  @GetMapping("/test")
  @CrossOrigin("http://localhost:3000")
  public List<TestBean> getTest() {
    return this.testService.findAll();
  }

  @GetMapping("/test_register")
  @CrossOrigin("http://localhost:3000")
  public String registerTest() {
    this.testService.register("わかたか");
    // this.testDomain.register();
    return "登録完了";
  }

  @GetMapping("/test_update")
  @CrossOrigin("http://localhost:3000")
  public String updateTest() {
    this.testService.update(1, "わかたかぐんだん");
    return "更新完了";
  }

  @GetMapping("/test_delete")
  @CrossOrigin("http://localhost:3000")
  public String deleteTest() {
    this.testService.delete(1);
    return "削除完了";
  }

  @ResponseBody
  @RequestMapping("/sample")
  public String sample(
    BindingResult bindingResult,
    @Validated String form,
    Model model
  ) {
    return "OK";
  }
}
