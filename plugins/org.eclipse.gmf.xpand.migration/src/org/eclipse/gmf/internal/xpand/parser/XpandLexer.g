--
-- Copyright (c) 2006 Borland Software Corp.
-- 
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--    Artem Tikhomirov (Borland)
--

%options fp=XpandLexer,prefix=Char_
%options package=org.eclipse.gmf.internal.xpand.parser
%options template=../expression/parser/LexerTemplateD.g
%options export_terminals=("XpandParsersym.java", "TK_")
%options filter=XpandKWLexer.g
-- stupid endrem needs 6
%options lalr=6

$Import
	../expression/parser/ExpressionLexer.g
$End

$Define
	$kw_lexer_class /.XpandKWLexer./
	$getKindMethodImpl /.public final int getKind(int i) { // Classify character at ith location
            char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
            return (c < 128 // ASCII Character
                      ? tokenKind[c]
                      : c == '\uffff'
                           ? Char_EOF
                           : getNonAsciiKind(c));
        }./
$End

$Headers
	/.
		private final static int getNonAsciiKind(char c) {
			if (c == '\u00AB') {
				return Char_LG;
			}
			if (c == '\u00BB') {
				return Char_RG;
			}
			return Char_AfterASCII;
		}
./
$End

$Export
	TEXT
	LG
--	RG
$End

$Terminals
	LG ::= '\u00AB'
	RG ::= '\u00BB'
$End

$Rules
	Token ::= LG
		/.$BeginAction
			makeToken($_LG);
		$EndAction./

	Token ::= RG textAny lgOpt
		/.$BeginAction
			makeToken($_TEXT);
		$EndAction./

	textAny -> $empty
	textAny -> textAny textAnyChars
	textAnyChars -> AfterASCII | NotSlashOrStar | '*' | '/' | CtlCharNotWS

	-- lgOpt -> EOF | LG
	lgOpt -> $empty
	lgOpt -> LG

	Token ::= R E M RG commentAny lgPlus E N D R E M 
		/.$BeginAction
			skipToken();
		$EndAction./

	commentAny -> $empty
	commentAny -> commentAny commentChar 
	commentAny -> commentAny LG commentCharNotE
	commentAny -> commentAny LG E commentCharNotN
	commentAny -> commentAny LG E N commentCharNotD
	commentAny -> commentAny LG E N D commentCharNotR
	commentAny -> commentAny LG E N D R commentCharNotE
	commentAny -> commentAny LG E N D R E commentCharNotM

	commentChar -> commentCharNoUpper | UpperCaseLetter

	commentCharNoUpper -> AfterASCII | Digit | SpecialNotSlash | WSChar | RG | '*' | '/' | CtlCharNotWS | LowerCaseLetter | '_' 

	commentCharNotE ::= commentCharNoUpper | UpperCaseLetterNotE
	commentCharNotN ::= commentCharNoUpper | UpperCaseLetterNotN
	commentCharNotD ::= commentCharNoUpper | UpperCaseLetterNotD
	commentCharNotR ::= commentCharNoUpper | UpperCaseLetterNotR
	commentCharNotM ::= commentCharNoUpper | UpperCaseLetterNotM

	UpperCaseLetterNotE -> A | B | C | D | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
	UpperCaseLetterNotN -> A | B | C | D | E | F | G | H | I | J | K | L | M | O | P | Q | R | S | T | U | V | W | X | Y | Z
	UpperCaseLetterNotD -> A | B | C | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
	UpperCaseLetterNotR -> A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | S | T | U | V | W | X | Y | Z
	UpperCaseLetterNotM -> A | B | C | D | E | F | G | H | I | J | K | L | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
	
	lgPlus ::= LG | lgPlus LG
$End