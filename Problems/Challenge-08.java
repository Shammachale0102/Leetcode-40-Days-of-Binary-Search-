/*Snapshot Array:

Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id */

import java.util.*;

class SnapshotArray {
    private TreeMap<Integer, Integer>[] snapMap;
    private int snapId;

    public SnapshotArray(int length) {
        snapMap = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            snapMap[i] = new TreeMap<>();
            snapMap[i].put(0, 0); 
        }
        snapId = 0;
    }
    
    public void set(int index, int val) {
        snapMap[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++; 
    }
    
    public int get(int index, int snap_id) {
        return snapMap[index].floorEntry(snap_id).getValue(); 
    }
}
