package com.workday.treemap;

import java.util.Enumeration;

import com.workday.model.Ids;

/**
 * Uses enumerations in Java to store the list of ids
 */
public class TreeMapIdsImpl implements Ids {
  private Enumeration<Short> enumeration;

  public TreeMapIdsImpl(Enumeration<Short> enumeration) {
    this.enumeration = enumeration;
  }

  public short nextId() {
    if (enumeration.hasMoreElements()) {
      return enumeration.nextElement();
    }

    return END_OF_IDS;
  }

}
