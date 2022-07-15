package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
  private int lastId;
  private List<WiseSaying> wiseSayings;
  WiseSayingService() {
    this.lastId = 0;
    this.wiseSayings = new ArrayList<>();
  }
  public WiseSaying write(String content, String author) {
    WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
    wiseSayings.add(wiseSaying);

    return wiseSaying;
  }


  public List<WiseSaying> findAll() {
    return wiseSayings;
  }

  public WiseSaying findById(int id) {
    for(WiseSaying wiseSaying : wiseSayings) {
      if(wiseSaying.id == id) return wiseSaying;
    }

    return null;
  }

  public void delete(WiseSaying wiseSaying) {
    wiseSayings.remove(wiseSaying);
  }

  public void update(WiseSaying wiseSaying, String content, String author) {
    wiseSaying.content = content;
    wiseSaying.author = author;
  }
}
