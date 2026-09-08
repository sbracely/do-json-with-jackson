package io.github.sbracely.Jackson_Ignore_Properties_on_Marshalling.Ignore_All_Fields_by_Type;

public class MyDto {
    private SomeType someType;
    private UncontrolledType uncontrolledType;
    private int intValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
    public UncontrolledType getUncontrolledType() {
        return uncontrolledType;
    }

    public void setUncontrolledType(UncontrolledType uncontrolledType) {
        this.uncontrolledType = uncontrolledType;
    }


    public SomeType getSomeType() {
        return someType;
    }

    public void setSomeType(SomeType someType) {
        this.someType = someType;
    }
}
