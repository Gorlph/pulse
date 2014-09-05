/*
 * Copyright (C) 2013-2014 Phokham Nonava
 *
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */
package com.fluxchess.pulse;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static com.fluxchess.test.AssertUtil.assertUtilityClassWellDefined;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CastlingTest {

  @Test
  public void testUtilityClass()
      throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertUtilityClassWellDefined(Castling.class);
  }

  @Test
  public void testIsValid() {
    for (int castling : Castling.values) {
      assertTrue(Castling.isValid(castling));
    }

    assertFalse(Castling.isValid(Castling.NOCASTLING));
  }

}
