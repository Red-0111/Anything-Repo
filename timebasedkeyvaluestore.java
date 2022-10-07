class TimeMap {

    HashMap<String, TreeMap<Integer, String>> tm;

    
    public TimeMap() {
        tm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!tm.containsKey(key)) {
            tm.put(key, new TreeMap<Integer, String>());
        }
        tm.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!tm.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tree = tm.get(key);
        Integer t = tree.floorKey(timestamp);
        if (t == null) {
            return "";
        }
        return tree.get(t);
    }
}