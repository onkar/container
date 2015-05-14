package com.workday.balancedbinarytree;

public class IdValue implements Comparable<IdValue> {
  private short id;
  private long value;

  public IdValue(short id, long value) {
    this.id = id;
    this.value = value;
  }

  public int compareTo(IdValue arg0) {
    if (this.value > arg0.value)
      return 1;
    else if (this.value == arg0.value)
      return 0;
    else
      return -1;
  }

  public short getId() {
    return this.id;
  }

  public long getValue() {
    return this.value;
  }

}
