package main.src.uom;

public interface UnitOfMeasure {

    float getConversionFactor();

    String getMeasureName();

    String getUnitName();

    float convertToOtherUnitOfMeasure(float value, UnitOfMeasure targetUnitOfMeasure);
}
