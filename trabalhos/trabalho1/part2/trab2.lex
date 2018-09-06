%option noyywrap


%{

	#include <stdio.h>

	
	int num_words = 0;
	int num_phrases = 0;
	int num_distinct_words = 0;
	int avg_word_per_phrase = 0;
	int duplicates = 0;


%}

%%


. ;

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);
	
	avg_word_per_phrase = (float)num_words / (float)num_phrases;
	float density = ( (float)num_distinct_words / (float)num_words ) * 100;
	printf("Número de palavras: %d\n", num_words);
	printf("Número de frases: %d\n", num_phrases);
	printf("Número de palavras diferentes: %d\n", num_distinct_words);
	printf("Número médio de palavras por frase: %d\n", avg_word_per_phrase);
	printf("Densidade léxica do texto: %.2f\n", density);
	return 0;
}


