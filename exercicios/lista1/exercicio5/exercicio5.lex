%option noyywrap

%{

#include <stdio.h>

%}

EMAIL	[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\.[a-zA-Z]{2,4}
WHITESPACE	[\ \t]
LINHA	[\n]

%%

{EMAIL}	{printf("%s\n", yytext);}
{LINHA}	;
{WHITESPACE}	;
.	;

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);
	return 0;
}


