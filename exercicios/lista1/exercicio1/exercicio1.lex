%option noyywrap

%{

#include <stdio.h>
#include <time.h>


int words = 0;

void sum(char* word){
	printf("%s", word);
	words++;
}

%}

%%

[a-zA-Z][a-zA-Z0-9]*	{sum(yytext);printf("-%s\n", yytext);}
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


