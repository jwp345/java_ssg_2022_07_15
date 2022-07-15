package com.ll.exam;

import java.util.Scanner;

public class App {
  public void run() {
    System.out.println("== 명언 SSG ==");
    while(true) {
      System.out.print("명령) ");
      Scanner sc = new Scanner(System.in);
      String input = sc.nextLine();
      if(input.equals("종료")) break;
    }
  }
}
