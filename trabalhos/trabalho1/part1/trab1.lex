%option noyywrap


%{

	#include <stdio.h>
	#include <stdbool.h>
	#include <string.h>

	typedef struct node {
		char * word;
		struct node * next;
	} node_t;

	int num_words = 0;
	int num_phrases = 0;
	int num_distinct_words = 0;
	int avg_word_per_phrase = 0;
	int duplicates = 0;
	node_t * head;
		
	bool exist(char* word){
		//printf("%s\n", word);
		if(head == NULL){
			return false;
		}
		node_t* current = head;
		while(current != NULL){
			//printf("%s=%s", current->word, word);
			if(strcmp(current->word, word) == 0){
				printf("já existe: %s", word);
				return true;
			}
			current = current->next;
		}
		return false;
	}
	
	void push(char* word) {
		num_words++;
		if(exist(word)){
			return;
		}
		num_distinct_words++;

		if(head == NULL){
			head = malloc(sizeof(node_t));
			head->word = word;
			head->next = NULL;
			return;
		}

		node_t * current = head;
		while (current->next != NULL) {
			current = current->next;
		}

		/* now we can add a new variable */
		current->next = malloc(sizeof(node_t));
		current->next->word = word;
		current->next->next = NULL;

	}
	
	

%}

FHRASE	[\.|\?|\!][\n|\r|\t| ]

%%


{FHRASE}	{num_phrases++;}
[a-zA-Z][a-zA-Z0-9]*	{push(yytext);}
. ;

%%

int main(int argc, char *argv[]){
	yyin = fopen(argv[1], "r");
	yylex();
	fclose(yyin);

	FILE* file_ptr = fopen("stats.txt", "w");	
	
	avg_word_per_phrase = (float)num_words / (float)num_phrases;
	float density = ( (float)num_distinct_words / (float)num_words ) * 100;
	fprintf(file_ptr, "Número de palavras: %d\n", num_words);
	fprintf(file_ptr, "Número de frases: %d\n", num_phrases);
	fprintf(file_ptr, "Número de palavras diferentes: %d\n", num_distinct_words);
	fprintf(file_ptr, "Número médio de palavras por frase: %d\n", avg_word_per_phrase);
	fprintf(file_ptr, "Densidade léxica do texto: %.2f\n", density);



	
	fclose(file_ptr);
	

	return 0;
}


