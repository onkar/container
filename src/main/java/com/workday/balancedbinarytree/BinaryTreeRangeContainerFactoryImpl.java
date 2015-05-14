package com.workday.balancedbinarytree;

import com.workday.model.RangeContainer;
import com.workday.model.RangeContainerFactory;

public class BinaryTreeRangeContainerFactoryImpl implements RangeContainerFactory {

  public RangeContainer createContainer(long[] data) {
    if (data == null || data.length == 0)
      return null;

    return new BinaryTreeRangeContainerImpl(data);
  }

}
