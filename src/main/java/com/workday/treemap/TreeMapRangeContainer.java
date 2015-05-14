package com.workday.treemap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.workday.model.Ids;
import com.workday.model.RangeContainer;

public class TreeMapRangeContainer implements RangeContainer {
  private TreeMap<Long, Short> rangeToIndex;

  public TreeMapRangeContainer(long[] data) {
    this.rangeToIndex = new TreeMap<Long, Short>();
    for (short i = 0; i < data.length; i++) {
      rangeToIndex.put(data[i], i);
    }
  }

  public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
    NavigableMap<Long, Short> m =
        rangeToIndex.subMap(fromValue, fromInclusive, toValue, toInclusive);
    List<Short> list = new ArrayList<Short>(m.values());
    Collections.sort(list);
    Ids result = new IdsImpl(Collections.enumeration(list));
    return result;
  }

}
