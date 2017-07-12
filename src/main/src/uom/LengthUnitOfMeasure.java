package main.src.uom;

import main.src.Measurement;

public enum LengthUnitOfMeasure implements UnitOfMeasure {
    MM("MM",1f),
    CM("CM", 10f),
    INCH("IN", 25.4f),
    FEET("FT", 304.8f),
    YARD("YD", 914.4f);

    private final float conversionFactor;
    private final String unitName;

    private final String measureName = "Length";

    LengthUnitOfMeasure(String name, float conversionFactor) {
        this.unitName = name;
        this.conversionFactor = conversionFactor;
    }

    @Override
    public String getUnitName() {
        return this.unitName;
    }

    @Override
    public float getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public String getMeasureName() {
        return measureName;
    }

    @Override
    public float convertToOtherUnitOfMeasure(float value, UnitOfMeasure targetUnitOfMeasure) {
        return  value / (MM.getConversionFactor() * targetUnitOfMeasure.getConversionFactor());
    }


}
