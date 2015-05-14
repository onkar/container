package com.workday;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.workday.model.Ids;
import com.workday.model.RangeContainer;
import com.workday.model.RangeContainerFactory;
import com.workday.treemap.TreeMapRangeContainerFactoryImpl;

public class RangeQueryBasicTestTreeMap {
  private RangeContainer rc;
  private RangeContainer largeContainer;
  private long[] largeData = new long[32000];

  @Before
  public void setUp() {
    RangeContainerFactory rf = new TreeMapRangeContainerFactoryImpl();
    rc = rf.createContainer(new long[] {10, 12, 17, 21, 2, 15, 16});
    int temp = 1000;
    for (int i = 0; i < 32000; i++) {
      largeData[i] = temp;
      temp += 1000;
    }
    largeContainer = rf.createContainer(largeData);
  }

  @Test
  public void runARangeQuery() {
    Ids ids = rc.findIdsInRange(14, 17, true, true);
    Assert.assertEquals(2, ids.nextId());
    Assert.assertEquals(5, ids.nextId());
    Assert.assertEquals(6, ids.nextId());
    Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());

    ids = rc.findIdsInRange(14, 17, true, false);
    Assert.assertEquals(5, ids.nextId());
    Assert.assertEquals(6, ids.nextId());
    Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());

    ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);
    Assert.assertEquals(3, ids.nextId());
    Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
  }

  @Test
  public void runLargeVolumRangeQuery() {
    Ids ids = largeContainer.findIdsInRange(1300, 32000000, true, true);
    Assert.assertEquals(1, ids.nextId());
    Assert.assertEquals(2, ids.nextId());
    ids = largeContainer.findIdsInRange(31999999, 32000000, true, true);
    Assert.assertEquals(31999, ids.nextId());
    Assert.assertEquals(Ids.END_OF_IDS, ids.nextId());
  }
}
