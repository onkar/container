package com.workday.balancedbinarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Balanced binary tree implementation.
 */
public class BalancedBinaryTree {
  private Node root;

  public BalancedBinaryTree(long[] data) {
    // Convert the given data to an id-value pair and store it as a balanced binary search tree
    // structure.
    IdValue[] idValueArray = new IdValue[data.length];
    for (short i = 0; i < data.length; i++) {
      idValueArray[i] = new IdValue(i, data[i]);
    }
    Arrays.sort(idValueArray);
    this.root = create(idValueArray);
  }

  private Node create(IdValue[] idValueArray) {
    if (idValueArray == null || idValueArray.length == 0)
      return null;

    // Calculate middle element of the array and copy left and right arrays. Then recursively call
    // node create on both subtrees.
    int begin = 0;
    int end = idValueArray.length;
    int mid = (begin + end) / 2;

    IdValue[] left = Arrays.copyOfRange(idValueArray, begin, mid);
    IdValue[] right = Arrays.copyOfRange(idValueArray, mid + 1, end);

    Node node = new Node(idValueArray[mid].getId(), idValueArray[mid].getValue());
    if (left.length > 0)
      node.left = create(left);
    if (right.length > 0)
      node.right = create(right);

    root = node;
    return root;
  }

  public List<Short> searchIdsInRange(long fromValue, long toValue, boolean fromInclusive,
      boolean toInclusive) {
    List<Short> result = new ArrayList<Short>();
    searchIdsInRangeRecursive(root, fromValue, toValue, fromInclusive, toInclusive, result);
    return result;
  }

  /**
   * Search ids in the range.
   * 
   * @param root
   * @param fromValue
   * @param toValue
   * @param fromInclusive
   * @param toInclusive
   * @param result
   */
  private void searchIdsInRangeRecursive(Node root, long fromValue, long toValue,
      boolean fromInclusive, boolean toInclusive, List<Short> result) {
    if (root == null)
      return;

    if (fromValue != toValue) {
      if (root.value == fromValue) {
        // If root's value equals from value and if from is included, add root to the result list
        // and recursively call on left and right subtrees.
        if (fromInclusive)
          result.add(root.id);

        searchIdsInRangeRecursive(root.left, fromValue, toValue, fromInclusive, toInclusive, result);
        searchIdsInRangeRecursive(root.right, fromValue, toValue, fromInclusive, toInclusive,
            result);
      }

      if (root.value == toValue) {
        // If root's value equals to value and if to is included, add root to the result list and
        // recursively call on left and right subtrees.
        if (toInclusive)
          result.add(root.id);
        searchIdsInRangeRecursive(root.left, fromValue, toValue, fromInclusive, toInclusive, result);
        searchIdsInRangeRecursive(root.right, fromValue, toValue, fromInclusive, toInclusive,
            result);
      }
    } else if (root.value == fromValue) {
      result.add(root.id);
      searchIdsInRangeRecursive(root.left, fromValue, toValue, fromInclusive, toInclusive, result);
      searchIdsInRangeRecursive(root.right, fromValue, toValue, fromInclusive, toInclusive, result);
    }

    // If root's value is between the range
    if (root.value > fromValue && root.value < toValue) {
      result.add(root.id);
      searchIdsInRangeRecursive(root.left, fromValue, toValue, fromInclusive, toInclusive, result);
      searchIdsInRangeRecursive(root.right, fromValue, toValue, fromInclusive, toInclusive, result);
    } else if (root.value < fromValue) {
      searchIdsInRangeRecursive(root.right, fromValue, toValue, fromInclusive, toInclusive, result);
    } else if (root.value > toValue) {
      searchIdsInRangeRecursive(root.left, fromValue, toValue, fromInclusive, toInclusive, result);
    }

  }
}
