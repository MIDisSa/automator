package com.example.automator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.automator.helper.ABMRunner;
import com.example.automator.helper.CSVReader;


public class AutomatorControllerTests {
    @InjectMocks
    private AutomatorController automatorController;

    @Mock
    private CSVReader csvReader;

    @Mock
    private ABMRunner abmRunner;

    @Test
    public void testModelResults() {

    }
}
