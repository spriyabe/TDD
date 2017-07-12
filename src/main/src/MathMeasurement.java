package main.src;

import main.src.uom.UnitOfMeasure;

import java.math.BigDecimal;

public class MathMeasurement extends Measurement {

    public MathMeasurement(float value, UnitOfMeasure type) {
        super(value, type);
    }

    @Override
    public Measurement add(Measurement measureObj2) throws UnsupportedOperationException{
        if(this.getUnitOfMeasure().getMeasureName().equals(measureObj2.getUnitOfMeasure().getMeasureName())) {
            BigDecimal resultValue = this.getBaseValue().add(measureObj2.getBaseValue());
            // convert to this measurement type value
            float convertedResult = this.getUnitOfMeasure().convertToOtherUnitOfMeasure(resultValue.floatValue(), this.getUnitOfMeasure());
            Measurement result = new Measurement(convertedResult, this.getUnitOfMeasure());

            return result;
        }
        throw new UnsupportedOperationException("The UnitOfMeasurements Don't Match");
    }

    public boolean equalsTo(Measurement measureObj2) throws UnsupportedOperationException{
        if(this.getUnitOfMeasure().getMeasureName().equals(measureObj2.getUnitOfMeasure().getMeasureName())) {
            return this.getBaseValue().equals(measureObj2.getBaseValue());
        }
        throw new UnsupportedOperationException("The UnitOfMeasurements Don't Match");
    }
}
