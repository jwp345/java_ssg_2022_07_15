package com.ll.exam;

import java.util.Scanner;

public class App {
  private Scanner sc;

  public App() {
    this.sc = new Scanner(System.in);
  }
  public void run() {
    System.out.println("== 명언 SSG ==");
    WiseSayingController wiseSayingController = new WiseSayingController(sc);

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
          wiseSayingController.delete();
          break;
        case "수정" :
          wiseSayingController.update();
          break;
        case "종료" :
          break;
      }
    }
  }
}
