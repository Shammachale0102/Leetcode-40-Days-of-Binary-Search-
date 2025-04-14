/*Time Based Key-Value Store:

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "". */

import java.util.*;

class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
