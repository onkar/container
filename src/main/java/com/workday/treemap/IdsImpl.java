package com.workday.treemap;

import java.util.Enumeration;

import com.workday.model.Ids;

public class IdsImpl implements Ids {
  private Enumeration<Short> enumeration;

  public IdsImpl(Enumeration<Short> enumeration) {
    this.enumeration = enumeration;
  }

  public short nextId() {
    if (enumeration.hasMoreElements()) {
      return enumeration.nextElement();
    }

    return END_OF_IDS;
  }

}
