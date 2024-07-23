/**
 * The Counter class represents a simple counter with thread-safe incrementation.
 *
 * @author : Percy Ratheko
 * @version 1.8.
 */

package com.bcit.comp601assignment2;


public class Counter
{

    private int count;
    private static final int START;

    static {
        START = 0;
    }

    /**
     * Constructs a new Counter with an initial count of 0.
     */
    public Counter()
    {
        this.count = START;
    }

    /**
     * Increments the counter in a thread-safe manner.
     */
    public synchronized void increment()
    {
        count++;
    }

    /**
     * Gets the current count of the counter.
     *
     * @return The current count of the counter.
     */
    public int getCount()
    {
        return count;
    }
}
