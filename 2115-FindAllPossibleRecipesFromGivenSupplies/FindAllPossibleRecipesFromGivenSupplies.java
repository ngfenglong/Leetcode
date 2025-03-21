import java.util.*;

// Garner all possibles supplies
// DFS for all recipes, keeping a visited arr to not visit a recipe multiple times
    // For each recipes, if supplies matched, add recipe item into supplesSet
// For each recipe, check if it in the supplies
public class FindAllPossibleRecipesFromGivenSupplies {
    class Solution {        
        Set<String> suppliesSet = new HashSet<>();
        HashMap<String, Integer> recipesIdxMap = new HashMap<>();
    
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            for(int i = 0; i < recipes.length; i++){
                recipesIdxMap.put(recipes[i], i);
            }
    
            for(String s: supplies){
                suppliesSet.add(s);
            }
    
            boolean[] visited = new boolean[recipes.length];
            for(int i = 0; i < recipes.length; i++){
                addSupplies(recipes, ingredients, visited, i);
            }
        
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < recipes.length; i++){
                if(suppliesSet.contains(recipes[i])) {
                    ans.add(recipes[i]);
                }
            }
    
            return ans;
        }
    
        private void addSupplies(String[] recipes, List<List<String>> ingredients, boolean[] visited, int i){
            if(visited[i]) return;
    
            visited[i] = true;
    
            boolean hasAllIngredients = true;
            for(String ingredient: ingredients.get(i)){
                if(suppliesSet.contains(ingredient)) continue;
    
                int ingredientIdx = recipesIdxMap.getOrDefault(ingredient, -1);
                if(recipesIdxMap.containsKey(ingredient) && !visited[ingredientIdx]){
                    addSupplies(recipes, ingredients, visited, recipesIdxMap.get(ingredient));
                }
                
                if(!suppliesSet.contains(ingredient)){
                    hasAllIngredients = false;
                }
            }
    
            if(hasAllIngredients){
                suppliesSet.add(recipes[i]);
            }
        }   
    }
    
}