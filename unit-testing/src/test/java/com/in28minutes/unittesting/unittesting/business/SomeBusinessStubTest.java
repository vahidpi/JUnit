package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;



class SomeDataServiceStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {
        return new int[] {1,2,3};
    }
}


class SomeDataServiceOneElementStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {
        return new int[] {5};
    }
}


class SomeDataServiceEmptyStub implements SomeDataService{
    @Override
    public int[] retriveAllData() {
        return new int[] {};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsindGataService_basic() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);

    }


    @Test
    public void calculateSumUsindGataService_empty() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void calculateSumUsindGataService_oneValue() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneElementStub());
        int actualResult =business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,actualResult);

    }

}
