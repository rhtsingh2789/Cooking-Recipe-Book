/*
Rohit Singh
111056206
CSE 114
Homework #5
 */
import java.util.ArrayList;
public class CookingRecipe {
    private String name;
    ArrayList<RecipeIngredient> ingredients = new ArrayList();
    
    public CookingRecipe(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<RecipeIngredient> getingredients(){
        return ingredients;
    }
    
    public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity){
        RecipeIngredient r=new RecipeIngredient(ingredient.getName(),ingredient.getMeasuringUnit(), 
                ingredient.getCaloriesPerUnit(),quantity);
        for (RecipeIngredient r2:ingredients)
            if(r2.getName().equals(r.getName())){
                r.setQuantity(quantity);
                return;
            }
        ingredients.add(r);
    }
    
    public RecipeIngredient getRecipeIngredient(String ingredientName){
        for (RecipeIngredient r:ingredients){
            if(r.getName().equals(ingredientName)){
                return r;
            }
        }
        return null;
    }
    
    public RecipeIngredient getRecipeIngredient(Ingredient ingredient){
        return getRecipeIngredient(ingredient.getName());
    }
    
    public RecipeIngredient removeRecipeIngredient(String ingredientName){
        for (RecipeIngredient r:ingredients){
            if(r.getName().equals(ingredientName)){
                ingredients.remove(r);
                return r;
            }
        }
        return null;
    }
    
    public RecipeIngredient removeRecipeIngredient(Ingredient ingredient){
        return removeRecipeIngredient(ingredient.getName());
    }
    
    public float calculateCalories(){
        float sum=0;
        for (RecipeIngredient r:ingredients){
            sum+=r.getCalories();
        }
            return sum;
        }
    
    public int getNumberOfIngredients(){
        return ingredients.size();
    }
    
    public String toString(){
        return "CookingRecipe\n" +
                "name-" + getName() + "\n" +
                ingredientsToString() +"\n";
    }
    
    private String ingredientsToString(){
        String s= "ingredients-[";
        for(RecipeIngredient r:ingredients)
            s+=r.toString()+"\n";
        s+="]\n";
        return s;
    }
    
    public boolean equals(Object o){
        CookingRecipe c=(CookingRecipe)o;
        return getName().equals(c.getName())&& 
                TestRecipeBook.equalSets(arrayListToArray(ingredients), arrayListToArray(c.ingredients));
    }

    public RecipeIngredient[] arrayListToArray(ArrayList<RecipeIngredient> l){
        RecipeIngredient[] a=new RecipeIngredient[l.size()];
        int i=0;
        for (RecipeIngredient r:ingredients){
            a[i++]=r;
        }
        return a;
    }
    }
    
    

