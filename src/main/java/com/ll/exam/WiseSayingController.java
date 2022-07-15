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

  public void delete(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    WiseSaying wiseSaying = wiseSayingService.findById(id);
    if (wiseSaying == null) {
      System.out.println(id + "번 명언은 존재하지 않습니다.");
      return;
    }

    wiseSayingService.delete(wiseSaying);
    System.out.println(id + "번 명언이 삭제되었습니다.");
  }

  public void update(Rq rq) {
    int id = rq.getIntParam("id", 0);

    if (id == 0) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    WiseSaying wiseSaying = wiseSayingService.findById(id);

    if (wiseSaying == null) {
      System.out.println(id + "번 명언은 존재하지 않습니다.");
      return;
    }

    System.out.println(wiseSaying.content + "명언(기존) : %s");
    System.out.print("명언 : ");
    String content = sc.nextLine();
    System.out.println("작가(기존) : " + wiseSaying.author);
    System.out.print("작가 : ");
    String author = sc.nextLine();

    wiseSayingService.update(wiseSaying, content, author);

    System.out.println(id + "번 명언이 수정되었습니다.");
  }
}
