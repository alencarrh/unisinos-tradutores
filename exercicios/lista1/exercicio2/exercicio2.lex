%option noyywrap

%{

#include <stdio.h>
#include <time.h>


int numebrs = 0;

%}

%%

[0-9]+	numebrs++;
\n
.

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);
	printf("Quantidade de números: %d\n", numebrs);
	return 0;
}


