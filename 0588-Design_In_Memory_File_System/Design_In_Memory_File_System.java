class FileSystem {
    HashMap<String, String> files = new HashMap<>();
    HashMap<String, Set<String>> directory = new HashMap<>();
    public FileSystem() {
        directory.put("/", new HashSet<>());
    }
    
    public List<String> ls(String path) {
        // if it is a file, return only the file name
        if(files.containsKey(path)){
            int lastDelimeter = path.lastIndexOf("/");
            return Arrays.asList(new String[]{path.substring(lastDelimeter + 1)});
        }
        else {
            List<String> dir = new ArrayList<>();
            for(String s : directory.get(path)) {
                dir.add(s);
            }
            Collections.sort(dir);
            return dir;
        }
        // if it is a directory, return the directories;
    }
    
    public void mkdir(String path) {
        StringBuilder sb = new StringBuilder();
        String[] parts = path.substring(1, path.length()).split("/");
        String curr = "/";
        for(int i = 0; i < parts.length; i++){
            sb.append("/");
            sb.append(parts[i]);
            directory.get(curr).add(parts[i]);
            curr = sb.toString();
            if(!directory.containsKey(sb.toString())) {
                directory.put(curr, new HashSet<>());
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        if(files.containsKey(filePath)) {
            StringBuilder sb = new StringBuilder();
            sb.append(files.get(filePath));
            sb.append(content);
            files.put(filePath, sb.toString());
        }
        else {
            int lastDelimeter = filePath.lastIndexOf("/");
            String path = filePath.substring(0, lastDelimeter);
            if(path == "") path = "/";
            directory.get(path).add(filePath.substring(lastDelimeter + 1));
            files.put(filePath, content);
        }
    }
    
    public String readContentFromFile(String filePath) {
        return files.get(filePath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */