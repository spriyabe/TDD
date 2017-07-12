package test.src;

import main.src.MathMeasurement;
import main.src.uom.LengthUnitOfMeasure;
import main.src.Measurement;
import main.src.uom.TemperatureUnitOfMeasure;
import main.src.uom.VolumeUnitOfMeasure;
import org.junit.Assert;
import org.junit.Test;


public class MeasurementTest {
    @Test
    public void testOneFeet(){
        Measurement feet = new MathMeasurement(1, LengthUnitOfMeasure.FEET);
        Measurement inch = new Measurement(12,LengthUnitOfMeasure.INCH);
        Assert.assertTrue(feet.equalsTo(inch));
    }
    @Test
    public void testTwoFeet(){
        Measurement feet = new Measurement(2,LengthUnitOfMeasure.FEET);
        Measurement inch = new Measurement(24,LengthUnitOfMeasure.INCH);
        Assert.assertTrue(feet.equalsTo(inch));
    }

    @Test
    public void testFeetToYardPositive(){
        Measurement threeFeet = new Measurement(3,LengthUnitOfMeasure.FEET);
        Measurement oneYard = new Measurement(1,LengthUnitOfMeasure.YARD);
        Assert.assertTrue(threeFeet.equalsTo(oneYard));
    }

    @Test
    public void testFeetToYardNegative(){
        Measurement threeFeet = new Measurement(3,LengthUnitOfMeasure.FEET);
        Measurement twoYard = new Measurement(2,LengthUnitOfMeasure.YARD);
        Assert.assertFalse(threeFeet.equalsTo(twoYard));
    }
    @Test
    public void testNegativeYardAndFeet(){
        Measurement minusThreeFeet = new Measurement(-3,LengthUnitOfMeasure.FEET);
        Measurement oneYard = new Measurement(1,LengthUnitOfMeasure.YARD);
        Assert.assertFalse(minusThreeFeet.equalsTo(oneYard));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDifferentUom(){
        Measurement oneFeet = new Measurement(1, LengthUnitOfMeasure.FEET);
        Measurement oneMilliLiter = new Measurement(12, VolumeUnitOfMeasure.ML);
        Assert.assertTrue(oneFeet.equalsTo(oneMilliLiter));
    }

    @Test
    public void testInchToCentimeter() {
        Measurement twoInch = new Measurement(2,LengthUnitOfMeasure.INCH);
        Measurement fiveCentimeter = new Measurement(5.08f,LengthUnitOfMeasure.CM);
        Assert.assertTrue(twoInch.equalsTo(fiveCentimeter));
    }

    @Test
    public void testInchAddition() {
        Measurement twoInchObj1 = new MathMeasurement(2, LengthUnitOfMeasure.INCH);
        Measurement twoInchObj2 = new MathMeasurement(2, LengthUnitOfMeasure.INCH);
        Measurement expectedResult = new MathMeasurement(4, LengthUnitOfMeasure.INCH);
        Measurement actualResult = twoInchObj1.add(twoInchObj2);
        Assert.assertTrue(actualResult.equalsTo(expectedResult));
        //Assert.assertEquals(expectedResult.getValue(), actualResult.getValue());
    }

    @Test
    public void testCompareGallonToLiter() {
        Measurement oneGallon = new Measurement(1,VolumeUnitOfMeasure.GALLON);
        Measurement threeLiter = new Measurement(3.78541f,VolumeUnitOfMeasure.LITER);
        Assert.assertTrue(oneGallon.equalsTo(threeLiter));
    }

    @Test
    public void testGallonAndLiterAddition() {
        Measurement oneGallon = new MathMeasurement(1, VolumeUnitOfMeasure.GALLON);
        Measurement oneLiter = new MathMeasurement(1, VolumeUnitOfMeasure.LITER);
        Measurement expectedResult = new MathMeasurement(4.78541f, VolumeUnitOfMeasure.LITER);
        Measurement actualResult = oneLiter.add(oneGallon);
        Assert.assertTrue(actualResult.equalsTo(expectedResult));
        //Assert.assertEquals(expectedResult.getValue(), actualResult.getValue());
    }

    @Test
    public void testCompareFahrenheitToCelsius() {
        Measurement twoOneTwoFarhen = new Measurement(212, TemperatureUnitOfMeasure.FAHRENHEIT);
        Measurement hundredCelsius = new Measurement(100, TemperatureUnitOfMeasure.CELSIUS);
        Assert.assertTrue(twoOneTwoFarhen.equalsTo(hundredCelsius));
    }
}
