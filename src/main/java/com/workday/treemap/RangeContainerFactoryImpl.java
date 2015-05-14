package com.workday.treemap;

import com.workday.model.RangeContainer;
import com.workday.model.RangeContainerFactory;

public class RangeContainerFactoryImpl implements RangeContainerFactory {

  public RangeContainer createContainer(long[] data) {
    return new TreeMapRangeContainer(data);
  }

}
