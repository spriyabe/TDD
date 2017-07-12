package main.src.uom;

public enum VolumeUnitOfMeasure implements UnitOfMeasure{
    ML("ML", 1f),
    LITER("LT", 1000f),
    GALLON("GN", 3785.41f);


    private String unitName;
    private final float conversionFactor;
    private final String measureName = "Volume";

    VolumeUnitOfMeasure(String name, float conversionFactor) {
        this.unitName = name;
        this.conversionFactor = conversionFactor;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public float getConversionFactor() {
        return conversionFactor;
    }

    public String getMeasureName() {
        return measureName;
    }

    //TODO : convert to big decimal with scale 2
    public float convertToOtherUnitOfMeasure(float value, UnitOfMeasure targetUnitOfMeasure) {
        return  value / (ML.getConversionFactor() * targetUnitOfMeasure.getConversionFactor());
    }
}
