/*
Rohit Singh
111056206
CSE 114
Homework #5
 */
public class TestRecipeBook {
    public static boolean equalSets(Object[] a, Object[] b){
        return subset(a,b) && subset(b,a);
    }
    public static boolean subset(Object[] a, Object[] b){
        for(Object o:a)
            if(!member(o,b))
                return false;
        return true;
    }
    public static boolean member(Object o,Object[] a){
        for(Object o2:a)
            if(o2.equals(o))
                return true;
        return false;
        
    }
    public static void main(String[] args){
        
        RecipeIngredient flour = new RecipeIngredient("flour", "mg", 10, 100);
        RecipeIngredient milk = new RecipeIngredient("milk", "ml", 20, 200);
        CookingRecipe c1=new CookingRecipe("cookies");
        c1.addOrUpdateRecipeIngredient(flour,100);
        c1.addOrUpdateRecipeIngredient(milk, 100);
        CookingRecipe c2=new CookingRecipe("cookies");
        c2.addOrUpdateRecipeIngredient(milk,100);
        c2.addOrUpdateRecipeIngredient(flour, 100);
        System.out.println(c1.equals(c2));
        RecipeBook book = new RecipeBook("Rohit's");
        
    }
}
