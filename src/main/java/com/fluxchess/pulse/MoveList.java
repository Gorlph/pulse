/*
 * Copyright 2013-2014 the original author or authors.
 *
 * This file is part of Pulse Chess.
 *
 * Pulse Chess is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Pulse Chess is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Pulse Chess.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fluxchess.pulse;

import com.fluxchess.jcpi.models.IntPiece;

public final class MoveList {

  private static final int MAXSIZE = 256;

  public final int[] moves = new int[MAXSIZE];
  public final int[] values = new int[MAXSIZE];
  public int size = 0;

  public void sort() {
    for (int i = 1; i < size; ++i) {
      int move = moves[i];
      int value = values[i];

      int j = i;
      while ((j > 0) && (values[j - 1] < value)) {
        moves[j] = moves[j - 1];
        values[j] = values[j - 1];
        --j;
      }

      moves[j] = move;
      values[j] = value;
    }
  }

  public void rateFromMVVLVA() {
    for (int i = 0; i < size; ++i) {
      int move = moves[i];
      int value = 0;

      int chessmanValue = Evaluation.getChessmanValue(IntPiece.getChessman(Move.getOriginPiece(move)));
      value += Evaluation.VALUE_KING / chessmanValue;

      int target = Move.getTargetPiece(move);
      if (IntPiece.isValid(target)) {
        value += 10 * Evaluation.getChessmanValue(IntPiece.getChessman(target));
      }

      assert value >= (Evaluation.VALUE_KING / Evaluation.VALUE_KING) && value <= (Evaluation.VALUE_KING / Evaluation.VALUE_PAWN) + 10 * Evaluation.VALUE_QUEEN;

      values[i] = value;
    }
  }

}
