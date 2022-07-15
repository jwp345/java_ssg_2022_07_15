package com.ll.exam;

import java.util.List;

public class WiseSayingService {
  private int lastId;
  private List<WiseSaying> wiseSayings;
  WiseSayingService() {
    this.lastId = 0;
  }
  public WiseSaying write(String content, String author) {
    WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
    wiseSayings.add(wiseSaying);

    return wiseSaying;
  }


  public List<WiseSaying> findAll() {
    return wiseSayings;
  }
}
