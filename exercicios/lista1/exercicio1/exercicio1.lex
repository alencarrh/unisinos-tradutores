%option noyywrap

%{

#include <stdio.h>
#include <time.h>


int words = 0;

%}

%%

[:alpha:]	words++;
\n
.

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);
	printf("Número de palavras: %d\n", words);
	return 0;
}


