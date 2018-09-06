%option noyywrap

%{

#include <stdio.h>
#include <time.h>


int tags = 0;

%}



%%

\<("/")?([a-zA-Z]|[0-9])+\>	tags++;
.|\n	;

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);
	printf("Quantidade de tags: %d\n", tags);
	return 0;
}


