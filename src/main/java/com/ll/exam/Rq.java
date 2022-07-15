package com.ll.exam;

import java.util.HashMap;
import java.util.Map;

public class Rq {
  String path;
  Map<String, String> queryParams;

  public Rq(String url) {
    String[] tokens = url.split("\\?");
    this.path = tokens[0];
    queryParams = new HashMap<>();

    if(tokens.length == 2) {
      String[] params = tokens[1].split("&");

      for(String param : params) {
        String[] paramNameAndVal = param.split("=", 2);
        if (paramNameAndVal.length == 1) continue;

        queryParams.put(paramNameAndVal[0].trim(), paramNameAndVal[1].trim());
      }
    }
  }

  public String getPath() {
    return path;
  }
}
