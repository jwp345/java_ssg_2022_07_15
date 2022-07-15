package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

  private Scanner sc;
  private WiseSayingService wiseSayingService;

  WiseSayingController(Scanner sc) {
    this.sc = sc;
    this.wiseSayingService = new WiseSayingService();
  }

  public void write() {
    System.out.print("명언: ");
    String content = sc.nextLine().trim();
    System.out.print("작가: ");
    String author = sc.nextLine().trim();
    WiseSaying wiseSaying = wiseSayingService.write(content, author);

    System.out.println(wiseSaying.id + "번 명언이 등록되었습니다.");
  }

  public void findAll() {
    System.out.println("번호 / 작가 / 명언");
    System.out.println("-------------------");
    List<WiseSaying> wiseSayings = wiseSayingService.findAll();

    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
      WiseSaying wiseSaying = wiseSayings.get(i);
      System.out.println(wiseSaying.id + " / " + wiseSaying.content + " / " + wiseSaying.author);
    }
  }

  public void delete() {

  }

  public void update() {
  }
}
