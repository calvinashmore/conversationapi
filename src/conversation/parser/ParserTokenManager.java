/* Generated By:JJTree&JavaCC: Do not edit this line. ParserTokenManager.java */
package conversation.parser;

public class ParserTokenManager implements ParserConstants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x1008000000000140L) != 0L)
            return 2;
         if ((active0 & 0x100000000L) != 0L || (active1 & 0x10L) != 0L)
            return 8;
         return -1;
      case 1:
         if ((active0 & 0x100L) != 0L)
            return 0;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 36;
         return jjMoveStringLiteralDfa1_0(0x80000000000L, 0x0L);
      case 37:
         jjmatchedKind = 55;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1L);
      case 38:
         jjmatchedKind = 52;
         return jjMoveStringLiteralDfa1_0(0x2000200000000000L, 0x0L);
      case 40:
         return jjStopAtPos(0, 24);
      case 41:
         return jjStopAtPos(0, 25);
      case 42:
         jjmatchedKind = 50;
         return jjMoveStringLiteralDfa1_0(0x800000000000000L, 0x0L);
      case 43:
         jjmatchedKind = 48;
         return jjMoveStringLiteralDfa1_0(0x200400000000000L, 0x0L);
      case 44:
         return jjStopAtPos(0, 31);
      case 45:
         jjmatchedKind = 49;
         return jjMoveStringLiteralDfa1_0(0x400800000000000L, 0x0L);
      case 46:
         jjmatchedKind = 32;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x10L);
      case 47:
         jjmatchedKind = 51;
         return jjMoveStringLiteralDfa1_0(0x1000000000000140L, 0x0L);
      case 58:
         return jjStopAtPos(0, 39);
      case 59:
         return jjStopAtPos(0, 30);
      case 60:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x100020000000000L, 0x2L);
      case 61:
         jjmatchedKind = 34;
         return jjMoveStringLiteralDfa1_0(0x10000000000L, 0x0L);
      case 62:
         jjmatchedKind = 71;
         return jjMoveStringLiteralDfa1_0(0x40000000000L, 0x6cL);
      case 63:
         return jjStopAtPos(0, 38);
      case 64:
         return jjStopAtPos(0, 33);
      case 91:
         return jjStopAtPos(0, 28);
      case 93:
         return jjStopAtPos(0, 29);
      case 94:
         jjmatchedKind = 54;
         return jjMoveStringLiteralDfa1_0(0x8000000000000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 26);
      case 124:
         jjmatchedKind = 53;
         return jjMoveStringLiteralDfa1_0(0x4000100000000000L, 0x0L);
      case 125:
         return jjStopAtPos(0, 27);
      case 126:
         return jjStopAtPos(0, 37);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         break;
      case 42:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(1, 8, 0);
         break;
      case 43:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         break;
      case 45:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         break;
      case 46:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x10L);
      case 47:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 60:
         if ((active0 & 0x100000000000000L) != 0L)
         {
            jjmatchedKind = 56;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x2L);
      case 61:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(1, 40);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 41);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStopAtPos(1, 43);
         else if ((active0 & 0x200000000000000L) != 0L)
            return jjStopAtPos(1, 57);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStopAtPos(1, 58);
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStopAtPos(1, 59);
         else if ((active0 & 0x1000000000000000L) != 0L)
            return jjStopAtPos(1, 60);
         else if ((active0 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(1, 61);
         else if ((active0 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 62);
         else if ((active0 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 63);
         else if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(1, 64);
         break;
      case 62:
         if ((active1 & 0x40L) != 0L)
         {
            jjmatchedKind = 70;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x2cL);
      case 124:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 44);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, 0L, active1);
      return 2;
   }
   switch(curChar)
   {
      case 46:
         if ((active1 & 0x10L) != 0L)
            return jjStopAtPos(2, 68);
         break;
      case 61:
         if ((active1 & 0x2L) != 0L)
            return jjStopAtPos(2, 65);
         else if ((active1 & 0x4L) != 0L)
            return jjStopAtPos(2, 66);
         break;
      case 62:
         if ((active1 & 0x20L) != 0L)
         {
            jjmatchedKind = 69;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active1, 0x8L);
      default :
         break;
   }
   return jjStartNfa_0(1, 0L, active1);
}
private final int jjMoveStringLiteralDfa3_0(long old1, long active1)
{
   if (((active1 &= old1)) == 0L)
      return jjStartNfa_0(1, 0L, old1); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, 0L, active1);
      return 3;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x8L) != 0L)
            return jjStopAtPos(3, 67);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, 0L, active1);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec3 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec4 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec5 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec6 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec7 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec8 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 52;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 6);
                  else if (curChar == 36)
                  {
                     if (kind > 21)
                        kind = 21;
                     jjCheckNAdd(32);
                  }
                  else if (curChar == 34)
                     jjCheckNAddStates(7, 9);
                  else if (curChar == 39)
                     jjAddStates(10, 11);
                  else if (curChar == 46)
                     jjCheckNAdd(8);
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 2;
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 13)
                        kind = 13;
                     jjCheckNAddTwoStates(5, 6);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 13)
                        kind = 13;
                     jjCheckNAddStates(12, 14);
                  }
                  break;
               case 0:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 7)
                     kind = 7;
                  break;
               case 2:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 4:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAddTwoStates(5, 6);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAddTwoStates(5, 6);
                  break;
               case 7:
                  if (curChar == 46)
                     jjCheckNAdd(8);
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(15, 17);
                  break;
               case 10:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(11);
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(11, 12);
                  break;
               case 13:
                  if (curChar == 39)
                     jjAddStates(10, 11);
                  break;
               case 14:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 15:
                  if (curChar == 39 && kind > 19)
                     kind = 19;
                  break;
               case 17:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 18:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(19, 15);
                  break;
               case 19:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 20:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 21:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(19);
                  break;
               case 22:
                  if (curChar == 34)
                     jjCheckNAddStates(7, 9);
                  break;
               case 23:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 25:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 26:
                  if (curChar == 34 && kind > 20)
                     kind = 20;
                  break;
               case 27:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(18, 21);
                  break;
               case 28:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 29:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 30:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(28);
                  break;
               case 31:
                  if (curChar != 36)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(32);
                  break;
               case 32:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(32);
                  break;
               case 33:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 6);
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(34, 35);
                  break;
               case 35:
                  if (curChar != 46)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(22, 24);
                  break;
               case 36:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddStates(22, 24);
                  break;
               case 38:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(39);
                  break;
               case 39:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(39, 12);
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(40, 41);
                  break;
               case 42:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(43);
                  break;
               case 43:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  jjCheckNAddTwoStates(43, 12);
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(25, 27);
                  break;
               case 46:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(47);
                  break;
               case 47:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(47, 12);
                  break;
               case 48:
                  if (curChar != 48)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAddStates(12, 14);
                  break;
               case 50:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAddTwoStates(50, 6);
                  break;
               case 51:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAddTwoStates(51, 6);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 3:
               case 32:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(32);
                  break;
               case 1:
                  if (kind > 7)
                     kind = 7;
                  break;
               case 6:
                  if ((0x100000001000L & l) != 0L && kind > 13)
                     kind = 13;
                  break;
               case 9:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(28, 29);
                  break;
               case 12:
                  if ((0x5000000050L & l) != 0L && kind > 17)
                     kind = 17;
                  break;
               case 14:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 16:
                  if (curChar == 92)
                     jjAddStates(30, 32);
                  break;
               case 17:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 23:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 24:
                  if (curChar == 92)
                     jjAddStates(33, 35);
                  break;
               case 25:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 37:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(36, 37);
                  break;
               case 41:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(38, 39);
                  break;
               case 45:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(40, 41);
                  break;
               case 49:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(50);
                  break;
               case 50:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAddTwoStates(50, 6);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 3:
               case 32:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 21)
                     kind = 21;
                  jjCheckNAdd(32);
                  break;
               case 1:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2) && kind > 7)
                     kind = 7;
                  break;
               case 14:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 23:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(7, 9);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 52 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjMoveStringLiteralDfa0_3()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_3(0x800L);
      default :
         return 1;
   }
}
private final int jjMoveStringLiteralDfa1_3(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(1, 11);
         break;
      default :
         return 2;
   }
   return 2;
}
private final int jjMoveStringLiteralDfa0_1()
{
   return jjMoveNfa_1(0, 0);
}
private final int jjMoveNfa_1(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 9)
                        kind = 9;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 9)
                     kind = 9;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x400L);
      default :
         return 1;
   }
}
private final int jjMoveStringLiteralDfa1_2(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(1, 10);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   34, 35, 40, 41, 44, 45, 12, 23, 24, 26, 14, 16, 49, 51, 6, 8, 
   9, 12, 23, 24, 28, 26, 36, 37, 12, 44, 45, 12, 10, 11, 17, 18, 
   20, 25, 27, 29, 38, 39, 42, 43, 46, 47, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default : 
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec8[i2] & l2) != 0L);
      default : 
         if ((jjbitVec3[i1] & l1) != 0L)
            return true;
         return false;
   }
}
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, "\50", "\51", 
"\173", "\175", "\133", "\135", "\73", "\54", "\56", "\100", "\75", "\74", "\41", 
"\176", "\77", "\72", "\75\75", "\74\75", "\76\75", "\41\75", "\174\174", "\46\46", 
"\53\53", "\55\55", "\53", "\55", "\52", "\57", "\46", "\174", "\136", "\45", "\74\74", 
"\53\75", "\55\75", "\52\75", "\57\75", "\46\75", "\174\75", "\136\75", "\45\75", 
"\74\74\75", "\76\76\75", "\76\76\76\75", "\56\56\56", "\76\76\76", "\76\76", "\76", };
public static final String[] lexStateNames = {
   "DEFAULT", 
   "IN_SINGLE_LINE_COMMENT", 
   "IN_FORMAL_COMMENT", 
   "IN_MULTI_LINE_COMMENT", 
};
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 2, 3, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffff3a2001L, 0xffL, 
};
static final long[] jjtoSkip = {
   0xe3eL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0xe00L, 0x0L, 
};
static final long[] jjtoMore = {
   0x11c0L, 0x0L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[52];
private final int[] jjstateSet = new int[104];
StringBuffer image;
int jjimageLen;
int lengthOfMatch;
protected char curChar;
public ParserTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public ParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 52; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 4 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = null;
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 12)
         {
            jjmatchedKind = 12;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 12)
         {
            jjmatchedKind = 12;
         }
         break;
       case 3:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_3();
         if (jjmatchedPos == 0 && jjmatchedKind > 12)
         {
            jjmatchedKind = 12;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
           TokenLexicalActions(matchedToken);
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else 
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        MoreLexicalActions();
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      case 7 :
         if (image == null)
            image = new StringBuffer();
         image.append(input_stream.GetSuffix(jjimageLen));
         jjimageLen = 0;
                   input_stream.backup(1);
         break;
      default : 
         break;
   }
}
void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 69 :
        if (image == null)
            image = new StringBuffer();
            image.append(jjstrLiteralImages[69]);
     matchedToken.kind = GT;
     ((Token.GTToken)matchedToken).realKind = RUNSIGNEDSHIFT;
     input_stream.backup(2);
         break;
      case 70 :
        if (image == null)
            image = new StringBuffer();
            image.append(jjstrLiteralImages[70]);
     matchedToken.kind = GT;
     ((Token.GTToken)matchedToken).realKind = RSIGNEDSHIFT;
     input_stream.backup(1);
         break;
      default : 
         break;
   }
}
}
