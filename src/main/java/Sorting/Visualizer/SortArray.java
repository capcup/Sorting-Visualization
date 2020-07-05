/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting.Visualizer;

import Sorting.Algorithms.BubbleSort;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;


/**
 *
 * @author rick
 */
public class SortArray extends JPanel{
    private int[] array;
    
    private static final int WIN_Width = 1280;
    private static final int WIN_Height = 720;
    private static final int BAR_WIDTH = 8;
    private static final int NUM_BARS = WIN_Width / BAR_WIDTH;
    
    
    public SortArray(){
        array = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
        }
        
        shuffleArray();
        setBackground(Color.darkGray);
    }
    
    public void run() {
        new BubbleSort().runSort(this);
    }
    
    private void shuffleArray(){
        Random rng = new Random();
        for (int i = 0; i < NUM_BARS; ++i){
            int swapIndex = rng.nextInt(NUM_BARS - 1);
            int tmp = getArray()[i];
            getArray()[i] = getArray()[swapIndex];
            getArray()[swapIndex] = tmp;
        }
    }
    
    public void swap(int firstIndex, int secondIndex) {
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp; 
        
        this.repaint();
        sleepFor(1000000);
    }
    
    public void sleepFor(long nanoseconds) {
        long timeElapsed;
        final long startTime = System.nanoTime();
        do {
            timeElapsed = System.nanoTime() - startTime;
        } while (timeElapsed < nanoseconds);
    }
    
    
    public int[] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(int[] array) {
        this.array = array;
    }
    
    public int getValue(int index) {
        return array[index];
    }
    
    public int arraySize() {
        return array.length;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.white);
        super.paintComponent(graphics); 
        
        for (int i = 0; i < NUM_BARS; i++) {
            //graphics.drawLine(i + BAR_WIDTH * i, 0, BAR_WIDTH, array[i]);
            int height = getArray()[i] * 3;
            int xBegin = i + (BAR_WIDTH - 1) * i;
            int yBegin = WIN_Height - height; 
            
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
        }        
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_Width, WIN_Height);
    }
   
}
