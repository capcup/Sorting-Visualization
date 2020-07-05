/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting.Algorithms;

import Sorting.Visualizer.SortArray;

/**
 *
 * @author rick
 */
public class BubbleSort implements ISortingAlgorithm {
    
    // private final long DELAY = 2000000;
    
    @Override
    public void runSort(SortArray array) {
        int len = array.arraySize();
        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - i - 1; ++j) {
                if (array.getValue(j) > array.getValue(j + 1)) {
                    array.swap(j, j + 1);
                }
            }
        }
    }

}
