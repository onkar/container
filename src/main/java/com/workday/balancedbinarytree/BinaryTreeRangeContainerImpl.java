package com.workday.balancedbinarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.workday.model.Ids;
import com.workday.model.RangeContainer;

/**
 * Uses balanced binary tree internally to support range scan queries.
 */
public class BinaryTreeRangeContainerImpl implements RangeContainer {
  private BalancedBinaryTree bbt;

  public BinaryTreeRangeContainerImpl(long[] data) {
    bbt = new BalancedBinaryTree(data);
  }

  public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
    if (fromValue > toValue || (fromValue == toValue && fromInclusive != toInclusive)
        || (fromValue == toValue && fromInclusive == false && toInclusive == false)) {
      return new BinaryTreeIdsImpl(new ArrayList<Short>());
    }
    List<Short> list = bbt.searchIdsInRange(fromValue, toValue, fromInclusive, toInclusive);
    Collections.sort(list);
    return new BinaryTreeIdsImpl(list);
  }
}
