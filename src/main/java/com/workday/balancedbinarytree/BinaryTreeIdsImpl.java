package com.workday.balancedbinarytree;

import java.util.List;

import com.workday.model.Ids;

/**
 * Stores the list of shorts and an index. Index is used to iterate over the collection.
 */
public class BinaryTreeIdsImpl implements Ids {
  private List<Short> list;
  private short index = 0;

  public BinaryTreeIdsImpl(List<Short> list) {
    this.list = list;
  }

  public short nextId() {
    if (list != null && list.size() > 0 && index < list.size()) {
      return list.get(index++);
    }
    return END_OF_IDS;
  }

}
