/*******************************************************************************
* Copyright (c) 2006 Eclipse.org
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
package org.eclipse.gmf.internal.xpand.parser;

public class XpandLexerprs implements lpg.lpgjavaruntime.ParseTable, XpandLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,3,3,1,3,1,1,1,1,1,
            2,2,1,1,1,1,1,2,2,2,
            2,1,1,1,1,2,1,1,1,2,
            1,1,1,1,5,1,1,2,3,1,
            2,2,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,2,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,2,2,1,1,1,1,1,1,
            1,1,1,1,1,1,1,3,2,2,
            0,1,2,1,2,0,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,6,
            2,2,2,2,2,2,2,2,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,3,0,2,1,1,1,1,
            1,0,1,12,0,2,3,4,5,6,
            7,8,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            2
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,20,20,20,
            20,20,20,20,20,20,20,16,16,21,
            14,14,14,5,5,5,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,1,1,
            1,1,1,1,1,1,1,1,4,4,
            4,4,4,22,22,6,6,6,6,6,
            6,6,6,6,6,6,6,6,6,6,
            6,6,6,6,6,6,6,6,6,6,
            6,6,6,25,25,26,26,26,26,26,
            26,26,26,26,10,10,10,10,23,23,
            23,23,24,24,17,17,15,15,12,12,
            12,12,12,12,12,12,12,12,12,12,
            12,12,12,12,12,12,12,12,12,12,
            12,12,12,12,12,11,11,11,11,11,
            11,13,13,13,13,13,13,13,13,9,
            9,9,9,9,9,9,9,9,9,9,
            9,8,8,20,20,27,27,29,29,29,
            29,29,28,28,20,30,30,30,30,30,
            30,30,30,32,32,7,7,7,7,7,
            7,7,7,7,7,18,18,33,33,34,
            34,35,35,36,36,19,19,19,19,19,
            19,19,19,19,19,19,19,19,19,19,
            19,19,19,19,19,19,19,19,19,19,
            37,37,37,37,37,37,37,37,37,37,
            37,37,37,37,37,37,37,37,37,37,
            37,37,37,37,37,38,38,38,38,38,
            38,38,38,38,38,38,38,38,38,38,
            38,38,38,38,38,38,38,38,38,38,
            39,39,39,39,39,39,39,39,39,39,
            39,39,39,39,39,39,39,39,39,39,
            39,39,39,39,39,40,40,40,40,40,
            40,40,40,40,40,40,40,40,40,40,
            40,40,40,40,40,40,40,40,40,40,
            31,31,1628,37,43,44,113,40,203,104,
            155,43,44,157,154,156,577,2140,415,228,
            1254,114,424,6,407,2147,38,549,1731,196,
            43,44,1152,195,1625,399,2141,224,226,164,
            197,199,2148,470,2171,474,1731,196,43,44,
            465,195,2159,38,2174,454,2176,164,197,199,
            2142,480,2175,474,1329,155,43,44,157,154,
            156,2177,2139,1720,160,1,246,253,244,248,
            2183,247,243,2160,1828,196,43,44,488,195,
            2184,2185,1624,1718,2186,165,197,199,1428,155,
            43,44,157,154,156,1805,483,236,158,207,
            246,253,2188,248,1901,247,255,309,246,253,
            2191,248,622,247,257,622,622,237,256,411,
            246,253,622,248,622,247,259,513,246,253,
            622,248,622,247,261,622,622,622,622,622,
            238,615,246,253,258,248,622,247,255,1527,
            146,43,44,239,145,150,622,260,622,241,
            256,622,240,1125,246,253,262,248,622,247,
            263,1990,37,43,44,144,40,1925,42,43,
            44,622,41,622,622,588,622,442,2055,42,
            43,44,622,41,622,622,2120,221,622,242,
            2120,221,622,264,600,222,2120,221,606,222,
            2120,221,622,622,610,222,622,622,200,222,
            622,622
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,101,102,0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,15,16,
            17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31,32,33,34,35,36,
            37,38,39,40,41,42,43,44,45,46,
            47,48,49,50,51,52,53,54,55,56,
            57,58,59,60,61,62,63,64,65,66,
            67,68,69,70,71,72,73,74,75,76,
            77,78,79,80,81,82,83,84,85,86,
            87,88,89,90,91,92,93,94,95,96,
            97,98,0,100,101,102,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,100,101,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,23,24,25,26,27,28,29,30,31,
            32,33,34,35,36,37,38,39,40,41,
            42,43,44,45,46,47,48,49,50,51,
            52,53,54,55,56,57,58,59,60,61,
            62,63,64,65,66,67,68,69,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            92,93,94,95,96,97,98,99,100,101,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,101,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            98,99,100,101,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            66,67,68,69,70,71,72,73,74,75,
            76,77,78,79,80,81,82,83,84,85,
            86,87,88,89,90,91,92,93,94,95,
            96,97,98,99,100,101,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,100,101,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,23,24,25,26,27,28,29,30,31,
            32,33,34,35,36,37,38,39,40,41,
            42,43,44,45,46,47,48,49,50,51,
            52,53,54,55,56,57,58,59,60,61,
            62,63,64,65,66,67,68,69,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            92,93,94,95,96,97,98,99,100,101,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,101,0,1,2,3,4,5,6,7,
            8,9,10,11,12,13,14,15,16,17,
            18,19,20,21,22,23,24,25,26,27,
            28,29,30,31,32,33,34,35,36,37,
            38,39,40,41,42,43,44,45,46,47,
            48,49,50,51,52,53,54,55,56,57,
            58,59,60,61,62,63,64,65,66,67,
            68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,
            88,89,90,91,92,93,94,95,96,97,
            98,99,100,101,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,0,28,29,30,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,65,
            66,67,68,69,70,71,72,73,74,75,
            76,77,78,79,80,81,82,83,84,85,
            86,87,88,89,90,91,92,93,94,95,
            96,97,98,99,100,101,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,0,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,97,98,99,100,101,0,1,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,17,18,19,20,21,
            22,23,24,25,26,27,28,29,30,31,
            32,33,34,35,36,37,38,39,40,41,
            42,43,44,45,46,47,48,49,50,51,
            52,53,54,55,56,57,58,59,60,61,
            62,63,64,65,66,67,68,69,70,71,
            72,73,74,75,76,77,78,79,80,81,
            82,83,84,85,86,87,88,89,90,91,
            92,93,94,95,96,97,98,0,1,2,
            3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,
            23,24,25,26,27,28,29,30,31,32,
            33,34,35,36,37,38,39,40,41,42,
            43,44,45,46,47,48,49,50,51,52,
            53,54,55,56,57,58,59,60,61,62,
            63,64,65,66,67,68,69,70,71,72,
            73,74,75,76,77,78,79,80,81,82,
            83,84,85,86,87,88,89,90,91,92,
            93,94,95,96,97,98,0,1,2,3,
            4,5,6,7,8,9,10,11,12,13,
            14,15,16,17,18,19,20,21,22,23,
            24,25,26,27,28,29,30,31,32,33,
            34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,
            54,55,56,57,58,59,60,61,62,63,
            64,65,66,67,68,69,70,71,72,73,
            74,75,76,77,78,79,80,81,82,83,
            84,85,86,87,88,89,90,91,92,93,
            94,95,96,0,0,0,100,0,1,2,
            3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,
            23,24,25,26,27,28,29,30,31,32,
            33,34,35,36,37,38,39,40,41,42,
            43,44,45,46,47,48,49,50,51,52,
            53,54,55,56,57,58,59,60,61,62,
            63,64,65,66,67,68,69,70,71,72,
            73,74,75,0,77,78,79,80,81,82,
            83,84,85,86,87,88,89,0,1,0,
            1,0,99,0,97,98,99,103,0,102,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,72,0,0,75,76,77,78,79,
            80,81,82,83,84,85,86,87,14,102,
            90,91,92,93,94,95,96,0,1,2,
            3,4,5,6,7,8,9,10,11,12,
            13,14,15,16,17,18,19,20,21,22,
            23,24,25,26,27,28,29,30,31,32,
            33,34,35,36,37,38,39,40,41,42,
            43,44,45,46,47,48,49,50,51,52,
            53,54,55,56,57,58,59,60,61,62,
            63,64,65,66,67,68,69,70,71,72,
            0,1,75,76,77,78,79,80,81,82,
            83,84,85,86,87,0,0,90,91,92,
            93,94,95,96,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,0,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,0,
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,0,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60,
            61,62,63,64,0,1,2,3,4,5,
            6,7,8,9,10,11,12,13,14,15,
            16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,0,31,32,33,34,35,
            36,37,38,39,40,41,42,43,44,45,
            46,47,48,49,50,51,52,53,54,55,
            56,57,58,59,60,61,62,63,64,0,
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,0,0,
            0,0,23,24,25,26,0,0,2,3,
            4,5,6,7,8,9,10,11,0,0,
            2,3,4,5,6,7,8,9,10,11,
            0,12,13,0,0,0,0,30,19,20,
            21,22,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            30,0,0,30,65,30,0,66,68,71,
            72,27,0,28,0,69,29,27,27,0,
            0,0,0,0,0,0,0,88,89,0,
            0,0,73,74,0,76,97,98,0,0,
            0,67,0,0,0,0,70,0,0,0,
            0,0,0,0,0,73,0,74,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,99,0,0,0,0,
            0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            622,698,720,721,722,723,724,725,726,727,
            728,729,669,673,697,668,670,671,672,681,
            685,687,688,694,695,696,699,706,707,711,
            763,674,675,676,677,678,679,680,682,683,
            684,686,689,690,691,692,693,876,700,701,
            702,703,704,705,708,709,710,712,713,714,
            715,716,717,718,719,730,753,747,749,760,
            762,873,872,741,751,742,752,754,755,756,
            757,758,759,761,737,738,739,740,733,734,
            746,743,744,745,764,748,750,731,732,871,
            874,867,499,232,698,720,721,722,723,724,
            725,726,727,728,729,669,673,697,668,670,
            671,672,681,685,687,688,694,695,696,699,
            706,707,711,763,674,675,676,677,678,679,
            680,682,683,684,686,689,690,691,692,693,
            667,700,701,702,703,704,705,708,709,710,
            712,713,714,715,716,717,718,719,730,753,
            747,749,760,762,852,851,741,751,742,752,
            754,755,756,757,758,759,761,737,738,739,
            740,733,734,746,743,744,745,764,748,750,
            731,732,225,853,849,855,390,2036,720,721,
            722,723,724,725,726,727,728,729,669,673,
            890,668,670,671,672,681,685,687,688,887,
            888,889,891,898,899,903,763,674,675,676,
            677,678,679,680,682,683,684,686,689,690,
            691,692,693,876,892,893,894,895,896,897,
            900,901,902,904,905,906,907,908,909,910,
            911,730,753,747,749,760,762,873,872,741,
            751,742,752,754,755,756,757,758,759,761,
            737,738,739,740,733,734,746,743,744,745,
            764,748,750,731,732,871,874,867,622,916,
            720,721,722,723,724,725,726,727,728,729,
            669,673,915,668,670,671,672,681,685,687,
            688,912,913,914,917,924,519,928,763,674,
            675,676,677,678,679,680,682,683,684,686,
            689,690,691,692,693,876,918,919,920,921,
            922,923,925,926,927,929,930,931,932,933,
            934,935,936,730,753,747,749,760,762,873,
            872,741,751,742,752,754,755,756,757,758,
            759,761,737,738,739,740,733,734,746,743,
            744,745,764,748,750,731,732,871,874,867,
            622,940,720,721,722,723,724,725,726,727,
            728,729,669,673,527,668,670,671,672,681,
            685,687,688,937,938,939,941,948,949,953,
            763,674,675,676,677,678,679,680,682,683,
            684,686,689,690,691,692,693,876,942,943,
            944,945,946,947,950,951,952,954,955,956,
            957,958,959,960,961,730,753,747,749,760,
            762,873,872,741,751,742,752,754,755,756,
            757,758,759,761,737,738,739,740,733,734,
            746,743,744,745,764,748,750,731,732,871,
            874,867,622,966,720,721,722,723,724,725,
            726,727,728,729,669,673,965,668,670,671,
            672,681,685,687,688,962,963,964,967,974,
            975,541,763,674,675,676,677,678,679,680,
            682,683,684,686,689,690,691,692,693,876,
            968,969,970,971,972,973,976,977,978,979,
            980,981,982,983,984,985,986,730,753,747,
            749,760,762,873,872,741,751,742,752,754,
            755,756,757,758,759,761,737,738,739,740,
            733,734,746,743,744,745,764,748,750,731,
            732,871,874,867,622,563,720,721,722,723,
            724,725,726,727,728,729,669,673,890,668,
            670,671,672,681,685,687,688,887,888,889,
            891,898,899,903,763,674,675,676,677,678,
            679,680,682,683,684,686,689,690,691,692,
            693,876,892,893,894,895,896,897,900,901,
            902,904,905,906,907,908,909,910,911,730,
            753,747,749,760,762,873,872,741,751,742,
            752,754,755,756,757,758,759,761,737,738,
            739,740,733,734,746,743,744,745,764,748,
            750,731,732,871,874,867,622,2240,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,622,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,1730,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            622,507,507,507,507,507,507,507,507,507,
            507,507,507,507,1832,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,622,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            1934,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,622,991,720,721,722,723,
            724,725,726,727,728,729,669,673,990,668,
            670,671,672,681,685,687,688,987,988,989,
            992,161,999,1003,763,674,675,676,677,678,
            679,680,682,683,684,686,689,690,691,692,
            693,876,993,994,995,996,997,998,1000,1001,
            1002,1004,1005,1006,1007,1008,1009,1010,1011,730,
            753,747,749,760,762,873,872,741,751,742,
            752,754,755,756,757,758,759,761,737,738,
            739,740,733,734,746,743,744,745,764,748,
            750,731,732,871,874,867,390,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,235,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,507,507,
            507,507,507,507,507,507,507,507,622,698,
            720,721,722,723,724,725,726,727,728,729,
            669,673,697,668,670,671,672,681,685,687,
            688,694,695,696,699,706,707,711,763,674,
            675,676,677,678,679,680,682,683,684,686,
            689,690,691,692,693,667,700,701,702,703,
            704,705,708,709,710,712,713,714,715,716,
            717,718,719,730,753,747,749,760,762,781,
            784,741,751,742,752,754,755,756,757,758,
            759,761,737,738,739,740,733,734,746,743,
            744,745,764,748,750,731,732,622,698,720,
            721,722,723,724,725,726,727,728,729,669,
            673,697,668,670,671,672,681,685,687,688,
            694,695,696,699,706,707,711,763,674,675,
            676,677,678,679,680,682,683,684,686,689,
            690,691,692,693,667,700,701,702,703,704,
            705,708,709,710,712,713,714,715,716,717,
            718,719,730,753,747,749,760,762,657,785,
            741,751,742,752,754,755,756,757,758,759,
            761,737,738,739,740,733,734,746,743,744,
            745,764,748,750,731,732,36,698,720,721,
            722,723,724,725,726,727,728,729,669,673,
            697,668,670,671,672,681,685,687,688,694,
            695,696,699,706,707,711,763,674,675,676,
            677,678,679,680,682,683,684,686,689,690,
            691,692,693,667,700,701,702,703,704,705,
            708,709,710,712,713,714,715,716,717,718,
            719,769,753,747,749,760,762,771,770,741,
            751,742,752,754,755,756,757,758,759,761,
            737,738,739,740,773,774,746,743,744,745,
            764,748,750,622,622,622,775,622,698,720,
            721,722,723,724,725,726,727,728,729,669,
            673,697,668,670,671,672,681,685,687,688,
            694,695,696,699,706,707,463,432,674,675,
            676,677,678,679,680,682,683,684,686,689,
            690,691,692,693,667,700,701,702,703,704,
            705,708,709,710,712,713,714,715,716,717,
            718,719,730,450,452,426,653,444,462,631,
            418,436,446,622,646,647,644,645,655,650,
            434,629,461,636,637,733,734,622,484,89,
            3205,622,410,622,731,732,398,621,622,845,
            166,698,720,721,722,723,724,725,726,727,
            728,729,669,673,697,668,670,671,672,681,
            685,687,688,694,695,696,699,706,707,711,
            815,674,675,676,677,678,679,680,682,683,
            684,686,689,690,691,692,693,667,700,701,
            702,703,704,705,708,709,710,712,713,714,
            715,716,717,718,719,820,805,801,803,812,
            814,792,795,622,622,796,473,806,807,808,
            809,810,811,813,790,791,793,794,502,1013,
            800,797,798,799,816,802,804,167,698,720,
            721,722,723,724,725,726,727,728,729,669,
            673,697,668,670,671,672,681,685,687,688,
            694,695,696,699,706,707,711,815,674,675,
            676,677,678,679,680,682,683,684,686,689,
            690,691,692,693,667,700,701,702,703,704,
            705,708,709,710,712,713,714,715,716,717,
            718,719,820,805,801,803,812,814,792,795,
            622,510,796,473,806,807,808,809,810,811,
            813,790,791,793,794,622,622,800,797,798,
            799,816,802,804,1,698,720,721,722,723,
            724,725,726,727,728,729,669,673,697,668,
            670,671,672,681,685,687,688,694,695,696,
            699,706,707,711,622,674,675,676,677,678,
            679,680,682,683,684,686,689,690,691,692,
            693,667,700,701,702,703,704,705,708,709,
            710,712,713,714,715,716,717,718,719,622,
            698,720,721,722,723,724,725,726,727,728,
            729,669,673,697,668,670,671,672,681,685,
            687,688,694,695,696,699,706,707,711,622,
            674,675,676,677,678,679,680,682,683,684,
            686,689,690,691,692,693,667,700,701,702,
            703,704,705,708,709,710,712,713,714,715,
            716,717,718,719,5,698,720,721,722,723,
            724,725,726,727,728,729,669,673,697,668,
            670,671,672,681,685,687,688,694,695,696,
            699,706,707,711,622,674,675,676,677,678,
            679,680,682,683,684,686,689,690,691,692,
            693,667,700,701,702,703,704,705,708,709,
            710,712,713,714,715,716,717,718,719,622,
            841,720,721,722,723,724,725,726,727,728,
            729,832,836,840,831,833,834,835,10,34,
            29,27,837,838,839,842,4,32,720,721,
            722,723,724,725,726,727,728,729,39,622,
            720,721,722,723,724,725,726,727,728,729,
            17,823,826,16,622,13,8,640,825,827,
            824,596,622,622,622,622,89,622,622,622,
            622,89,622,622,622,622,622,622,622,622,
            642,622,622,641,730,643,622,634,652,765,
            422,482,622,495,622,571,504,856,3200,622,
            622,622,622,622,622,622,622,733,734,622,
            622,622,828,829,622,830,731,732,622,622,
            622,633,622,622,622,622,648,622,622,622,
            622,622,622,622,622,625,622,624,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,622,622,622,622,622,
            622,622,622,622,622,481
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 50,
           NT_OFFSET         = 105,
           LA_STATE_OFFSET   = 1013,
           MAX_LA            = 6,
           NUM_RULES         = 391,
           NUM_NONTERMINALS  = 41,
           NUM_SYMBOLS       = 146,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 392,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 103,
           EOLT_SYMBOL       = 106,
           ACCEPT_ACTION     = 621,
           ERROR_ACTION      = 622;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
