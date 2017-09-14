/*
Rohit Singh
111056206
CSE 114
Homework #5
 */
public class RecipeIngredient extends Ingredient{
    private float quantity;
    public RecipeIngredient(String name, String measuringUnit, int caloriesPerUnit,
    float quantity){
        super(name,measuringUnit,caloriesPerUnit);
        this.quantity=quantity;
    }
    public float getQuantity(){
        return quantity;
    }
    public void setQuantity(float quantity){
        this.quantity=quantity;
    }
    public float getCalories(){
        return getCaloriesPerUnit()*quantity;
    }
    public boolean equals(Object o){
        RecipeIngredient r=(RecipeIngredient)o;
        return super.equals(o) && this.quantity==quantity;
    }
    public String toString(){
        return "Ingredient\n" +
                "name-" + getName() + "\n" +
                "measuringUnit-" + getMeasuringUnit() + "\n"+
                "caloriesPerUnit-" + getCaloriesPerUnit() + "\n"+
                "quantity-" + quantity +"\n";
    }
}
