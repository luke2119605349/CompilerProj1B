// DO NOT EDIT
// Generated by JFlex 1.9.0 http://jflex.de/
// source: Documents/School/Cedarville/JR/SP/Compiler/jflex-1.9.0/examples/cup-java/src/main/jflex/java.flex

/*
 * Copyright (C) 1998-2018  Gerwin Klein <lsf@jflex.de>
 * SPDX-License-Identifier: GPL-2.0-only
 */

/* Java 1.2 language lexer specification */

/* Use together with unicode.flex for Unicode preprocesssing */
/* and java12.cup for a Java 1.2 parser                      */

/* Note that this lexer specification is not tuned for speed.
   It is in fact quite slow on integer and floating point literals,
   because the input is read twice and the methods used to parse
   the numbers are not very fast.
   For a production quality application (e.g. a Java compiler)
   this could be optimized */

package com.example;

@SuppressWarnings("fallthrough")
public class CMinusScanner2 {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int CHARLITERAL = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2, 2
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\10\u2f00\31\u1f00\1\u0100\1\u3000\1\u3100\1\u0100\1\u3200"+
    "\1\u3300\1\u3400\1\u3500\1\u1f00\1\u3600\1\u3700\1\u3800\1\u3900"+
    "\1\u0100\1\u3a00\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u4000"+
    "\1\u1f00\1\u4100\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700"+
    "\1\u4800\1\u4900\1\u4a00\1\u4b00\1\u4c00\1\u1f00\1\u4d00\1\u4e00"+
    "\1\u4f00\1\u1f00\3\u0100\1\u5000\1\u5100\1\u5200\12\u1f00\4\u0100"+
    "\1\u5300\17\u1f00\2\u0100\1\u5400\41\u1f00\2\u0100\1\u5500\1\u5600"+
    "\2\u1f00\1\u5700\1\u5800\27\u0100\1\u5900\2\u0100\1\u5a00\45\u1f00"+
    "\1\u0100\1\u5b00\1\u5c00\11\u1f00\1\u5d00\27\u1f00\1\u5e00\1\u5f00"+
    "\1\u6000\1\u6100\11\u1f00\1\u6200\1\u6300\5\u1f00\1\u6400\1\u6500"+
    "\4\u1f00\1\u6600\21\u1f00\246\u0100\1\u6700\20\u0100\1\u6800\1\u6900"+
    "\25\u0100\1\u6a00\34\u0100\1\u6b00\14\u1f00\2\u0100\1\u6c00\u0e05\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\4\1\5\22\0\1\1"+
    "\1\6\6\0\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\0\1\15\12\16\1\0\1\17\1\20\1\21\1\22"+
    "\2\0\32\23\1\24\1\25\1\26\3\0\3\23\1\27"+
    "\1\30\1\31\1\23\1\32\1\33\2\23\1\34\1\23"+
    "\1\35\1\36\2\23\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\3\23\1\45\1\0\1\46\7\0\1\3\44\0"+
    "\1\23\12\0\1\23\4\0\1\23\5\0\27\23\1\0"+
    "\37\23\1\0\u01ca\23\4\0\14\23\16\0\5\23\7\0"+
    "\1\23\1\0\1\23\201\0\5\23\1\0\2\23\2\0"+
    "\4\23\1\0\1\23\6\0\1\23\1\0\3\23\1\0"+
    "\1\23\1\0\24\23\1\0\123\23\1\0\213\23\10\0"+
    "\246\23\1\0\46\23\2\0\1\23\6\0\51\23\107\0"+
    "\33\23\4\0\4\23\55\0\53\23\43\0\2\23\1\0"+
    "\143\23\1\0\1\23\17\0\2\23\7\0\2\23\12\0"+
    "\3\23\2\0\1\23\20\0\1\23\1\0\36\23\35\0"+
    "\131\23\13\0\1\23\30\0\41\23\11\0\2\23\4\0"+
    "\1\23\5\0\26\23\4\0\1\23\11\0\1\23\3\0"+
    "\1\23\27\0\31\23\7\0\13\23\65\0\25\23\1\0"+
    "\10\23\106\0\66\23\3\0\1\23\22\0\1\23\7\0"+
    "\12\23\17\0\20\23\4\0\10\23\2\0\2\23\2\0"+
    "\26\23\1\0\7\23\1\0\1\23\3\0\4\23\3\0"+
    "\1\23\20\0\1\23\15\0\2\23\1\0\3\23\16\0"+
    "\2\23\12\0\1\23\10\0\6\23\4\0\2\23\2\0"+
    "\26\23\1\0\7\23\1\0\2\23\1\0\2\23\1\0"+
    "\2\23\37\0\4\23\1\0\1\23\23\0\3\23\20\0"+
    "\11\23\1\0\3\23\1\0\26\23\1\0\7\23\1\0"+
    "\2\23\1\0\5\23\3\0\1\23\22\0\1\23\17\0"+
    "\2\23\27\0\1\23\13\0\10\23\2\0\2\23\2\0"+
    "\26\23\1\0\7\23\1\0\2\23\1\0\5\23\3\0"+
    "\1\23\36\0\2\23\1\0\3\23\17\0\1\23\21\0"+
    "\1\23\1\0\6\23\3\0\3\23\1\0\4\23\3\0"+
    "\2\23\1\0\1\23\1\0\2\23\3\0\2\23\3\0"+
    "\3\23\3\0\14\23\26\0\1\23\64\0\10\23\1\0"+
    "\3\23\1\0\27\23\1\0\20\23\3\0\1\23\32\0"+
    "\3\23\5\0\2\23\36\0\1\23\4\0\10\23\1\0"+
    "\3\23\1\0\27\23\1\0\12\23\1\0\5\23\3\0"+
    "\1\23\40\0\1\23\1\0\2\23\17\0\2\23\22\0"+
    "\10\23\1\0\3\23\1\0\51\23\2\0\1\23\20\0"+
    "\1\23\5\0\3\23\10\0\3\23\30\0\6\23\5\0"+
    "\22\23\3\0\30\23\1\0\11\23\1\0\1\23\2\0"+
    "\7\23\72\0\60\23\1\0\2\23\14\0\7\23\72\0"+
    "\2\23\1\0\1\23\1\0\5\23\1\0\30\23\1\0"+
    "\1\23\1\0\12\23\1\0\2\23\11\0\1\23\2\0"+
    "\5\23\1\0\1\23\25\0\4\23\40\0\1\23\77\0"+
    "\10\23\1\0\44\23\33\0\5\23\163\0\53\23\24\0"+
    "\1\23\20\0\6\23\4\0\4\23\3\0\1\23\3\0"+
    "\2\23\7\0\3\23\4\0\15\23\14\0\1\23\21\0"+
    "\46\23\1\0\1\23\5\0\1\23\2\0\53\23\1\0"+
    "\115\23\1\0\4\23\2\0\7\23\1\0\1\23\1\0"+
    "\4\23\2\0\51\23\1\0\4\23\2\0\41\23\1\0"+
    "\4\23\2\0\7\23\1\0\1\23\1\0\4\23\2\0"+
    "\17\23\1\0\71\23\1\0\4\23\2\0\103\23\45\0"+
    "\20\23\20\0\126\23\2\0\6\23\3\0\u016c\23\2\0"+
    "\21\23\1\0\32\23\5\0\113\23\6\0\10\23\7\0"+
    "\15\23\1\0\4\23\16\0\22\23\16\0\22\23\16\0"+
    "\15\23\1\0\3\23\17\0\64\23\43\0\1\23\4\0"+
    "\1\23\103\0\131\23\7\0\5\23\2\0\42\23\1\0"+
    "\1\23\5\0\106\23\12\0\37\23\61\0\36\23\2\0"+
    "\5\23\13\0\54\23\4\0\32\23\66\0\27\23\11\0"+
    "\65\23\122\0\1\23\135\0\57\23\21\0\7\23\67\0"+
    "\36\23\15\0\2\23\12\0\54\23\32\0\44\23\51\0"+
    "\3\23\12\0\44\23\2\0\11\23\7\0\53\23\2\0"+
    "\3\23\51\0\4\23\1\0\6\23\1\0\2\23\3\0"+
    "\1\23\5\0\300\23\100\0\26\23\2\0\6\23\2\0"+
    "\46\23\2\0\6\23\2\0\10\23\1\0\1\23\1\0"+
    "\1\23\1\0\1\23\1\0\37\23\2\0\65\23\1\0"+
    "\7\23\1\0\1\23\3\0\3\23\1\0\7\23\3\0"+
    "\4\23\2\0\6\23\4\0\15\23\5\0\3\23\1\0"+
    "\7\23\53\0\2\3\107\0\1\23\15\0\1\23\20\0"+
    "\15\23\145\0\1\23\4\0\1\23\2\0\12\23\1\0"+
    "\1\23\3\0\5\23\6\0\1\23\1\0\1\23\1\0"+
    "\1\23\1\0\4\23\1\0\13\23\2\0\4\23\5\0"+
    "\5\23\4\0\1\23\64\0\2\23\u017b\0\57\23\1\0"+
    "\57\23\1\0\205\23\6\0\4\23\3\0\2\23\14\0"+
    "\46\23\1\0\1\23\5\0\1\23\2\0\70\23\7\0"+
    "\1\23\20\0\27\23\11\0\7\23\1\0\7\23\1\0"+
    "\7\23\1\0\7\23\1\0\7\23\1\0\7\23\1\0"+
    "\7\23\1\0\7\23\120\0\1\23\325\0\2\23\52\0"+
    "\5\23\5\0\2\23\4\0\126\23\6\0\3\23\1\0"+
    "\132\23\1\0\4\23\5\0\53\23\1\0\136\23\21\0"+
    "\33\23\65\0\306\23\112\0\360\23\20\0\215\23\103\0"+
    "\56\23\2\0\15\23\3\0\20\23\12\0\2\23\24\0"+
    "\57\23\20\0\37\23\2\0\106\23\61\0\11\23\2\0"+
    "\147\23\2\0\65\23\2\0\5\23\60\0\13\23\1\0"+
    "\3\23\1\0\4\23\1\0\27\23\35\0\64\23\16\0"+
    "\62\23\76\0\6\23\3\0\1\23\1\0\2\23\13\0"+
    "\34\23\12\0\27\23\31\0\35\23\7\0\57\23\34\0"+
    "\1\23\20\0\5\23\1\0\12\23\12\0\5\23\1\0"+
    "\51\23\27\0\3\23\1\0\10\23\24\0\27\23\3\0"+
    "\1\23\3\0\62\23\1\0\1\23\3\0\2\23\2\0"+
    "\5\23\2\0\1\23\1\0\1\23\30\0\3\23\2\0"+
    "\13\23\7\0\3\23\14\0\6\23\2\0\6\23\2\0"+
    "\6\23\11\0\7\23\1\0\7\23\1\0\53\23\1\0"+
    "\14\23\10\0\163\23\35\0\244\23\14\0\27\23\4\0"+
    "\61\23\4\0\u0100\3\156\23\2\0\152\23\46\0\7\23"+
    "\14\0\5\23\5\0\1\23\1\0\12\23\1\0\15\23"+
    "\1\0\5\23\1\0\1\23\1\0\2\23\1\0\2\23"+
    "\1\0\154\23\41\0\153\23\22\0\100\23\2\0\66\23"+
    "\50\0\14\23\164\0\5\23\1\0\207\23\44\0\32\23"+
    "\6\0\32\23\13\0\131\23\3\0\6\23\2\0\6\23"+
    "\2\0\6\23\2\0\3\23\43\0\14\23\1\0\32\23"+
    "\1\0\23\23\1\0\2\23\1\0\17\23\2\0\16\23"+
    "\42\0\173\23\205\0\35\23\3\0\61\23\57\0\40\23"+
    "\15\0\24\23\1\0\10\23\6\0\46\23\12\0\36\23"+
    "\2\0\44\23\4\0\10\23\60\0\236\23\22\0\44\23"+
    "\4\0\44\23\4\0\50\23\10\0\64\23\234\0\67\23"+
    "\11\0\26\23\12\0\10\23\230\0\6\23\2\0\1\23"+
    "\1\0\54\23\1\0\2\23\3\0\1\23\2\0\27\23"+
    "\12\0\27\23\11\0\37\23\101\0\23\23\1\0\2\23"+
    "\12\0\26\23\12\0\32\23\106\0\70\23\6\0\2\23"+
    "\100\0\1\23\17\0\4\23\1\0\3\23\1\0\35\23"+
    "\52\0\35\23\3\0\35\23\43\0\10\23\1\0\34\23"+
    "\33\0\66\23\12\0\26\23\12\0\23\23\15\0\22\23"+
    "\156\0\111\23\67\0\63\23\15\0\63\23\15\0\44\23"+
    "\334\0\35\23\12\0\1\23\10\0\26\23\232\0\27\23"+
    "\14\0\65\23\113\0\55\23\40\0\31\23\32\0\44\23"+
    "\35\0\1\23\13\0\43\23\3\0\1\23\14\0\60\23"+
    "\16\0\4\23\25\0\1\23\1\0\1\23\43\0\22\23"+
    "\1\0\31\23\124\0\7\23\1\0\1\23\1\0\4\23"+
    "\1\0\17\23\1\0\12\23\7\0\57\23\46\0\10\23"+
    "\2\0\2\23\2\0\26\23\1\0\7\23\1\0\2\23"+
    "\1\0\5\23\3\0\1\23\22\0\1\23\14\0\5\23"+
    "\236\0\65\23\22\0\4\23\24\0\1\23\40\0\60\23"+
    "\24\0\2\23\1\0\1\23\270\0\57\23\51\0\4\23"+
    "\44\0\60\23\24\0\1\23\73\0\53\23\15\0\1\23"+
    "\107\0\33\23\345\0\54\23\164\0\100\23\37\0\1\23"+
    "\240\0\10\23\2\0\47\23\20\0\1\23\1\0\1\23"+
    "\34\0\1\23\12\0\50\23\7\0\1\23\25\0\1\23"+
    "\13\0\56\23\23\0\1\23\42\0\71\23\7\0\11\23"+
    "\1\0\45\23\21\0\1\23\61\0\36\23\160\0\7\23"+
    "\1\0\2\23\1\0\46\23\25\0\1\23\31\0\6\23"+
    "\1\0\2\23\1\0\40\23\16\0\1\23\u0147\0\23\23"+
    "\15\0\232\23\346\0\304\23\274\0\57\23\321\0\107\23"+
    "\271\0\71\23\7\0\37\23\161\0\36\23\22\0\60\23"+
    "\20\0\4\23\37\0\25\23\5\0\23\23\260\0\100\23"+
    "\200\0\113\23\5\0\1\23\102\0\15\23\100\0\2\23"+
    "\1\0\1\23\34\0\370\23\10\0\363\23\15\0\37\23"+
    "\61\0\3\23\21\0\4\23\10\0\u018c\23\4\0\153\23"+
    "\5\0\15\23\3\0\11\23\7\0\12\23\146\0\125\23"+
    "\1\0\107\23\1\0\2\23\2\0\1\23\2\0\2\23"+
    "\2\0\4\23\1\0\14\23\1\0\1\23\1\0\7\23"+
    "\1\0\101\23\1\0\4\23\2\0\10\23\1\0\7\23"+
    "\1\0\34\23\1\0\4\23\1\0\5\23\1\0\1\23"+
    "\3\0\7\23\1\0\u0154\23\2\0\31\23\1\0\31\23"+
    "\1\0\37\23\1\0\31\23\1\0\37\23\1\0\31\23"+
    "\1\0\37\23\1\0\31\23\1\0\37\23\1\0\31\23"+
    "\1\0\10\23\64\0\55\23\12\0\7\23\20\0\1\23"+
    "\u0171\0\54\23\24\0\305\23\73\0\104\23\7\0\1\23"+
    "\264\0\4\23\1\0\33\23\1\0\2\23\1\0\1\23"+
    "\2\0\1\23\1\0\12\23\1\0\4\23\1\0\1\23"+
    "\1\0\1\23\6\0\1\23\4\0\1\23\1\0\1\23"+
    "\1\0\1\23\1\0\3\23\1\0\2\23\1\0\1\23"+
    "\2\0\1\23\1\0\1\23\1\0\1\23\1\0\1\23"+
    "\1\0\1\23\1\0\2\23\1\0\1\23\2\0\4\23"+
    "\1\0\7\23\1\0\4\23\1\0\4\23\1\0\1\23"+
    "\1\0\12\23\1\0\21\23\5\0\3\23\1\0\5\23"+
    "\1\0\21\23\104\0\327\23\51\0\65\23\13\0\336\23"+
    "\2\0\u0182\23\16\0\u0131\23\37\0\36\23\342\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[27904];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\2\0\1\2\2\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\1\1\21\1\22\5\1\1\23\1\24\2\25"+
    "\1\2\2\26\1\27\1\0\1\3\1\30\1\31\1\32"+
    "\1\1\1\33\4\1\1\34\1\0\1\1\1\35\3\1"+
    "\1\36\1\1\1\37\2\1\1\40\1\41";

