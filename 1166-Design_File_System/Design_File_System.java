class FileSystem {
    HashMap<String, Integer> hm = new HashMap<>();
    public FileSystem() {
        
    }
    
    public boolean createPath(String path, int value) {
        if(path.length() <= 1) return false;
        if(path.charAt(0) != '/') return false;
        if(hm.containsKey(path)) return false;
  
        int lastDelimeter = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastDelimeter);
        
        if(parentPath.length() > 1 && !hm.containsKey(parentPath)){
            return false;
        }
        
        hm.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if(hm.containsKey(path)) return hm.get(path);
        return -1;
    }
    
}