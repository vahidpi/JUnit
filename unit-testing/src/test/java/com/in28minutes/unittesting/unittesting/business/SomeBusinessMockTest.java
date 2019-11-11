package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business=new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock;


    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }



    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }



    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.calculateSumUsingDataService());
    }



}
