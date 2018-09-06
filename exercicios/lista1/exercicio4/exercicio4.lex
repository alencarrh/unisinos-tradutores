%option noyywrap

%{

#include <stdio.h>
#include <time.h>


int numlines = 0;

%}

TAG	\<(.)*\>
WHITESPACE	[\ \t]
LINHA	[\n]

%%

{TAG}	;
{LINHA}	{numlines++; printf("%s", yytext);}
{WHITESPACE}	{printf("%s", yytext);}
.	{printf("%s", yytext);}

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);
	printf("Quantidade de linhas processadas: %d\n", numlines);
	return 0;
}


