package com.ll.exam;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Util {
  public static void saveToFile(String path, List<WiseSaying> wiseSayings) {
    new File(path).delete();
    try {
      RandomAccessFile stream = new RandomAccessFile(path, "rw");
      FileChannel channel = stream.getChannel();

      StringBuilder sb = new StringBuilder();
      for(WiseSaying wiseSaying : wiseSayings) {
        if(!sb.isEmpty()) sb.append(",\n");
        sb.append(wiseSaying.toJson());
      }

      byte[] strBytes = sb.toString().getBytes();
      ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
      buffer.put(strBytes);
      buffer.flip();
      channel.write(buffer);
      stream.close();
      channel.close();
    } catch (IOException e) {

    }
  }

  public static List<WiseSaying> readFromFile(String path) {
    try (RandomAccessFile reader = new RandomAccessFile(path, "r")) {
      String body = "";

      String line = null;
      while ((line = reader.readLine()) != null) {
        body += new String(line.getBytes("iso-8859-1"), "utf-8") + "\n";
      }

      return jsonToList(body.trim());
    } catch (IOException e) {
    }

    return new ArrayList<>();
  }

  public static List<WiseSaying> jsonToList(String json) {
    if (json.isEmpty()) {
      return null;
    }

    final String[] jsonBits = json
            .replaceAll("\\{", "")
            .replaceAll("\n", "")
            .replaceAll(" ", "")
            .split("\\},");

    List<WiseSaying> list = new ArrayList<>();
    Pattern pattern = Pattern.compile("\"id\":(\\d+),\"content\":\"([가-힣]+)\",\"author\":\"([가-힣]+)\"");
    for(String bits : jsonBits) {
      Matcher matcher = pattern.matcher(bits);
      if(matcher.find())
        list.add(new WiseSaying(Integer.valueOf(matcher.group(1)), matcher.group(2), matcher.group(3)));
    }

    return list;
  }
}