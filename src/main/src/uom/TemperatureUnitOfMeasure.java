package main.src.uom;

public enum TemperatureUnitOfMeasure implements UnitOfMeasure {
    FAHRENHEIT("F",33.8f),
    CELSIUS("C",1f);


    private final float conversionFactor;


    private final String unitName;

    private final String measureName = "Temperature";

    TemperatureUnitOfMeasure(String name, float conversionFactor) {
        this.unitName = name;
        this.conversionFactor = conversionFactor;
    }


    @Override
    public String getUnitName() {
        return unitName;
    }

    @Override
    public float getConversionFactor() {
        return this.conversionFactor;
    }

    @Override
    public String getMeasureName() {
        return this.measureName;
    }

    @Override
    public float convertToOtherUnitOfMeasure(float value, UnitOfMeasure targetUnitOfMeasure) {
        float result = -1;
        if(targetUnitOfMeasure.getUnitName().equals(this.getUnitName())) {

            result = value; //do nothing

        }else if(   this.getUnitName().equals(CELSIUS.getUnitName()) &&
                    targetUnitOfMeasure.getUnitName().equals(FAHRENHEIT.getUnitName())) {

            result =  (value - 32) * (5/9);

        }else if(   this.getUnitName().equals(FAHRENHEIT.getUnitName()) &&
                targetUnitOfMeasure.getUnitName().equals(CELSIUS.getUnitName())) {

            result =  (value * (9/5)) + 32;

        }

        return result;
    }
}
