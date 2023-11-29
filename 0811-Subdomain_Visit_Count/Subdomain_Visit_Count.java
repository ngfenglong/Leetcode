class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        
        for(int i = 0; i < cpdomains.length; i++){
            String[] input = cpdomains[i].split("\s");
            int occ = Integer.parseInt(input[0]);
            
            String[] domainNames = input[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append(domainNames[domainNames.length - 1]);
            hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + occ);
            
            for(int j = domainNames.length - 2; j >= 0; j--){
                sb.insert(0,".");
                sb.insert(0, domainNames[j]);
                hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + occ);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(String s: hm.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(hm.get(s));
            sb.append(" ");
            sb.append(s);
            list.add(sb.toString());
        }
        
        return list;
    }
}