package com.ll.exam;

import java.util.Scanner;

public class App {
  private Scanner sc;

  public App() {
    this.sc = new Scanner(System.in);
  }
  public void run() {
    String path = "data.json";
    System.out.println("== 명언 SSG ==");
    WiseSayingController wiseSayingController = new WiseSayingController(sc, path);

    while(true) {
      System.out.print("명령) ");
      String cmd = sc.nextLine().trim();

      Rq rq = new Rq(cmd);
      switch (rq.getPath()) {
        case "등록" :
          wiseSayingController.write();
          break;
        case "목록" :
          wiseSayingController.findAll();
          break;
        case "삭제" :
          wiseSayingController.delete(rq);
          break;
        case "수정" :
          wiseSayingController.update(rq);
          break;
        case "빌드" :
          wiseSayingController.save(path);
          break;
        case "종료" :
          return;
      }
    }
  }
}