  private static int [] zzUnpackAction() {
    int [] result = new int[60];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\165\0\165\0\234\0\303\0\165"+
    "\0\165\0\165\0\165\0\165\0\165\0\352\0\u0111\0\165"+
    "\0\u0138\0\u015f\0\u0186\0\u01ad\0\165\0\165\0\u01d4\0\u01fb"+
    "\0\u0222\0\u0249\0\u0270\0\165\0\165\0\165\0\u0297\0\u02be"+
    "\0\165\0\u02e5\0\165\0\u030c\0\u0333\0\165\0\165\0\165"+
    "\0\u035a\0\u01ad\0\u0381\0\u03a8\0\u03cf\0\u03f6\0\165\0\u041d"+
    "\0\u0444\0\u01ad\0\u046b\0\u0492\0\u04b9\0\u01ad\0\u04e0\0\u01ad"+
    "\0\u0507\0\u052e\0\u01ad\0\u01ad";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[60];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\4\1\26\1\24\1\27"+
    "\2\24\1\30\3\24\1\31\3\24\1\32\1\33\1\34"+
    "\1\35\2\4\1\36\2\4\1\37\17\4\1\40\23\4"+
    "\1\41\2\4\1\42\17\4\1\40\21\4\51\0\1\5"+
    "\65\0\1\43\36\0\1\44\3\0\1\45\47\0\1\17"+
    "\51\0\1\46\46\0\1\47\46\0\1\50\50\0\1\24"+
    "\3\0\16\24\25\0\1\24\3\0\5\24\1\51\10\24"+
    "\25\0\1\24\3\0\2\24\1\52\3\24\1\53\7\24"+
    "\25\0\1\24\3\0\1\24\1\54\14\24\25\0\1\24"+
    "\3\0\7\24\1\55\6\24\25\0\1\24\3\0\3\24"+
    "\1\56\12\24\4\0\1\36\44\0\2\57\4\0\41\57"+
    "\2\0\1\41\44\0\11\44\1\60\35\44\2\45\1\5"+
    "\2\45\1\6\41\45\23\0\1\24\3\0\11\24\1\61"+
    "\4\24\25\0\1\24\3\0\12\24\1\62\3\24\25\0"+
    "\1\24\3\0\12\24\1\63\3\24\25\0\1\24\3\0"+
    "\4\24\1\64\11\24\25\0\1\24\3\0\4\24\1\65"+
    "\11\24\2\0\11\44\1\60\3\44\1\5\31\44\23\0"+
    "\1\24\3\0\1\24\1\66\14\24\25\0\1\24\3\0"+
    "\13\24\1\67\2\24\25\0\1\24\3\0\1\70\15\24"+
    "\25\0\1\24\3\0\5\24\1\71\10\24\25\0\1\24"+
    "\3\0\10\24\1\72\5\24\25\0\1\24\3\0\1\24"+
    "\1\73\14\24\25\0\1\24\3\0\6\24\1\74\7\24"+
    "\2\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[1365];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\2\0\2\11\2\1\6\11\2\1\1\11\4\1"+
    "\2\11\5\1\3\11\2\1\1\11\1\1\1\11\1\0"+
    "\1\1\3\11\6\1\1\11\1\0\14\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[60];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  private Token nextToken = new Token(Token.TokenType.NONE);

  public CMinusScanner2 (String file) {
    try {
		zzReader  = new java.io.FileReader (file);
		nextToken = scanToken();
    }
    catch (Exception e) {

    }
  }
  
  public Token getNextToken () {
    Token returnToken = nextToken;
    if (nextToken.getType() != "Token.TokenType.EOF_TOKEN")
		try {nextToken = scanToken();}
		catch (Exception e) {}
    return returnToken;
  }

  public Token viewNextToken () {
    return nextToken;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CMinusScanner2(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token scanToken() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
              {
                return new Token(Token.TokenType.EOF_TOKEN);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return new Token(Token.TokenType.ID, yytext());
            }
          // fall through
          case 34: break;
          case 2:
            { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn);
            }
          // fall through
          case 35: break;
          case 3:
            { /* ignore */
            }
          // fall through
          case 36: break;
          case 4:
            { return new Token(Token.TokenType.ERROR);
            }
          // fall through
          case 37: break;
          case 5:
            { return new Token(Token.TokenType.LPAREN);
            }
          // fall through
          case 38: break;
          case 6:
            { return new Token(Token.TokenType.RPAREN);
            }
          // fall through
          case 39: break;
          case 7:
            { return new Token(Token.TokenType.STAR);
            }
          // fall through
          case 40: break;
          case 8:
            { return new Token(Token.TokenType.PLUS);
            }
          // fall through
          case 41: break;
          case 9:
            { return new Token(Token.TokenType.COMMA);
            }
          // fall through
          case 42: break;
          case 10:
            { return new Token(Token.TokenType.MINUS);
            }
          // fall through
          case 43: break;
          case 11:
            { return new Token(Token.TokenType.SLASH);
            }
          // fall through
          case 44: break;
          case 12:
            { return new Token(Token.TokenType.NUM, yytext());
            }
          // fall through
          case 45: break;
          case 13:
            { return new Token(Token.TokenType.SEMI);
            }
          // fall through
          case 46: break;
          case 14:
            { return new Token(Token.TokenType.LT);
            }
          // fall through
          case 47: break;
          case 15:
            { return new Token(Token.TokenType.EQ);
            }
          // fall through
          case 48: break;
          case 16:
            { return new Token(Token.TokenType.GT);
            }
          // fall through
          case 49: break;
          case 17:
            { return new Token(Token.TokenType.LBRACK);
            }
          // fall through
          case 50: break;
          case 18:
            { return new Token(Token.TokenType.RBRACK);
            }
          // fall through
          case 51: break;
          case 19:
            { return new Token(Token.TokenType.LBRAY);
            }
          // fall through
          case 52: break;
          case 20:
            { return new Token(Token.TokenType.RBRAY);
            }
          // fall through
          case 53: break;
          case 21:
            { throw new RuntimeException("Unterminated string at end of line");
            }
          // fall through
          case 54: break;
          case 22:
            { throw new RuntimeException("Unterminated character literal at end of line");
            }
          // fall through
          case 55: break;
          case 23:
            { return new Token(Token.TokenType.NOTEQ);
            }
          // fall through
          case 56: break;
          case 24:
            { return new Token(Token.TokenType.LTE);
            }
          // fall through
          case 57: break;
          case 25:
            { return new Token(Token.TokenType.EQEQ);
            }
          // fall through
          case 58: break;
          case 26:
            { return new Token(Token.TokenType.GTE);
            }
          // fall through
          case 59: break;
          case 27:
            { return new Token(Token.TokenType.KEYWORD, "if");
            }
          // fall through
          case 60: break;
          case 28:
            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\"");
            }
          // fall through
          case 61: break;
          case 29:
            { return new Token(Token.TokenType.KEYWORD, "int");
            }
          // fall through
          case 62: break;
          case 30:
            { return new Token(Token.TokenType.KEYWORD, "else");
            }
          // fall through
          case 63: break;
          case 31:
            { return new Token(Token.TokenType.KEYWORD, "void");
            }
          // fall through
          case 64: break;
          case 32:
            { return new Token(Token.TokenType.KEYWORD, "while");
            }
          // fall through
          case 65: break;
          case 33:
            { return new Token(Token.TokenType.KEYWORD, "return");
            }
          // fall through
          case 66: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}