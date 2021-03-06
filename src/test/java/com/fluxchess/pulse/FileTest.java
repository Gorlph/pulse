/*
 * Copyright (C) 2013-2015 Phokham Nonava
 *
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */
package com.fluxchess.pulse;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static com.fluxchess.pulse.File.NOFILE;
import static com.fluxchess.test.AssertUtil.assertUtilityClassWellDefined;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileTest {

  @Test
  public void testUtilityClass()
      throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertUtilityClassWellDefined(File.class);
  }

  @Test
  public void testValues() {
    for (int file : File.values) {
      assertThat(File.values[file], is(file));
    }
  }

  @Test
  public void testIsValid() {
    for (int file : File.values) {
      assertThat(File.isValid(file), is(true));
    }

    assertThat(File.isValid(NOFILE), is(false));
  }

}
