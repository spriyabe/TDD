package main.src;


import main.src.uom.LengthUnitOfMeasure;
import main.src.uom.UnitOfMeasure;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Measurement {
    private float value;
    private UnitOfMeasure unitOfMeasure;

    private final int ROUND_OF_DIGITS = 2;
    private final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    public Measurement(float value,UnitOfMeasure type) {
        this.value = value;
        this.unitOfMeasure = type;
    }

    public float getValue() {
        return value;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public BigDecimal getBaseValue(){
        float convertToBase = this.value * unitOfMeasure.getConversionFactor();
        return new BigDecimal( convertToBase).setScale(ROUND_OF_DIGITS, ROUNDING_MODE);
    }

    public boolean equalsTo(Measurement measureObj2) throws UnsupportedOperationException{
        if(this.getUnitOfMeasure().getMeasureName().equals(measureObj2.getUnitOfMeasure().getMeasureName())) {
            return this.getBaseValue().equals(measureObj2.getBaseValue());
        }
        throw new UnsupportedOperationException("The UnitOfMeasurements Don't Match");
    }


    public Measurement add(Measurement measureObj2) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }


    /*public Measurement add(Measurement measureObj2) throws UnsupportedOperationException{
        if(this.getUnitOfMeasure().getMeasureName().equals(measureObj2.getUnitOfMeasure().getMeasureName())) {
            BigDecimal resultValue = this.getBaseValue().add(measureObj2.getBaseValue());
            // convert to this measurement type value
            float convertedResult = this.unitOfMeasure.convertToOtherUnitOfMeasure(resultValue.floatValue(), this.unitOfMeasure);
            Measurement result = new Measurement(convertedResult, this.unitOfMeasure);

            return result;
        }
        throw new UnsupportedOperationException("The UnitOfMeasurements Don't Match");
    }*/


}



