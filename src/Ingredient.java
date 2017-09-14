/*
Rohit Singh
111056206
CSE 114
Homework #5
 */
public class Ingredient {
    private String name, measuringUnit;
    private int caloriesPerUnit;
    public Ingredient(String name, String measuringUnit, int caloriesPerUnit){
        this.name=name;
        this.measuringUnit=measuringUnit;
        this.caloriesPerUnit= caloriesPerUnit;
    }
    public String toString(){
        return "Ingredient\n" +
                "name-" + name + "\n" +
                "measuringUnit-" + measuringUnit + "\n"+
                "caloriesPerUnit-" + caloriesPerUnit + "\n";
    }
    public boolean equals(Object o){
        Ingredient i= (Ingredient)o;
        return i.name.equals(name) && i.measuringUnit.equals(measuringUnit) && caloriesPerUnit==caloriesPerUnit;
    }
    public String getMeasuringUnit(){
        return measuringUnit;
    }
    public String getName(){
        return name;
    }
    public int getCaloriesPerUnit(){
        return caloriesPerUnit;
    }
    public void setCaloriesPerUnit(int caloriesPerUnit){
        this.caloriesPerUnit=caloriesPerUnit;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMeasuringUnit(String measuringUnit){
        this.measuringUnit=measuringUnit;
        
    }
}
