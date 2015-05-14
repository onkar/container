package com.workday.balancedbinarytree;

public class Node {
  long value;
  short id;
  Node left, right;

  public Node(short id, long value) {
    this.id = id;
    this.value = value;
  }
}
