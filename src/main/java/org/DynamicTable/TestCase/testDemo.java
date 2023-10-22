package org.DynamicTable.TestCase;

import org.DynamicTable.Functions.funDemo;
import org.DynamicTable.Utilities.baseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class testDemo extends baseClass {

    @Test
    public void testDemoMethod() throws InterruptedException, IOException {
        funDemo fd = new funDemo(webDriver);
        fd.sorting();
        fd.pagination();
        fd.teraDown();
    }

}
