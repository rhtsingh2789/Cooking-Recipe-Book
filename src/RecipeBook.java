/*
Rohit Singh
111056206
CSE 114
Homework #5
 */
import java.util.ArrayList;
public class RecipeBook {
    private String name;
    ArrayList<CookingRecipe> recipes = new ArrayList();
    
    public RecipeBook(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<CookingRecipe> getRecipes(){
        return recipes;
    }
    public CookingRecipe addRecipe(String name, RecipeIngredient[] ingredients){
        CookingRecipe c=new CookingRecipe(name);
        for(RecipeIngredient r:ingredients)
            c.addOrUpdateRecipeIngredient(r, r.getQuantity());
        recipes.add(c);
        return c;
    }
    public CookingRecipe removeRecipe(String name){
        for(CookingRecipe c:recipes)
            if(c.getName().equals(name)){
                recipes.remove(c);
                return c;
            }
        return null;
    }
    
    public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients){
        ArrayList<CookingRecipe> l=new ArrayList();
        for(CookingRecipe c:recipes)
            if(TestRecipeBook.subset(ingredients,c.arrayListToArray(c.getingredients())))
                l.add(c);
        return arrayListToArray(l);
    }
    public CookingRecipe[] arrayListToArray(ArrayList<CookingRecipe> l){
        CookingRecipe[] a = new CookingRecipe[l.size()];
        int i=0;
        for(CookingRecipe c:l){
            a[i]=c;
        }
        return a;
    }
    
    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients){
        ArrayList<CookingRecipe> l=new ArrayList();
        for(CookingRecipe c:recipes)
            if(c.getingredients().size()<=numberOfIngredients)
                l.add(c);
        return arrayListToArray(l);
    
    }
    
    public CookingRecipe[] findRecipesLowCalories(){
        ArrayList<CookingRecipe> l=new ArrayList();
        float min = Float.MAX_VALUE;
        for(CookingRecipe c:recipes)
            if(min>c.calculateCalories())
                min=c.calculateCalories();
        for(CookingRecipe c:recipes)
            if(c.calculateCalories()==min)
                l.add(c);
        return arrayListToArray(l);
    }
    
    public String toString(){
        return "RecipeBook\n" +
                "name-" + getName() + "\n" +
                recipesToString() +"\n";
    }
       
    private String recipesToString(){
        String s= "recipes-[";
        for(CookingRecipe r:recipes)
            s+=r.toString()+"\n";
        s+="]\n";
        return s;
    }
    
    public boolean equals(Object o){
        RecipeBook c=(RecipeBook)o;
        return getName().equals(c.getName())&& 
                TestRecipeBook.equalSets(arrayListToArray(recipes), arrayListToArray(c.recipes));
    }
}
