package com.layneyiu.forecast

import com.layneyiu.forecast.extensions.toDateString
import org.junit.Assert
import org.junit.Test

class ExtensionsTest {

    @Test
    fun `"longToDateString" returns valid value`() {
        Assert.assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }
}