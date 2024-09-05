package org.example;

/**
 * A house that keeps information on its value and owner.
 * @author Josh Sherry
 */
public class House {
    //region Private members
    private String owner;
    private float value;
    //endregion
    
    /**
     * Constructor with parameters.
     * @param owner House's owner
     * @param value House's value
     */
    public House(String owner, float value) {
        this.owner = owner;
        this.value = value;
    }

    /**
     * No-argument constructor
     */
    public House() {
        this.owner = "N/A";
        this.value = 0;
    }

    /**
     * Returns a deep copy of this house instance.
     */
    public House deepCopy() {
        return new House(this.owner, this.value);
    }

    //region Setters and Getters
    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    //endregion

    /**
     * @return Returns a formatted String.
     */
    public String toString() {
        return "$" +  String.format("%,.0f", value) + " - " + owner ;
    }
    /**
     *
     * @param obj Object being compared.
     * @return Will return true when owners are the same of instance 'House'.
     */
    public boolean equals(Object obj) {
        return obj instanceof House && ((House)obj).getOwner().equals(this.owner);
    }
}
