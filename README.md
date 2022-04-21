Sistema referente ao trabalho: Utilização de algoritmo de mineração de regras de associação 
para reconhecimento de padrões através de um fluxo de dados. O sistema é composto de duas implementações, a
primeira é um programa de gerenciamento de fluxo de dados chamado Esper, esse programa foi construído em Java.

Para o funcionamento do Esper
Main.java

	Para iniciar o janelamento é preciso escolher a simulação de fluxo de dados há ser utilizada, para isso, 
na parte especificada do arquivo "new FileReader("../Arquivos/Fluxos de dados/nome da base de dados")" adicione o nome
da base. Vale lembra que a base será lida se estiver na pasta "Fluxo de dados" do sistema. 

EsperEngine.java

	Após selecionar uma simulação de fluxo é preciso definir qual é o tempo e o tamanho das janelas de despejo do Esper,
isso é definido da expressão "String expression = "select transLine from MarketEvent#time_length_batch(1 sec, quantidade de transações por janela)";"
	Quando o programa é inicializado ele processa os dados do Fluxo e despeja as janelas na pasta "Janelamento" do sistema
	
A segunda parte do sistema é composta pelo algoritmo Apriori que processa as janelas a partir de parâmetros definidos pelo usuário.

Para o funcionamento do Esper

Main.py
	Para que o algoritmo funcione adequadamente são somente necessários quatro parâmetros a serem alterados no código.
	"min_support" : Suporte base para o processamento dos resultados;
	"min_confidence": Confiança base para o processamento dos resultados;
	"number": Número de janelas (+1) a serem processadas;
	"loop": Número de vezes que essas janelas serão testadas.
A partir do processamento das janelas os resultados serão disponibilizados em formato .csv na pasta "Resultados"