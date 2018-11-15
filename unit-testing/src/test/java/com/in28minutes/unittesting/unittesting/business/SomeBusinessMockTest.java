package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        SomeDataService dataServiceMock=mock(SomeDataService.class);

        // dataServiceMock retriveAllData new int[] {1,2,3}

        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});



        business.setSomeDataService(dataServiceMock);


        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);

    }



    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        SomeDataService dataServiceMock=mock(SomeDataService.class);

        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});

        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);

    }



    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        SomeDataService dataServiceMock=mock(SomeDataService.class);

        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {5});

        business.setSomeDataService(dataServiceMock);

        int actualResult =business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,actualResult);

    }



}
